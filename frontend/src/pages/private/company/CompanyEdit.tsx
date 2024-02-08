import { Link } from "react-router-dom"
import InputField from "../../../components/fields/InputField"
import { PATH_ADMIN_COMPANY } from "../../../routes/private/PrivatePaths"
import TextArea from "../../../components/fields/TextArea"

const CompanyEdit = () => {
    return (
        <section className="flex justify-center  font-poppins dark:bg-gray-800 lg:py-12 pt-4">
            <div className="w-full px-4 mb-10 md:w-1/2 lg:mb-0 ">
                <div className="flex justify-center">
                    <div className="grid justify-center">
                        <h2 className="pb-2 text-xl font-bold text-primary-900 md:text-4xl dark:text-gray-300">
                            Editar empresa
                        </h2>
                        <div className="flex justify-center w-32 mt-1 mb-6 overflow-hidden rounded mx-auto">
                            <div className="flex-1 h-2 bg-primary-200">
                            </div>
                            <div className="flex-1 h-2 bg-primary-400">
                            </div>
                            <div className="flex-1 h-2 bg-primary-300">
                            </div>
                        </div>
                    </div>
                </div>
                <div className="grid lg:grid-cols-2 gap-3">
                    <InputField
                        mode="text"
                        label="Nombre de la empresa"
                    />
                    <InputField
                        mode="tel"
                        label="Telefono"
                    />
                    <InputField
                        mode="text"
                        label="Facebook"
                    />
                    <InputField
                        mode="tel"
                        label="Instagram"
                    />
                    <InputField
                        mode="text"
                        label="WhatAapp"
                    />
                    <InputField
                        mode="tel"
                        label="Tiktok"
                    />
                </div>
                <div className="pt-3">
                    <TextArea label="Direccion de la empresas" placeholder={""} rows={0} />
                </div>
                <div className="flex justify-center pt-10">
                    <div className="grid justify-center">
                        <h2 className="pb-2 text-xl font-bold text-primary-900 md:text-4xl dark:text-gray-300">
                            Configuracion del email
                        </h2>
                        <div className="flex justify-center w-32 mt-1 mb-6 overflow-hidden rounded mx-auto">
                            <div className="flex-1 h-2 bg-primary-200">
                            </div>
                            <div className="flex-1 h-2 bg-primary-400">
                            </div>
                            <div className="flex-1 h-2 bg-primary-300">
                            </div>
                        </div>
                    </div>
                </div>
                <div className="grid lg:grid-cols-2 gap-3">
                    <InputField
                        mode="text"
                        label="Email"
                    />
                    <InputField
                        mode="text"
                        label="Clave del email"
                    />
                    <InputField
                        mode="text"
                        label="Host"
                    />
                    <InputField
                        mode="numeric"
                        label="Puerto"
                    />
                </div>
                <div className="flex justify-center py-5 pt-9 gap-x-5">
                    <Link to={PATH_ADMIN_COMPANY} className="bg-danger-400 hover:bg-danger-500 py-2 px-3 rounded-xl text-white">Cancelar</Link>
                    <div className="text-white bg-primary-500 hover:bg-primary-600 py-2 px-3 rounded-xl cursor-pointer">Guardar</div>
                </div>
            </div>
        </section>
    )
}

export default CompanyEdit