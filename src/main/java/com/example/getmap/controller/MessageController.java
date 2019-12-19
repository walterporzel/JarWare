package com.example.getmap.controller;

import com.example.getmap.model.Message;
import com.example.getmap.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("message")
@RestController
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public void addMessage(@Valid @NonNull @RequestBody Message message){
        messageService.addMessage(message);
    }

    @GetMapping
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }

    @GetMapping(path = "{id}")
    public Message getMessageById(@PathVariable("id") UUID id) {
        return messageService.getMessageById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMessageById(@PathVariable("id") UUID id){
        messageService.deleteMessage(id);
    }

    @PutMapping(path = "{id}")
    public void updateMessage(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Message messageToUpdate){
        messageService.updateMessage(id, messageToUpdate);
    }

}
