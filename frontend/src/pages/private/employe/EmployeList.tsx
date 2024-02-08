import { Link } from "react-router-dom";
import { PATH_EMPLEADO_ADMIN_ID } from "../../../routes/private/PrivatePaths";
import { useEffect, useState } from "react";
import axios from "axios";
import { API_URL } from "../../../functions/ApiConst";
import { motion } from "framer-motion";
import { FaAngleLeft, FaAngleRight } from "react-icons/fa";
import { formatDate } from "../../../functions/Funtions";
import { Employe } from "./model/Employe";

const EmployeList = () => {

    const [data, setData] = useState<Employe[]>([]);
    const [currentPage, setCurrentPage] = useState(0);
    const [totalItems, setTotalItems] = useState(0);
    const [isLoading, setIsLoading] = useState(false);
    const [isError, setIsError] = useState(false);
    const [errorMessage, setErrorMessage] = useState("");

    useEffect(() => {
        fetchData();
    }, [currentPage]);

    const fetchData = () => {

        setIsLoading(true);

        setTimeout(async () => {
            try {
                const response = await axios.get(API_URL + 'employe/list', {
                    params: {
                        page: currentPage,
                        size: 12
                    }
                });
                setData(response.data.content);
                setTotalItems(response.data.totalElements);
                setIsLoading(false);
            } catch (error) {
                setIsError(true);
                setIsLoading(false);
                if (error instanceof Error) {
                    setErrorMessage(error.message.toString().toUpperCase());
                } else {
                    setErrorMessage('Error en la solicitud. Por favor, inténtalo de nuevo más tarde');
                }
            }

        }, 500);
    };

    const totalPages = Math.ceil(totalItems / 12);

    const visiblePages = 12;
    const firstVisiblePage = Math.max(0, currentPage - Math.floor(visiblePages / 2));
    const lastVisiblePage = Math.min(totalPages - 1, firstVisiblePage + visiblePages - 1);
    const visiblePagesArray = Array.from({ length: lastVisiblePage - firstVisiblePage + 1 }, (_, i) => i + firstVisiblePage);

    if (firstVisiblePage > 0) {
        visiblePagesArray.unshift(-1);
    }

    const handlePageChange = (newPage: number) => {
        if (newPage >= 0 && newPage < totalPages) {
            setCurrentPage(newPage);
            window.scrollTo(0, 0);
        }
    };

    return (
        <>
            {isLoading ? (
                <>
                    <motion.div
                        initial={{ opacity: 0.5 }}
                        animate={{ opacity: 0.5 }}
                        transition={{ duration: 0.5 }}
                        className="grid grid-cols-1 md:grid-cols-3 sm:grid-cols-1 gap-4 w-full">
                        {
                            [...Array(9)].map((_, index) => (
                                <div key={index} className="flex border border-primary-500/30  bg-white  flex-col justify-between w-full sm-w-96 h-48 bg-center text-primary-800 overflow-hidden cursor-pointer bg-cover rounded-xl">
                                    <div className="animate-pulse flex justify-between items-center pr-4 pt-3 pb-8">
                                        <div className={`animate-pulse bg-green-400/40  backdrop-blur-md text-white bg-opacity-95  flex items-center text-xs rounded-xl ml-auto px-7 py-2.5`} />
                                    </div>

                                    <div className="animate-pulse rounded-r-xl p-1 py-3 flex flex-col mr-4 mb-3 bg-primary-300/50 dark:bg-white/5 backdrop-blur-md border border-primary-500/30 ">
                                        <div className="text-xl font-bold w-28 pb-1 mt-1 py-2 rounded-md text-white line-clamp-1 px-4  bg-primary-500/20 mb-4 mr-1" />
                                        <div className="text-white-75 rounded-md mr-1 text-sm line-clamp-2 py-1 pb-1 bg-primary-500/20   mb-2" />
                                        <div className="text-white-75 rounded-md mr-1 text-sm line-clamp-2 py-1 pb-1 bg-primary-500/20   mb-2" />
                                    </div>
                                </div>
                            ))
                        }
                    </motion.div>
                </>
            ) : (
                <div className="w-full">
                    < div className="grid lg:grid-cols-2 gap-2 w-full" >
                        {
                            data.map(employe => (
                                <Link to={PATH_EMPLEADO_ADMIN_ID + employe.idEmploye + "/" + employe.fullName?.replace(/\s+/g, '-')} className="flex h-fit items-start justify-between cursor-pointer bg-white hover:rounded-xl rounded-xl" key={employe.idEmploye}>
                                    <div className="flex items-center gap-3 p-3 w-full rounded-xl hover:bg-black-100/50">
                                        <div className="relative h-16 max-h-16 w-16 items-start justify-start rounded-full">
                                            <img src={"https://" + employe.photo} className="h-16 max-h-16 max-w-16 w-16 rounded-full" />
                                        </div>
                                        <div className="lg:flex lg:justify-between grid w-full">
                                            <div className="grid">
                                                <h5 className="uppercase line-clamp-1 text-base font-bold text-black-700 dark:text-white">
                                                    {employe.fullName}
                                                </h5>
                                                <div className="flex">
                                                    <span className=" text-black-700 font-bold pr-1">Email:</span>
                                                    <span className=" text-black-500 line-clamp-1">{employe.email}</span>
                                                </div>
                                                <div className="flex">
                                                    <span className=" text-black-700 font-bold pr-1">Telefono:</span>
                                                    <span className=" text-black-500">{employe.phone}</span>
                                                </div>
                                                <div className="flex">
                                                    <span className=" text-black-700 font-bold pr-1 line-clamp-1">Creado:</span>
                                                    <span className=" text-black-500 line-clamp-1">{formatDate(employe?.created)}</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </Link>
                            ))
                        }
                    </div >
                    {!isError && (  // Si no hay errores, muestra información de paginación
                        <div className="bg-claro mx-auto w-full my-8">
                            <div className="grid grid-cols-1  mx-auto w-full ">
                                <div className="flex justify-center">
                                    <span className="text-md text-black-600 text-center ">
                                        Mostrando rango de
                                        <span className='font-bold p-1'>
                                            {Math.min(currentPage * 12 + 1, totalItems)}
                                        </span>
                                        al
                                        <span className='font-bold p-1'>
                                            {Math.min((currentPage + 1) * 12, totalItems)}
                                        </span>
                                        de
                                        <span className='font-bold p-1'>
                                            {totalItems}
                                        </span>
                                        registros
                                    </span>
                                </div>
                                <div className="flex justify-center pt-3">
                                    <div className='flex gap-1 text-primary-500'>
                                        <div
                                            onClick={() => handlePageChange(currentPage - 1)}
                                            className={`cursor-pointer p-2 text-center 
                                                ${currentPage === 0 ? 'bg-primary-500/30' : 'bg-primary-500/30'}
                                                 hover:bg-primary-200  rounded-xl hover:text-primary-500/50 text-white `}
                                        >
                                            <FaAngleLeft className=" text-2xl" />
                                        </div>
                                        {visiblePagesArray.map(page => (
                                            <div
                                                key={page}
                                                onClick={() => page === -1 ? handlePageChange(0) : handlePageChange(page)}
                                                className={`cursor-pointer p-2 px-4 text-center 
                                                    ${page === -1 ? 'bg-primary-300  hover:bg-primary-300' : (currentPage === page ? 'bg-primary-800/30 text-white font-semibold' : 'bg-primary-100 hover:bg-primary-200/70 ')}
                                                   rounded-xl `}
                                            >
                                                {page === -1 ? "1" : page + 1}
                                            </div>
                                        ))}
                                        <div className={`cursor-pointer p-2 text-center 
                                            ${currentPage === totalPages - 1 ? 'bg-primary-500/30 hover:bg-primary-300/50 ' : 'bg-primary-500/30 hover:text-primary-500/50 hover:bg-primary-200  '}  text-white rounded-xl hover:text-primary-500/50 `}
                                            onClick={() => handlePageChange(currentPage + 1)}>
                                            <FaAngleRight className=" text-2xl" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    )}
                    {isError && (  // Si hay un error, muestra un mensaje de error
                        <div className="flex flex-col max-h-max lg:py-36  py-16 lg:px-16 justify-center  bg-white rounded-2xl">
                            <div className='text-9xl text-center'>
                                🔊
                            </div>
                            <br />
                            <div className=' text-3xl text-center lg:px-16 text-red-500'>
                                {errorMessage}
                            </div>
                        </div>
                    )}
                </div >
            )}
        </>
    )
}

export default EmployeList;
