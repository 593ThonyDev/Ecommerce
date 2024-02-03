import { ChangeEvent, FC } from "react";

interface InputFieldProps {
  label?: string;
  id?: string;
  extra?: string;
  value?: string;
  type?: string;
  placeholder?: string;
  variant?: string;
  disabled?: boolean;
  accept?: string;
  onChange?: (event: ChangeEvent<HTMLInputElement>) => void;
}

const InputField: FC<InputFieldProps> = ({
  label,
  id,
  extra,
  value,
  type,
  placeholder,
  variant,
  disabled,
  accept,
  onChange
}) => {
  return (
    <div className={`${extra == null ? "" : extra}`}>
      {label && (
        <label
          htmlFor={id}
          className={` font-normal text-sm text-gray-400 dark:text-white/60 ${variant === "auth" ? "ml-1.5 font-medium" : "ml-1.5 font-bold"
            }`}
        >
          {label}
        </label>
      )}
      <input
        autoComplete="false"
        value={value}
        disabled={disabled}
        type={type}
        id={id}
        accept={accept}
        placeholder={placeholder}
        onChange={onChange}
        className={`focus:ring-0 mt-0 flex w-full border-none bg-gray-100 lg:bg-obscuro-nomal dark:bg-obscuro-normal dark:border-none text-gray-600 dark:text-white/60  items-center justify-center rounded-2xl p-4 text-sm outline-none`
        }
      />
    </div>
  );
};

export default InputField;
