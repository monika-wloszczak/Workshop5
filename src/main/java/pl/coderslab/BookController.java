package pl.coderslab;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	MemoryBookService memoryBookService;

@RequestMapping("/hello")
public String hello(){

return "hello: World";

}
@RequestMapping("/helloBook")
public Book helloBook(){

return new Book(1L,"9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming");

}

@GetMapping("/book/{title}")//+
public String getBook(@PathVariable("title") String title){
	return memoryBookService.showBook(title);
}
@RequestMapping("/delete/{title}")//+
public String deleteBook(@PathVariable("title") String title){
	return memoryBookService.deleteBook(title);
}
@PostMapping("/edit")
public String editBook(@RequestParam("id") long id,
		@RequestParam("isbn") String isbn,
		@RequestParam("title") String title,
		@RequestParam("author") String author,
		@RequestParam("publisher") String publisher,
		@RequestParam("type") String type){
	Book book = new Book(id,isbn,title, author, publisher, type);
	return memoryBookService.editBook(book);
}
@RequestMapping("/showBooks")//++
public List<Book> showBooks(){
	return memoryBookService.showList();
}
@GetMapping("/addBook")
public Book addBook(@RequestParam("id") long id,
		@RequestParam("isbn") String isbn,
		@RequestParam("title") String title,
		@RequestParam("author") String author,
		@RequestParam("publisher") String publisher,
		@RequestParam("type") String type){
	Book book = new Book(id,isbn,title, author, publisher, type);
	return memoryBookService.addBook(book);
}





}