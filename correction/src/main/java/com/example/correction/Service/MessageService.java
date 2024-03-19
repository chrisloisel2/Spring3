package com.example.correction.Service;

import java.util.List;

import com.example.correction.Model.MessageModel;

public interface MessageService {
    MessageModel sendMessage(MessageModel message);
    List<MessageModel> getMessagesByUser(String username);
    MessageModel getMessageById(Long id);
    MessageModel updateMessage(Long id, MessageModel message);
    void deleteMessage(Long id);
}

