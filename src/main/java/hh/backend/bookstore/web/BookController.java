package hh.backend.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.backend.bookstore.domain.BookRepository;



@Controller
public class BookController {
    @Autowired
   private BookRepository bookRepository;

   public BookController(BookRepository bookRepository) {
   }

   @GetMapping("/booklist")
   public String showBookList(Model model) {
    model.addAttribute("books", bookRepository.findAll());
       return "booklist";
   }
   

}
