package es.eoi.whatsapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Chat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idChat;
	
	@ManyToOne
	@JoinColumn(name = "user", referencedColumnName = "idUser")	
	private User user;	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "chat")
	private List<Message> messages;

}
