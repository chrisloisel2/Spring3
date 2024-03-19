package com.example.CorrectionApi.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CorrectionApi.Model.DTO.MessageDTO;
import com.example.CorrectionApi.Model.Entity.Message;
import com.example.CorrectionApi.Model.Repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private UserService userService;

	private MessageRepository repo;

	public MessageService(MessageRepository repo)
	{
		this.repo = repo;
	}

	public MessageDTO CreateMessage(MessageDTO data) {
		
		var res = repo.save(this.convertToMessage(data));
		
		return this.convertToDTO(res);
	}

	public MessageDTO UpdateMessage(MessageDTO data, Long id) {
		MessageDTO usr = this.convertToDTO(repo.findById(id).get());
		usr.setContenu(data.getContenu());
		usr.setReceiverId(data.getReceiverId());
		usr.setSenderId(data.getSenderId());
		return this.CreateMessage(usr);
	}

	public MessageDTO GetMessageById(Long id) {
		var result = this.repo.findById(id).get();
		return this.convertToDTO(result);
	}

	public List<MessageDTO> GetAllMessage() {
		return this.repo.findAll().stream().map((val)->this.convertToDTO(val)).toList();
	}

	public void DeleteMessageById(Long id) {
		this.repo.deleteById(id);
	}
	
	public MessageDTO convertToDTO(Message msg)
	{
		MessageDTO msgdto = new MessageDTO();
		msgdto.setContenu(msg.getContenu());
		msgdto.setId(msg.getId());
		msgdto.setReceiverId(msg.getReceiver().getId());
		msgdto.setSenderId(msg.getSender().getId());
		return msgdto;

	}
	
	public Message convertToMessage(MessageDTO msgdto)
	{
		Message msg = new Message();
		msg.setContenu(msgdto.getContenu());
		msg.setId(msgdto.getId());
		msg.setReceiver(userService.GetUserById(msgdto.getReceiverId()).get());
		msg.setSender(userService.GetUserById(msgdto.getSenderId()).get());
		return msg;

	}

}
