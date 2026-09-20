import type { FilterType } from "../types/library";

interface MenuProps {
  currentFilter: FilterType;
  onFilterChange: (filter: FilterType) => void;
  onAddClick: () => void;
}

function Menu({ currentFilter, onFilterChange, onAddClick }: MenuProps) {
  return (
    <div className=" m-4 flex flex-col sm:flex-row items-center justify-between gap-4 mb-8">
      <div className="flex flex-wrap gap-3">
        <button
          onClick={() => onFilterChange("ALL")}
          className={`px-4 py-2 rounded-xl text-sm font-semibold transition-all flex items-center gap-2 cursor-pointer ${
            currentFilter === "ALL"
              ? "bg-[#592C3D] text-white shadow-md"
              : "bg-[#e0e5ec] text-gray-700 shadow-[inset_-3px_-3px_6px_rgba(255,255,255,0.7),inset_3px_3px_6px_rgba(163,177,198,0.6)]"
          }`}
        >
          {currentFilter === "ALL" && <span>✓</span>}
          All my library
        </button>

        <button
          onClick={() => onFilterChange("BOOK")}
          className={`px-4 py-2 rounded-xl text-sm font-semibold transition-all flex items-center gap-2 cursor-pointer ${
            currentFilter === "BOOK"
              ? "bg-[#592C3D] text-white shadow-md"
              : "bg-[#e0e5ec] text-gray-700 shadow-[inset_-3px_-3px_6px_rgba(255,255,255,0.7),inset_3px_3px_6px_rgba(163,177,198,0.6)]"
          }`}
        >
          {currentFilter === "BOOK" && <span>✓</span>}
          Books
        </button>

        <button
          onClick={() => onFilterChange("MAGAZINE")}
          className={`px-4 py-2 rounded-xl text-sm font-semibold transition-all flex items-center gap-2 cursor-pointer ${
            currentFilter === "MAGAZINE"
              ? "bg-[#592C3D] text-white shadow-md"
              : "bg-[#e0e5ec] text-gray-700 shadow-[inset_-3px_-3px_6px_rgba(255,255,255,0.7),inset_3px_3px_6px_rgba(163,177,198,0.6)]"
          }`}
        >
          {currentFilter === "MAGAZINE" && <span>✓</span>}
          Magazines
        </button>
      </div>

      <button
        onClick={onAddClick}
        className="px-5 py-2.5 rounded-xl text-sm font-bold text-black/60 bg-[#F2E6B1] hover:bg-[#d2c797] transition-all shadow-md flex items-center cursor-pointer shrink-0"
      >
        <span>+</span> Add new readings
      </button>
    </div>
  );
}

export default Menu;