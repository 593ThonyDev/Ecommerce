import { FaSearch } from "react-icons/fa"
import OrderList from "./OrderList"

const Order = () => {
    return (
        <div className="grid lg:py-5 py-2 lg:px-20 px-3 w-full">
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
                    <div
                        className="px-2 py-1 h-fit text-white bg-primary-400 rounded-xl hover:bg-primary-500">
                        <div className="flex justify-center content-center items-center flex-nowrap">
                            <FaSearch className="w-6" />
                            <span className=" uppercase font-semibold my-auto lg:pb-1">Buscar</span>
                        </div>
                    </div>
                </div>
            </div>
            <div className="flex w-full">
                <OrderList />
            </div>
        </div>
    )
}

export default Order