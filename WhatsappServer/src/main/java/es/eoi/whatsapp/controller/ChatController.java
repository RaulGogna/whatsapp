package es.eoi.whatsapp.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.whatsapp.dto.ChatDto;
import es.eoi.whatsapp.entity.Chat;
import es.eoi.whatsapp.service.ChatService;

@RestController
@RequestMapping(value = "/chat")
public class ChatController {
	
	@Autowired
	ChatService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(value = "/{id}")
	public ChatDto find(@PathVariable String id) {
		Chat Chat = service.read(Integer.parseInt(id));
		ChatDto ChatDto = modelMapper.map(Chat, ChatDto.class);
		return ChatDto;
	}

	@PostMapping
	public void create(@RequestBody ChatDto dto) {
		Chat entity=modelMapper.map(dto, Chat.class);	
		service.create(entity);		
	}	

	@PutMapping
	public void update(@RequestBody ChatDto dto) {
		Chat entity=modelMapper.map(dto, Chat.class);	
		service.create(entity);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable String id) {
		service.delete(Integer.parseInt(id));

	}


}
