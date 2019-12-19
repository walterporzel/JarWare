package com.example.getmap.service;

import com.example.getmap.Repository.MessageDao;
import com.example.getmap.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MessageService {

    private final MessageDao messageDao;

    @Autowired
    public MessageService(@Qualifier("postgres") MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public int addMessage(Message message){
        return messageDao.insertMessage(message);
    }

    public List<Message> getAllMessages() {
        return messageDao.selectAllMessages();
    }

    public Optional<Message> getMessageById(UUID id){
        return messageDao.selectMessageById(id);
    }

    public int deleteMessage(UUID id){
        return messageDao.deleteMessageByID(id);
    }

    public int updateMessage(UUID id, Message newMessage){
        return messageDao.updateMessageById(id, newMessage);
    }
}
