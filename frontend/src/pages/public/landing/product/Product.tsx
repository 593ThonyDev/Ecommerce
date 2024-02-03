import { Link } from "react-router-dom"
import { PATH_PRODUCTOS, PATH_PRODUCTO_ID } from "../../../../routes/public/Paths"

const Product = () => {
    return (
        <div className=" bg-primary-50 pb-10">
            <div className="px-4 mb-10 md:text-center md:mb-12 pt-8 text-center">
                <h2 className="pb-2 text-2xl font-bold text-primary-900 md:text-4xl dark:text-gray-300">
                    Productos destacados
                </h2>
                <div className="flex w-32 mt-1 mb-6 overflow-hidden rounded mx-auto">
                    <div className="flex-1 h-2 bg-primary-100">
                    </div>
                    <div className="flex-1 h-2 bg-primary-400">
                    </div>
                    <div className="flex-1 h-2 bg-primary-300">
                    </div>
                </div>
            </div>

            <div className="flex justify-center lg:mx-32">
                <div className="grid lg:grid-cols-4 md:grid-cols-3 px-6 gap-x-4 gap-y-2 ">
                    
                    <div className="relative  flex w-full max-w-xs flex-col overflow-hidden rounded-2xl bg-white border border-primary-100">
                        <div className="relative mx-3 mt-3 flex h-60 overflow-hidden rounded-2xl">
                            <img className="object-cover" src="https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8c25lYWtlcnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60" alt="product image" />
                            <span className="absolute top-0 right-0 m-2 rounded-full bg-success-200 backdrop-blur-md px-2 text-center text-xl font-medium text-white">$449</span>
                        </div>
                        <div className="mt-4 px-5 pb-5">
                            <Link to={PATH_PRODUCTO_ID + 1 +"/Nike-Air-MX-Super-2500"}>
                                <h5 className="text-xl tracking-tight text-center text-primary-500 pb-3">
                                    Nike Air MX Super 2500
                                </h5>
                            </Link>
                            <div className="flex items-center justify-center rounded-xl bg-warning-400 px-5 py-2.5 text-center text-sm font-medium text-white hover:bg-warning-500/90 ">
                                <svg xmlns="http://www.w3.org/2000/svg" className="mr-2 h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z" />
                                </svg>
                                Agregar al carrito
                            </div>
                        </div>
                    </div>
                    
                    <div className="relative  flex w-full max-w-xs flex-col overflow-hidden rounded-2xl bg-white border border-primary-100">
                        <div className="relative mx-3 mt-3 flex h-60 overflow-hidden rounded-2xl">
                            <img className="object-cover" src="https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8c25lYWtlcnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60" alt="product image" />
                            <span className="absolute top-0 right-0 m-2 rounded-full bg-success-200 backdrop-blur-md px-2 text-center text-xl font-medium text-white">$449</span>
                        </div>
                        <div className="mt-4 px-5 pb-5">
                            <Link to={PATH_PRODUCTO_ID + 1 +"/Nike-Air-MX-Super-2500"}>
                                <h5 className="text-xl tracking-tight text-center text-primary-500 pb-3">
                                    Nike Air MX Super 2500
                                </h5>
                            </Link>
                            <div className="flex items-center justify-center rounded-xl bg-warning-400 px-5 py-2.5 text-center text-sm font-medium text-white hover:bg-warning-500/90 ">
                                <svg xmlns="http://www.w3.org/2000/svg" className="mr-2 h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z" />
                                </svg>
                                Agregar al carrito
                            </div>
                        </div>
                    </div>
                    
                    <div className="relative  flex w-full max-w-xs flex-col overflow-hidden rounded-2xl bg-white border border-primary-100">
                        <div className="relative mx-3 mt-3 flex h-60 overflow-hidden rounded-2xl">
                            <img className="object-cover" src="https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8c25lYWtlcnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60" alt="product image" />
                            <span className="absolute top-0 right-0 m-2 rounded-full bg-success-200 backdrop-blur-md px-2 text-center text-xl font-medium text-white">$449</span>
                        </div>
                        <div className="mt-4 px-5 pb-5">
                            <Link to={PATH_PRODUCTO_ID + 1 +"/Nike-Air-MX-Super-2500"}>
                                <h5 className="text-xl tracking-tight text-center text-primary-500 pb-3">
                                    Nike Air MX Super 2500
                                </h5>
                            </Link>
                            <div className="flex items-center justify-center rounded-xl bg-warning-400 px-5 py-2.5 text-center text-sm font-medium text-white hover:bg-warning-500/90 ">
                                <svg xmlns="http://www.w3.org/2000/svg" className="mr-2 h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z" />
                                </svg>
                                Agregar al carrito
                            </div>
                        </div>
                    </div>
                    
                    <div className="relative  flex w-full max-w-xs flex-col overflow-hidden rounded-2xl bg-white border border-primary-100">
                        <div className="relative mx-3 mt-3 flex h-60 overflow-hidden rounded-2xl">
                            <img className="object-cover" src="https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8c25lYWtlcnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60" alt="product image" />
                            <span className="absolute top-0 right-0 m-2 rounded-full bg-success-200 backdrop-blur-md px-2 text-center text-xl font-medium text-white">$449</span>
                        </div>
                        <div className="mt-4 px-5 pb-5">
                            <Link to={PATH_PRODUCTO_ID + 1 +"/Nike-Air-MX-Super-2500"}>
                                <h5 className="text-xl tracking-tight text-center text-primary-500 pb-3">
                                    Nike Air MX Super 2500
                                </h5>
                            </Link>
                            <div className="flex items-center justify-center rounded-xl bg-warning-400 px-5 py-2.5 text-center text-sm font-medium text-white hover:bg-warning-500/90 ">
                                <svg xmlns="http://www.w3.org/2000/svg" className="mr-2 h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
                                    <path stroke-linecap="round" stroke-linejoin="round" d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z" />
                                </svg>
                                Agregar al carrito
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <div className="flex justify-center">
                <Link to={PATH_PRODUCTOS} className="flex items-center mt-8 justify-center rounded-xl bg-primary-500 px-3 py-2.5 text-center text-sm font-medium text-white">
                    <span className="mr-3 text-white">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            className="w-5 h-5 bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
                            <path
                                d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z" />
                        </svg>
                    </span>
                    Ver los demas productos
                </Link>
            </div>

        </div>
    )
}

export default Product