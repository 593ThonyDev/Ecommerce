import axios, { AxiosResponse } from "axios";
import { User } from "./User";
import { API_URL } from "../../../../../functions/ApiConst";

export const getAllUsers = async (setIsLoading: (value: boolean) => void): Promise<User[]> => {
    try {
        setIsLoading(true);
        await new Promise(resolve => setTimeout(resolve, 800));
        const response: AxiosResponse<{ content: User[] }> = await axios.get(API_URL + 'user/list');
        setIsLoading(false);
        return response.data.content;
    } catch (error) {
        setIsLoading(false);
        throw error;
    }
};

export const getUserById = async (id: number): Promise<User> => {
    try {
        const response = await axios.get(`${API_URL}user/${id}`);
        return response.data.content;
    } catch (error) {
        throw error;
    }
};