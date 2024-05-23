import React, { useEffect, useState } from "react";
import axios from "axios";
import '../css/home.css'; // カスタムCSSをインポート

const Home = () => {
  const [users, setUsers] = useState([]); 
  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/home');
        setUsers(response.data);
        console.log("Users fetched:", response.data);
      } catch (error) {
        console.error("Error fetching users:", error);
      }
    };
    fetchUsers();
  }, []);

  return (
    <div className="container">
      <h1>出社管理</h1>
      <ul>    
        {users.map((user) => (
          <li key={user.id}>
            <div className="user-id">{user.id}</div>   
            <div className="user-role">{user.role}</div>
              <div className="user-username">{user.username}</div>
              <div>未出社</div>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Home;
