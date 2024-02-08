import { Link } from "react-router-dom";
import { PATH_NOSOTROS, PATH_PRODUCTOS } from "../../../../routes/public/Paths";

const Home = () => {
    return (
        <div className="bg-primary-50 flex relative z-20 items-center overflow-hidden">
            <div className="container mx-auto px-6 flex relative py-8 lg:py-20 flex-col-reverse sm:flex-row">
                <div className="sm:w-2/3 lg:w-3/5 flex flex-col relative z-20 lg:pt-8 lg:pl-16">
                    <span className="w-28 h-2 bg-warning-500 mb-0">
                    </span>
                    <h1 className="font-bebas-neue uppercase text-6xl sm:text-8xl font-black flex flex-col leading-none text-primary-500">
                        Be on
                        <span className="text-5xl sm:text-7xl">
                            Time
                        </span>
                    </h1>
                    <p className="text-sm sm:text-base text-black-500 dark:text-white">
                        Dimension of reality that makes change possible and understandable. An indefinite and homogeneous environment in which natural events and human existence take place.
                    </p>
                    <div className="flex mt-8">
                        <Link to={PATH_PRODUCTOS} className="uppercase py-2 px-4 rounded-xl bg-warning-400 border-transparent text-white text-md mr-4 hover:bg-warning-500 font-bold">
                            Ver Productos
                        </Link>
                        <Link to={PATH_NOSOTROS} className="uppercase py-2 px-4 rounded-xl bg-transparent border-2 border-warning-400 text-warning-400 text-md hover:border-warning-500 hover:text-warning-500 font-bold">
                            Conocenos
                        </Link>
                    </div>
                </div>
                <div className="sm:w-1/3 lg:w-3/5 relative pb-4 -mt-4">
                    <img src="https://www.tailwind-kit.com/images/object/10.png" className="max-w-xs md:max-w-sm m-auto sm:mt-0" />
                </div>
            </div>
        </div>
    );
}

export default Home;
