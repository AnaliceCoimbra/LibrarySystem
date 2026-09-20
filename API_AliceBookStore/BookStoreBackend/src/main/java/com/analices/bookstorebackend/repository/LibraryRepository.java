package com.analices.bookstorebackend.repository;

import com.analices.bookstorebackend.model.Book;
import com.analices.bookstorebackend.model.LibraryItem;
import com.analices.bookstorebackend.model.Magazine;
import com.analices.bookstorebackend.model.ReadingStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class LibraryRepository {

        //Creating a Catalog List to add books and magazines
        private final List<LibraryItem> catalog = new ArrayList<>();
        private int nextId = 0;

        // Save new Item
        public LibraryItem saveNewItem(LibraryItem item) {
            item.setId(nextId++);
            catalog.add(item);
            return item;
        }

        // List all catalog
        public List<LibraryItem> listAll() {
            return catalog;
        }

        // Get by ID
        public Optional<LibraryItem> findById(int id) {
            return catalog.stream()
                    .filter(item -> item.getId() == id)
                    .findFirst();
        }

        // Filter by status (Reading, Want to Read, Completed)
        public List<LibraryItem> findByStatus(ReadingStatus status) {
            return catalog.stream()
                    .filter(item -> item.getStatus() == status)
                    .collect(Collectors.toList());
        }

        // Update Item attributes
        public LibraryItem updateItemAttributes(int id, LibraryItem updatedItem) {
            Optional<LibraryItem> existingItemOpt = findById(id);
            if (existingItemOpt.isEmpty()) {
                return null;
            } else {
                LibraryItem item = existingItemOpt.get();
                item.setTitle(updatedItem.getTitle());
                item.setCoverUrl(updatedItem.getCoverUrl());
                item.setStatus(updatedItem.getStatus());
                item.setGenre(updatedItem.getGenre());
                item.setPages(updatedItem.getPages());

                //If the item type is a Book, updates the book attributes (author)
                if (item instanceof Book book && updatedItem instanceof Book updatedBook) {
                    book.setAuthor(updatedBook.getAuthor());
                } //If the item type is a Magazine, updates the Magazine attributes (edition)
                else if (item instanceof Magazine mag && updatedItem instanceof Magazine updatedMag) {
                    mag.setEdition(updatedMag.getEdition());
                }
                return item;
            }
        }

        // Delete from catalog
        public boolean deleteById(int id) {
            return catalog.removeIf(item -> item.getId() == id);
        }
    }

