package com.example.CorrectionApi.Model.DTO;

import com.example.CorrectionApi.Model.Entity.Message;

public class MessageDTO {
	private Long id;
	private String contenu;
	private Long senderId;
	private Long receiverId;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Long getSenderId() {
		return senderId;
	}
	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}
	public Long getReceiverId() {
		return receiverId;
	}
	
	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}
		
}
