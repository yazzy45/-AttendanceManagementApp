function CameraButton() {
    const handleButtonClick = async()=>{
        const response = await fetch('http://localhost:8080/', {
            method: 'GET',
          });
          const data = await response.json();
          console.log("値帰ってきたよ",data);
    }
  

  return (
    <button onClick={handleButtonClick}>カメラを起動</button>
  );
}

export default CameraButton;
