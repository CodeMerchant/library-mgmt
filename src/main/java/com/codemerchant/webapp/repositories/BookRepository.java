package com.codemerchant.webapp.repositories;

import com.codemerchant.webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
