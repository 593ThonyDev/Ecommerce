import { PATH_ADMIN_ABOUT, PATH_ADMIN_COMPANY, PATH_ADMIN_HOME, PATH_CATEGORIA_PRODUCTOS_ADMIN, PATH_CLIENTES_ADMIN, PATH_EMPLEADOS_ADMIN, PATH_ORDERS_ADMIN, PATH_PRODUCTOS_ADMIN, PATH_USERS_ADMIN } from "../../../../routes/private/admin/PrivatePaths"
import DropDownAdmin from "../../../dropdown/DropDownAdmin"
import { RiCloseFill, RiMenuFill } from "react-icons/ri"
import { Dialog } from "@headlessui/react"
import { Link } from "react-router-dom"
import { useState } from "react"

const NavbarAdmin = () => {
    
    const [menuOpen, setMenuOpen] = useState(false);

    const navigation = [
        {
            name: 'Inicio',
            href: PATH_ADMIN_HOME
        },
        {
            name: 'Empresa',
            href: PATH_ADMIN_COMPANY
        },
        {
            name: 'Ventas',
            href: PATH_ORDERS_ADMIN
        },
        {
            name: 'Cat. productos',
            href: PATH_CATEGORIA_PRODUCTOS_ADMIN
        },
        {
            name: 'Productos',
            href: PATH_PRODUCTOS_ADMIN
        },
        {
            name: 'Empleados',
            href: PATH_EMPLEADOS_ADMIN
        },
        {
            name: 'Clientes',
            href: PATH_CLIENTES_ADMIN
        },
        {
            name: 'Usuarios',
            href: PATH_USERS_ADMIN
        },
        {
            name: 'Nosotros',
            href: PATH_ADMIN_ABOUT
        },
        {
            name: 'Blog',
            href: PATH_ADMIN_ABOUT
        },
    ];

    return (
        <header className="h-16 sm:h-16 flex items-center z-30 w-full sticky top-0 bg-primary-50 lg:bg-white border-b border-primary-100">
            <div className="container mx-auto lg:px-6 md:px-2 px-1 flex items-center justify-between">

                <div className="flex items-center flex-row-reverse justify-center">
                    <Link to={PATH_ADMIN_HOME} className="p-2 my-auto uppercase text-black-500 font-black lg:text-3xl text-2xl">
                        Shop.ME
                    </Link>
                    <div onClick={() => setMenuOpen(true)} className="relative inline-flex items-center p-3 lg:ml-4 md:ml-2 hover:bg-black-100/50 px-3 rounded-full text-sm font-medium text-center text-black-300">
                        <RiMenuFill className="w-6 h-6" />
                    </div>
                </div>

                <div className="flex items-center">
                    <div className="z-50 relative inline-flex items-center px-3 text-sm font-medium text-center text-black-300 rounded-lg">
                        <DropDownAdmin />
                    </div>
                </div>
            </div>

            <Dialog as="div"
                open={menuOpen}
                onClose={() => setMenuOpen(false)}
                className="bg-black-100 "
            >
                <div tabIndex={-1}
                    className="fixed inset-0 z-50 backdrop-blur-sm" />
                <Dialog.Panel
                    className={`fixed inset-y-0 ${menuOpen ? 'left-0' : '-right-full'} z-50 w-full overflow-y-auto bg-primary-50 lg:bg-white border-r border-primary-100 lg:shadow-2xl px-6 py-3 sm:max-w-sm transition-transform duration-1000 ease-in-out`}>
                    <div className="flex items-center justify-between">
                        <div className="uppercase text-black-500 font-black text-3xl">
                            Menu
                        </div>
                        <span
                            className="-m-2.5 rounded-full p-2.5 font-bold bg-primary-100 md:bg-white md:hover:bg-black-100 lg:bg-white lg:hover:bg-black-100 hover:bg-primary-200/50 text-black-300 outline-none"
                            onClick={() => setMenuOpen(false)}
                            tabIndex={0}
                        >
                            <RiCloseFill className="h-6 w-6" aria-hidden="true" />
                        </span>
                    </div>
                    <div className="mt-6 flow-root">
                        <div className="-my-6 divide-y divide-primary-200">
                            <div className="space-y-2 py-6">
                                {navigation.map((item) => (
                                    <Link
                                        onClick={() => setMenuOpen(false)}
                                        key={item.name}
                                        to={item.href}
                                        className={`block rounded-lg px-3 py-2 text-base font-semibold leading-7 text-center text-primary-300 bg-white lg:bg-primary-50/80 lg:hover:bg-primary-100/60 transition-colors duration-300 ${location.pathname === item.href ? 'text-green-500' : 'text-primary-200'}`}
                                    >
                                        {item.name}
                                    </Link>
                                ))}
                            </div>
                        </div>
                    </div>
                </Dialog.Panel>
            </Dialog>
        </header>
    )
}

export default NavbarAdmin
