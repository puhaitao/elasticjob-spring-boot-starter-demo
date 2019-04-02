package com.joinpay.estask.demo.dao;

import com.joinpay.estask.demo.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("from Book b where mod(bookId,:shardingCount)=:ys and b.bookState=:state")
    Page<Book> findOnsellBook(Pageable pageable,@Param("shardingCount") int shardingCount,@Param("ys") int ys,@Param("state") int state);
}
