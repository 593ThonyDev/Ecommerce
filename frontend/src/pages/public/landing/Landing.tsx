import About from "./about/About"
import Home from "./home/Home"
import Blog from "./blog/Blog"
import ProductCategoryList from "./categories/ProductCategoryList"
import Product from "./product/Product"

const Landing = () => {
  return (
    <div>
      <Home/>
      <ProductCategoryList/>
      <About/>
      <Product/>
      <Blog/>
    </div>
  )
}

export default Landing