package es.eoi.whatsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import es.eoi.whatsapp.entity.User;
import es.eoi.whatsapp.repository.UserRepository;

@Service
public class UserService implements GenericCrudService<User> {

	@Autowired
	UserRepository repository;

	public void create(User entity) {
		repository.save(entity);
	}

	public User read(int id) {
		return repository.findById(id).get();
	}

	public List<User> readAll() {
		return repository.findAll();
	}

	public void update(User entity) {
		repository.save(entity);
	}

	public void delete(int id) {
		repository.deleteById(id);
	}
	
	public List<User> findByPredicate(Predicate predicate) {
		return (List<User>) repository.findAll(predicate);
	}

}
