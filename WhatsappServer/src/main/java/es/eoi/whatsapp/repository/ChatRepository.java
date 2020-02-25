package es.eoi.whatsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.eoi.whatsapp.entity.Chat;

public interface ChatRepository extends JpaRepository<Chat, Integer>{

}
