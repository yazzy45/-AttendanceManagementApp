import cv2
import numpy as np
import requests
import face_recognition 
def send_toserver(name):
    url = "http://localhost:8080/api/facerecognition"
    data = { "name": name,"names":"dd" }
    try:
        response = requests.post(url, data=data)
        print(response.text)
    except requests.exceptions.RequestException as e:
        print(e)
    
print("Python script started")
video_capture = cv2.VideoCapture(0)
yazzy_image = face_recognition.load_image_file("./img/yazzy/yazzy.jpg")
# [0]は検出した最初の顔のエンコード　これは1つの画像に1つの顔がある場合のみ　別のファイルにかいてもいいかも
yazzy_face_encoding = face_recognition.face_encodings(yazzy_image)[0]
known_face_encodings = [
    yazzy_face_encoding,
]
known_face_names = [
    "yazzy",
]
face_locations = []
face_encodings = []
face_names = []
process_this_frame = True
recognized_names = set()
while True:
    ret, frame = video_capture.read()

    if process_this_frame:
        # フレームを小さくすることで処理を高速化
        small_frame = cv2.resize(frame, (0, 0), fx=0.25, fy=0.25)
        # BGRをRGBに変換 face_locationsで使用するため
        rgb_small_frame = np.ascontiguousarray(small_frame[:, :, ::-1])
        # 顔の位置を検出
        face_locations = face_recognition.face_locations(rgb_small_frame) 
        # 顔のエンコード
        face_encodings = face_recognition.face_encodings(rgb_small_frame, face_locations)

        face_names = []
        for face_encoding in face_encodings:
            # 顔が知っている顔と一致するか
            matches = face_recognition.compare_faces(known_face_encodings, face_encoding)
            name = "Unknown"
            # 顔が一致したら
            if True in matches:
                first_match_index = matches.index(True)
                name = known_face_names[first_match_index]
                
            if name != "Unknown" and name not in recognized_names:
                send_toserver(name)
                recognized_names.add(name)
            face_names.append(name)
            # もしくは距離が一番近いものを選ぶ
            # face_distances = face_recognition.face_distance(known_face_encodings, face_encoding)
            # # : NumPyライブラリの関数で、与えられた配列の中で最小値を持つ要素のインデックスを返す
            # best_match_index = np.argmin(face_distances)
            # if matches[best_match_index]:
            #     name = known_face_names[best_match_index]
            # face_names.append(name)


    process_this_frame = not process_this_frame

    # 表示 zip()では多い分の要素が無視される
    for (top, right, bottom, left), name in zip(face_locations, face_names):
        # 顔の位置を元のサイズに戻す
        top *= 4
        right *= 4
        bottom *= 4
        left *= 4
        cv2.rectangle(frame, (left, top), (right, bottom), (0, 0, 255), 2)
        cv2.rectangle(frame, (left, bottom - 35), (right, bottom), (0, 0, 255), cv2.FILLED)
        font = cv2.FONT_HERSHEY_DUPLEX
        cv2.putText(frame, name, (left + 6, bottom - 6), font, 1.0, (255, 255, 255), 1)
    cv2.imshow('Video', frame)
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

    # ビデオキャプチャを解放
video_capture.release()
cv2.destroyAllWindows()
print("Python script started")

