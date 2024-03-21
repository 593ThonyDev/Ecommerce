import axios from "axios";
import { API_URL } from "../../../../functions/ApiConst";

export const createOrder = (idCustomer: string) => {
    return axios.post(`${API_URL}order/create/${idCustomer}`)
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

export const addProduct = (orderCode: string, idProduct: string) => {

    const formDataToSend = new FormData();

    formDataToSend.append("orderCode", orderCode);
    formDataToSend.append("idProduct", idProduct);

    return axios.post(`${API_URL}order/addProduct`, formDataToSend)
        .then((response) => {
            if (response.data == null) {
                return null;
            } else {
                return response.data;
            }
        })
        .catch((error) => {
            throw error;
        });
};

export const updateProduct = (orderCode: string, idProduct: string, quantity: string) => {

    const formDataToSend = new FormData();

    formDataToSend.append("orderCode", orderCode);
    formDataToSend.append("idProduct", idProduct);
    formDataToSend.append("quantity", quantity);

    return axios.post(`${API_URL}order/updateProduct`, formDataToSend)
        .then((response) => {
            if (response.data == null) {
                return null;
            } else {
                return response.data;
            }
        })
        .catch((error) => {
            throw error;
        });
};

export const deleteProduct = (orderCode: string, idProduct: string) => {

    const formDataToSend = new FormData();

    formDataToSend.append("orderCode", orderCode);
    formDataToSend.append("idProduct", idProduct);

    return axios.post(`${API_URL}order/deleteProduct`, formDataToSend)
        .then((response) => {
            if (response.data == null) {
                return null;
            } else {
                return response.data;
            }
        })
        .catch((error) => {
            throw error;
        });
};

export const getOrder = (idCustomer: string, orderCode: string) => {
    return axios.get(`${API_URL}order/getOrder/${idCustomer}/${orderCode}`)
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