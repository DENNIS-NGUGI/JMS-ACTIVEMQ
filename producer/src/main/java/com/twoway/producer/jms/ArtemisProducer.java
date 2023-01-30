package com.twoway.producer.jms;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;



@Component
@EnableJms

public class ArtemisProducer {
	@Autowired
	JmsTemplate jmsTemplate;
	
	//@Value("${jms.queue.destination}")
	String destinationQueue = "destination_queue";
	
	
	

	public void send(String msg)
	{
		jmsTemplate.convertAndSend(destinationQueue, msg);
	}
	public void send(Book book)
	{
		jmsTemplate.convertAndSend(destinationQueue, book);
	}
	

}
