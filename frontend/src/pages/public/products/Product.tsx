import { BsSearch } from "react-icons/bs";
import { Link } from "react-router-dom";
import { PATH_PRODUCTO_ID } from "../../../routes/public/Paths";

const Product = () => {
    const categories = [
        {
            id: 1,
            name: "Fast Food",
            image:
                "https://duyt4h9nfnj50.cloudfront.net/new_search_home_eats_icon/FastFood_BrowseHome@3x.png",
        },
        {
            id: 2,
            name: "Pizza",
            image:
                "https://duyt4h9nfnj50.cloudfront.net/new_search_home_eats_icon/Pizza_BrowseHome@3x.png",
        },
        {
            id: 3,
            name: "Wings",
            image:
                "https://duyt4h9nfnj50.cloudfront.net/new_search_home_eats_icon/Wings_BrowseHome@3x.png",
        },
        {
            id: 4,
            name: "Indian",
            image:
                "https://duyt4h9nfnj50.cloudfront.net/new_search_home_eats_icon/Indian_BrowseHome@3x.png",
        },
        {
            id: 5,
            name: "Indian",
            image:
                "https://duyt4h9nfnj50.cloudfront.net/new_search_home_eats_icon/Indian_BrowseHome@3x.png",
        },
        {
            id: 6,
            name: "Indian",
            image:
                "https://duyt4h9nfnj50.cloudfront.net/new_search_home_eats_icon/Indian_BrowseHome@3x.png",
        },
        {
            id: 7,
            name: "Indian",
            image:
                "https://duyt4h9nfnj50.cloudfront.net/new_search_home_eats_icon/Indian_BrowseHome@3x.png",
        },
        {
            id: 8,
            name: "Indian",
            image:
                "https://duyt4h9nfnj50.cloudfront.net/new_search_home_eats_icon/Indian_BrowseHome@3x.png",
        },
    ];
    return (
        <div className=" bg-primary-50 lg:px-5">
            <div className="grid h-full grid-cols-1 xl:grid-cols-1 2xl:grid-cols-6  rounded-2xl">

                <div className="hidden sticky top-20 px-6 lg:grid grid-cols h-fit lg:border-r-2 border-primary-50">
                    <div className=" pb-4 text-md font-bold text-black-400">Filtrar por categorias</div>
                    <div className="grid lg:pb-2">
                        {categories.map((item, index) => (
                            <div
                                key={index}
                                className="bg-gray-100 hover:bg-white cursor-pointer duration-500 rounded-lg px-3 flex justify-start items-center"
                            >
                                <img src={item.image} alt={item.name} className="w-8" />
                                <h2 className="sm:text-lg text-black-600">{item.name}</h2>
                            </div>
                        ))}
                    </div>
                </div>
                <div className="col-span-1 h-fit w-full xl:col-span-1 2xl:col-span-5 mb-2 px-5">
                    <div className="flex justify-between sticky top-16 z-20 py-2 bg-primary-50">
                        <div className="md:text-center text-center lg:px-0 px-2">
                            <h2 className=" text-xl font-bold text-primary-900">
                                Productos en stock
                            </h2>
                            <div className="flex flex-row-reverse w-32 mt-1 overflow-hidden rounded">
                                <div className="flex-1 h-2 bg-primary-200">
                                </div>
                                <div className="flex-1 h-2 bg-primary-400">
                                </div>
                                <div className="flex-1 h-2 bg-primary-300">
                                </div>
                            </div>
                        </div>
                        <div className="flex mt-0 ">
                            <div className="cursor-pointer hover:bg-primary-400 flex bg-primary-300 h-fit py-0.5 px-2 rounded-xl justify-center text-white text-xl">
                                <BsSearch className=" font-bold my-auto" />
                                <div className="my-auto pb-1">Buscar</div>
                            </div>
                        </div>
                    </div>
                    <div className="flex justify-center">
                        <div className="grid lg:grid-cols-4 md:grid-cols-3 gap-x-4 gap-y-4 pb-4 ">
                            
                            <div className="relative  flex w-full max-w-xs flex-col overflow-hidden rounded-2xl bg-white border border-primary-100">
                                <div className="relative mx-3 mt-3 flex h-60 overflow-hidden rounded-2xl">
                                    <img className="object-cover" src="https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8c25lYWtlcnxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60" alt="product image" />
                                    <span className="absolute top-0 right-0 m-2 rounded-full bg-success-200 backdrop-blur-md px-2 text-center text-xl font-medium text-white">$449</span>
                                </div>
                                <div className="mt-4 px-5 pb-5">
                                    <Link to={PATH_PRODUCTO_ID + 1 + "/Nike-Air-MX-Super-2500"}>
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
                                    <Link to={PATH_PRODUCTO_ID + 1 + "/Nike-Air-MX-Super-2500"}>
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
                                    <Link to={PATH_PRODUCTO_ID + 1 + "/Nike-Air-MX-Super-2500"}>
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
                                    <Link to={PATH_PRODUCTO_ID + 1 + "/Nike-Air-MX-Super-2500"}>
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
                                    <Link to={PATH_PRODUCTO_ID + 1 + "/Nike-Air-MX-Super-2500"}>
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
                                    <Link to={PATH_PRODUCTO_ID + 1 + "/Nike-Air-MX-Super-2500"}>
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
                                    <Link to={PATH_PRODUCTO_ID + 1 + "/Nike-Air-MX-Super-2500"}>
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
                                    <Link to={PATH_PRODUCTO_ID + 1 + "/Nike-Air-MX-Super-2500"}>
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
                                    <Link to={PATH_PRODUCTO_ID + 1 + "/Nike-Air-MX-Super-2500"}>
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
                                    <Link to={PATH_PRODUCTO_ID + 1 + "/Nike-Air-MX-Super-2500"}>
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
                                    <Link to={PATH_PRODUCTO_ID + 1 + "/Nike-Air-MX-Super-2500"}>
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
                                    <Link to={PATH_PRODUCTO_ID + 1 + "/Nike-Air-MX-Super-2500"}>
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
                </div>
            </div>
        </div>
    )
}

export default Product