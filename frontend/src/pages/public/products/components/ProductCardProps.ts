import { ChangeEvent } from "react";

export interface ProductCardProps {
    idProduct: string;
    price: string;
    name: string;
    img1: string;
    onChange?: (event: ChangeEvent<HTMLInputElement>) => void;
}
