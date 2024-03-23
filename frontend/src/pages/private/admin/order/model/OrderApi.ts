import axios, { AxiosResponse } from "axios";
import { setToken } from "../../../../../functions/AuthApi";
import { OrderModel } from "./Order";
import { API_URL } from "../../../../../functions/ApiConst";

export const getAllOrders = async (currentPage: number, setIsLoading: (value: boolean) => void): Promise<{ content: OrderModel[], totalElements: number }> => {
    try {
        setToken();
        setIsLoading(true);
        await new Promise(resolve => setTimeout(resolve, 800));
        const response: AxiosResponse<{ content: OrderModel[], totalElements: number }> = await axios.get(API_URL + 'order/allList', {
            params: {
                page: currentPage,
                size: 12
            }
        });
        setIsLoading(false);
        return response.data;
    } catch (error:any) {
        setIsLoading(false);
        return error;
    }
};