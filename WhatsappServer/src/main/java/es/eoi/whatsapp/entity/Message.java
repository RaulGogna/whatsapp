package es.eoi.whatsapp.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;	
	@Column
	private String content;
	@Column
	private Date messageDate;
	@Column
	private boolean delivered;
	@Column
	private boolean readed;	
	@OneToOne
	private User sender;	
	@OneToOne
	private User receiver;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "idChat", referencedColumnName = "idChat")
	private Chat chat;

}
