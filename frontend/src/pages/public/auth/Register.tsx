import { Link } from "react-router-dom"
import { PATH_HOME, PATH_LOGIN } from "../../../routes/public/Paths"
import InputFieldAlt from "../../../components/fields/InputFieldAlt"
import AuthImg from "../../../assets/auth.png";
import Footer from "../../../components/footer/Footer";
import TextAreaAlt from "../../../components/fields/TextAreaAlt";

const Register = () => {
    return (
        <main className={`mx-auto`}>
            <div className="relative flex">
                <div className="mx-auto flex min-h-full w-full flex-col justify-start md:max-w-[75%] lg:h-screen lg:max-w-[1013px] lg:px-8 lg:pt-0 xl:h-[100vh] xl:max-w-[1383px] xl:px-0 xl:pl-[70px]">
                    <div className="mb-auto flex flex-col pl-5 pr-5 md:pr-0 md:pl-12 lg:max-w-[48%] lg:pl-0 xl:max-w-full">
                        <Link to={PATH_HOME} className="uppercase text-black-500 font-black lg:text-3xl text-2xl ml-1 mt-4">
                            Shop.ME
                        </Link>
                        <div className="mt-4 mb-16 flex h-full w-full items-center justify-center px-2 md:mx-0 md:px-0 lg:mb-10 lg:items-center lg:justify-start">
                            <div className="mt-[1vh] w-full max-w-full flex-col items-center md:pl-4 lg:pl-0 xl:max-w-[420px]">
                                <h4 className="mb-10 mt-0 text-4xl text-center font-bold text-primary-400 ">
                                    REGISTRATE
                                </h4>
                                <div className="grid lg:grid-cols-2 md:grid-cols-2 gap-x-3">
                                    <InputFieldAlt
                                        mode='text'
                                        extra="mb-3"
                                        label="Nombres*"
                                        placeholder="Ingrese sus nombres"
                                        type="text"
                                    />

                                    <InputFieldAlt
                                        mode='text'
                                        extra="mb-3"
                                        label="Apellidos*"
                                        placeholder="Ingrese sus Apellidos"
                                        type="text"
                                    />
                                    <InputFieldAlt
                                        mode='email'
                                        extra="mb-3"
                                        label="Email*"
                                        placeholder="Ingrese su email"
                                        type="text"
                                    />

                                    <InputFieldAlt
                                        mode='tel'
                                        extra="mb-3"
                                        label="Telefono*"
                                        placeholder="Ingrese su telefono"
                                        type="text"
                                    />
                                    <InputFieldAlt
                                        mode='text'
                                        extra="mb-3"
                                        label="Pais*"
                                        placeholder="Ingrese su pais de residencia"
                                        type="text"
                                    />

                                    <InputFieldAlt
                                        mode='numeric'
                                        extra="mb-3"
                                        label="Codigo postal*"
                                        placeholder="Ingrese su codigo postal"
                                        type="text"
                                    />
                                </div>
                                <TextAreaAlt
                                    label="Direccion del domicilio"
                                    placeholder={"Avenida siempre viva 123"}
                                    rows={3} />
                                <button className=" w-full uppercase py-2 mt-7 px-4 rounded-xl bg-primary-400 border-transparent text-white text-md mr-4 hover:bg-primary-500 font-bold">
                                    Ingresar
                                </button>

                                <div className="flex items-center justify-center px-2 pt-6">
                                    <Link to={PATH_LOGIN} className="text-primary-300 hover:text-primary-400">
                                        ¿Tienes una cuenta? <span className=" font-bold"> Iniciar sesion</span>
                                    </Link>
                                </div>
                            </div>
                        </div>
                        <div
                            className="absolute right-0 hidden h-full min-h-screen md:block lg:w-[45vw] 2xl:w-[55vw]"
                        >
                            <div
                                className="absolute flex h-full w-full items-end justify-center bg-cover bg-center lg:rounded-bl-[120px] xl:rounded-bl-[200px]"
                                style={{ backgroundImage: `url(${AuthImg})` }}
                            />
                        </div>
                    </div>
                </div>
            </div>
            <Footer />
        </main>
    )
}

export default Register