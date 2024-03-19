package com.example.correction.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.Model.MessageModel;
import com.example.correction.Repository.MessageRepository;
import com.example.correction.Repository.UserRepository;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public MessageModel sendMessage(MessageModel message) {
        return messageRepository.save(message);
    }

    @Override
    public List<MessageModel> getMessagesByUser(String username) {
        return messageRepository.findAll().stream()
                .filter(message -> message.getSender().getUsername().equals(username) || message.getReceiver().getUsername().equals(username))
                .collect(Collectors.toList());
    }

    @Override
    public MessageModel getMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    public MessageModel updateMessage(Long id, MessageModel messageDetails) {
    	MessageModel message = messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found with id: " + id));
        message.setMessage(messageDetails.getMessage());
        return messageRepository.save(message);
    }

    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
