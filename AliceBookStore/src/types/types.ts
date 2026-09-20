// Status de Leitura
export type ReadingStatus = 'READ' | 'READING' | 'WANT_TO_READ';

// Item Base (LibraryItem)
export interface LibraryItem {
  id: number;
  title: string;
  coverUrl?: string;
  status: ReadingStatus;
  type: 'BOOK' | 'MAGAZINE';
  genre: string;
  pages: number;
  // Book
  author?: string;
  // Magazine
  edition?: number;
}

// Resposta do Cache / Métricas (para mostrar que você domina Cache no Java)
export interface CacheStats {
  hits: number;
  misses: number;
  cachedItemsCount: number;
}