import type{ LibraryItem, ReadingStatus } from '../types/library';


const API_BASE_URL = 'https://librarysystembackend-1xvj.onrender.com/api/items';

export const api = {

    async getItems(): Promise<LibraryItem[]> {
    const response = await fetch(API_BASE_URL);
    if (!response.ok) {
      throw new Error('Error when getting catalog');
    }
    return response.json();
  },

  // Update reading status
  async updateStatus(id: number, status: ReadingStatus): Promise<LibraryItem> {
    const response = await fetch(`${API_BASE_URL}/${id}/status?status=${status}`, {
      method: 'PATCH',
    });
    if (!response.ok) {
      throw new Error('Error updating status');
    }
    return response.json();
  },

  // Delete an item
  async deleteItem(id: number): Promise<void> {
    const response = await fetch(`${API_BASE_URL}/${id}`, {
      method: 'DELETE',
    });
    if (!response.ok) {
      throw new Error('Error when deleting item');
    }
  }
};