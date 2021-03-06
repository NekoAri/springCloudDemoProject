package com.cloud.rabbitmq_hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitmqHelloApplication.class)
public class HelloApplicationTests {
    @Autowired
    private Sender sender;

    @Test
    public void hello() throws Exception {
        sender.send();
    }
}
