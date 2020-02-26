package yte.intern.questioner.question.ClassicQuestion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.intern.questioner.question.model.Question;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassicQuestion extends Question {

    private String answer;
}
