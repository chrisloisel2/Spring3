package com.example.CorrectionApi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CorrectionApi.Model.DTO.MessageDTO;
import com.example.CorrectionApi.Model.Entity.Message;
import com.example.CorrectionApi.Service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

	private MessageService service;
	
	public MessageController(MessageService service) {
		this.service = service;
	}
	
	@GetMapping()
	public List<MessageDTO> GetAllMessage() {
		return this.service.GetAllMessage();
	}

	@GetMapping("/{id}")
	public MessageDTO GetMessageById(@PathVariable Long id) {
		return this.service.GetMessageById(id);
	}

	@PostMapping()
	public MessageDTO CreateMessage(@RequestBody MessageDTO Message) {
		return this.service.CreateMessage(Message);
	}

	@PutMapping("/{id}")
	public MessageDTO UpdateMessage(@PathVariable Long id, @RequestBody MessageDTO Message) {
		return this.service.UpdateMessage(Message, id);
	}

	@DeleteMapping("/{id}")
	public void DeleteMessage(@PathVariable Long id) {
		this.service.DeleteMessageById(id);
	}

}

