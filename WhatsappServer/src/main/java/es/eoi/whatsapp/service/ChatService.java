package es.eoi.whatsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.whatsapp.entity.Chat;
import es.eoi.whatsapp.repository.ChatRepository;

@Service
public class ChatService {
	
	@Autowired
	ChatRepository repository;
	
	public void create(Chat entity) {
		repository.save(entity);
	}

	public Chat read(int id) {
		return repository.findById(id).get();
	}
	
	public List<Chat> readAll() {
		return repository.findAll();
	}

	public void update(Chat entity) {
		repository.save(entity);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

}
