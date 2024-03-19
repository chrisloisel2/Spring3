package com.example.correction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.correction.Model.MessageModel;

@Repository
public interface MessageRepository extends JpaRepository<MessageModel, Long> {
}
