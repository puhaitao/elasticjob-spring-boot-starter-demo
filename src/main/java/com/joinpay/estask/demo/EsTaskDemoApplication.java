package com.joinpay.estask.demo;

import com.joinpay.esjob.utils.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SpringUtil.class)
public class EsTaskDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsTaskDemoApplication.class, args);
    }

}

