package com.subho.notificationservice;

import com.subho.notificationservice.workers.NotificationThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class NotificationServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(NotificationServiceApplication.class, args);
		context.getBean(NotificationThread.class).startNotificationWorker();
	}

}

