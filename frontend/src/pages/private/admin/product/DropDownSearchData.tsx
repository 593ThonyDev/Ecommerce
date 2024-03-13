import React, { useEffect, useRef, useState } from 'react';
import { searchCategoryProduct } from '../product-category/model/CategoryApi';

interface Category {
    idCategory: string;
    categoryName: string;
}

interface DropdownProps {
    buttonText: string;
    extraClass?: string;
    extraOptionClass?: string;
    onCategoryIdChange: (categoryId: string) => void; // Nuevo prop para manejar el cambio de ID de categoría
}

const DropDownSearchData: React.FC<DropdownProps> = ({ buttonText, extraClass, extraOptionClass,  onCategoryIdChange }) => {
    const [isOpen, setIsOpen] = useState(false);
    const [searchValue, setSearchValue] = useState('');
    const [categories, setCategories] = useState<Category[]>([]);
    const [selectedCategory, setSelectedCategory] = useState<string>(''); // Estado para almacenar el ID seleccionado
    const [selectedButtonText, setSelectedButtonText] = useState<string>(buttonText); // Estado para almacenar el texto seleccionado
    const [hasResults, setHasResults] = useState(true);
    const dropdownRef = useRef<HTMLDivElement>(null);

    const toggleDropdown = () => {
        setIsOpen(!isOpen);
    };

    const closeDropdown = (e: MouseEvent) => {
        if (dropdownRef.current && !dropdownRef.current.contains(e.target as Node)) {
            setIsOpen(false);
        }
    };

    useEffect(() => {
        document.addEventListener('click', closeDropdown);
        return () => {
            document.removeEventListener('click', closeDropdown);
        };
    }, []);

    useEffect(() => {
        const fetchCategories = async () => {
            try {
                const categoriesData = await searchCategoryProduct(searchValue);
                if (categoriesData !== null) {
                    setCategories(categoriesData);
                } else {
                    setCategories([]);
                }
            } catch (error) {
                console.error('Error al obtener las categorías:', error);
            }
        };

        fetchCategories();
    }, [searchValue]);

    const handleOptionClick = (selectedValue: string, categoryId: string) => {
        setSelectedCategory(categoryId); // Almacenar el ID seleccionado en el estado
        setSelectedButtonText(selectedValue); // Actualizar el texto seleccionado
        // onChange(selectedValue); // Llamar al onChange original
        onCategoryIdChange(categoryId); // Llamar al nuevo método onCategoryIdChange
        setIsOpen(false);
        setSearchValue('');
        setHasResults(true);
    };

    useEffect(() => {
        setHasResults(categories.length > 0);
    }, [searchValue, categories]);

    return (
        <div className="relative" ref={dropdownRef}>
            <div
                onClick={toggleDropdown}
                className={`${extraClass ? extraClass : 'text-black-500 bg-primary-100'} focus:ring-0 flex  border-none bg-primary-100/50 text-black-600 items-center rounded-2xl p-4  text-sm outline-nonetext-sm w-full  cursor-pointer z-30 px-4 py-4 h-full`}
            >
                {selectedButtonText } {/* Utiliza selectedButtonText en lugar de buttonText */}
            </div>

            {isOpen && (
                <div className={`${extraOptionClass} absolute right-0 mt-0.5 w-full bg-white  border border-primary-200  rounded-lg shadow-lg text-center z-50`}>
                    <div className="p-1">
                        <input
                            type="text"
                            placeholder="Buscar..."
                            value={searchValue}
                            onChange={(e) => setSearchValue(e.target.value)}
                            className="focus:ring-0 mt-0 flex h-10 w-full border-none bg-primary-50 items-center justify-center rounded-lg p-3 text-sm outline-none"
                        />
                    </div>
                    <div className="overflow-y-scroll scrollbar-hide max-h-60 p-1">
                        {hasResults ? (
                            categories.map((category, index) => (
                                <span
                                    key={index}
                                    className={`whitespace-nowrap block px-4 py-2 text-black-500 dark:hover:bg-gray-600/10  hover:bg-black-600/10  rounded-md cursor-pointer ${
                                        selectedCategory === category.idCategory ? 'bg-primary-200' : ''
                                    }`} // Aplicar estilo de selección
                                    onClick={() => handleOptionClick(category.categoryName, category.idCategory)}
                                >
                                    {category.categoryName}
                                </span>
                            ))
                        ) : (
                            <span className="relative px-4 py-2 text-justify text-black-500">
                                No se encontraron resultados
                            </span>
                        )}
                    </div>
                </div>
            )}
        </div>
    );
};

export default DropDownSearchData;
