package com.example.CorrectionApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CorrectionApi.Model.MessageModel;

@Repository
public interface MessageRepository extends JpaRepository<MessageModel, Long> {
}
