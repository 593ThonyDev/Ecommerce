import { PATH_EMPLEADOS_ADMIN, PATH_EMPLEADO_ADMIN_EDIT_ID } from '../../../routes/private/PrivatePaths'
import SytyleBackgroundView from './components/SytyleBackgroundView'
import { formatDate } from '../../../functions/Funtions'
import customerPhoto from "../../../assets/cliente.png"
import NotFoundAdmin from '../../error/NotFoundAdmin'
import { API_URL } from '../../../functions/ApiConst'
import { useParams } from 'react-router-dom'
import { useEffect, useState } from 'react'
import { BiCamera } from 'react-icons/bi'
import { Employe } from './model/Employe'
import axios from 'axios'
import DropdownItem, { Dropdown } from '../../../components/dropdown/DropDownOptions'

const EmployeView = () => {

    const { id, name } = useParams<{ id: string; name: string }>();

    const [loading, setLoading] = useState(true);

    const [formData, setFormData] = useState<Employe>({
        idEmploye: 0,
        fullName: "",
        created: "",
        email: "",
        description: "",
        phone: "",
        photo: "",
    });

    const fetchData = async () => {
        try {
            const response = await axios.get(`${API_URL}employe/${id}`);
            const data = response.data.content;
            setTimeout(() => {
                setFormData({
                    idEmploye: data.idEmploye,
                    fullName: data.fullName,
                    created: data.created,
                    email: data.email,
                    description: data.description,
                    phone: data.phone,
                    photo: data.photo
                });
                setLoading(false);
            }, 1000);
        } catch (error) {
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchData();
    }, [id, name]);

    return (
        <section className="flex">
            {loading ? (
                <div className="justify-center flex-1 max-w-6xl py-4 mx-auto md:px-6 lg:pt-16 pt-10 animate-pulse">
                    <div className="flex flex-wrap">
                        <div className="relative w-full px-4 mb-10 md:w-1/2 lg:mb-0 z-10">
                            <div className="relative">
                                <div className="flex items-center justify-center">
                                    <div className="object-cover object-center flex items-center justify-center bg-black-300/50 h-80 w-80 lg:h-96 lg:w-96 rounded-full backdrop-blur-3xl">
                                        <svg className="w-24 text-black-100" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 16 20">
                                            <path d="M14.066 0H7v5a2 2 0 0 1-2 2H0v11a1.97 1.97 0 0 0 1.934 2h12.132A1.97 1.97 0 0 0 16 18V2a1.97 1.97 0 0 0-1.934-2ZM10.5 6a1.5 1.5 0 1 1 0 2.999A1.5 1.5 0 0 1 10.5 6Zm2.221 10.515a1 1 0 0 1-.858.485h-8a1 1 0 0 1-.9-1.43L5.6 10.039a.978.978 0 0 1 .936-.57 1 1 0 0 1 .9.632l1.181 2.981.541-1a.945.945 0 0 1 .883-.522 1 1 0 0 1 .879.529l1.832 3.438a1 1 0 0 1-.031.988Z" />
                                            <path d="M5 5V.13a2.96 2.96 0 0 0-1.293.749L.879 3.707A2.98 2.98 0 0 0 .13 5H5Z" />
                                        </svg>
                                    </div>
                                    <div className="absolute lg:top-80 bottom-4 z-40 lg:right-28 sm:right-60 lg:py-4 rounded-full right-10 p-4  cursor-pointer bg-primary-500/40 hover:bg-primary-600/40 backdrop-blur-lg text-white">
                                        <BiCamera className='my-auto' />
                                    </div>
                                </div>
                            </div>
                            <SytyleBackgroundView />
                        </div>
                        <div className="w-full px-4 mb-10 md:w-1/2 lg:mb-0 ">
                            <div className="flex justify-between">
                                <div className="grid">
                                    <div className="h-5 bg-black-300/60 rounded-full w-80 my-3 mt-4 mb-3"></div>
                                    <div className="flex w-32 mt-1 mb-6 overflow-hidden rounded">
                                        <div className="flex-1 h-2 bg-primary-200">
                                        </div>
                                        <div className="flex-1 h-2 bg-primary-400">
                                        </div>
                                        <div className="flex-1 h-2 bg-primary-300">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <ul className="mb-10">
                                <li className="flex mb-4 text-base text-black-800">
                                    <span className="mr-3 bg-primary-500 p-2.5 h-1 rounded-full" />
                                    <div className="grid">
                                        <div className="h-3 bg-black-200 rounded-full w-16 mt-1 mb-3"></div>
                                        <div className="h-2 bg-black-200 rounded-full w-56 my-2"></div>
                                    </div>
                                </li>
                                <li className="flex mb-4 text-base text-black-800">
                                    <span className="mr-3 bg-primary-500 p-2.5 h-1 rounded-full" />
                                    <div className="grid">
                                        <div className="h-3 bg-black-200 rounded-full w-16 mt-1 mb-3"></div>
                                        <div className="h-2 bg-black-200 rounded-full w-56 my-2"></div>
                                    </div>
                                </li>
                                <li className="flex mb-4 text-base text-black-800">
                                    <span className="mr-3 bg-primary-500 p-2.5 h-1 rounded-full" />
                                    <div className="grid">
                                        <div className="h-3 bg-black-200 rounded-full w-16 mt-1 mb-3"></div>
                                        <div className="h-2 bg-black-200 rounded-full w-56 my-2"></div>
                                    </div>
                                </li>
                                <li className="flex mb-4 text-base text-black-800">
                                    <span className="mr-3 bg-primary-500 p-2.5 h-1 rounded-full" />
                                    <div className="grid">
                                        <div className="h-3 bg-black-200 rounded-full w-16 mt-1 mb-3"></div>
                                        <div className="h-2 bg-black-200 rounded-full w-56 my-2"></div>
                                    </div>
                                </li>
                                <li className="flex mb-4 text-base text-black-800">
                                    <span className="mr-3 bg-primary-500 p-2.5 h-1 rounded-full" />
                                    <div className="grid">
                                        <div className="h-3 bg-black-200 rounded-full w-16 mt-1 mb-3"></div>
                                        <div className="h-2 bg-black-200 rounded-full w-56 my-2"></div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            ) : (
                formData.fullName?.replace(/\s+/g, '-') === name ?
                    <div className="justify-center flex-1 max-w-6xl py-4 mx-auto md:px-6 lg:pt-16 pt-10">
                        <div className="flex flex-wrap">
                            <div className="relative w-full px-4 mb-10 md:w-1/2 lg:mb-0 z-10">
                                <div className="relative">
                                    <div className="flex items-center justify-center">
                                        <img src={formData.photo ? "https://" + formData.photo : customerPhoto} alt=""
                                            className="relative z-40 object-cover rounded-full h-80 w-80 lg:h-96 lg:w-96" />
                                        <div className="absolute lg:top-80 bottom-4 z-40 lg:right-28 sm:right-60 lg:py-4 rounded-full right-10 p-4  cursor-pointer bg-primary-500/40 hover:bg-primary-600/40 backdrop-blur-lg text-white">
                                            <BiCamera className='my-auto' />
                                        </div>
                                    </div>
                                </div>
                                <SytyleBackgroundView />
                            </div>
                            <div className="w-full px-4 mb-10 md:w-1/2 lg:mb-0 ">
                                <div className="flex justify-between">
                                    <div className="grid">
                                        <h2 className="pb-2 text-xl font-bold text-primary-900 md:text-4xl uppercase">
                                            Datos del empleado
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
                                    <Dropdown label={'•••'}>
                                        <DropdownItem text={'Editar empleado'} path={PATH_EMPLEADO_ADMIN_EDIT_ID + formData.idEmploye + "/" + formData.fullName?.replace(/\s+/g, '-')} />
                                    </Dropdown>
                                </div>
                                <ul className="mb-10">
                                    <li className="flex mb-4 text-base text-black-800">
                                        <span className="mr-3 text-primary-500">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                                className="w-5 h-5 bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z" />
                                            </svg>
                                        </span>
                                        <div className="grid">
                                            <span className="text-black-500 text-lg font-semibold">Nombres:</span>
                                            <h3 className="text-black-700">{formData.fullName}</h3>
                                        </div>
                                    </li>
                                    <li className="flex mb-4 text-base text-black-800">
                                        <span className="mr-3 text-primary-500">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                                className="w-5 h-5 bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z" />
                                            </svg>
                                        </span>
                                        <div className="grid">
                                            <span className="text-black-500 text-lg font-semibold">Se unio el:</span>
                                            <h3 className="text-black-700">{formatDate(formData?.created)}</h3>
                                        </div>
                                    </li>
                                    <li className="flex mb-4 text-base text-black-800">
                                        <span className="mr-3 text-primary-500">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                                className="w-5 h-5 bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z" />
                                            </svg>
                                        </span>
                                        <div className="grid">
                                            <span className="text-black-500 text-lg font-semibold">Telefono:</span>
                                            <h3 className="text-black-700">{formData.phone}</h3>
                                        </div>
                                    </li>
                                    <li className="flex mb-4 text-base text-black-800">
                                        <span className="mr-3 text-primary-500">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                                className="w-5 h-5 bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z" />
                                            </svg>
                                        </span>
                                        <div className="grid">
                                            <span className="text-black-500 text-lg font-semibold">Email:</span>
                                            <h3 className="text-black-700">{formData.email}</h3>
                                        </div>
                                    </li>
                                    <li className="flex mb-4 text-base text-black-800">
                                        <span className="mr-3 text-primary-500">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                                className="w-5 h-5 bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
                                                <path
                                                    d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z" />
                                            </svg>
                                        </span>
                                        <div className="grid">
                                            <span className="text-black-500 text-lg font-semibold">Descripcion:</span>
                                            <h3 className="text-black-700">
                                                {formData.description}
                                            </h3>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    : (
                        <NotFoundAdmin error='404'
                            message='Recurso no encontrado'
                            link={PATH_EMPLEADOS_ADMIN}
                        />
                    )
            )}
        </section >
    )
}

export default EmployeView
