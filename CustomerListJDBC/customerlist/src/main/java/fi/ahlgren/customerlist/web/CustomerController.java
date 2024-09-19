package fi.ahlgren.customerlist.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CustomerController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/customers")
    public String customerList(Model model){
        String sql = "SELECT * FROM customer";
        List<Map<String,Object>> customers = jdbcTemplate.queryForList(sql);

        model.addAttribute("customers", customers);
        // model.addAttribute("customers", customerRepository.findAll());
        return "customers";
    }

}
