import axios, { AxiosResponse } from 'axios';
import { toast } from 'react-hot-toast';
import { API_URL } from '../../../../functions/ApiConst';
import { Employe } from '../model/Employe';

export const saveEmploye = async (employe: Employe): Promise<boolean> => {
    try {
        const formDataToSend = new FormData();
        formDataToSend.append("nombres", employe.names + " " + employe.lastName);
        formDataToSend.append("email", employe.email);
        formDataToSend.append("descripcion", employe.description);
        formDataToSend.append("telefono", employe.phone);
        if (employe.photo) {
            formDataToSend.append("photo", employe.photo);
        }
        const response = await axios.post(`${API_URL}employe/save`, formDataToSend);
        const message = response.data.message;
        toast.success(message);
        return true;
    } catch (error: any) {
        const errorMessage = error.response?.data?.message || 'Error al guardar el empleado';
        toast.error(errorMessage);
        return false;
    }
};

export const getAllEmployes = async (currentPage: number, setIsLoading: (value: boolean) => void): Promise<{ content: Employe[], totalElements: number }> => {
    try {
        setIsLoading(true);
        await new Promise(resolve => setTimeout(resolve, 800));
        const response: AxiosResponse<{ content: Employe[], totalElements: number }> = await axios.get(API_URL + 'employe/list', {
            params: {
                page: currentPage,
                size: 12
            }
        });
        setIsLoading(false);
        return response.data;
    } catch (error) {
        setIsLoading(false);
        throw error;
    }
};

export const getEmployeById = async (id: number): Promise<Employe> => {
    try {
        const response = await axios.get(`${API_URL}employe/${id}`);
        return response.data.content;
    } catch (error) {
        throw error;
    }
};