package com.codestates.hello_world.Repository;

import com.codestates.hello_world.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message,Long> {
    List<Message> findAll();
}
