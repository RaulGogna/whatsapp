package es.eoi.whatsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.whatsapp.entity.Message;
import es.eoi.whatsapp.repository.MessageRepository;

@Service
public class MessageService implements GenericCrudService<Message> {

	@Autowired
	MessageRepository repository;

	public void create(Message entity) {
		repository.save(entity);
	}

	public Message read(int id) {
		return repository.findById(id).get();
	}

	public List<Message> readAll() {
		return repository.findAll();
	}

	public void update(Message entity) {
		repository.save(entity);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

}
