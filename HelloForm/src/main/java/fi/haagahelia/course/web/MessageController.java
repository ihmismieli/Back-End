package fi.haagahelia.course.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haagahelia.course.domain.Message;

@Controller
//C2 1. Hello Thymeleaf
public class MessageController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String greetingForm(@RequestParam(name="name") String name, @RequestParam(name="age") int age, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "hello";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String greetingSubmit(@ModelAttribute Message msg, Model model) {
		model.addAttribute("message", msg);
		return "result";
	}
}