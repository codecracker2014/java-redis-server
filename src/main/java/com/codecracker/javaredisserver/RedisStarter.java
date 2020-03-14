package com.codecracker.javaredisserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import redis.embedded.RedisServer;

/**
 * @author gajendra(raaz2.gajendra@gmail.com)
 */
@Component
public class RedisStarter implements CommandLineRunner {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    RedisStarter.class);

    @Value("${redis.server.port:6379}")
    private int port;

    @Value("${redis.server.password:redis}")
    private String password;

    @Override
    public void run(String...args) throws Exception {
        logger.info("Starting redis server on port {}",port);
        RedisServer redisServer = RedisServer.builder()
                .port(port)
                .setting("requirepass "+password)
                .build();
        redisServer.start();
   }
}
