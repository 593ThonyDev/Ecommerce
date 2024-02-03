import { FC } from "react";

interface ListLabelProps {
    label?: string,
    value: string,
    type?: string
}

const ListLabel: FC<ListLabelProps> = ({ label, value, type }) => {
    return (
        <div className={`
        ${type === "flex" ? "lg:flex text-justify" : ""} 
        ${type === "grid" ? "grid text-justify" : ""}
        `}>
            <span className="text-lg font-semibold text-gray-600 dark:text-white text-justify mr-1">{label}</span>
            <span className="text-lg text-gray-600 dark:text-gray-100/50 text-justify">{value}</span>
        </div>
    )
}

export default ListLabel