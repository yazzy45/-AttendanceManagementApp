import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
// シンプルなログインフォームを作るためMDBReactUIKit
import { 
    MDBContainer, 
    MDBInput, 
    MDBBtn, 
} from 'mdb-react-ui-kit'; 
const LoginPage = () => {
    const [email, setemail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");
    // ルートへのナビゲーションを提供するために使用
    const navigate = useNavigate();
    const handleLogin = async () => {
        try{
            if (!email || !password) {
              setError('メールアドレスまたはパスワードが入力されていません。'); 
              return;
            }
            const response = await axios.post('http://localhost:8080/api/login', { email,password }); 
            console.log('Login successful:', response.data); 
            if (response.data["status"]==="success") {
              console.log('OK');
              navigate('/home');
            }
            //コンソールログと違って強調表示　response.dataがあればサーバーからのエラーメッセージを表示
          }catch(error){
            setError('メールアドレスまたはパスワードが正しくありません。もう一度お試しください。');
            console.error('Login failed:', error.response ? error.response.data : error.message); 
          }
    };

  return (
    <div className="d-flex justify-content-center align-items-center vh-100"> 
    <div className="border rounded-lg p-4" style={{ width: '500px', height: 'auto' }}> 
        <MDBContainer className="p-3"> 
            <h2 className="mb-4 text-center">ログインページ</h2> 
            <MDBInput wrapperClass='mb-4' placeholder='email' id='email' value={email} type='email' onChange={(e) => setemail(e.target.value)} /> 
            <MDBInput wrapperClass='mb-4' placeholder='Password' id='password' type='password' value={password} onChange={(e) => setPassword(e.target.value)} /> 
            {error && <p className="text-danger" style={{coler:'red'}}>{error}</p>} 
            <MDBBtn className="mb-4 d-block btn-primary" style={{ height:'50px',width: '100%' }} onClick={handleLogin}>サインイン</MDBBtn> 
        </MDBContainer> 
    </div> 
</div> 
  );
}

export default LoginPage;
