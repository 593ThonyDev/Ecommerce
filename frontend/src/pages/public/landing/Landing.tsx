import About from "./about/About"
import Categories from "./categories/Categories"
import Home from "./home/Home"
import Blog from "./blog/Blog"
import Product from "./product/Product"

const Landing = () => {
  return (
    <div>
      <Home/>
      <Categories/>
      <About/>
      <Product/>
      <Blog/>
    </div>
  )
}

export default Landing