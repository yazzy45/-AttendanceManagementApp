// src/Routes.tsx
import { Routes, Route } from "react-router-dom";
import Home from "./compornent/home"
import LoginPage from "./compornent/login";

export const AppRoutes = () => {
    return (
        <Routes>
            <Route path="/home" element={<Home />} />
            <Route path="/" element={<LoginPage />} />
        </Routes>
    )
}