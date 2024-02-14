import { lazy } from "react";
import { PATH_ADMIN_COMPANY, PATH_ADMIN_COMPANY_EDIT, PATH_ADMIN_HOME, PATH_CATEGORIA_PRODUCTOS_ADMIN, PATH_CATEGORIA_PRODUCTOS_ADMIN_NEW, PATH_CLIENTES_ADMIN, PATH_CLIENTE_ADMIN, PATH_CLIENTE_ADMIN_EDIT, PATH_CLIENTE_ADMIN_NEW, PATH_EMPLEADOS_ADMIN, PATH_EMPLEADO_ADMIN, PATH_EMPLEADO_ADMIN_EDIT, PATH_EMPLEADO_ADMIN_NEW, PATH_ORDERS_ADMIN, PATH_PRODUCTOS_ADMIN, PATH_PRODUCTO_ADMIN, PATH_PRODUCTO_ADMIN_NEW } from "./PrivatePaths";

export const PATHS_ADMIN = {
    layout: lazy(async () => await import("../../../layouts/private/admin/AdminLayout")),
    children: [
        // ======== Inicio ========
        {
            path: PATH_ADMIN_HOME,
            element: lazy(async () => await import("../../../pages/public/blog/Blog")),
        },
        // ======== Company ========
        {
            path: PATH_ADMIN_COMPANY,
            element: lazy(async () => await import("../../../pages/private/admin/company/Company")),
        },
        {
            path: PATH_ADMIN_COMPANY_EDIT,
            element: lazy(async () => await import("../../../pages/private/admin/company/CompanyEdit")),
        },
        // ======== Employes ========
        {
            path: PATH_EMPLEADOS_ADMIN,
            element: lazy(async () => await import("../../../pages/private/admin/employe/EmployeIndex")),
        },
        {
            path: PATH_EMPLEADO_ADMIN_NEW,
            element: lazy(async () => await import("../../../pages/private/admin/employe/EmployeNew")),
        },
        {
            path: PATH_EMPLEADO_ADMIN,
            element: lazy(async () => await import("../../../pages/private/admin/employe/EmployeView")),
        },
        {
            path: PATH_EMPLEADO_ADMIN_EDIT,
            element: lazy(async () => await import("../../../pages/private/admin/employe/EmployeEdit")),
        },
        // ======== Product-category ========
        {
            path: PATH_CATEGORIA_PRODUCTOS_ADMIN,
            element: lazy(async () => await import("../../../pages/private/admin/product-category/ProductCategoryIndex")),
        },
        {
            path: PATH_CATEGORIA_PRODUCTOS_ADMIN_NEW,
            element: lazy(async () => await import("../../../pages/private/admin/product-category/ProductCategoryNew")),
        },
        // ======== Product ========
        {
            path: PATH_PRODUCTOS_ADMIN,
            element: lazy(async () => await import("../../../pages/private/admin/product/ProductIndex")),
        },
        {
            path: PATH_PRODUCTO_ADMIN_NEW,
            element: lazy(async () => await import("../../../pages/private/admin/product/ProductNew")),
        },
        {
            path: PATH_PRODUCTO_ADMIN,
            element: lazy(async () => await import("../../../pages/private/admin/product/ProductView")),
        },
        // ======== Customer ========
        {
            path: PATH_CLIENTES_ADMIN,
            element: lazy(async () => await import("../../../pages/private/admin/customer/CustomerIndex")),
        },
        {
            path: PATH_CLIENTE_ADMIN,
            element: lazy(async () => await import("../../../pages/private/admin/customer/CustomerView")),
        },
        {
            path: PATH_CLIENTE_ADMIN_NEW,
            element: lazy(async () => await import("../../../pages/private/admin/customer/CustomerNew")),
        },
        {
            path: PATH_CLIENTE_ADMIN_EDIT,
            element: lazy(async () => await import("../../../pages/private/admin/customer/CustomerEdit")),
        },
        // ======== Order ========
        {
            path: PATH_ORDERS_ADMIN,
            element: lazy(async () => await import("../../../pages/private/admin/order/Order")),
        },
        {
            path: PATH_ADMIN_HOME + "/*",
            element: lazy(async () => await import("../../../pages/error/NotFoundAdmin")),
        },
    ]
}