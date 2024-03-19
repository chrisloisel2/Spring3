package com.example.CorrectionApi.Service;

import java.util.List;

import com.example.CorrectionApi.Model.MessageModel;

public interface MessageService {
    MessageModel sendMessage(MessageModel message);
    List<MessageModel> getMessagesByUser(String username);
    MessageModel getMessageById(Long id);
    MessageModel updateMessage(Long id, MessageModel message);
    void deleteMessage(Long id);
}

