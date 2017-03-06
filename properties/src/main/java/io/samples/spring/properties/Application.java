package io.samples.spring.properties;

import io.samples.spring.properties.model.Settings;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Settings.class);

        Settings settings = ctx.getBean(Settings.class);
        System.out.println(settings.getPort());
    }
}
