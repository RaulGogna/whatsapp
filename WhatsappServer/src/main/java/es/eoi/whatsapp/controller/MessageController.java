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

import es.eoi.whatsapp.dto.MessageDto;
import es.eoi.whatsapp.entity.Message;
import es.eoi.whatsapp.service.ChatService;
import es.eoi.whatsapp.service.MessageService;
import es.eoi.whatsapp.service.UserService;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
	
	@Autowired
	MessageService service;
	@Autowired
	UserService userService;
	@Autowired
	ChatService chatService;
	
	@Autowired
	ModelMapper modelMapper;

	@GetMapping(value = "/{id}")
	public MessageDto find(@PathVariable String id) {
		Message Message = service.read(Integer.parseInt(id));
		MessageDto MessageDto = modelMapper.map(Message, MessageDto.class);
		return MessageDto;
	}

	@PostMapping
	public void create(@RequestBody MessageDto dto) {
		Message entity=modelMapper.map(dto, Message.class);	
		entity.setChat(chatService.read(dto.getIdChat()));
		entity.setSender(userService.read(dto.getIdSender()));
		entity.setReceiver(userService.read(dto.getIdReceiver()));
		service.create(entity);
	}

	@PutMapping
	public void update(@RequestBody MessageDto dto) {		
		Message entity=modelMapper.map(dto, Message.class);	
		service.create(entity);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable String id) {
		service.delete(Integer.parseInt(id));

	}


}
