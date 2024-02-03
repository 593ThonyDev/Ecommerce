import { Link } from "react-router-dom"
import { PATH_BLOG } from "../../../../routes/public/Paths"

const Information = () => {
    return (
        <div className="bg-primary-100 py-10">
            <div className="px-4 py-5 md:text-center text-center">
                <h2 className="pb-2 text-2xl font-bold text-primary-900 md:text-4xl">
                    Mantente informado con nuestro Blog
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
            <div className="flex justify-center">
                <div className="grid lg:grid-cols-2 md:grid-cols-2 md:px-6 lg:gap-6 md:gap-6">
                    <a href="#" className="flex flex-col items-center bg-primary-50 md:rounded-lg lg:rounded-lg shadow md:flex-row md:max-w-xl hover:bg-white ">
                        <img className="object-cover w-full lg:rounded-t-lg h-96 md:h-auto md:w-48 md:rounded-none md:rounded-s-lg" src="https://flowbite.com/docs/images/blog/image-4.jpg" alt="" />
                        <div className="flex flex-col justify-between p-4 leading-normal">
                            <h5 className="mb-2 text-2xl font-bold tracking-tight text-black-900">Noteworthy technology acquisitions 2021</h5>
                            <p className="mb-3 font-normal text-black-700">Here are the biggest enterprise technology acquisitions of 2021 so far, in reverse chronological order.</p>
                        </div>
                    </a>                                                       
                    <a href="#" className="flex flex-col items-center bg-primary-50 md:rounded-lg lg:rounded-lg shadow md:flex-row md:max-w-xl hover:bg-white ">
                        <img className="object-cover w-full lg:rounded-t-lg h-96 md:h-auto md:w-48 md:rounded-none md:rounded-s-lg" src="https://flowbite.com/docs/images/blog/image-4.jpg" alt="" />
                        <div className="flex flex-col justify-between p-4 leading-normal">
                            <h5 className="mb-2 text-2xl font-bold tracking-tight text-black-900">Noteworthy technology acquisitions 2021</h5>
                            <p className="mb-3 font-normal text-black-700">Here are the biggest enterprise technology acquisitions of 2021 so far, in reverse chronological order.</p>
                        </div>
                    </a>                                                       
                    <a href="#" className="flex flex-col items-center bg-primary-50 md:rounded-lg lg:rounded-lg shadow md:flex-row md:max-w-xl hover:bg-white ">
                        <img className="object-cover w-full lg:rounded-t-lg h-96 md:h-auto md:w-48 md:rounded-none md:rounded-s-lg" src="https://flowbite.com/docs/images/blog/image-4.jpg" alt="" />
                        <div className="flex flex-col justify-between p-4 leading-normal">
                            <h5 className="mb-2 text-2xl font-bold tracking-tight text-black-900">Noteworthy technology acquisitions 2021</h5>
                            <p className="mb-3 font-normal text-black-700">Here are the biggest enterprise technology acquisitions of 2021 so far, in reverse chronological order.</p>
                        </div>
                    </a>                                                       
                    <a href="#" className="flex flex-col items-center bg-primary-50 md:rounded-lg lg:rounded-lg shadow md:flex-row md:max-w-xl hover:bg-white ">
                        <img className="object-cover w-full lg:rounded-t-lg h-96 md:h-auto md:w-48 md:rounded-none md:rounded-s-lg" src="https://flowbite.com/docs/images/blog/image-4.jpg" alt="" />
                        <div className="flex flex-col justify-between p-4 leading-normal">
                            <h5 className="mb-2 text-2xl font-bold tracking-tight text-black-900">Noteworthy technology acquisitions 2021</h5>
                            <p className="mb-3 font-normal text-black-700">Here are the biggest enterprise technology acquisitions of 2021 so far, in reverse chronological order.</p>
                        </div>
                    </a>                                                       
                                                                           
                </div>
                
            </div>
            <div className="flex justify-center">
                <Link to={PATH_BLOG} className="flex items-center mt-8 justify-center rounded-xl bg-primary-500 px-3 py-2.5 text-center text-sm font-medium text-white hover:bg-gray-700">
                    <span className="mr-3 text-white">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                            className="w-5 h-5 bi bi-arrow-right-circle-fill" viewBox="0 0 16 16">
                            <path
                                d="M8 0a8 8 0 1 1 0 16A8 8 0 0 1 8 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z" />
                        </svg>
                    </span>
                    Ver todos los articulos
                </Link>
            </div>
        </div>
    )
}

export default Information