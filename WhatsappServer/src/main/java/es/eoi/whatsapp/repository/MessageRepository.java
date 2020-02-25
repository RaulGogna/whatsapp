package es.eoi.whatsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.eoi.whatsapp.entity.Message;

public interface MessageRepository extends JpaRepository<Message,Integer>{

}
