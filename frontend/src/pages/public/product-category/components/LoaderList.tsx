const LoaderList = () => {
    return (
        <div className="flex h-fit items-start justify-between cursor-pointer bg-white hover:rounded-xl rounded-xl">
            <div className="flex items-center gap-3 p-1 w-full rounded-xl">
                <div className="relative h-8 max-h-8 w-8 items-start justify-start rounded-full">
                    <div className="h-8 max-h-8 max-w-8 w-8 rounded-xl bg-primary-100" />
                </div>
                <div className="lg:flex lg:justify-between grid w-full">
                    <div className="grid">
                        <div className="bg-black-100 h-2.5 lg:w-32 w-16 rounded-full my-auto" />
                    </div>
                </div>
            </div>
        </div>
    )
}

export default LoaderList