package pl.coderslab;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MemoryBookService {

	private List<Book> list;

	public MemoryBookService() {

		list = new ArrayList<>();
		list.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Bruce Eckel", "zzz"));

		list.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy", " Bates Bert", "yyy"));

		list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann", " Gary Cornell", "xxx"));

	}

	public List<Book> getList() {

		return list;

	}

	public void setList(List<Book> list) {

		this.list = list;

	}
	//DELETE
public String deleteBook(String title){
	for(Book elem:list){
		if((title).equals(elem.title)){
			list.remove(elem);
			return "book removed";
		}
	}
	return "we don't have this book";
}
//SHOW
public String showBook(String title){
	for(Book elem:list){
		if((title).equals(elem.title)){
			return elem.toString();
		}
	}
	return "we don't have this book";
}

// EDIT
public String editBook(Book book){
	for(Book elem:list){
		if((book.id)==(elem.id)){
			list.remove(elem);
			list.add(book);
			return book + "book edited";
		}
	}
	return "we don't have this book";
}
// SHOW LIST
public List<Book> showList(){
	return list;
}
public Book addBook(Book book){
	list.add(book);
	return book;
}
}