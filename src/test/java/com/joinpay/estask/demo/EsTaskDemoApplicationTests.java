package com.joinpay.estask.demo;

import com.joinpay.estask.demo.dao.BookRepository;
import com.joinpay.estask.demo.entities.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTaskDemoApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void save() {

        for(int i=0;i<1000;i++){
            Book book = new Book();
            book.setBookAuthor("Author"+i);
            book.setBookState(1);
            book.setBookTitle("Title "+i);
            book.setPublishDate(new Date());
            book.setPublishHouse("Changjiang");
            bookRepository.save(book);
        }

    }

    @Test
    public void get(){
        Pageable pageable = PageRequest.of(0, 10);

        Page<Book> page = bookRepository.findOnsellBook(pageable,12,1,1);

        List<Book> books = page.getContent();

        books.forEach(book->{
            System.out.println(book);
        });
    }

}

