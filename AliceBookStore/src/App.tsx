import './App.css'
import { api } from './services/api';
import BookCard from './hooks/BookCard'
import { useEffect, useState } from 'react';
import Menu from './hooks/Menu';
import type { FilterType, LibraryItem } from './types/library';

function App() {
  const [items, setItems] = useState<LibraryItem[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);
  const [filter, setFilter] = useState<FilterType>('ALL');

  const handleOpenAddModal = () => {
    console.log("Abrir formulário de adicionar livro");
    };

useEffect(() => {
    api.getItems()
      .then((data) => {
        setItems(data);
        setLoading(false);
      })
      .catch((err) => {
        console.error(err);
        setError('Não foi possível carregar os dados da API.');
        setLoading(false);
      });
  }, []);

  if (loading) {
    return (
      <div className="min-h-screen bg-[#e0e5ec] flex items-center justify-center">
        <p className="text-gray-600 text-lg font-semibold animate-pulse">Loading your latest readings...</p>
      </div>
    );
  }
  if (error) {
    return (
      <div className="min-h-screen bg-[#e0e5ec] flex items-center justify-center">
        <p className="text-red-500 font-medium">{error}</p>
      </div>
    );
  }

  const filteredItems = items.filter(item => {
    if (filter === 'BOOK') {
      return item.type === 'BOOK'; // Ou cheque a propriedade que identifica se é livro
    }
    if (filter === 'MAGAZINE') {
      return item.type === 'MAGAZINE'; // Ou cheque se possui 'edition'
    }
    return true; // Se filter === 'ALL', retorna tudo
  });
  return (
    <>
    <header className='flex flex-row justify-between shadow p-4'> 
    <div> 
      <h1 className='font-bold text-4xl text-[#3D2B1F]'> Have I ever read it? </h1>
    </div>
    <div>       
      <h3 className='font-medium text-lg mt-3'> What are you reading, now? </h3>
    </div>
    <div> 
      <h3 className='font-medium text-lg mt-3'>Made by Analice Coimbra </h3>
    </div>
    </header>

    <main className='m-4 border-2'>
       
       <Menu
          currentFilter={filter} 
          onFilterChange={setFilter} 
          onAddClick={handleOpenAddModal}
       />
       <section className='grid grid-cols-5'>
        {filteredItems.map((item) => (
          <BookCard key={item.id} item={item}/>
        ))}
       </section>
    </main>

    <footer className='bg-[#2ab620] mb-0 border-2'>
        <p> test</p>
    </footer>
    </>
  )
}

export default App
