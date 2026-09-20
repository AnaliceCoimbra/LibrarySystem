import './App.css'
import BookCard from './hooks/BookCard'

function App() {

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
       <BookCard/>

       {/* Aqui ficará um for book : /items cria uma div pro book */}
    </main>

    <footer className='bg-[#2ab620] mb-0 border-2'>
        <p> test</p>
    </footer>
    </>
  )
}

export default App
