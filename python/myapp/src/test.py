import cmake
print(cmake.__file__)
import cv2
# 顔検出用のカスケード分類器の読み込み
cascade_path = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')
# カメラをキャプチャする
cap = cv2.VideoCapture(0)

while True:
    # フレームをキャプチャする
    ret, frame = cap.read()

    # グレースケールに変換する
    # 画像をグレースケールに変換することで、処理を高速化する
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    # 顔を検出する
    # scaleFactor: 画像縮小時のスケールファクタ　様々なスケールで検出を行うために、画像を縮小する　アルゴリズムは元の画像のサイズから始め、次にその画像を10%縮小したサイズで顔を検出します。
    #minNeighbors – 物体候補となる矩形は，最低でもこの数だけの近傍矩形を含む必要があります
    # minSize: 検出されるオブジェクトの最小サイズそのサイズよりも小さいオブジェクトは無視
    faces = cascade_path.detectMultiScale(gray, scaleFactor=1.1, minNeighbors=5, minSize=(30, 30))

    # 検出した顔に矩形を描画する
    for (x, y, w, h) in faces:
        cv2.rectangle(frame, (x, y), (x+w, y+h), (255, 0, 0), 2)

    # フレームを表示する
    cv2.imshow('Frame', frame)

    # 'q'キーが押されたらループを抜ける
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# カメラを解放する
cap.release()
cv2.destroyAllWindows()
