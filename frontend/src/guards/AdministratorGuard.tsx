import { getToken, logOut } from "../functions/AuthApi";
import { PATH_HOME } from "../routes/public/Paths";
import { Navigate } from "react-router-dom";
import { jwtDecode } from "jwt-decode";
import React from "react";

interface JwtPayload {
  exp: number;
  role: string;
}

interface AuthGuardProps {
  children: React.ReactNode;
}

const AuthGuard = ({ children }: AuthGuardProps) => {
  const token = getToken();

  if (token) {
    try {
      const decoded: JwtPayload = jwtDecode(token);

      const now = Math.floor(Date.now() / 1000);

      if (decoded.exp < now) {
        logOut();
        return <Navigate to={PATH_HOME} />;
      } else {
        if (decoded.role === 'ADMINISTRATOR') {
          return <>{children}</>;
        } else {
          logOut();
          return <Navigate to={PATH_HOME} />;
        }
      }
    } catch (error) {
      return <Navigate to={PATH_HOME} />;
    }
  } else {
    return <Navigate to={PATH_HOME} />;
  }
}

export default AuthGuard;
