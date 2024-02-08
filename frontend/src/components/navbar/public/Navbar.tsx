import { RiCloseFill, RiMenuFill, RiShoppingCartFill } from "react-icons/ri"
import { Link, useLocation } from "react-router-dom"
import { PATH_BLOG, PATH_HOME, PATH_LOGIN, PATH_NOSOTROS, PATH_PRODUCTOS } from "../../../routes/public/Paths"
import { Dialog } from "@headlessui/react"
import { useState } from "react"
import DropDownUser from "../../dropdown/DropDownUser"

const Navbar = () => {

    const navigation = [
        {
            name: 'Productos',
            href: PATH_PRODUCTOS
        },
        {
            name: 'Nosotros',
            href: PATH_NOSOTROS
        },
        {
            name: 'Blog',
            href: PATH_BLOG
        }
    ];

    const [mobileMenuOpen, setMobileMenuOpen] = useState(false);
    const [shopOpen, setShopOpen] = useState(false);
    const location = useLocation();

    return (
        <header className="h-16 sm:h-16 flex items-center z-30 w-full sticky top-0 bg-primary-50 border-b border-primary-100">
            <div className="container mx-auto px-6 flex items-center justify-between">
                <Link to={PATH_HOME} className="uppercase text-black-500 font-black lg:text-3xl text-2xl">
                    Shop.ME
                </Link>
                <div className="flex items-center">
                    <nav className=" font-poppins text-black-400 uppercase text-lg lg:flex items-center hidden">
                        <Link to={PATH_PRODUCTOS} className="py-2 px-6 flex">
                            Productos
                        </Link>
                        <Link to={PATH_NOSOTROS} className="py-2 px-6 flex">
                            Nosotros
                        </Link>
                        <Link to={PATH_BLOG} className="py-2 px-6 flex">
                            Blog informativo
                        </Link>
                    </nav>
                    <button type="button" onClick={() => setShopOpen(true)} className="relative inline-flex items-center p-2  text-sm font-medium text-center text-primary-300">
                        <RiShoppingCartFill className="w-8 h-8" />
                        <div className="absolute inline-flex items-center justify-center w-6 h-6 text-xs font-bold text-white bg-danger-300  rounded-full -top-0 -end-2">0</div>
                    </button>
                    <div className=" z-50 relative inline-flex items-center px-3 text-sm font-medium text-center text-success-200 rounded-lg">
                        <DropDownUser/>
                    </div>
                    <button className="lg:hidden flex flex-col" onClick={() => setMobileMenuOpen(true)}>
                        <RiMenuFill className="w-8 h-10 text-black-300" />
                    </button>
                </div>
            </div>

            <Dialog as="div" className=" bg-black-100" open={shopOpen} onClose={() => setShopOpen(false)}>
                <div className="fixed inset-0 z-50 backdrop-blur-sm" tabIndex={-1}></div>
                <Dialog.Panel className="shadow-2xl lg:rounded-s-3xl md:rounded-s-3xl fixed inset-y-0 right-0 z-50 w-full overflow-y-auto lg:border-l md:border-primary-800/35 lg:bg-white md:border-l border-primary-100 bg-primary-50 px-6 py-3 sm:max-w-sm">
                    <div className="flex items-center justify-between">
                        <div className="uppercase text-black-500 font-black text-2xl pt-1">
                            Orden de compras
                        </div>
                        <span
                            className="-m-2.5 rounded-full p-2.5 font-bold md:bg-white md:hover:bg-black-100 bg-primary-100 hover:bg-primary-200/50 text-black-300"
                            onClick={() => setShopOpen(false)}
                            tabIndex={0}
                        >
                            <RiCloseFill className="h-6 w-6" aria-hidden="true" />
                        </span>
                    </div>
                    <div className="mt-6 flow-root">
                        
                    </div>
                </Dialog.Panel>
            </Dialog>

            <Dialog as="div" className="lg:hidden" open={mobileMenuOpen} onClose={() => setMobileMenuOpen(false)}>
                <div className="fixed inset-0 z-50 backdrop-blur-sm" tabIndex={-1}></div>
                <Dialog.Panel className="fixed inset-y-0 right-0 z-50 w-full overflow-y-auto lg:border-l md:border-primary-100 md:border-l border-primary-100 bg-primary-50 px-6 py-3 sm:max-w-sm">
                    <div className="flex items-center justify-between">
                        <div className="uppercase text-black-500 font-black lg:text-3xl text-2xl pt-1">
                            Menu
                        </div>
                        <span
                            className="-m-2.5 rounded-full p-2.5 font-bold bg-primary-100 hover:bg-primary-200/50 text-black-300"
                            onClick={() => setMobileMenuOpen(false)}
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
                                        onClick={() => setMobileMenuOpen(false)}
                                        key={item.name}
                                        to={item.href}

                                        className={`-mx-auto block rounded-lg px-3 py-2 text-base font-semibold leading-7 text-center text-primary-300 bg-white  ${location.pathname === item.href ? 'text-green-500' : 'text-primary-400'
                                            } `}
                                    >
                                        {item.name}
                                    </Link>
                                ))}
                            </div>
                            <div className="grid py-6 gap-2 text-center">
                                <Link
                                    onClick={() => setMobileMenuOpen(false)}
                                    to={PATH_LOGIN}
                                    className="block rounded-lg px-3 py-2.5 text-base font-semibold leading-7 text-primary-300 hover:text-primary-300 bg-white  "
                                    tabIndex={0}
                                >
                                    Iniciar Sesion
                                </Link>
                            </div>
                        </div>
                    </div>
                </Dialog.Panel>
            </Dialog>
        </header>
    )
}

export default Navbar