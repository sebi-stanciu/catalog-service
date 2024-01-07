package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record Book(
        @Id
        Long id,

        @NotBlank(message = "The book ISBN must be defined.")
        String isbn,

        @NotBlank(message = "The book title must be defined.")
        String title,

        @NotBlank(message = "The book author must be defined.")
        String author,

        @NotNull(message = "The book price must be defined.")
        @Positive(message = "The book price must be greater than zero.")
        Double price,

        @Version
        int version
) {
    public static Book of(String isbn, String title, String author, Double price
    ) {
        return new Book(null, isbn, title, author, price, 0); // An entity is considered new when the ID is null and the version is 0.
    }
}
