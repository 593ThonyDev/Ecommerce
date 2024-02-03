import { ChangeEvent, FC } from "react";

interface InputFieldProps {
  label?: string;
  id?: string;
  extra?: string;
  value?: string;
  placeholder: string;
  disabled?: boolean;
  rows: number; // Asegúrate de que rows sea de tipo number
  onChange?: (event: ChangeEvent<HTMLTextAreaElement>) => void;
}

const TextArea: FC<InputFieldProps> = ({
  label,
  id,
  extra,
  value,
  placeholder,
  disabled,
  rows,
  onChange
}) => {
  return (
    <div className={`${extra}`}>
      {label && (
        <label
          htmlFor={id}
          className={`ml-2 font-normal text-sm text-gray-400 dark:text-white/60`}
        >
          {label}
        </label>
      )}
      <textarea
        value={value}
        disabled={disabled}
        id={id}
        placeholder={placeholder}
        className={"focus:ring-0 mt-0 flex w-full border-none bg-gray-100 dark:bg-obscuro-normal dark:border-none text-gray-600 dark:text-white/60  items-center justify-center rounded-2xl p-4 text-sm outline-none"}
        rows={rows}
        onChange={onChange}
      />
    </div>
  );
};

export default TextArea;
