import { BiCamera } from "react-icons/bi"
import InputField from "../../../components/fields/InputField"
import { PATH_EMPLEADOS_ADMIN } from "../../../routes/private/PrivatePaths"
import { Link } from "react-router-dom"
import { StyleBackground } from "./components/StyleBackground"
import TextArea from "../../../components/fields/TextArea"

const EmployeNew = () => {
    return (
        <div className="flex flex-wrap justify-center py-10">
            <div className="relative w-full px-4 mb-10 md:w-1/2 lg:mb-0 z-10">
                <div className="grid justify-center">
                    <h2 className="pb-2 text-xl font-bold text-primary-900 md:text-4xl dark:text-gray-300 uppercase">
                        Crear empleado
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
                <div className="relative">
                    <div className="flex items-center justify-center">
                        <img src="https://img.freepik.com/foto-gratis/chico-guapo-seguro-posando-contra-pared-blanca_176420-32936.jpg?w=826&t=st=1707245749~exp=1707246349~hmac=6490e44a6632e302926f730fce9e22bb12ed4f6f30a51b2cfa6ec48d8df4498e" alt=""
                            className="relative z-40 object-cover rounded-full w-56 h-56 bg-primary-300/20 backdrop-blur-md border border-primary-200" />
                        <div className="absolute  bottom-2 z-40 right-14 lg:right-52 py-4 rounded-full px-4  cursor-pointer bg-primary-500/40 hover:bg-primary-700/40  backdrop-blur-lg text-white">
                            <BiCamera />
                        </div>
                    </div>
                </div>
                <div className="grid lg:pt-4">
                    <div className="grid lg:grid-cols-2 gap-3 pb-3">
                        <InputField
                            mode="text"
                            label="Nombres"
                        />
                        <InputField
                            mode="text"
                            label="Apellidos"
                        />
                        <InputField
                            mode="email"
                            label="Email"
                        />
                        <InputField
                            mode="tel"
                            label="Telefono"
                        />
                    </div>
                    <div className="py-3">
                        <TextArea label="Descripcion del empleado" placeholder={""} rows={0} />
                    </div>
                </div>

                <div className="grid justify-center ">
                    <div className="flex justify-center pt-9 gap-x-5">
                        <Link to={PATH_EMPLEADOS_ADMIN} className="bg-danger-400 hover:bg-danger-500 py-2 px-3 rounded-xl text-white">Cancelar</Link>
                        <div className="text-white bg-primary-500 hover:bg-primary-600 py-2 px-3 rounded-xl cursor-pointer">Crear empleado</div>
                    </div>
                </div>

                <StyleBackground />
            </div>
        </div>
    )
}

export default EmployeNew