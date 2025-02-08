package hh.backend.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.bookstore.domain.Book;
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

   @GetMapping("/addbook")
   public String showAddBookForm(Model model) {
       model.addAttribute("book", new Book());
       return "addbook";
   }

   @PostMapping("/addbook")
   public String addbook(@ModelAttribute Book book) {
    bookRepository.save(book);
    return "redirect:/booklist";
   }

   @GetMapping("/deletebook/{id}")
   public String deleteBook(@PathVariable("id") Long id) {
    bookRepository.deleteById(id);
    return "redirect:/booklist";
   }
   
   

}
