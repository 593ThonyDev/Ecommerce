import { Dialog } from "@headlessui/react";
import { useState } from "react";
import { RiShoppingCartFill, RiCloseFill } from "react-icons/ri";

const CartIndex = () => {
    const [shopOpen, setShopOpen] = useState(false);

    return (
        <div className=" outline-none">
            <div
                onClick={() => setShopOpen(true)}
                className="relative inline-flex items-center p-2 text-sm font-medium text-center text-primary-300"
            >
                <RiShoppingCartFill className="w-8 h-8" />
                <div className="absolute inline-flex items-center justify-center w-6 h-6 text-xs font-bold text-white bg-danger-300 rounded-full -top-0 -end-2">
                    0
                </div>
            </div>
            <Dialog
                as="div"
                className=" bg-black-100"
                open={shopOpen}
                onClose={() => setShopOpen(false)}
            >
                <div className="fixed inset-0 z-50 backdrop-blur-sm" tabIndex={-1}></div>
                <Dialog.Panel className="shadow-2xl fixed inset-y-0 right-0 z-50 w-full overflow-y-auto lg:border-l md:border-primary-200 lg:bg-white md:border-l border-primary-200 bg-primary-50 px-6 sm:max-w-sm">
                    <div className="flex flex-col h-full justify-between">
                        <div className="lg:bg-white bg-primary-50">
                            <div className="flex w-full justify-between sticky pt-3 pb-1 top-0 lg:bg-white bg-primary-50">
                                <div className="uppercase text-black-500 font-black text-xl pt-1">
                                    Carrito de compras
                                </div>
                                <div
                                    className=" rounded-full p-2.5 font-bold md:bg-black-50 md:hover:bg-black-100 bg-black-100 hover:bg-black-200/50 text-black-300"
                                    onClick={() => setShopOpen(false)}
                                    tabIndex={0}
                                >
                                    <RiCloseFill className="h-6 w-6" aria-hidden="true" />
                                </div>
                            </div>
                            <div className="py-3 flex flex-col">
                                <div className="flex justify-between mb-2">
                                    <span className="text-black-500">Producto 1</span>
                                    <span className="text-black-500">$10.00</span>
                                </div>
                                <div className="flex justify-between mb-2">
                                    <span className="text-black-500">Producto 2</span>
                                    <span className="text-black-500">$15.00</span>
                                </div>
                                <div className="flex justify-between mb-2">
                                    <span className="text-black-500">Producto 1</span>
                                    <span className="text-black-500">$10.00</span>
                                </div>
                                <div className="flex justify-between mb-2">
                                    <span className="text-black-500">Producto 2</span>
                                    <span className="text-black-500">$15.00</span>
                                </div>
                                <div className="flex justify-between mb-2">
                                    <span className="text-black-500">Producto 1</span>
                                    <span className="text-black-500">$10.00</span>
                                </div>
                                <div className="flex justify-between mb-2">
                                    <span className="text-black-500">Producto 2</span>
                                    <span className="text-black-500">$15.00</span>
                                </div>
                                <div className="flex justify-between mb-2">
                                    <span className="text-black-500">Producto 1</span>
                                    <span className="text-black-500">$10.00</span>
                                </div>
                                <div className="flex justify-between mb-2">
                                    <span className="text-black-500">Producto 2</span>
                                    <span className="text-black-500">$15.00</span>
                                </div>
                                <div className="flex justify-between mb-2">
                                    <span className="text-black-500">Producto 1</span>
                                    <span className="text-black-500">$10.00</span>
                                </div>
                                <div className="flex justify-between mb-2">
                                    <span className="text-black-500">Producto 2</span>
                                    <span className="text-black-500">$15.00</span>
                                </div>
                                <div className="flex justify-between mb-2">
                                    <span className="text-black-500">Producto 1</span>
                                    <span className="text-black-500">$10.00</span>
                                </div>
                                <div className="flex justify-between mb-2">
                                    <span className="text-black-500">Producto 2</span>
                                    <span className="text-black-500">$15.00</span>
                                </div>
                                <div className="flex justify-between mb-2">
                                    <span className="text-black-500">Producto 1</span>
                                    <span className="text-black-500">$10.00</span>
                                </div>
                            </div>
                        </div>
                        <div className=" sticky bottom-0 lg:bg-white bg-primary-50 pb-4 ">
                            <div className="flex justify-between pt-3">
                                <span className="text-black-500 font-bold">Total a pagar:</span>
                                <span className="text-black-500 font-bold">$25.00</span>
                            </div>
                            <div className="flex pb-3">
                                <small className="text-black-500 text-sm">Las tazas y fletes estan calculados en la orden de compra.</small>
                            </div>
                            <button className="w-full bg-primary-300 text-white font-bold rounded-2xl py-3 uppercase text-center">
                                ir al checkout
                            </button>
                        </div>
                    </div>

                </Dialog.Panel>
            </Dialog>
        </div>
    );
};

export default CartIndex;
