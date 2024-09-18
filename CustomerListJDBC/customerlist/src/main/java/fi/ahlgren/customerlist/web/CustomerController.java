package fi.ahlgren.customerlist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.ahlgren.customerlist.domain.Customer;

@Controller
public class CustomerController {

    @Autowired
    // private CustomerRepository customerRepository;
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/customers")
    public String customerList(Model model){
        String sql = "SELECT * FROM customer";
        List<Customer> customers = jdbcTemplate.query(sql, (rs, rowNum) ->
        new Customer(
            rs.getString("firstname"),
            rs.getString("lastname"),
            rs.getString("email")

        )
        );
        model.addAttribute("customers", customers);
        // model.addAttribute("customers", customerRepository.findAll());
        return "customers";
    }

}
