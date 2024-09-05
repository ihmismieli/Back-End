package fi.haagahelia.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.haagahelia.course.domain.BookRepository;

@Controller
public class BookController {
    //injektoi dependencyn BookRepository instancen StudentController classiin
    @Autowired
    //tämän avulla voidaan käyttää BookRepository rajapinnan metodeja
    private BookRepository repository;

    @RequestMapping(value={"/", "/booklist"})
    public String bookList(Model model){
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

}
