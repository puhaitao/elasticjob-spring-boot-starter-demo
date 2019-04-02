package com.joinpay.estask.demo.tasks;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.joinpay.esjob.utils.SpringUtil;
import com.joinpay.estask.demo.dao.BookRepository;
import com.joinpay.estask.demo.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class DataFlowTask implements DataflowJob {

    private BookRepository bookRepository = SpringUtil.getBean(BookRepository.class);

    @Override
    public List<Book> fetchData(ShardingContext shardingContext) {
        int pageSize = Integer.parseInt(shardingContext.getJobParameter());

        int currentShardingItem = shardingContext.getShardingItem();
        int shardingTotal = shardingContext.getShardingTotalCount();

        Page<Book> page = bookRepository.findOnsellBook(PageRequest.of(0, pageSize),shardingTotal,currentShardingItem,1);

        return page.getContent();
    }

    @Override
    public void processData(ShardingContext shardingContext, List data) {

        data.forEach(item->{
            System.out.println(item);
            Book book = (Book) item;
            book.setBookState(0);
            bookRepository.save(book);
        });

    }
}
