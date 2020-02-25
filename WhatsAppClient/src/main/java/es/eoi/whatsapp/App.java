package es.eoi.whatsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import es.eoi.whatsapp.controller.MenuController;

@SpringBootApplication
@EnableAutoConfiguration
public class App {

		
	public static void main(String[] args) {		
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);		
		MenuController controller = context.getBean(MenuController.class);
		controller.printMainMenu();
	}
	
	
	
	
}
