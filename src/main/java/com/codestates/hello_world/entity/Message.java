package com.codestates.hello_world.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Message {
    @Id
    private long messageId;
    private String message;
}
