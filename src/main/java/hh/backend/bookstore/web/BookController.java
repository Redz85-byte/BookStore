package hh.backend.bookstore.web;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;
import hh.backend.bookstore.domain.CategoryRepository;



//
@Controller
public class BookController {
 

   private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
  

   public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
    this.bookRepository = bookRepository;
    this.categoryRepository = categoryRepository;
  
   }    

   @GetMapping("/booklist")
   public String showBookList(Model model) {
    model.addAttribute("books", bookRepository.findAll());
     String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
       return "booklist";
   }

   @GetMapping("/addbook")
   public String showAddBookForm(Model model) {
       model.addAttribute("book", new Book());
       model.addAttribute("categories", categoryRepository.findAll());
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

   @GetMapping("/edit/{id}")
   public String editBook(@PathVariable("id") Long id, Model model) {
       Book book = bookRepository.findById(id).get();
       model.addAttribute("book", book);
       return "edit-book";  
   }

   @GetMapping("/login")
   public String login() {
       return "login"; 
   }
}

  
