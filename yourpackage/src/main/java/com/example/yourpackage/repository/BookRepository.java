package com.example.yourpackage.repository;

import com.example.yourpackage.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("UPDATE Book b SET b.stock = b.stock - :quantity WHERE b.id = :id AND b.stock >= :quantity")
    int purchaseBook(@Param("id") Long id, @Param("quantity") int quantity);

    @Query("SELECT b FROM Book b WHERE b.author = :author AND b.description = :description")
    Optional<Book> findByAuthorAndDescription(@Param("author") String author, @Param("description") String description);

    @Query("SELECT b FROM Book b WHERE b.author IN (:authors) AND b.description IN (:descriptions)")
    List<Book> findByAuthorsAndDescriptions(@Param("authors") List<String> authors, @Param("descriptions") List<String> descriptions);


    List<Book> findByAuthorIn(List<String> authors);

    List<Book> findByDescriptionIn(List<String> descriptions);
}
