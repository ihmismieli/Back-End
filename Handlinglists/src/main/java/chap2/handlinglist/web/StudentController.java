package chap2.handlinglist.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import chap2.handlinglist.domain.Friend;
import chap2.handlinglist.domain.Student;


@Controller
public class StudentController {
     // C2 2.Handling Lists
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String listStudents(Model model) {

        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Kate", "Cole"));
        students.add(new Student("Dan", "Brown"));
        students.add(new Student("Mike", "Mars"));

        // lisätään lista modeliin, jotta se voidaan näyttää thymeleafissa
        model.addAttribute("students", students);

        return "hello";
    }

    //C2 3. Friend List

    List<String> friends = new ArrayList<>();

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String addFriendsToAList(Model model) {
        
        //luodaan friend-olio, jotta käyttäjä voi lisätä lomakkeella ystävän
        model.addAttribute("message", new Friend());
        //lisätään lista modeliin, jotta listan sisältö voidaan näyttää sivulla
        model.addAttribute("friends", friends);
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    //@ModelAttribute Friend message: tallennetaan käyttäjän antamat tiedot Friend-olion message instanssiin
    public String submitFriends(@ModelAttribute Friend message, Model model) {
        friends.add(message.getName());
        //lisätään päivitetty lista modeliin
        model.addAttribute("friends", friends);
        //tyhjennetään lomake uudelle syötteelle
        model.addAttribute("message", new Friend());
        return "index";
    }
}
