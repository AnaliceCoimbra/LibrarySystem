package com.analices.bookstorebackend.dataInitializer;

import com.analices.bookstorebackend.model.Book;
import com.analices.bookstorebackend.model.Magazine;
import com.analices.bookstorebackend.model.ReadingStatus;
import com.analices.bookstorebackend.service.LibraryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(LibraryService libraryService) {
        return args -> {

            // 1. Create a few books to use as example
            Book book1 = new Book();
            book1.setTitle("O Hobbit");
            book1.setAuthor("J.R.R. Tolkien");
            book1.setGenre("Fantasy");
            book1.setPages(310);
            book1.setStatus(ReadingStatus.COMPLETED);

            Book book2 = new Book();
            book2.setTitle("Clean Code");
            book2.setAuthor("Robert C. Martin");
            book2.setGenre("Technology");
            book2.setPages(425);
            book2.setStatus(ReadingStatus.READING);

            Book book3 = new Book();
            book3.setTitle("Understanding Algorithms");
            book3.setAuthor("Aditya Y. Bhargava");
            book3.setGenre("Technology");
            book3.setPages(264);
            book3.setStatus(ReadingStatus.WANT_TO_READ);

            // 2. Create a few magazines
            Magazine mag1 = new Magazine();
            mag1.setTitle("National Geographic");
            mag1.setGenre("Geography");
            mag1.setEdition(240);
            mag1.setStatus(ReadingStatus.WANT_TO_READ);

            Magazine mag2 = new Magazine();
            mag2.setTitle("Vogue");
            mag2.setGenre("Fashion");
            mag2.setEdition(60);
            mag2.setStatus(ReadingStatus.WANT_TO_READ);

            // 3. Save items using Service
            libraryService.saveItem(book1);
            libraryService.saveItem(book2);
            libraryService.saveItem(book3);
            libraryService.saveItem(mag1);

            libraryService.addToReadingQueue(book3.getId());
            libraryService.addToReadingQueue(mag1.getId());

            System.out.println("Mocked data initialized!");
        };
    }
}