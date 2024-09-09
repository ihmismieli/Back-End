package projekti.bookstoreproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import projekti.bookstoreproject.domain.Book;
import projekti.bookstoreproject.domain.BookRepository;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookController {
@Autowired
private BookRepository repository;

    @RequestMapping(value="/booklist")
    public String bookList (Model model){
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value="/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "addstudent";
    }
    
    @PostMapping("/save")
    public String save(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }
    
}
