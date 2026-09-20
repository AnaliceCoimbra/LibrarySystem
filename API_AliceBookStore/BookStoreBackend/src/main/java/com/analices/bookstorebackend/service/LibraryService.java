package com.analices.bookstorebackend.service;

import com.analices.bookstorebackend.model.LibraryItem;
import com.analices.bookstorebackend.model.ReadingStatus;
import com.analices.bookstorebackend.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    public LibraryService(LibraryRepository bookRepository) {
        this.libraryRepository = bookRepository;
    }
    private final Queue<LibraryItem> readingQueue = new ArrayDeque<>();

    // Save a new Item
    public LibraryItem saveItem(LibraryItem item) {
        if (item.getTitle() == null || item.getTitle().isBlank()) {
            throw new IllegalArgumentException("The title can't be empty!");
        }
        return libraryRepository.saveNewItem(item);
    }

    // List all items
    public List<LibraryItem> getAllItems() {
        return libraryRepository.listAll();
    }

    // Get by ID
    public LibraryItem getItemById(int id) {
        return libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item with ID: " + id + " does not exist."));
    }

    // Filter by Reading Status
    public List<LibraryItem> getItemsByStatus(ReadingStatus status) {
        return libraryRepository.findByStatus(status);
    }

    // Update Item attributes (title and cover image)
    public LibraryItem updateItem(int id, LibraryItem updatedItem) {
        getItemById(id);
        if (updatedItem.getTitle() == null || updatedItem.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title can not be empty!");
        }
        return libraryRepository.updateItemAttributes(id, updatedItem);
    }

    // Update reading Status
    public LibraryItem updateStatus(int id, ReadingStatus newStatus) {
        LibraryItem item = getItemById(id);
        item.setStatus(newStatus);

        if (newStatus != ReadingStatus.WANT_TO_READ) {
            readingQueue.remove(item);
        }
        return item;
    }

    // Delete item by ID
    public void deleteItem(int id) {
        boolean deleted = libraryRepository.deleteById(id);
        if (!deleted) {
        throw new RuntimeException("Could not delete item with ID " + id + ".");
        }
    }

    //A Queue of Want to Read books
    public LibraryItem addToReadingQueue(int id) {
        LibraryItem item = getItemById(id);

        // If the item is already on the queue, wont add again
        if (!readingQueue.contains(item)) {
            item.setStatus(ReadingStatus.WANT_TO_READ);
            readingQueue.add(item); // insere no fim da fila
        }
        return item;
    }

    //Checks (peek) the next book to read
    public LibraryItem peekNextToRead() {
        return readingQueue.peek();
    }

    //Change the reading status
    public LibraryItem startReadingNext() {
        LibraryItem item = readingQueue.poll();
        if (item != null) {
            item.setStatus(ReadingStatus.READING);
        }
        return item;
    }

    //Shows the items to read on queue
    public List<LibraryItem> getReadingQueue() {
        return new ArrayList<>(readingQueue);
    }
}

