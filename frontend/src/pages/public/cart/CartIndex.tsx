// CartIndex.tsx
import { Dialog } from "@headlessui/react";
import { useState, useEffect } from "react";
import { RiShoppingCartFill, RiCloseFill } from "react-icons/ri";
import ProductCart from "./components/ProductCart";
import { Product } from "../products/model/Product";
import { Link } from "react-router-dom";
import { PATH_PAYMENT, PATH_PRODUCTOS } from "../../../routes/public/Paths";
import toast from "react-hot-toast";



const CartIndex = () => {
    const [shopOpen, setShopOpen] = useState(false);
    const [cartItems, setCartItems] = useState<Product[]>([]);

    useEffect(() => {
        if (shopOpen) {
            const storedCartItems = localStorage.getItem('cartItems');
            if (storedCartItems) {
                setCartItems(JSON.parse(storedCartItems));
            }
        }
    }, [shopOpen]);

    useEffect(() => {
        const storedCartItems = localStorage.getItem('cartItems');
        if (storedCartItems) {
            setCartItems(JSON.parse(storedCartItems));
        }
    }, []);

    const updateCartItemQuantity = (idProduct: string, newQuantity: number) => {
        const updatedCartItems = cartItems.map(item => {
            if (item.idProduct !== undefined && item.idProduct.toString() === idProduct) {
                return { ...item, quantity: newQuantity, totalPrice: item.price * newQuantity };
            }
            return item;
        });

        setCartItems(updatedCartItems);
        localStorage.setItem('cartItems', JSON.stringify(updatedCartItems)); // Actualizar en localStorage
    };

    const deleteCartItem = (idProduct: string) => {
        const updatedCartItems = cartItems.filter(item => item.idProduct !== undefined && item.idProduct.toString() !== idProduct);
        setCartItems(updatedCartItems);
        toast.success("Producto eliminado del carrito")
        localStorage.setItem('cartItems', JSON.stringify(updatedCartItems));
    };



    return (
        <div className="outline-none">
            <div
                onClick={() => setShopOpen(true)}
                className="relative inline-flex items-center p-2 text-sm font-medium text-center text-primary-300 hover:text-primary-400"
            >
                <RiShoppingCartFill className="w-8 h-8" />
            </div>
            <Dialog
                as="div"
                className="bg-black-100"
                open={shopOpen}
                onClose={() => setShopOpen(false)}
            >
                <div className="fixed inset-0 z-50 backdrop-blur-sm" tabIndex={-1}></div>
                <Dialog.Panel className="shadow-2xl fixed inset-y-0 right-0 z-50 w-full overflow-y-auto lg:border-l md:border-primary-200 lg:bg-white md:border-l border-primary-200 bg-primary-50 px-6 sm:max-w-sm">
                    <div className="flex flex-col h-full justify-between">
                        <div className="lg:bg-white bg-primary-50 z-40">
                            <div className="flex w-full justify-between sticky pt-3 pb-1 top-0 lg:bg-white bg-primary-50 z-50">
                                <div className="uppercase text-black-500 font-black text-xl pt-1">
                                    Carrito de compras
                                </div>
                                <div
                                    className="rounded-full p-2.5 font-bold md:bg-black-50 md:hover:bg-black-100 bg-black-100 hover:bg-black-200/70 text-black-300 outline-none"
                                    onClick={() => setShopOpen(false)}
                                    tabIndex={0}
                                >
                                    <RiCloseFill className="h-6 w-6" aria-hidden="true" />
                                </div>
                            </div>
                            <div className="flex flex-col gap-y-2.5">
                                {cartItems.length === 0 ? ( // Mostrar mensaje si el carrito está vacío
                                    null
                                ) : (
                                    cartItems.map(item => (
                                        <ProductCart
                                            key={item.idProduct !== undefined ? item.idProduct.toString() : ""}
                                            productName={item.name}
                                            quantity={item.quantity}
                                            stock={item.stock}
                                            totalPrice={item.totalPrice}
                                            img1={"" + item.img1}
                                            onDelete={() => deleteCartItem(item.idProduct !== undefined ? item.idProduct.toString() : "")}
                                            updateQuantity={(newQuantity: number) => updateCartItemQuantity(item.idProduct !== undefined ? item.idProduct.toString() : "", newQuantity)}
                                            idProduct={item.idProduct !== undefined ? item.idProduct.toString() : ""} onProductClick={() => setShopOpen(false)} />
                                    ))
                                )
                                }
                            </div>
                        </div>
                        {cartItems.length === 0 ? ( // Mostrar mensaje si el carrito está vacío
                            <div className="sticky top-0 lg:bg-white bg-primary-50 pb-4 z-50">
                                <div className="flex w-full justify-center text-9xl text-black-200/60">
                                    <RiShoppingCartFill className="" />
                                </div>
                                <div className="flex pb-10 pt-3 w-full justify-center">
                                    <span className="text-black-500 text-lg text-center">
                                        Tu carrito de compras esta vacio
                                    </span>
                                </div>
                                <Link
                                    onClick={() => setShopOpen(false)}
                                    to={PATH_PRODUCTOS} className="flex justify-center w-full mt-36 bg-primary-300 hover:bg-primary-400 text-white font-bold rounded-2xl py-3 uppercase text-center">
                                    Ver productos
                                </Link>
                            </div>
                        ) : (
                            <div className="sticky bottom-0 lg:bg-white bg-primary-50 pb-4 z-50">
                                <div className="flex justify-between pt-3">
                                    <span className="text-black-500 font-bold">Total a pagar:</span>
                                    <span className="text-black-500 font-bold">${cartItems.reduce((total, item) => total + item.totalPrice, 0).toFixed(2)}</span>
                                </div>
                                <div className="flex pb-3">
                                    <small className="text-black-500 text-sm">Las tazas están calculadas en la orden de compra.</small>
                                </div>
                                <Link
                                    onClick={() => setShopOpen(false)}
                                    to={PATH_PAYMENT} className="flex justify-center w-full bg-primary-300 hover:bg-primary-400 text-white font-bold rounded-2xl py-3 uppercase text-center">
                                    Ir al checkout
                                </Link>
                            </div>
                        )
                        }

                    </div>
                </Dialog.Panel>
            </Dialog>
        </div>
    );
};

export default CartIndex;
