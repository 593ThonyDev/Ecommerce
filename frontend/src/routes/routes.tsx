import { FC, LazyExoticComponent, ReactNode, lazy } from "react";
import { PATHS_PUBLIC } from "./public/PathsPublic";
import { PATH_LOGIN, PATH_REGISTER } from "./public/Paths";

interface LayoutComponentProps {
    children: ReactNode;
}

interface GuardComponentProps {
    children: ReactNode;
}

interface ElementComponentProps {
    children: ReactNode;
}

export interface RouteProps {
    path?: string;
    element?: LazyExoticComponent<FC<ElementComponentProps>> | null;
    layout?: LazyExoticComponent<FC<LayoutComponentProps>> | null;
    guard?: LazyExoticComponent<FC<GuardComponentProps>> | null;
    children?: RouteProps[];
}

export const routes: RouteProps[] = [
    {
        children: [
            {
                path: PATH_LOGIN,
                element: lazy(async () => await import("../pages/public/auth/Login")),
            },
            {
                path: PATH_REGISTER,
                element: lazy(async () => await import("../pages/public/auth/Register")),
            },
        ]
    },
    PATHS_PUBLIC
];