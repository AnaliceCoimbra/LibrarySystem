
function BookCard() {
    return (
        <> 
    <div className="bg-white border border-gray-200 rounded-lg p-5 shadow-md hover:shadow-lg transition">
    <span className="text-xs font-semibold uppercase text-indigo-600">
        Fantasia
    </span>
    <h3 className="text-xl font-bold text-gray-800 mt-1">
        O Nome do Vento
    </h3>
    <p className="text-sm text-gray-500 mb-4">
        Patrick Rothfuss
    </p>
    <div className="flex items-center justify-between">
        <span className="text-xs px-2 py-1 bg-emerald-100 text-emerald-700 font-medium rounded-full">
        Disponível
        </span>
        <button className="bg-indigo-600 text-white text-sm font-medium px-4 py-2 rounded-md hover:bg-indigo-700 transition">
        Reservar
        </button>
    </div>
    </div>
    </>
    )
}

export default BookCard;
