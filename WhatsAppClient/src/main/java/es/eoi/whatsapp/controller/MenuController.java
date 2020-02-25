package es.eoi.whatsapp.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import es.eoi.whatsapp.dto.UserDto;

@Controller
public class MenuController {
		
	public  Scanner scan=null;
	public  String message="";	
	@Value("${whatsapp.server.url}")
	public String url;
	
	public void printMainMenu() {	
		
		
		System.out.println("Introduce destinatario");
		scan= new Scanner(System.in);
		message= scan.next();
		
		System.out.println("Introduce mensaje: ");
		scan= new Scanner(System.in);
		message= scan.next();		
				
		System.out.println("enviar mensaje al server");
		 RestTemplate restTemplate = new RestTemplate();
		 UserDto result = restTemplate.getForObject(url+"/user/1", UserDto.class); 
		 
		 System.out.println(result.getName());
	}
	
}
