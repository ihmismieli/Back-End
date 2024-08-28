package projekti.bookstoreproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.qos.logback.core.model.Model;
import projekti.bookstoreproject.domain.Book;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookController {

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String listBooks (Model model){
        return "index";
    }
    
    @PostMapping("/index")
    public String postMethodName(@ModelAttribute Book book, Model model) {
        //TODO: process POST request
        
        return "result";
    }
    
}
