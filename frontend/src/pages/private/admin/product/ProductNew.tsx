import { PATH_PRODUCTOS_ADMIN } from "../../../../routes/private/admin/PrivatePaths";
import InputField from "../../../../components/fields/InputField";
import TextArea from "../../../../components/fields/TextArea";
import imgProduct from "../../../../assets/UploadPhoto.png"
import { saveOrUpdateProduct } from "./model/ProductApi";
import { Link, useNavigate } from "react-router-dom";
import { BiCamera } from "react-icons/bi";
import { Product } from "./model/Product";
import toast from "react-hot-toast";
import { useState } from "react";

const ProductNew = () => {
    const navigate = useNavigate();

    const [productData, setProductData] = useState<Product>({
        name: "",
        price: 0,
        stock: 0,
        img1: undefined,
        img2: undefined,
        img3: undefined,
        description: "",
        Category: undefined,
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        const { name, value } = e.target;
        setProductData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handlePhotoChange = (e: React.ChangeEvent<HTMLInputElement>, imgIndex: number) => {
        const file = e.target.files?.[0];
        if (file) {
            setProductData(prevState => ({
                ...prevState,
                [`img${imgIndex}` as keyof Product]: file  // Type assertion
            }));
        }
    };
    
    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        const camposFaltantes = validarProduct(productData);
        if (camposFaltantes.length === 0) {
            const loadingToast = toast.loading('Guardando registro...');
            try {
                const savedSuccessfully = await saveOrUpdateProduct(productData);
                if (savedSuccessfully) {
                    toast.dismiss(loadingToast);
                    navigate(PATH_PRODUCTOS_ADMIN);
                } else {
                    toast.dismiss(loadingToast);
                }
            } catch (error) {
                console.error('Error al guardar los cambios:', error);
                toast.dismiss(loadingToast);
            }
        } else {
            toast.error(`Debe agregar ${camposFaltantes.join(", ")} del producto`);
        }
    };

    const validarProduct = (productData: Product) => {
        const camposFaltantes: string[] = [];
        if (!productData.name) camposFaltantes.push("nombre");
        if (!productData.description) camposFaltantes.push("descripcion");
        if (!productData.price) camposFaltantes.push("precio");
        if (!productData.stock) camposFaltantes.push("stock");
        if (!productData.img1) camposFaltantes.push("foto 1");
        if (!productData.img2) camposFaltantes.push("foto 2");
        if (!productData.img3) camposFaltantes.push("foto 3");
        if (!productData.Category?.idCategory) camposFaltantes.push("categoria");
        return camposFaltantes;
    };

    return (
        <div className="flex flex-wrap justify-center py-10">
            <div className="grid px-4 mb-10 lg:mb-0 z-10">
                <div className="grid justify-center">
                    <h2 className="pb-2 text-xl font-bold text-primary-900 md:text-4xl dark:text-gray-300">
                        AGREGAR PRODUCTO
                    </h2>
                    <div className="flex w-32 mt-1 mb-6 overflow-hidden rounded mx-auto">
                        <div className="flex-1 h-2 bg-primary-200"></div>
                        <div className="flex-1 h-2 bg-primary-400"></div>
                        <div className="flex-1 h-2 bg-primary-300"></div>
                    </div>
                </div>

                <form onSubmit={handleSubmit}>
                    <div className="grid">
                        <div>
                            <InputField
                                mode="text"
                                label="Nombre del producto"
                                id="name"
                                value={productData.name}
                                onChange={handleChange}
                            />
                        </div>
                        <div className="py-3">
                            <TextArea
                                label="Descripcion del producto"
                                placeholder={""}
                                rows={0}
                                id="description"
                                value={productData.description}
                                onChange={handleChange}
                            />
                        </div>
                        <div className="grid grid-cols-2 gap-3 pb-3">
                            <InputField
                                mode="numeric"
                                label="Precio"
                                id="price"
                                value={productData.price.toString()}
                                onChange={handleChange}
                            />
                            <InputField
                                mode="numeric"
                                label="Stock"
                                id="stock"
                                value={productData.stock.toString()}
                                onChange={handleChange}
                            />
                        </div>
                    </div>

                    <div className="grid start">
                        <h2 className="text-primary-600/50 font-semibold text-lg pb-2">
                            Fotos producto:
                        </h2>
                    </div>
                    <div className="flex justify-center">
                        <div className="grid grid-cols-2 md:grid-cols-3 gap-4">
                            {[1, 2, 3].map((index) => (
                                <div className="flex justify-center" key={index}>
                                    <div className="relative">
                                        <div className="flex items-center justify-center">
                                            <img
                                                src={productData[`img${index}`] ? URL.createObjectURL(productData[`img${index}`]) : imgProduct}
                                                alt=""
                                                className="my-auto z-40 object-cover max-h-40 max-w-40 w-40 rounded-3xl align-middle h-40 bg-primary-100/50 backdrop-blur-md"
                                            />
                                            <label
                                                htmlFor={`img${index}`}
                                                className="absolute bottom-4 z-40  rounded-full px-3 py-2 cursor-pointer bg-success-400/40 hover:bg-success-500/40  backdrop-blur-lg text-white">
                                                <div className="flex items-center">
                                                    <BiCamera className=" mt-0.5 mr-1" />
                                                    <span className="text-sm uppercase">Imagen {index}</span>
                                                </div>
                                            </label>
                                            <input
                                                type="file"
                                                id={`img${index}`}
                                                accept="image/*"
                                                className="hidden"
                                                onChange={(e) => handlePhotoChange(e, index)}
                                            />
                                        </div>
                                    </div>
                                </div>
                            ))}
                        </div>
                    </div>
                    <div className="flex justify-center py-5 pt-9 gap-x-5">
                        <Link
                            to={PATH_PRODUCTOS_ADMIN}
                            className="bg-danger-400 hover:bg-danger-500 py-2 px-4 rounded-xl text-white"
                        >
                            Cancelar
                        </Link>
                        <button
                            type="submit"
                            className="text-white bg-primary-500 hover:bg-primary-600 py-2 px-4 rounded-xl cursor-pointer"
                        >
                            Guardar
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default ProductNew;
