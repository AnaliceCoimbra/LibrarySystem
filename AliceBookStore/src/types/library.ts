// Status de Leitura
export type ReadingStatus = 'READ' | 'READING' | 'WANT_TO_READ';

// Item Base (LibraryItem)
export interface LibraryItem {
  id: number;
  title: string;
  coverUrl?: string;
  status?: ReadingStatus;
  type?: 'BOOK' | 'MAGAZINE';
  genre: string;
  pages: number;
  // Book
  author?: string;
  // Magazine
  edition?: number;
}

export type FilterType = 'ALL' | 'BOOK' | 'MAGAZINE';

export interface CacheStats {
  hits: number;
  misses: number;
  cachedItemsCount: number;
}