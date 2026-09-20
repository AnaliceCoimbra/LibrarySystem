
function BookCard() {
    return (
        <> 
    <div className= "flex flex-col w-70 h-115 bg-[#e0e5ec] m-4 p-4 rounded-2xl shadow-[inset_-5px_-5px_10px_rgba(255,255,255,0.7),inset_5px_5px_10px_rgba(163,177,198,0.6)]">
        
        <div className="p-3 overflow-hidden">
                <img 
                    src="https://i.pinimg.com/736x/47/45/40/474540f3452d3b43358a6c011fd2d37a.jpg" 
                    alt="Capa do livro" 
                    className="h-85 object-cover"
                />
            </div> 
        <h3 className="text-xl font-bold text-gray-800">
            titulo
        </h3>
            <p className="text-sm text-gray-500">
                AUTHOR      
            </p>
        <div className="mt-0.5 self-end">
            <span className="text-xs px-2 py-1 bg-emerald-100 text-emerald-700 font-medium rounded-full">
            Status de leitura
            </span>
        </div>
    </div>
    </>
    )
}

export default BookCard;
