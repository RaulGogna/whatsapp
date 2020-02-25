package es.eoi.whatsapp.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {
		
	private int id;	

	private String content;

	private Date messageDate;
	
	private boolean delivered;

	private boolean readed;	

	private int idSender;	
	
	private int idReceiver;	
	
	private int idChat;
	
	

}
