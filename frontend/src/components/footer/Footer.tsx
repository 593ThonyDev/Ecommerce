const Footer = () => {
    return (
        <div className=" text-sm  text-gray-100 relative overflow-hidden bg-primary-50 border-t border-primary-100">

            <div className="py-2 clas">
                <div className=" opacity-15">
                    <svg width="314" height="214" viewBox="0 0 314 214" fill="none" xmlns="http://www.w3.org/2000/svg" className="absolute right-0 top-0">
                        <path d="M174.5 6V-23.5L233 36H204.5C187.931 36 174.5 22.5685 174.5 6Z" fill="##2fbeff"></path>
                        <path d="M174.5 6V-23.5L116 36H144.5C161.069 36 174.5 22.5685 174.5 6Z" fill="#77d4ff"></path>
                        <path d="M116.5 65.5V36L175 95.5H146.5C129.931 95.5 116.5 82.0685 116.5 65.5Z" fill="#2fbeff"></path>
                        <path d="M116.5 65.5V36L58 95.5H86.5C103.069 95.5 116.5 82.0685 116.5 65.5Z" fill="#0085d0"></path>
                        <path d="M59.5 125V95.5L118 155H89.5C72.9315 155 59.5 141.569 59.5 125Z" fill="#77d4ff"></path>
                        <path d="M59.5 125V95.5L1.00003 155H29.5C46.0686 155 59.5 141.569 59.5 125Z" fill="#0085d0"></path>
                        <path d="M58.5 184.5L58.5 214L-5.20166e-06 154.5L28.5 154.5C45.0685 154.5 58.5 167.931 58.5 184.5Z" fill="#77d4ff"></path>
                        <path d="M58.5 184.5L58.5 214L117 154.5L88.5 154.5C71.9315 154.5 58.5 167.931 58.5 184.5Z" fill="#0085d0"></path>
                        <path d="M174.5 125V95.5L233 155H204.5C187.931 155 174.5 141.569 174.5 125Z" fill="#77d4ff"></path>
                        <path d="M174.5 125V95.5L116 155H144.5C161.069 155 174.5 141.569 174.5 125Z" fill="#0085d0"></path>
                        <path d="M173.5 184.5L173.5 214L115 154.5L143.5 154.5C160.069 154.5 173.5 167.931 173.5 184.5Z" fill="#77d4ff"></path>
                        <path d="M173.5 184.5L173.5 214L232 154.5L203.5 154.5C186.931 154.5 173.5 167.931 173.5 184.5Z" fill="#0085d0"></path>
                        <path d="M289.5 125V95.5L348 155H319.5C302.931 155 289.5 141.569 289.5 125Z" fill="#77d4ff"></path>
                        <path d="M289.5 125V95.5L231 155H259.5C276.069 155 289.5 141.569 289.5 125Z" fill="#0085d0"></path>
                        <path d="M288.5 184.5L288.5 214L230 154.5L258.5 154.5C275.069 154.5 288.5 167.931 288.5 184.5Z" fill="#77d4ff"></path>
                        <path d="M288.5 184.5L288.5 214L347 154.5L318.5 154.5C301.931 154.5 288.5 167.931 288.5 184.5Z" fill="#0085d0"></path>
                        <path d="M286.5 6V-23.5L345 36H316.5C299.931 36 286.5 22.5685 286.5 6Z" fill="#2fbeff"></path>
                        <path d="M286.5 6V-23.5L228 36H256.5C273.069 36 286.5 22.5685 286.5 6Z" fill="#0085d0"></path>
                        <path d="M346.5 66.5V37L288 96.5H316.5C333.069 96.5 346.5 83.0685 346.5 66.5Z" fill="#0085d0"></path>
                        <g opacity="0.34">
                            <path d="M233 65.5V36L291.5 95.5H263C246.431 95.5 233 82.0685 233 65.5Z" fill="#2fbeff"></path>
                            <path d="M233 65.5V36L174.5 95.5H203C219.569 95.5 233 82.0685 233 65.5Z" fill="#0085d0"></path>
                        </g>
                    </svg>
                </div>



                <footer>
                    <div className="mx-auto w-full max-w-screen-xl p-4 py-6 lg:py-8">
                        <div className="md:flex md:justify-between">
                            <div className="flex items-start justify-between">
                                <div className="uppercase text-black-500 font-black lg:text-3xl text-2xl">
                                    Shop.ME
                                </div>
                            </div>
                            <div className="grid grid-cols-2 gap-8 sm:gap-6 sm:grid-cols-2 justify-center lg:pt-0 pt-12">
                                <div>
                                    <h2 className="mb-6 text-xl font-bold uppercase text-primary-200">Recursos</h2>
                                    <ul className=" text-primary-800 font-bold">
                                        <li className="mb-4">
                                            <a href="#" className="hover:underline">Productos</a>
                                        </li>
                                        <li>
                                            <a href="#" className="hover:underline">Nosotros</a>
                                        </li>
                                    </ul>
                                </div>
                                <div>
                                    <h2 className="mb-6 text-xl font-bold uppercase text-primary-200">Legal</h2>
                                    <ul className=" text-primary-800 font-bold">
                                        <li className="mb-4">
                                            <a href="#" className="hover:underline">Politicas de privacidad</a>
                                        </li>
                                        <li>
                                            <a href="#" className="hover:underline">Terminos &amp; Condiciones</a>
                                        </li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                    </div>
                </footer>

            </div>
        </div>
    )
}

export default Footer