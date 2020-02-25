package es.eoi.whatsapp.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
		
	private int idUser;

	private String name;
	
	private String surname;
	
	private String mail;

	private String username;

	private String password;	

	private Date birthDate;		
	
	

}
