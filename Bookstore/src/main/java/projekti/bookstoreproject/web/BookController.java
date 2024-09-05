package projekti.bookstoreproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import projekti.bookstoreproject.domain.Book;
import projekti.bookstoreproject.domain.BookRepository;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookController {
@Autowired
private BookRepository repository;

    @RequestMapping(value="/index")
    public String bookList (Model model){
        model.addAttribute("books", repository.findAll());
        return "index";
    }
    
    @PostMapping("/index")
    public String postMethodName(@ModelAttribute Book book, Model model) {
        //TODO: process POST request
        
        return "result";
    }
    
}
