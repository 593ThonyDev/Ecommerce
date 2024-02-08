import ImgNotFound from "../../assets/404.svg";

const NotFound = () => {

    return (
        <div>
            <div className="flex flex-col h-screen bg-lightPrimary dark:bg-obscuro-normal">
                <div className="mx-auto my-auto ">
                    <div className="floating-animation mx-10">
                        <img src={ImgNotFound} className="mb-3" alt="" />
                        <div className="flex justify-center">
                            <span className=" text-primary-500 font-bold text-center text-2xl mx-auto">
                                El recurso que estás buscando
                                <br />
                                se ha esfumado en el cyberespacio o
                                <br />
                                no existe
                                <br />
                            </span>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    );

};

export default NotFound;