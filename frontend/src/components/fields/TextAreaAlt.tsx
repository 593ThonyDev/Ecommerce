import { FC } from "react";

interface InputFieldProps {
  label?: string;
  id?: string;
  extra?: string;
  value?: string;
  placeholder: string;
  disabled?: boolean;
  rows: number;
  onChangeText?: (event: React.ChangeEvent<HTMLTextAreaElement>) => void;
}

const TextAreaAlt: FC<InputFieldProps> = ({
  label,
  id,
  extra,
  value,
  placeholder,
  disabled,
  rows,
  onChangeText
}) => {
  return (
    <div className={`${extra}`}>
      {label && (
        <label
          htmlFor={id}
          className={` font-normal text-sm text-navy-700 dark:text-white/60`}
        >
          {label}
        </label>
      )}
      <textarea
        onChange={onChangeText}
        value={value}
        disabled={disabled}
        id={id}
        placeholder={placeholder}
        className={"focus:ring-0 mt-0 flex w-full border-none lg:bg-gray-100 bg-white lg:bg-obscuro-nomal lg:dark:bg-obscuro-alt dark:bg-obscuro-normal dark:border-none text-navy-700 dark:text-white/60  items-center justify-center rounded-2xl p-4 text-sm outline-none"}
        rows={rows}
      />
    </div>
  );
};

export default TextAreaAlt;
