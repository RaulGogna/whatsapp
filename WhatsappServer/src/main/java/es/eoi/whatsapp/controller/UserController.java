package es.eoi.whatsapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;

import es.eoi.whatsapp.dto.UserDto;
import es.eoi.whatsapp.entity.User;
import es.eoi.whatsapp.repository.UserRepository;
import es.eoi.whatsapp.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService service;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping(value = "/{id}")
	public UserDto find(@PathVariable String id) {
		User user = service.read(Integer.parseInt(id));
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

	@PostMapping
	public void createAndMap(@RequestBody UserDto dto) {		
		User entity = modelMapper.map(dto, User.class);
		service.create(entity);
	}

	@PutMapping
	public void update(@RequestBody UserDto dto) {
		User entity = modelMapper.map(dto, User.class);
		service.create(entity);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable String id) {
		service.delete(Integer.parseInt(id));

	}

	@GetMapping
	public List<UserDto> getUsersByRequestParam(@QuerydslPredicate(root = User.class, bindings = UserRepository.class) Predicate predicate) {
		
		List<UserDto> usersDto=new ArrayList<UserDto>();
		List<User> users=service.findByPredicate(predicate);
		for (User user : users) {
			UserDto dto = modelMapper.map(user, UserDto.class);
			usersDto.add(dto);
		}					
		return usersDto;
	}
}
