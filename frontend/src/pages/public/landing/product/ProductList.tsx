

import { motion } from "framer-motion";
import { useState, useEffect } from "react";
import productImg from "../../../../assets/NotFound.png";
import ProductCard from "../../products/components/ProductCard";
import { getAllProducts } from "../../products/model/ProductApi";
import { Product } from "../../products/model/Product";
import LoaderList from "../../products/components/LoaderList";

const ProductList = () => {

    const [data, setData] = useState<Product[]>([]);
    const [currentPage, ] = useState(0);
    const [totalItems, setTotalItems] = useState(0);
    const [isLoading, setIsLoading] = useState(false);


    useEffect(() => {
        const fetchDataAndSetState = async () => {
            try {
                setIsLoading(true);
                const response = await getAllProducts(currentPage, setIsLoading);
                setData(response.content);
                setTotalItems(response.totalElements);
            } catch (error) {
                console.error("Error fetching data:", error);
                setIsLoading(false);
            }
        };
        fetchDataAndSetState();
    }, [currentPage]);
    const totalPages = Math.ceil(totalItems / 12);

    const visiblePages = 12;
    const firstVisiblePage = Math.max(0, currentPage - Math.floor(visiblePages / 2));
    const lastVisiblePage = Math.min(totalPages - 1, firstVisiblePage + visiblePages - 1);
    const visiblePagesArray = Array.from({ length: lastVisiblePage - firstVisiblePage + 1 }, (_, i) => i + firstVisiblePage);

    if (firstVisiblePage > 0) {
        visiblePagesArray.unshift(-1);
    }



    return (
        <>
            {isLoading ? (
                <div className="  flex w-full justify-center">
                    <motion.div
                        initial={{ opacity: 0.5 }}
                        animate={{ opacity: 0.5 }}
                        transition={{ duration: 0.5 }}
                        className="grid w-full justify-items-center lg:grid-cols-4 md:grid-cols-3 gap-x-4 gap-y-4 pb-4">
                        {
                            [...Array(12)].map((_, index) => (
                                <LoaderList key={index} />
                            ))
                        }
                    </motion.div>
                </div>
            ) : (
                <div>
                    < div className="grid lg:grid-cols-4 md:grid-cols-3 gap-x-4 gap-y-4 pb-4 " >
                        {
                            data.map(product => (
                                <ProductCard
                                    idProduct={product.idProduct?.toString() ?? ""}
                                    price={product.price.toString()}
                                    name={product.name}
                                    img1={product.img1 ? product.img1.toString() : productImg}
                                />
                            ))
                        }
                    </div >

                </div >
            )}
        </>
    )
}

export default ProductList;
