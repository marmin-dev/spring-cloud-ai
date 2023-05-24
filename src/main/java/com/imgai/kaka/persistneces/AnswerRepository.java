package com.imgai.kaka.persistneces;


import com.imgai.kaka.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Long> {

    @Query(value = "SELECT * FROM answer ORDER BY id DESC LIMIT 5",nativeQuery = true)
    List<Answer> getTenAnswer();
}
