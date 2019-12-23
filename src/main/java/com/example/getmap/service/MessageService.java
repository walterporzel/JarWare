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

    @Autowired
    private final MessageDao messageDao;


    //@Qualifier("postgres")
    @Autowired
    public MessageService( MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public Message addMessage(Message message){
        return messageDao.save(message);
    }

    public List<Message> getAllMessages() {
        return messageDao.findAll();
    }

    public Message getMessageById(UUID id){
        return messageDao.findMessageById(id);
    }

    public void deleteMessage(UUID id){
        messageDao.deleteById(id);
    }

    public void updateMessage(UUID id, String newMessage){
        //return messageDao.saveAndFlush(newMessage);
        Message old = messageDao.findMessageById(id);
        old.setMessage(newMessage);
        messageDao.save(old);
    }
}
