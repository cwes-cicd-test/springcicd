package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@RestController
public class GreetingController {

	private static final Logger logger = LoggerFactory.getLogger(RestServiceApplication.class);
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
    private Environment env;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		logger.info(env.getProperty("SPRINGTEST"));
		logger.info("Wanted a line: " + counter.get());
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
