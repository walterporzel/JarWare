package com.example.getmap.Repository;

import com.example.getmap.model.Message;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MessageDao {

    int insertMessage(UUID id, Message message);

    default int insertMessage(Message message){
        UUID id = UUID.randomUUID();
        return insertMessage(id, message);
    }

    List<Message> selectAllMessages();

    Optional<Message> selectMessageById(UUID id);

    int deleteMessageByID(UUID id);

    int updateMessageById(UUID id, Message message);
}
