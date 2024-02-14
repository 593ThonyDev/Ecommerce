import { PATH_CLIENTE_ADMIN_ID } from "../../../../routes/private/admin/PrivatePaths";
import { formatDate } from "../../../../functions/Funtions";
import { FaAngleLeft, FaAngleRight } from "react-icons/fa";
import customerPhoto from "../../../../assets/cliente.png"
import { getAllCustomers } from "./model/CustomerApi";
import LoaderList from "./components/LoaderList";
import { useEffect, useState } from "react";
import { Customer } from "./model/Customer";
import { Link } from "react-router-dom";

const CustomerList = () => {

    const [data, setData] = useState<Customer[]>([]);
    const [currentPage, setCurrentPage] = useState(0);
    const [totalItems, setTotalItems] = useState(0);
    const [isLoading, setIsLoading] = useState(false);
    const [isError, setIsError] = useState(false);
    const [errorMessage, setErrorMessage] = useState("");

    useEffect(() => {
        fetchData();
    }, [currentPage]);

    const fetchData = () => {

        const fetchDataAndSetState = async () => {
            try {
                setIsLoading(true);
                const response = await getAllCustomers(currentPage, setIsLoading);
                setData(response.content);
                setTotalItems(response.totalElements);
            } catch (error) {
                console.error("Error fetching data:", error);
                setIsError(true);
                setIsLoading(false);
                if (error instanceof Error) {
                    setErrorMessage(error.message.toString().toUpperCase());
                } else {
                    setErrorMessage('Error en la solicitud. Por favor, inténtalo de nuevo más tarde');
                }
            }
        };
        fetchDataAndSetState();
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
                    <div className="grid lg:grid-cols-2 gap-2 w-full">
                        {
                            [...Array(12)].map((_, index) => (
                                <LoaderList key={index} />
                            ))
                        }
                    </div>
                </>
            ) : (
                <div className="w-full">
                    < div className="grid lg:grid-cols-2 gap-2" >
                        {
                            data.map(customer => (
                                <div>

                                    <Link to={PATH_CLIENTE_ADMIN_ID + customer.idCustomer + "/" + customer.fullName?.replace(/\s+/g, '-')} className="flex h-fit items-start justify-between cursor-pointer bg-white hover:rounded-xl rounded-xl" key={customer.idCustomer}>
                                        <div className="flex items-center gap-3 p-3 w-full rounded-xl hover:bg-black-50/50">
                                            <div className="relative h-16 max-h-16 w-16 items-start justify-start rounded-full">
                                                <img src={customer.photo ? "https://" + customer.photo : customerPhoto} className="h-16 max-h-16 max-w-16 w-16 rounded-full border border-primary-100" />
                                            </div>
                                            <div className="lg:flex lg:justify-between grid">
                                                <div className="grid">
                                                    <h5 className="uppercase line-clamp-1 text-base font-bold text-black-700 dark:text-white">
                                                        {customer.fullName}
                                                    </h5>
                                                    <div className="flex overflow-ellipsis line-clamp-1">
                                                        <span className=" text-black-700 font-bold pr-1">Email:</span>
                                                        <span className=" text-black-500">{customer.email}</span>
                                                    </div>
                                                    <div className="flex">
                                                        <span className=" text-black-700 font-bold pr-1 line-clamp-1">Creado:</span>
                                                        <span className=" text-black-500 line-clamp-1">{formatDate(customer?.created)}</span>
                                                    </div>
                                                    <div className="flex">
                                                        <span className=" text-black-700 font-bold pr-1">Telefono:</span>
                                                        <span className=" text-black-500">{customer.phone}</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </Link>
                                </div>
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
                                                ${currentPage === 0 ? 'bg-primary-500/30' : 'bg-primary-500/30'} hover:bg-primary-200  rounded-xl hover:text-primary-500/50 text-white `}
                                        >
                                            <FaAngleLeft className=" text-2xl" />
                                        </div>
                                        {visiblePagesArray.map(page => (
                                            <div
                                                key={page}
                                                onClick={() => page === -1 ? handlePageChange(0) : handlePageChange(page)}
                                                className={`cursor-pointer p-2 rounded-xl px-4 text-center 
                                                    ${page === -1 ? 'bg-primary-300  hover:bg-primary-300' : (currentPage === page ? 'bg-primary-800/30 text-white font-semibold' : 'bg-primary-100 hover:bg-primary-200/70 ')}rounded-xl `}
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

export default CustomerList;
