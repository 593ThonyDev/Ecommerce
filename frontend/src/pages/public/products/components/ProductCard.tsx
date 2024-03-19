import { Link } from "react-router-dom";
import { PATH_PRODUCTO_ID } from "../../../../routes/public/Paths";
import { ProductCardProps } from "./ProductCardProps";
import toast from "react-hot-toast";
import { Product } from "../model/Product";
import { getToken } from "../../../../functions/AuthApi";

const ProductCard: React.FC<ProductCardProps> = ({ product }) => {

    const handleAddToCart = () => {
        if (!getToken()) {
            toast.error("¡Debes iniciar sesion para agregar a tu orden de compra!");
        } else {
            const cartItems = localStorage.getItem('cartItems');
            if (cartItems) {
                const parsedCartItems = JSON.parse(cartItems) as Product[];
                const existingItem = parsedCartItems.find(item => item.idProduct === product.idProduct);
                if (existingItem) {
                    toast.error("¡Este producto ya está en el carrito!");
                    return;
                }
            }

            if (product.stock > 0) {
                toast.success("Producto agregado al carrito");
                updateLocalStorage(product);
            } else {
                toast.error("¡No hay suficiente stock disponible para agregar este producto al carrito!");
            }
        }
    };

    const updateLocalStorage = (product: Product) => {
        const cartItem = {
            idProduct: product.idProduct,
            name: product.name,
            description: product.description,
            img1: product.img1,
            stock: product.stock,
            quantity: 1, // Agregamos una cantidad fija de 1 unidad
            price: product.price, // Precio por unidad del producto
            totalPrice: product.price * 1 // Precio total inicialmente igual al precio unitario
        };

        let cartItems: Product[] = [];
        const storedCartItems = localStorage.getItem('cartItems');
        if (storedCartItems) {
            cartItems = JSON.parse(storedCartItems);
        }

        cartItems.push(cartItem);
        localStorage.setItem('cartItems', JSON.stringify(cartItems));
    };

    return (
        <div className="relative flex w-full max-w-xs flex-col overflow-hidden rounded-2xl bg-white border border-primary-100" key={parseInt(product.idProduct?.toString() ?? '0')}>
            <Link
                to={PATH_PRODUCTO_ID + product.idProduct + "/" + (product.name?.replace(/\s+/g, '-') ?? '')}
                className="relative mx-3 mt-3 flex h-60 overflow-hidden rounded-2xl"
            >
                <img className="object-cover w-full bg-primary-50" src={"https://" + product.img1} alt="product image" />
                <span className="absolute top-0 right-0 m-2 rounded-full bg-success-200 backdrop-blur-md px-2 text-center text-xl font-medium text-white">${product.price}</span>
            </Link>
            <div className="mt-4 px-5 pb-5">
                <Link
                    to={PATH_PRODUCTO_ID + (product.idProduct ?? '') + "/" + (product.name?.replace(/\s+/g, '-') ?? '')}
                >
                    <h5 className="text-sm tracking-tight text-center text-primary-500 pb-3 uppercase line-clamp-1">
                        {product.name}
                    </h5>
                </Link>
                <div
                    onClick={handleAddToCart}
                    className="flex cursor-pointer items-center justify-center rounded-xl bg-warning-400 px-5 py-2.5 text-center text-sm font-medium text-white hover:bg-warning-500/90"
                >
                    <svg xmlns="http://www.w3.org/2000/svg" className="mr-2 h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" strokeWidth="2">
                        <path strokeLinecap="round" strokeLinejoin="round" d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z" />
                    </svg>
                    <span className="font-semibold">Agregar al carrito</span>
                </div>
            </div>
        </div>
    );
};

export default ProductCard;
