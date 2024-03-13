import { useEffect, useRef, useState } from 'react';
import { FaUser } from 'react-icons/fa';
import { getFullName, getPhotoProfile, logOut } from '../../functions/AuthApi';
import { useNavigate } from 'react-router-dom';

const DropDownAdmin = () => {
    const navigate = useNavigate();
    const [isOpen, setIsOpen] = useState(false);
    const dropdownRef = useRef<HTMLDivElement>(null);
    const userPhoto = getPhotoProfile();
    const fullName = getFullName();

    const toggleDropdown = () => {
        setIsOpen(!isOpen);
    };

    const handleLogOut = () => {
        logOut(navigate);
    };

    const closeDropdown = (e: MouseEvent) => {
        if (dropdownRef.current && !dropdownRef.current.contains(e.target as Node)) {
            setIsOpen(false);
        }
    };

    // Manejador de eventos para el clic en el modal
    const handleModalClick = (e: React.MouseEvent<HTMLDivElement>) => {
        e.stopPropagation();
    };

    useEffect(() => {
        const clickListener = (e: MouseEvent) => closeDropdown(e);
        document.addEventListener('click', clickListener);
        return () => {
            document.removeEventListener('click', clickListener);
        };
    }, []);

    return (
        <div className="relative" ref={dropdownRef}>
            <div
                className='cursor-pointer'
                onClick={toggleDropdown}
            >
                {userPhoto ?
                    <div className='flex align-middle bg-primary-50 rounded-full border border-primary-100'>
                        <div className=' my-auto px-2 lg:block hidden'>{fullName}</div>
                        <img src={userPhoto} className=' w-10 h-10 rounded-full border border-primary-200' alt="" />
                    </div>
                    :
                    <FaUser className="w-6 h-6" />
                }

            </div>

            {isOpen && (
                <div
                    className=" text-black-500 absolute right-0 mt-2 p-1 w-40 bg-primary-100 border border-primary-500/10 rounded-lg shadow-lg"
                    onClick={handleModalClick}
                >
                    <div
                        className="cursor-pointer lg:hidden block px-2 py-2 text-black-900 rounded-md"
                    >
                        <div className="flex justify-center border-b border-primary-300 pb-3 uppercase">
                            <div className=' my-auto px-2 '>{fullName}</div>
                        </div>
                    </div>
                    <div
                        onClick={() => { }}
                        className="cursor-pointer block px-2 py-2 text-black-500  hover:bg-primary-50 rounded-md"
                    >
                        <div className="flex justify-center">
                            <span className=" my-auto">Mi perfil</span>
                        </div>
                    </div>
                    <div
                        onClick={handleLogOut}
                        className="cursor-pointer block px-2 py-2 text-black-500  hover:bg-primary-50 rounded-md"
                    >
                        <div className="flex justify-center">
                            <span className=" my-auto">Cerrar sesion</span>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}

export default DropDownAdmin;
