import { lazy } from "react";
import { PATH_ADMIN_COMPANY, PATH_ADMIN_COMPANY_EDIT, PATH_ADMIN_HOME, PATH_CATEGORIA_PRODUCTOS_ADMIN, PATH_CATEGORIA_PRODUCTOS_ADMIN_NEW, PATH_CLIENTES_ADMIN, PATH_CLIENTE_ADMIN, PATH_CLIENTE_ADMIN_NEW, PATH_EMPLEADOS_ADMIN, PATH_EMPLEADO_ADMIN, PATH_EMPLEADO_ADMIN_EDIT, PATH_EMPLEADO_ADMIN_NEW, PATH_ORDERS_ADMIN, PATH_PRODUCTOS_ADMIN, PATH_PRODUCTO_ADMIN, PATH_PRODUCTO_ADMIN_NEW } from "./PrivatePaths";

export const PATHS_ADMIN = {
    layout: lazy(async () => await import("../../layouts/private/AdminLayout")),
    children: [
        // ======== Inicio ========
        {
            path: PATH_ADMIN_HOME,
            element: lazy(async () => await import("../../pages/public/blog/Blog")),
        },
        {
            path: PATH_ADMIN_COMPANY,
            element: lazy(async () => await import("../../pages/private/company/Company")),
        },
        {
            path: PATH_ADMIN_COMPANY_EDIT,
            element: lazy(async () => await import("../../pages/private/company/CompanyEdit")),
        },
        {
            path: PATH_EMPLEADOS_ADMIN,
            element: lazy(async () => await import("../../pages/private/employe/EmployeIndex")),
        },
        {
            path: PATH_EMPLEADO_ADMIN_NEW,
            element: lazy(async () => await import("../../pages/private/employe/EmployeNew")),
        },
        {
            path: PATH_EMPLEADO_ADMIN,
            element: lazy(async () => await import("../../pages/private/employe/EmployeView")),
        },
        {
            path: PATH_EMPLEADO_ADMIN_EDIT,
            element: lazy(async () => await import("../../pages/private/employe/EmployeEdit")),
        },
        {
            path: PATH_CATEGORIA_PRODUCTOS_ADMIN,
            element: lazy(async () => await import("../../pages/private/product-category/ProductCategoryIndex")),
        },
        {
            path: PATH_CATEGORIA_PRODUCTOS_ADMIN_NEW,
            element: lazy(async () => await import("../../pages/private/product-category/ProductCategoryNew")),
        },
        {
            path: PATH_PRODUCTOS_ADMIN,
            element: lazy(async () => await import("../../pages/private/product/ProductIndex")),
        },
        {
            path: PATH_PRODUCTO_ADMIN_NEW,
            element: lazy(async () => await import("../../pages/private/product/ProductNew")),
        },
        {
            path: PATH_PRODUCTO_ADMIN,
            element: lazy(async () => await import("../../pages/private/product/ProductView")),
        },
        {
            path: PATH_CLIENTES_ADMIN,
            element: lazy(async () => await import("../../pages/private/customer/CustomerIndex")),
        },
        {
            path: PATH_CLIENTE_ADMIN,
            element: lazy(async () => await import("../../pages/private/customer/CustomerView")),
        },
        {
            path: PATH_CLIENTE_ADMIN_NEW,
            element: lazy(async () => await import("../../pages/private/customer/CustomerNew")),
        },
        {
            path: PATH_ORDERS_ADMIN,
            element: lazy(async () => await import("../../pages/private/order/Order")),
        },
        {
            path: PATH_ADMIN_HOME + "/*",
            element: lazy(async () => await import("../../pages/error/NotFoundAdmin")),
        },
    ]
}