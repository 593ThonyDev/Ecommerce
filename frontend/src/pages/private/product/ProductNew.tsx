
import { BiCamera } from "react-icons/bi"
import InputField from "../../../components/fields/InputField"
import { PATH_PRODUCTOS_ADMIN } from "../../../routes/private/PrivatePaths"
import { Link } from "react-router-dom"
import TextArea from "../../../components/fields/TextArea"

const ProductNew = () => {
    return (
        <div className="flex flex-wrap justify-center py-10">

            <div className="grid px-4 mb-10 lg:mb-0 z-10">
                <div className="grid justify-center">
                    <h2 className="pb-2 text-xl font-bold text-primary-900 md:text-4xl dark:text-gray-300">
                        AGREGAR PRODUCTO
                    </h2>
                    <div className="flex w-32 mt-1 mb-6 overflow-hidden rounded mx-auto">
                        <div className="flex-1 h-2 bg-primary-200">
                        </div>
                        <div className="flex-1 h-2 bg-primary-400">
                        </div>
                        <div className="flex-1 h-2 bg-primary-300">
                        </div>
                    </div>
                </div>

                <div className="grid">

                    <div>
                        <InputField
                            mode="text"
                            label="Nombre del producto"
                        />
                    </div>
                    <div className="py-3">
                        <TextArea label="Descripcion del producto" placeholder={""} rows={0} />
                    </div>
                    <div className="grid grid-cols-2 gap-3 pb-3">
                        <InputField
                            mode="numeric"
                            label="Precio"
                        />
                        <InputField
                            mode="numeric"
                            label="Stock"
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
                        <div className="flex justify-center">
                            <div className="relative">
                                <div className="flex items-center justify-center">
                                    <img src="https://duyt4h9nfnj50.cloudfront.net/new_search_home_eats_icon/FastFood_BrowseHome@3x.png" alt=""
                                        className=" my-auto z-40 object-cover max-h-40 max-w-40 w-40 rounded-3xl align-middle h-40 bg-primary-300/20 backdrop-blur-md" />
                                    <div className="absolute bottom-1 z-40  rounded-full px-3 py-2 cursor-pointer bg-success-400/40 hover:bg-success-500/40  backdrop-blur-lg text-black-700">
                                        <div className="flex items-center">
                                            <BiCamera />
                                            <span className=" text-sm uppercase">Imagen 1</span>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="flex justify-center">
                            <div className="relative">
                                <div className="flex items-center justify-center">
                                    <img src="https://duyt4h9nfnj50.cloudfront.net/new_search_home_eats_icon/FastFood_BrowseHome@3x.png" alt=""
                                        className=" my-auto z-40 object-cover max-h-40 max-w-40 w-40 rounded-3xl align-middle h-40 bg-primary-300/20 backdrop-blur-md" />
                                    <div className="absolute bottom-1 z-40  rounded-full px-3 py-2 cursor-pointer bg-success-400/40 hover:bg-success-500/40  backdrop-blur-lg text-black-700">
                                        <div className="flex items-center">
                                            <BiCamera />
                                            <span className=" text-sm uppercase">Imagen 1</span>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="flex justify-center">
                            <div className="relative">
                                <div className="flex items-center justify-center">
                                    <img src="https://duyt4h9nfnj50.cloudfront.net/new_search_home_eats_icon/FastFood_BrowseHome@3x.png" alt=""
                                        className=" my-auto z-40 object-cover max-h-40 max-w-40 w-40 rounded-3xl align-middle h-40 bg-primary-300/20 backdrop-blur-md" />
                                    <div className="absolute bottom-1 z-40  rounded-full px-3 py-2 cursor-pointer bg-success-400/40 hover:bg-success-500/40  backdrop-blur-lg text-black-700">
                                        <div className="flex items-center">
                                            <BiCamera />
                                            <span className=" text-sm uppercase">Imagen 1</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="flex justify-center py-5 pt-9 gap-x-5">
                    <Link to={PATH_PRODUCTOS_ADMIN} className="bg-danger-400 hover:bg-danger-500 py-2 px-3 rounded-xl text-white">Cancelar</Link>
                    <div className="text-white bg-primary-500 hover:bg-primary-600 py-2 px-3 rounded-xl cursor-pointer">Guardar</div>
                </div>
            </div>
        </div>
    )
}

export default ProductNew