package fi.ahlgren.customer.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.ahlgren.customer.domain.Customer;
import fi.ahlgren.customer.domain.CustomerDAO;
import fi.ahlgren.customer.domain.CustomerRepository;


@Controller
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/customerlist")
    public String customerList(Model model) {

        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customerlist";
    }

    @GetMapping("/add")
    public String addCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "addcustomer";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Customer customer){
        customerDAO.save(customer);
        return "redirect:customerlist";
    }

}
