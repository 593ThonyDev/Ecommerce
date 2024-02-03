import { lazy } from "react";
import { PATH_BLOG, PATH_HOME, PATH_LOGIN, PATH_PRODUCTO, PATH_PRODUCTOS, PATH_REGISTER } from "./Paths";

export const PATHS_PUBLIC = {
    layout: lazy(async () => await import("../../layouts/public/PublicLayout")),
    children: [
        // ======== Inicio ========
        {
            path: PATH_HOME,
            element: lazy(async () => await import("../../pages/public/landing/Landing")),
        },       
        {
            path: PATH_PRODUCTOS,
            element: lazy(async () => await import("../../pages/public/products/Product")),
        },       
        {
            path: PATH_PRODUCTO,
            element: lazy(async () => await import("../../pages/public/products/ProductDetail")),
        },       
        {
            path: PATH_BLOG,
            element: lazy(async () => await import("../../pages/public/blog/Blog")),
        },       
        {
            path: PATH_LOGIN,
            element: lazy(async () => await import("../../pages/public/auth/Login")),
        },       
        {
            path: PATH_REGISTER,
            element: lazy(async () => await import("../../pages/public/auth/Register")),
        },       
    ]
}