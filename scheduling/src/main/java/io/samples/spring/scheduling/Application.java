package io.samples.spring.scheduling;

import io.samples.spring.scheduling.config.RootConfig;
import io.samples.spring.scheduling.config.TaskConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(RootConfig.class, TaskConfig.class);
        appContext.getBean("task", TaskExecutorExample.class).execute();
    }

}
