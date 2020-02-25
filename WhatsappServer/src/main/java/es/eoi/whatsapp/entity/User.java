package es.eoi.whatsapp.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idUser;
	@Column
	private String name;
	@Column
	private String surname;
	@Column
	private String mail;
	@Column
	private String username;
	@Column
	private String password;	
	@Column
	private Date birthDate;	
	@Column
	private String phone;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "user")
	private List<Chat> chats;
	

}
