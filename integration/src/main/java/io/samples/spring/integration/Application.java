package io.samples.spring.integration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("integration.xml");

        TimeService timeService = appContext.getBean("timeService", TimeService.class);
        long time = timeService.time();
        System.out.println("current time:" + time);
    }

}
