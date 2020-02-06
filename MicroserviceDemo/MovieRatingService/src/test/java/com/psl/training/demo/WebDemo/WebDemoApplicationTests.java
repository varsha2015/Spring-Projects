package com.psl.training.demo.WebDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


@SpringBootTest
class WebDemoApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {
	}
	

@Test
public void testGetAllUsers() {
HttpHeaders headers = new HttpHeaders();
HttpEntity<String> entity = new HttpEntity<String>(null, headers);
ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/users",
HttpMethod.GET, entity, String.class);

}
}
