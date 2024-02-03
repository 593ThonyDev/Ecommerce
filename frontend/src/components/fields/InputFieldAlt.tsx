import { FC } from "react";

interface InputFieldProps {
  mode?: "search" | "text" | "none" | "tel" | "url" | "email" | "numeric" | "decimal" | undefined;
  value?: string;
  label?: string;
  id?: string;
  extra?: string;
  type: string;
  placeholder?: string;
  variant?: string;
  state?: string;
  disabled?: boolean;
  onChange?: (event: React.ChangeEvent<HTMLInputElement>) => void;
}

const InputFieldAlt: FC<InputFieldProps> = ({
  mode,
  value,
  label,
  id,
  extra,
  type,
  placeholder,
  variant,
  state,
  disabled,
  onChange, 
}) => {
  return (
    <div className={`${extra}`}>
      {label && (
        <label
          htmlFor={id}
          className={` font-normal text-sm text-navy-700 dark:text-white/60 ${variant === "auth" ? "ml-1.5 font-medium" : "ml-1.5 font-bold"
            }`}
        >
          {label}
        </label>
      )}
      <input
        onChange={onChange}
        autoComplete="false"
        inputMode={`${mode || "text"}`}
        value={value}
        disabled={disabled}
        type={type}
        id={id}
        placeholder={placeholder}
        className={` focus:ring-0 mt-0 flex h-12 w-full border-none lg:bg-gray-100 bg-white lg:bg-obscuro-nomal lg:dark:bg-obscuro-alt dark:bg-obscuro-normal dark:border-none items-center justify-center rounded-xl p-3 text-sm outline-none ${disabled === true
          ? "!border-none !bg-gray-100 dark:!bg-white/5 dark:placeholder:!text-[rgba(255,255,255,0.15)]"
          : state === "error"
            ? "border-red-500 text-red-500 placeholder:text-red-500 dark:!border-red-400 dark:!text-red-400 dark:placeholder:!text-red-400"
            : state === "success"
              ? "border-green-500 text-green-500 placeholder:text-green-500 dark:!border-green-400 dark:!text-green-400 dark:placeholder:!text-green-400"
              : "border-gray-200 dark:!border-white/10 dark:text-white"
          }`}
      />
    </div>
  );
};

export default InputFieldAlt;
