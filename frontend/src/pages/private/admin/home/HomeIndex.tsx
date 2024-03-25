import Stadistics from "./Stadistics"
import Home from "./Home"

const HomeIndex = () => {

    return (
        <div className="lg:bg-white grid h-full grid-cols-1 gap-5 xl:grid-cols-2 2xl:grid-cols-3 px-4">
            <div className="col-span-1 h-fit w-full xl:col-span-1 2xl:col-span-2">
                <div className=" grid h-full grid-cols-1">
                    <div className="col-span-1 h-fit w-full xl:col-span-1 md:col-span-1 2xl:col-span-2">
                        <Home />
                        <Stadistics />
                    </div>
                </div>
            </div>
            <div className="grid grid-cols-1 h-fit lg:sticky lg:top-20 overflow-y-scroll scroll-hidden pb-3">
                <span className=" text-primary-500 uppercase pb-3 text-xl">Ultimos Usuarios registrados</span>

                <div className=" grid gap-y-3 pb-2">
                    
                    <div className="flex h-fit items-start px-1 justify-between cursor-pointer lg:bg-primary-50 bg-white rounded-3xl">
                        <div className="flex items-center gap-3 p-3 w-full rounded-xl">
                            <div className="relative h-16 max-h-16 w-16 items-start justify-start rounded-full">
                                <div className="h-16 max-h-16 max-w-16 w-16 rounded-full bg-black-100" />
                            </div>
                            <div className="lg:flex lg:justify-between grid w-full">
                                <div className="grid py-1">
                                    <small className=" line-clamp-2 uppercase text-primary-700 font-semibold">
                                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum repellat pariatur
                                    </small>
                                    <div className="flex">
                                        <small className=" text-black-700 font-semibold pr-1">Fecha:</small>
                                        <small className=" text-black-500">26 de julio del 2001, 4:30</small>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="flex h-fit items-start px-1 justify-between cursor-pointer lg:bg-primary-50 bg-white rounded-3xl">
                        <div className="flex items-center gap-3 p-3 w-full rounded-xl">
                            <div className="relative h-16 max-h-16 w-16 items-start justify-start rounded-full">
                                <div className="h-16 max-h-16 max-w-16 w-16 rounded-full bg-black-100" />
                            </div>
                            <div className="lg:flex lg:justify-between grid w-full">
                                <div className="grid py-1">
                                    <small className=" line-clamp-2 uppercase text-primary-700 font-semibold">
                                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum repellat pariatur
                                    </small>
                                    <div className="flex">
                                        <small className=" text-black-700 font-semibold pr-1">Fecha:</small>
                                        <small className=" text-black-500">26 de julio del 2001, 4:30</small>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <span className=" text-primary-500  uppercase pb-3 text-xl">Articulos por aprobar</span>

                <div className=" grid gap-y-3 lg:max-h-min">
                    <div className="flex h-fit items-start px-1 justify-between cursor-pointer lg:bg-primary-50 bg-white rounded-3xl">
                        <div className="flex items-center gap-3 p-3 w-full rounded-xl">
                            <div className="relative h-16 max-h-16 w-16 items-start justify-start rounded-full">
                                <div className="h-16 max-h-16 max-w-16 w-16 rounded-full bg-black-100" />
                            </div>
                            <div className="lg:flex lg:justify-between grid w-full">
                                <div className="grid py-1">
                                    <small className=" line-clamp-2 uppercase text-primary-700 font-semibold">
                                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum repellat pariatur
                                    </small>
                                    <div className="flex">
                                        <small className=" text-black-700 font-semibold pr-1">Fecha:</small>
                                        <small className=" text-black-500">26 de julio del 2001, 4:30</small>
                                    </div>
                                    <div className="flex">
                                        <small className="text-black-700 font-semibold pr-1">Estado:</small>
                                        <small className="text-black-500">Creado</small>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="flex h-fit items-start px-1 justify-between cursor-pointer lg:bg-primary-50 bg-white rounded-3xl">
                        <div className="flex items-center gap-3 p-3 w-full rounded-xl">
                            <div className="relative h-16 max-h-16 w-16 items-start justify-start rounded-full">
                                <div className="h-16 max-h-16 max-w-16 w-16 rounded-full bg-black-100" />
                            </div>
                            <div className="lg:flex lg:justify-between grid w-full">
                                <div className="grid py-1">
                                    <small className=" line-clamp-2 uppercase text-primary-700 font-semibold">
                                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum repellat pariatur
                                    </small>
                                    <div className="flex">
                                        <small className=" text-black-700 font-semibold pr-1">Fecha:</small>
                                        <small className=" text-black-500">26 de julio del 2001, 4:30</small>
                                    </div>
                                    <div className="flex">
                                        <small className="text-black-700 font-semibold pr-1">Estado:</small>
                                        <small className="text-black-500">Creado</small>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="flex h-fit items-start px-1 justify-between cursor-pointer lg:bg-primary-50 bg-white rounded-3xl">
                        <div className="flex items-center gap-3 p-3 w-full rounded-xl">
                            <div className="relative h-16 max-h-16 w-16 items-start justify-start rounded-full">
                                <div className="h-16 max-h-16 max-w-16 w-16 rounded-full bg-black-100" />
                            </div>
                            <div className="lg:flex lg:justify-between grid w-full">
                                <div className="grid py-1">
                                    <small className=" line-clamp-2 uppercase text-primary-700 font-semibold">
                                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Nostrum repellat pariatur
                                    </small>
                                    <div className="flex">
                                        <small className=" text-black-700 font-semibold pr-1">Fecha:</small>
                                        <small className=" text-black-500">26 de julio del 2001, 4:30</small>
                                    </div>
                                    <div className="flex">
                                        <small className="text-black-700 font-semibold pr-1">Estado:</small>
                                        <small className="text-black-500">Creado</small>
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

export default HomeIndex