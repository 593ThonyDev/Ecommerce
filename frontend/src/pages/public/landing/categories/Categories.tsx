const Categories = () => {

    const categories = [
        {
            id: 1,
            name: "Fast Food",
            image:
                "https://duyt4h9nfnj50.cloudfront.net/new_search_home_eats_icon/FastFood_BrowseHome@3x.png",
        },
        {
            id: 2,
            name: "Pizza",
            image:
                "https://duyt4h9nfnj50.cloudfront.net/new_search_home_eats_icon/Pizza_BrowseHome@3x.png",
        },
        {
            id: 3,
            name: "Wings",
            image:
                "https://duyt4h9nfnj50.cloudfront.net/new_search_home_eats_icon/Wings_BrowseHome@3x.png",
        },
        {
            id: 4,
            name: "Indian",
            image:
                "https://duyt4h9nfnj50.cloudfront.net/new_search_home_eats_icon/Indian_BrowseHome@3x.png",
        }
    ];

    return (
        <div className=' relative -mb-16 lg:mx-48 mt-5'>
            <div className="container flex flex-row justify-around mx-auto bg-primary-200 md:rounded-3xl lg:rounded-3xl pb-6 lg:py-1 py-5">
                <div className="max-w-[1640px] m-auto">
                    <h1 className="text-white font-bold text-4xl text-center py-1 pt-3 pb-2 px-2">
                        Categorias de nuestros productos
                    </h1>
                    <div className="grid grid-cols-2 md:grid-cols-4 gap-6 lg:px-2 px-4 lg:pb-2">
                        {categories.map((item, index) => (
                            <div
                                key={index}
                                className="bg-gray-100 hover:bg-primary-100 cursor-pointer duration-500 rounded-lg px-3 flex justify-center items-center"
                            >
                                <img src={item.image} alt={item.name} className="w-10" />
                                <h2 className="font-bold sm:text-xl">{item.name}</h2>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Categories