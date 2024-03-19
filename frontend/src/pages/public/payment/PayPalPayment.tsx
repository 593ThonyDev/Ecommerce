import { useState, useEffect } from "react";
import { RiShoppingCartFill } from "react-icons/ri";
import { Product } from "../products/model/Product";
import { Link } from "react-router-dom";
import { PATH_PRODUCTOS } from "../../../routes/public/Paths";
import toast from "react-hot-toast";
import ProductCart from "../cart/components/ProductCart";
import PaypalButton from "./PaypalButton";
import { getToken } from "../../../functions/AuthApi";
import NotFoundPublic from "../../error/NotFoundPublic";

const CartIndex = () => {
  const [cartItems, setCartItems] = useState<Product[]>([]);

  useEffect(() => {
    const storedCartItems = localStorage.getItem('cartItems');
    if (storedCartItems) {
      setCartItems(JSON.parse(storedCartItems));
    }
  }, []);

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
    !getToken() ?
      <div className="bg-white overflow-hidden w-full">
        <NotFoundPublic error="401" message="Debes iniciar sesion para realizar esta operacion"/>
      </div>
      : (<div className="flex justify-center bg-white z-10 pb-16">
        <div className="bg-white rounded-lg overflow-hidden w-full max-w-md">
          <div className="p-4">
            <div className="grid justify-center items-center pt-8 pb-4 w-full">
              <h2 className="text-3xl uppercase font-semibold text-black-500">Orden de compras</h2>
              <div className="flex mx-auto w-32 mt-1 overflow-hidden rounded">
                <div className="flex-1 h-2 bg-primary-200">
                </div>
                <div className="flex-1 h-2 bg-primary-400">
                </div>
                <div className="flex-1 h-2 bg-primary-300">
                </div>
              </div>
            </div>
            <div className="mt-4">
              {cartItems.length === 0 ? (
                <div className="flex flex-col items-center h-84 py-32">
                  <RiShoppingCartFill className="text-6xl text-black-400" />
                  <p className="text-black-600 mt-2">Tu carrito está vacío</p>
                  <p className="text-black-600 mb-2">¡Agrega productos para comprar!</p>
                  <Link to={PATH_PRODUCTOS} className="mt-4 px-4 py-2 bg-primary-500 text-white rounded-xl hover:bg-blue-600">
                    Ver productos
                  </Link>
                </div>
              ) : (
                <div className="space-y-4 z-30 py-3">
                  {cartItems.map(item => (
                    <ProductCart
                      key={item.idProduct !== undefined ? item.idProduct.toString() : ""}
                      productName={item.name}
                      quantity={item.quantity}
                      stock={item.stock}
                      totalPrice={item.totalPrice}
                      img1={"" + item.img1}
                      onDelete={() => deleteCartItem(item.idProduct !== undefined ? item.idProduct.toString() : "")}
                      updateQuantity={(newQuantity: number) => updateCartItemQuantity(item.idProduct !== undefined ? item.idProduct.toString() : "", newQuantity)}
                      idProduct={item.idProduct !== undefined ? item.idProduct.toString() : ""}
                      onProductClick={() => { }}
                    />
                  ))}
                  <div className="flex justify-between items-center pt-8">
                    <span className="text-black-500 text-xl font-semibold">Total a pagar:</span>
                    <span className="text-black-800 text-xl font-semibold">${cartItems.reduce((total, item) => total + item.totalPrice, 0).toFixed(2)}</span>
                  </div>
                  <div className="relative z-20">
                    <PaypalButton totalValue={cartItems.reduce((total, item) => total + item.totalPrice, 0).toFixed(2)} invoice={"Total a pagar"} />
                  </div>
                </div>
              )}
            </div>
          </div>
        </div>
      </div>)
  );
};

export default CartIndex;
