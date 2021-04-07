package com.codemerchant.webapp.controllers;

import com.codemerchant.webapp.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Will improve this class and use @RestController and Collections instead

@AllArgsConstructor
@Controller

public class BookController {

    private final BookRepository bookRepository;

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());

        return "templates/books/bookList";
    }

}
