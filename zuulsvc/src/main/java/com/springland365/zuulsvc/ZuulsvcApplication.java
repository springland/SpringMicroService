package com.springland365.zuulsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulsvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulsvcApplication.class, args);
	}

}
