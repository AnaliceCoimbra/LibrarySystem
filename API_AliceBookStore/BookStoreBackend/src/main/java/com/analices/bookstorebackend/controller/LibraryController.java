package com.analices.bookstorebackend.controller;
import com.analices.bookstorebackend.model.Book;
import com.analices.bookstorebackend.model.LibraryItem;
import com.analices.bookstorebackend.model.Magazine;
import com.analices.bookstorebackend.model.ReadingStatus;
import com.analices.bookstorebackend.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    // GET /api/items/all
    // GET /api/items/all?status=READING -> Filter by status if parameter is used
    @GetMapping()
    public ResponseEntity<List<LibraryItem>> getAllItems(@RequestParam(required = false) ReadingStatus status) {
        if (status != null) {
            return ResponseEntity.ok(libraryService.getItemsByStatus(status));
        }
        return ResponseEntity.ok(libraryService.getAllItems());
    }

    // GET /api/items/{id}
    @GetMapping("/{id}")
    public ResponseEntity<LibraryItem> getItemById(@PathVariable int id) {
        return ResponseEntity.ok(libraryService.getItemById(id));
    }

    // POST /api/items/newbook -> Create new book
    @PostMapping("/newbook")
    public ResponseEntity<Book> createBook(@RequestBody Book newbook) {
        Book savedBook = (Book) libraryService.saveItem(newbook); //Save the new book in the library repository
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    // POST /api/items/magazine -> Create new Magazine
    @PostMapping("/magazine")
    public ResponseEntity<Magazine> createMagazine(@RequestBody Magazine newmagazine) {
        Magazine savedMagazine = (Magazine) libraryService.saveItem(newmagazine); //Save the new magazine in the library repository
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMagazine);
    }

    // PUT /api/items/book/{id} -> Update Book Attributes
    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        Book updatedBook = (Book) libraryService.updateItem(id, book);
        return ResponseEntity.ok(updatedBook);
    }

    // PUT /api/items/magazine/{id} -> Update Magazine Attributes
    @PutMapping("/magazine/{id}")
    public ResponseEntity<Magazine> updateMagazine(@PathVariable int id, @RequestBody Magazine magazine) {
        Magazine updatedMagazine = (Magazine) libraryService.updateItem(id, magazine);
        return ResponseEntity.ok(updatedMagazine);
    }

    // PATCH /api/items/{id}/status?status=COMPLETED -> Updates only the reading status
    @PatchMapping("/{id}/status")
    public ResponseEntity<LibraryItem> updateStatus(@PathVariable int id, @RequestParam ReadingStatus status) {
        LibraryItem updatedItem = libraryService.updateStatus(id, status);
        return ResponseEntity.ok(updatedItem);
    }

    // POST /api/items/queue/{id} -> Add the book to the end of queue, "Want to Read"
    @PostMapping("/queue/{id}")
    public ResponseEntity<LibraryItem> addToQueue(@PathVariable int id) {
        return ResponseEntity.ok(libraryService.addToReadingQueue(id));
    }

    // GET /api/items/queue -> Return the want to read queue
    @GetMapping("/queue")
    public ResponseEntity<List<LibraryItem>> getQueue() {
        return ResponseEntity.ok(libraryService.getReadingQueue());
    }

    // GET /api/items/queue/next -> Peek the next in line
    @GetMapping("/queue/next")
    public ResponseEntity<LibraryItem> getNextInQueue() {
        LibraryItem next = libraryService.peekNextToRead();
        if (next == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(next);
    }

    // POST /api/items/queue/start -> Starts the book and remove from queue start
    @PostMapping("/queue/start")
    public ResponseEntity<LibraryItem> startNextInQueue() {
        LibraryItem item = libraryService.startReadingNext();
        if (item == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(item);
    }

    // DELETE /api/items/{id} -> Delete item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable int id) {
        libraryService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}

