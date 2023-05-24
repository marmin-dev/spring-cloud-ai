package com.imgai.kaka.persistneces;


import com.imgai.kaka.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
