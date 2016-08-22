package io.samples.spring.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component("task")
public class TaskExecutorExample {

    @Autowired
    @Qualifier("simpleAsyncTaskExecutor")
    private TaskExecutor taskExecutor;

    public void execute() {
        for (int i = 0; i < 25; i++) {
            taskExecutor.execute(new Task(String.valueOf(i)));
        }
    }

    private class Task implements Runnable {

        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                String threadName = Thread.currentThread().getName();

                System.out.println(String.format("%s - task %s started", threadName, name));

                Thread.sleep(5000);

                System.out.println(String.format("%s - task %s finished", threadName, name));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
