import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
// シンプルなログインフォームを作るためMDBReactUIKit
import { 
    MDBContainer, 
    MDBInput, 
    MDBBtn, 
} from 'mdb-react-ui-kit'; 
import '../css/login.css';
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
    <div className="login-container">
    <div className="login-box">
        <MDBContainer>
            <h2 className="mb-4">ログインページ</h2> 
            <MDBInput className="form-control" placeholder='Email' id='email' value={email} type='email' onChange={(e) => setemail(e.target.value)} /> 
            <MDBInput className="form-control" placeholder='Password' id='password' type='password' value={password} onChange={(e) => setPassword(e.target.value)} /> 
            {error && <p className="text-danger">{error}</p>} 
            <MDBBtn className="btn-primary" onClick={handleLogin}>サインイン</MDBBtn> 
        </MDBContainer> 
    </div> 
</div> 
  );
}

export default LoginPage;
