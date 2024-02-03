import { Link } from "react-router-dom"
import { PATH_HOME, PATH_REGISTER, RESTORE_PASSWORD } from "../../../routes/public/Paths"
import InputFieldAlt from "../../../components/fields/InputFieldAlt"
import AuthImg from "../../../assets/auth.png";
import Footer from "../../../components/footer/Footer";

const Login = () => {
    return (
        <main className={`mx-auto`}>
            <div className="relative flex">
                <div className="mx-auto flex min-h-full w-full flex-col justify-start md:max-w-[75%] lg:h-screen lg:max-w-[1013px] lg:px-8 lg:pt-0 xl:h-[100vh] xl:max-w-[1383px] xl:px-0 xl:pl-[70px]">
                    <div className="mb-auto flex flex-col pl-5 pr-5 md:pr-0 md:pl-12 lg:max-w-[48%] lg:pl-0 xl:max-w-full">
                        <Link to={PATH_HOME} className="uppercase text-black-500 font-black lg:text-3xl text-2xl ml-1 mt-4">
                            Shop.ME
                        </Link>
                        <div className="mt-16 mb-16 flex h-full w-full items-center justify-center px-2 md:mx-0 md:px-0 lg:mb-10 lg:items-center lg:justify-start">
                            <div className="mt-[2vh] w-full max-w-full flex-col items-center md:pl-4 lg:pl-0 xl:max-w-[420px]">
                                <h4 className="mb-14 mt-0 text-4xl text-center font-bold text-primary-400 ">
                                    INICIAR SESION
                                </h4>
                                <InputFieldAlt
                                    mode='email'
                                    variant="auth"
                                    extra="mb-3 pt-6"
                                    label="Usuario*"
                                    placeholder="Ingrese su usuario o cedula"
                                    id="email"
                                    type="text"
                                />

                                <InputFieldAlt
                                    mode='text'
                                    extra="mb-3"
                                    label="Contraseña*"
                                    placeholder="Ingrese su contraseña"
                                    id="password"
                                    type="password"
                                />
                                <button className=" w-full uppercase py-2 mt-7 px-4 rounded-xl bg-primary-400 border-transparent text-white text-md mr-4 hover:bg-primary-500 font-bold">
                                    Ingresar
                                </button>

                                <div className="mt-20 lg:mt-12 flex items-center justify-center px-2 pt-6 pb-5">
                                    <Link to={PATH_REGISTER} className="text-primary-300 hover:text-primary-400">
                                        ¿No tienes una cuenta? <span className=" font-bold"> Registrate</span>
                                    </Link>
                                </div>
                                <div className=" flex items-center justify-center px-2 ">
                                    <Link to={RESTORE_PASSWORD} className="text-black-300 hover:text-black-400">
                                        ¿Olvidaste tu contraseña?
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

export default Login