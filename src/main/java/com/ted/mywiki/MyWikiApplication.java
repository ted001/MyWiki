package com.ted.mywiki;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MyWikiApplication {
    private static final Logger LOG = LoggerFactory.getLogger(MyWikiApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MyWikiApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("Run successfully！！");
        LOG.info("Address: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }

}
