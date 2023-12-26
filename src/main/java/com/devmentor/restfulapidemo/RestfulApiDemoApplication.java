package com.devmentor.restfulapidemo;

import com.devmentor.restfulapidemo.Dao.EventDao;
import com.devmentor.restfulapidemo.entities.Event;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class RestfulApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApiDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EventDao eventDao) {
		return runner -> {
			createEvent(eventDao);
		};
	}

	private void createEvent(EventDao eventDao) throws ParseException {
		System.out.println("create event");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = simpleDateFormat.parse("2024-01-10 09:00:00");
		Timestamp timestamp = new Timestamp(date.getTime());
		Event event = new Event(
				"Simple Life Event",
				timestamp,
				new Timestamp(System.currentTimeMillis())
		);

		eventDao.save(event);
	}
}
