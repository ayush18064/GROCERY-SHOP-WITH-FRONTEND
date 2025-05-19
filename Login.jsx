import React, { useState } from "react";
import axios from "axios"
import { useNavigate } from "react-router-dom";
function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  const handleLogin = async () => {
    try {
      const response = await axios.post("/login",
        {
          email,
          password
        }
      )
      navigate("/catalog")


    } catch (error) {
      alert("incorrect credentials")
      console.log(error);

    }
  }
  return (
    <>
      <div className="container mt-4">
        <h2>Login</h2>
        <div className="mb-3">
          <label htmlFor="" className="form-label">
            Email
          </label>
          <input
            className="form-control"
            type="email"
            name="email"
            id="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
        <div className="mb-3">
          <label>Password:</label>
          <input
            type="password"
            className="form-control"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="Enter your password"
          />
        </div>
        <button onClick={handleLogin} className="btn btn-primary">Login</button>

      </div>
    </>
  );
}

export default Login;
