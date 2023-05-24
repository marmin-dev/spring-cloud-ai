package com.imgai.kaka.dtos;

import com.imgai.kaka.entities.Answer;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerResponseDto {

    public Long id;

    public String question;

    public String answer;

    public AnswerResponseDto(Answer answer){
        this.id = answer.getId();
        this.question = answer.getQuestion();
        this.answer = answer.getAnswer();
    }

}
