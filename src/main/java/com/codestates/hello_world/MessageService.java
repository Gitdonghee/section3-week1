package com.codestates.hello_world;

import com.codestates.hello_world.Repository.MessageRepository;
import com.codestates.hello_world.entity.Message;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message message){

        return messageRepository.save(message);
    }

    public Message findMessage(long memberId){
        Optional<Message> message = messageRepository.findById(memberId);
        return message.get();
    }
    public List<Message> findMessages() {

        return messageRepository.findAll();
    }

}
