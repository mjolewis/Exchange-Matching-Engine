package com.taurinustrading.exchangematchingengine.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Configuration file the matching engines thread pool executor. This configuration enables the matching engine to run
 * its matching algorithms in a background thread without having a client wait for a response before submitting
 * additional orders.
 */
@Configuration
@EnableAsync
public class AsyncConfiguration {

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(1000);
        executor.setQueueCapacity(1);
        executor.setThreadNamePrefix("Exchange-Matching-Engine-Server-");
        executor.initialize();
        return executor;
    }
}
