package com.codemerchant.webapp.repositories;

import com.codemerchant.webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
