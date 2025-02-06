package hh.backend.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/index")
        public String welcomeToBookStore() {
            return "BookStore";
        }

}
