package com.example.yourpackage.controller;

import com.example.yourpackage.model.Book;
import com.example.yourpackage.model.PurchaseRequest;
import com.example.yourpackage.model.SearchRequest;
import com.example.yourpackage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book updatedBook = bookService.updateBook(book.getId(), book);
        return updatedBook != null ? ResponseEntity.ok(updatedBook) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return updatedBook != null ? ResponseEntity.ok(updatedBook) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<Book>> purchaseBooks(@RequestBody List<PurchaseRequest> requests) {
        List<Book> purchasedBooks = new ArrayList<>();
        for (PurchaseRequest request : requests) {
            Book book = bookService.purchaseBook(request.getAuthor(), request.getDescription(), request.getQuantity());
            if (book != null) {
                purchasedBooks.add(book);
            }
        }
        return !purchasedBooks.isEmpty() ? ResponseEntity.ok(purchasedBooks) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestBody SearchRequest request) {
        List<Book> books;

        // Check if both authors and descriptions are provided
        if (request.getAuthors() != null && request.getDescriptions() != null) {
            books = bookService.searchBooksByAuthorAndDescription(request.getAuthors(), request.getDescriptions());
        }
        // Check if only authors are provided
        else if (request.getAuthors() != null) {
            books = bookService.searchBooksByAuthor(request.getAuthors());
        }
        // Check if only descriptions are provided
        else if (request.getDescriptions() != null) {
            books = bookService.searchBooksByDescription(request.getDescriptions());
        }
        else {
            return ResponseEntity.badRequest().build();
        }

        return books != null && !books.isEmpty() ? ResponseEntity.ok(books) : ResponseEntity.notFound().build();
    }

}
