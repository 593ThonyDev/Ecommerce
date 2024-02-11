import { Category } from "../../product-category/model/Category"

export interface Product {
    idProduct?: number
    name?: string
    img1?: string
    img2?: string
    img3?: string
    price?: number
    stock?: number
    status?: string
    created?: string
    description?: string
    category?: Category
}