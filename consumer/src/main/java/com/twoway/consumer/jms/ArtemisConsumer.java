package com.twoway.consumer.jms;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;



@Component
public class ArtemisConsumer {
	
	@JmsListener(destination = "destination_queue")
	public void receive(Message message)
	{
		if(message.getPayload() instanceof String) {
			System.out.println("Received Message:" + message.getPayload().toString());
		}else if(message.getPayload() instanceof Book) {
				System.out.println("Received Book" + message.getPayload().toString());
		}else {
			System.err.println("Message Type Unknown !");
		}
		
		}
	}

