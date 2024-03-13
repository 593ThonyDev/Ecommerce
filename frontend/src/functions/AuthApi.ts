import { NavigateFunction } from 'react-router-dom';
import { SESSION_FULL_NAME, SESSION_ID_ADMIN_EMPLOYE_CUSTOMER, SESSION_ID_USER, SESSION_PHOTO_PROFILE, SESSION_TOKEN } from './ApiConst';
import axios from 'axios';
import { PATH_HOME } from '../routes/public/Paths';

export const saveToken = (token: string): void => {
    localStorage.setItem(SESSION_TOKEN, token);
};

export const getToken = (): string | null => {
    return localStorage.getItem(SESSION_TOKEN);
}

export const setToken = (): void => {
    const token: string | null = localStorage.getItem(SESSION_TOKEN);
    if (token) {
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
    } else {
        delete axios.defaults.headers.common['Authorization'];
    }
};

export const setPhotoProfile = (photo: string): void => {
    localStorage.setItem(SESSION_PHOTO_PROFILE, "https://" + photo);
};

export const getPhotoProfile = (): string | null => {
    return localStorage.getItem(SESSION_PHOTO_PROFILE);
}

export const setIdUser = (idUser: string): void => {
    localStorage.setItem(SESSION_ID_USER, idUser);
};

export const getIdUser = (): string | null => {
    return localStorage.getItem(SESSION_ID_USER);
}

export const setCustomerOrEmploye = (idCustomerAdmin: string): void => {
    localStorage.setItem(SESSION_ID_ADMIN_EMPLOYE_CUSTOMER, idCustomerAdmin);
};

export const getCustomerOrEmploye = (): string | null => {
    return localStorage.getItem(SESSION_ID_ADMIN_EMPLOYE_CUSTOMER);
};

export const setFullName = (fullName: string): void => {
    localStorage.setItem(SESSION_FULL_NAME, fullName);
};

export const getFullName = (): string | null => {
    return localStorage.getItem(SESSION_FULL_NAME);
};

export const logOut = (navigate: NavigateFunction): void => {
    localStorage.removeItem(SESSION_TOKEN);
    localStorage.removeItem(SESSION_ID_USER);
    localStorage.removeItem(SESSION_PHOTO_PROFILE);
    localStorage.removeItem(SESSION_FULL_NAME);
    localStorage.removeItem(SESSION_ID_ADMIN_EMPLOYE_CUSTOMER);
    navigate(PATH_HOME);
};


