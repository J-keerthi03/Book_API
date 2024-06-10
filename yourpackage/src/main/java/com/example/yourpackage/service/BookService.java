package com.example.yourpackage.service;

import com.example.yourpackage.model.Book;
import com.example.yourpackage.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(Long id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            return bookRepository.save(book);
        } else {
            return null;
        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book purchaseBook(String author, String description, int quantity) {
        Book book = bookRepository.findByAuthorAndDescription(author, description).orElse(null);
        if (book != null && book.getStock() >= quantity) {
            book.setStock(book.getStock() - quantity);
            return bookRepository.save(book);
        }
        return null;
    }

    public List<Book> searchBooks(List<String> authors, List<String> descriptions) {
        return bookRepository.findByAuthorsAndDescriptions(authors, descriptions);
    }

    public List<Book> searchBooksByAuthorAndDescription(List<String> authors, List<String> descriptions) {
        return bookRepository.findByAuthorsAndDescriptions(authors, descriptions);
    }

    public List<Book> searchBooksByAuthor(List<String> authors) {
        return bookRepository.findByAuthorIn(authors);
    }

    public List<Book> searchBooksByDescription(List<String> descriptions) {
        return bookRepository.findByDescriptionIn(descriptions);
    }


}
