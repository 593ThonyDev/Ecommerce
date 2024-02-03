import Footer from "../../components/footer/Footer"
import Navbar from "../../components/navbar/Navbar"
import { LayoutPropos } from "../LayoutProps"

const PublicLayout = ({ children }: LayoutPropos) => {
  return (
    <div>
      <Navbar/>
      {children}
      <Footer/>
    </div>
  )
}

export default PublicLayout