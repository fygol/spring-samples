package io.samples.spring.integration;

public class TimeServiceImpl implements TimeService {
    @Override public long time() {
        return System.currentTimeMillis();
    }
}
