package com.example.CorrectionApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CorrectionApi.Model.MessageModel;
import com.example.CorrectionApi.Service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public MessageModel sendMessage(@RequestBody MessageModel message) {
        return messageService.sendMessage(message);
    }

    @GetMapping("/user/{username}")
    public List<MessageModel> getMessagesByUser(@PathVariable String username) {
        return messageService.getMessagesByUser(username);
    }

    @GetMapping("/{id}")
    public MessageModel getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }

    @PutMapping("/{id}")
    public MessageModel updateMessage(@PathVariable Long id, @RequestBody MessageModel message) {
        return messageService.updateMessage(id, message);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }
}
