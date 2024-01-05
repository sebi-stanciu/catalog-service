package com.polarbookshop.catalogservice.persistance;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryBookRepository implements BookRepository {

    private static final ConcurrentHashMap<String, Book> booksDb = new ConcurrentHashMap<>();

    @Override
    public Iterable<Book> findAll() {
        return booksDb.values();
    }

    @Override
    public boolean existsByIsbn(String isbn) {
        return booksDb.containsKey(isbn);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return booksDb.containsKey(isbn) ? Optional.of(booksDb.get(isbn)) : Optional.empty();
    }

    @Override
    public Book save(Book book) {
        booksDb.put(book.isbn(), book);
        return book;
    }

    @Override
    public void deleteByIsbn(String isbn) {
        booksDb.remove(isbn);
    }
}
