package com.example.CorrectionApi.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CorrectionApi.Model.Entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
