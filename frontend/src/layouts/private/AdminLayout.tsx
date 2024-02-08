import NavbarAdmin from "../../components/navbar/private/NavbarAdmin";
import { LayoutProps } from "../LayoutProps"

const Sidebar = ({ children }: LayoutProps) => {
    return (
        <div className="gap-5 relative">
            <NavbarAdmin />
            <main className="">{children}</main>
        </div>
    );
};

export default Sidebar;
