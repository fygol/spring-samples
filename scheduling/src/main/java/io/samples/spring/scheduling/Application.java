package io.samples.spring.scheduling;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
            "spring/rootContext.xml",
            "spring/scheduling.xml"
        );

        appContext.getBean("task", TaskExecutorExample.class).runExample();
    }

}
