import { lazy } from "react";
import { PATH_ADMIN_COMPANY, PATH_ADMIN_COMPANY_EDIT, PATH_ADMIN_HOME, PATH_CATEGORIA_PRODUCTOS_ADMIN, PATH_CATEGORIA_PRODUCTOS_ADMIN_NEW, PATH_CATEGORIA_PRODUCTO_ADMIN, PATH_CATEGORIA_PRODUCTO_ADMIN_EDIT, PATH_CLIENTES_ADMIN, PATH_CLIENTE_ADMIN, PATH_CLIENTE_ADMIN_EDIT, PATH_CLIENTE_ADMIN_NEW, PATH_EMPLEADOS_ADMIN, PATH_EMPLEADO_ADMIN, PATH_EMPLEADO_ADMIN_EDIT, PATH_EMPLEADO_ADMIN_NEW, PATH_ORDERS_ADMIN, PATH_PRODUCTOS_ADMIN, PATH_PRODUCTO_ADMIN, PATH_PRODUCTO_ADMIN_EDIT, PATH_PRODUCTO_ADMIN_NEW, PATH_USERS_ADMIN, PATH_USER_ADMIN_VIEW } from "./PrivatePaths";
import { RouteProps } from "../../routes";


export const PATHS_ADMIN: RouteProps = {
    layout: lazy(async () => await import("../../../layouts/private/admin/AdminLayout")),
    guard: lazy(async () => await import("../../../guards/AdministratorGuard")),
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
        {
            path: PATH_CATEGORIA_PRODUCTO_ADMIN_EDIT,
            element: lazy(async () => await import("../../../pages/private/admin/product-category/ProductCategoryEdit")),
        },
        {
            path: PATH_CATEGORIA_PRODUCTO_ADMIN,
            element: lazy(async () => await import("../../../pages/private/admin/product-category/ProductCategoryView")),
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
            path: PATH_PRODUCTO_ADMIN_EDIT,
            element: lazy(async () => await import("../../../pages/private/admin/product/ProductEdit")),
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
        // ======== User ========
        {
            path: PATH_USERS_ADMIN,
            element: lazy(async () => await import("../../../pages/private/admin/user/UserIndex")),
        },
        {
            path: PATH_USER_ADMIN_VIEW,
            element: lazy(async () => await import("../../../pages/private/admin/user/UserView")),
        },
        // ======== Error Page admin ========
        {
            path: PATH_ADMIN_HOME + "/*",
            element: lazy(async () => await import("../../../pages/error/NotfoundAdminDefault"))
        },
    ]
}