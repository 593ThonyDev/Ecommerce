import axios, { AxiosResponse } from "axios";
import { API_URL } from "../../../functions/ApiConst";

export const handleResponse = async (promise: Promise<AxiosResponse>): Promise<any> => {
    try {
        const response = await promise;
        return response.data;
    } catch (error: any) {
        throw new Error(error.response?.data?.message || 'Error al realizar la operación');
    }
};

export const AuthByUsernamePassword = async (user: LoginResponse): Promise<any> => {
    try {
        const formDataToSend = new FormData();
        if (user.username && user.password) {
            formDataToSend.append("username", user.username);
            formDataToSend.append("password", user.password);
        }
        const request = axios.post(`${API_URL}auth/login`, formDataToSend);
        return await handleResponse(request);
    } catch (error) {
        throw new Error("Error al autenticar usuario");
    }
};
