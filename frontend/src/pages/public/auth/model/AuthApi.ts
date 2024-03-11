import axios from "axios";
import { API_URL, SESSION_TOKEN } from "../../../../functions/ApiConst";
import toast from "react-hot-toast";
import { PATH_ADMIN_HOME } from "../../../../routes/private/admin/PrivatePaths";
import { PATH_HOME } from "../../../../routes/public/Paths";
import { NavigateFunction } from "react-router-dom";

export const AuthByUsernamePassword = async (user: LoginResponse, navigate: NavigateFunction): Promise<boolean> => {
    try {
        const formDataToSend = new FormData();

        if (!user.username || !user.password) {
            toast.error("Debe proporcionar un nombre de usuario y una contraseña");
            return false;
        }

        formDataToSend.append("username", user.username);
        formDataToSend.append("password", user.password);

        const response = await axios.post(`${API_URL}auth/login`, formDataToSend);
        const responseData = response.data;

        if (responseData.message) {
            toast.success(responseData.message);
        } else {
            toast.error("Mensaje no encontrado en la respuesta");
        }

        if (responseData.userDetails) {
            const userDetails = responseData.userDetails;
            user.userDetails = userDetails;

            if (user.userDetails?.role === "ADMINISTRATOR") {
                navigate(PATH_ADMIN_HOME);
            } else if (user.userDetails?.role === "CUSTOMER") {
                navigate(PATH_ADMIN_HOME); // ¿Esto debería ser PATH_HOME?
            } else {
                navigate(PATH_HOME);
            }
        } else {
            toast.error("Detalles del usuario no encontrados en la respuesta");
        }

        if (responseData.token) {
            localStorage.setItem(SESSION_TOKEN, responseData.token);
        }

        return true;
    } catch (error: any) {
        const errorMessage = error.response?.data?.message || 'Error al realizar la operación';
        toast.error(errorMessage);
        return false;
    }
};
