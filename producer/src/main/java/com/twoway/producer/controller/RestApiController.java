package com.twoway.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twoway.producer.jms.ArtemisProducer;
import com.twoway.producer.jms.Book;

@RestController
public class RestApiController {
	@Autowired
	ArtemisProducer artemisProducer;
	
	@PostMapping("/request")
	public String produce(@RequestBody String msg)
	{
		artemisProducer.send(msg);
		return "done!";
	}
	
	@PostMapping("/")
	public String produce(@RequestBody Book b)
	{
		artemisProducer.send(b);
		return "Send Book Done!" + b.toString();
	}
	
	
}
