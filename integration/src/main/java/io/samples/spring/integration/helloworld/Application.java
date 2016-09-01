package io.samples.spring.integration.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Application {

    public static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/helloworld/integration.xml");

        MessageChannel inputChannel = ctx.getBean("inputChannel", MessageChannel.class);
        PollableChannel outputChannel = ctx.getBean("outputChannel", PollableChannel.class);

        Runnable producer = () -> {
            IntStream.range(0, 10)
                .forEach(i -> {
                    Message m = MessageBuilder.withPayload("payload-" + i).build();
                    logger.info("send message: {}", i);
                    inputChannel.send(m);
                });
        };

        Runnable consumer = () -> {
            boolean hasMoreMessages = true;
            while (hasMoreMessages) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    logger.error("interruption", e);
                }

                logger.info("try to receive next message");
                Message message = outputChannel.receive(3000);

                if (message != null) {
                    logger.info("received message: {}", message.getPayload());
                } else {
                    hasMoreMessages = false;
                }
            }

            logger.info("no more messages");
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(producer);
        executor.submit(consumer);
        executor.shutdown();
    }
}
