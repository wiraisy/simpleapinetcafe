package com.task.netcafe.boom;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoomApplication.class, args);
		try {
			openHomePage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void openHomePage() throws IOException {
	       Runtime rt = Runtime.getRuntime();
	       rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8020/swagger-ui.html");
	    }


}
