interface LoginResponse {
    username?: string
    password?: string
    token?: string;
    userDetails?: {
        iduser: number;
        idCustomer?: number;
        idEmploye?: number;
        username: string;
        fullname: string;
        role: string;
        status?: string;
        photo?: string;
    };
}