import Footer from "../../components/footer/Footer"
import Navbar from "../../components/navbar/public/Navbar"
import { LayoutProps } from "../LayoutProps"

const PublicLayout = ({ children }: LayoutProps) => {
  return (
    <div>
      <Navbar/>
      {children}
      <Footer/>
    </div>
  )
}

export default PublicLayout