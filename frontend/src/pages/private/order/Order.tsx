import { Link } from "react-router-dom"
import { PATH_ADMIN_COMPANY_EDIT, PATH_EMPLEADO_ADMIN_ID } from "../../../routes/private/PrivatePaths"
import { FaSearch } from "react-icons/fa"

const Order = () => {
    return (
        <div className="grid lg:py-5 py-2 lg:px-32 px-3">
            <div className="flex justify-between">
                <div className="grid">
                    <h2 className="pb-2 text-xl font-bold text-primary-900 md:text-4xl dark:text-gray-300">
                        Ordenes
                    </h2>
                    <div className="flex w-32 mt-1 mb-6 overflow-hidden rounded">
                        <div className="flex-1 h-2 bg-primary-200">
                        </div>
                        <div className="flex-1 h-2 bg-primary-400">
                        </div>
                        <div className="flex-1 h-2 bg-primary-300">
                        </div>
                    </div>
                </div>
                <div className="grid gap-x-1">
                    <Link to={PATH_ADMIN_COMPANY_EDIT}
                        className="px-2 py-1 h-fit text-white bg-primary-400 rounded-xl hover:bg-primary-500">
                        <div className="flex justify-center items-center flex-nowrap">
                            <FaSearch className="w-6" />
                            <span>Buscar</span>
                        </div>
                    </Link>
                </div>
            </div>
            <div className="flex">
                <div className="grid grid-cols-1 gap-2 w-full">
                    <Link to={PATH_EMPLEADO_ADMIN_ID + "/"} className="flex h-fit items-start justify-between cursor-pointer bg-white hover:rounded-xl rounded-xl" key={1}>
                        <div className="flex items-center gap-3 p-3 w-full rounded-xl hover:bg-black-100/50">
                            <div className="relative h-16 max-h-16 w-16 items-start justify-start rounded-full">
                                <img src={"https://scontent.fgye1-1.fna.fbcdn.net/v/t39.30808-6/420154971_2520274338149738_172533631695156924_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=efb6e6&_nc_ohc=1g_JtT23TVcAX8eDRMZ&_nc_ht=scontent.fgye1-1.fna&oh=00_AfBGijlZK0R40J7INYkUvju92qf9LZZn1hrCRqumHOUKCw&oe=65C62B95"} className="h-16 max-h-16 max-w-16 w-16 rounded-full" />
                                <div className={`absolute p-2 ${"".toLowerCase() === "online" || "".toLowerCase() === "actualizar" ? "bg-green-500" : "bg-red-400"} rounded-full right-0 bottom-1`} />
                            </div>
                            <div className="lg:flex lg:justify-between grid w-full">
                                <div className="grid">
                                    <h5 className="uppercase line-clamp-1 text-base font-bold text-black-800 dark:text-white">
                                        Richard Anthony Pérez Palacios
                                    </h5>
                                    <div className="flex flex-wrap">
                                        <div className="flex pr-3">
                                            <span className=" text-black-700 font-bold pr-1">Codigo:</span>
                                            <span className=" text-black-500 line-clamp-1">as7da9d-asd789-asd9a07</span>
                                        </div>
                                        <div className="flex ">
                                            <span className=" text-black-700 font-bold pr-1">Fecha:</span>
                                            <span className=" text-black-500">2024-01-27</span>
                                        </div>
                                    </div>
                                    <div className="flex flex-wrap">
                                        <div className="flex pr-3">
                                            <span className=" text-black-700 font-bold pr-1">Email:</span>
                                            <span className=" text-black-500">example@email.com</span>
                                        </div>
                                        <div className="flex ">
                                            <span className=" text-black-700 font-bold pr-1">Valor total:</span>
                                            <span className=" text-success-600 font-semibold">599 USD</span>
                                        </div>
                                    </div>
                                </div>
                                <div className="lg:block h-fit my-auto hidden bg-success-300  px-2 pb-1 rounded-xl line-clamp-1 text-base text-black-50">
                                    Pagado
                                </div>
                            </div>
                        </div>
                    </Link>
                </div>
            </div>
        </div>
    )
}

export default Order