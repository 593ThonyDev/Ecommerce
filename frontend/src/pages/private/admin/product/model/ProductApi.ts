import { API_URL } from '../../../../../functions/ApiConst';
import axios, { AxiosResponse } from 'axios';
import { Product } from './Product';
import toast from 'react-hot-toast';

export const getAllProducts = async (currentPage: number, setIsLoading: (value: boolean) => void): Promise<{ content: Product[], totalElements: number }> => {
    try {
        setIsLoading(true);
        await new Promise(resolve => setTimeout(resolve, 800));
        const response: AxiosResponse<{ content: Product[], totalElements: number }> = await axios.get(API_URL + 'product/list', {
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

export const searchProduct = (value: string) => {
    return axios.get(`${API_URL}product/search/${value}`)
        .then((response) => {
            if (response.data == null) {
                return null;
            } else if (response.status == 204) {
                return null;
            } else {
                return response.data;
            }
        })
        .catch((error) => {
            throw error;
        });
};

const handleResponse = async (promise: Promise<AxiosResponse>): Promise<any> => {
    try {
        const response = await promise;
        const message = response.data.message;
        toast.success(message);
        return true;
    } catch (error: any) {
        const errorMessage = error.response?.data?.message || 'Error al realizar la operación';
        toast.error(errorMessage);
        return false;
    }
};

export const saveOrUpdateProduct = async (product: Product, idProduct?: string): Promise<boolean> => {
    try {
        const formDataToSend = new FormData();
        formDataToSend.append("nombre", product.name);
        formDataToSend.append("descripcion", product.description);
        formDataToSend.append("precio", product.price.toString());
        formDataToSend.append("stock", product.stock.toString());
        
        if (idProduct) {
            formDataToSend.append("idProducto", idProduct);
        }
        if (product.Category?.idCategory) {
            formDataToSend.append("categoria", product.Category.idCategory?.toString());
        }

        if (product.created) {
            formDataToSend.append("empleado", product.created.toString());
        }

        if (product.img1) {
            formDataToSend.append("img1", product.img1);
        }

        if (product.img2) {
            formDataToSend.append("img2", product.img2);
        }

        if (product.img3) {
            formDataToSend.append("img3", product.img3);
        }

        const request = idProduct ? axios.patch(`${API_URL}product/update`, formDataToSend) :
            axios.post(`${API_URL}product/save`, formDataToSend);

        return await handleResponse(request);
    } catch (error) {
        return false;
    }
};