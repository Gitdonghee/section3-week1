package com.codestates.hello_world;

import com.codestates.hello_world.dto.MessagePostDto;
import com.codestates.hello_world.dto.MessageResponseDto;
import com.codestates.hello_world.entity.Message;
import com.codestates.hello_world.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/messages")
public class MessageController {
    private final MessageService messageService;
    private final MessageMapper mapper;

    @Autowired
    public MessageController(MessageService messageService, MessageMapper mapper){
        this.messageService = messageService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postMessage(@Valid @RequestBody MessagePostDto messagePostDto){

        Message message = messageService.createMessage(mapper.messageDtoToMessage(messagePostDto));

        return ResponseEntity.ok(mapper.messageToMessageResponseDto(message));
    }

    @GetMapping("/{message-id}")
    public ResponseEntity getMessage(@PathVariable("message-id") long messageId){

        Message message = messageService.findMessage(messageId);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMessages(){
        List<Message> messages = messageService.findMessages();

        List<MessageResponseDto> response =
                messages.stream()
                                .map(message -> mapper.messageToMessageResponseDto(message))
                                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
