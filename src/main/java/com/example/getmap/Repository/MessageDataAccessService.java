package com.example.getmap.Repository;

import com.example.getmap.model.Message;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class MessageDataAccessService implements MessageDao {
    @Override
    public int insertMessage(UUID id, Message message) {
        return 0;
    }

    @Override
    public List<Message> selectAllMessages() {
        return List.of(new Message(UUID.randomUUID(), "FROM POSTGRES DB"));
    }

    @Override
    public Optional<Message> selectMessageById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteMessageByID(UUID id) {
        return 0;
    }

    @Override
    public int updateMessageById(UUID id, Message message) {
        return 0;
    }
}
