package com.example.getmap.Repository;

import com.example.getmap.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MessageDao extends JpaRepository<Message, UUID>{

    Message findMessageById(UUID id);


    //int insertMessage(UUID id, Message message);

//    default int insertMessage(Message message){
////        UUID id = UUID.randomUUID();
////        return insertMessage(id, message);
////    }

    //List<Message> selectAllMessages();

    //Optional<Message> selectMessageById(UUID id);

    //int deleteMessageById(UUID id);

    //int updateMessageById(UUID id, Message message);
}
