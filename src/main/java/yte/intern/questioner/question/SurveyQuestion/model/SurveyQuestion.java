package yte.intern.questioner.question.SurveyQuestion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.intern.questioner.question.model.Choice;
import yte.intern.questioner.question.model.Question;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SurveyQuestion extends Question {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "sq_id")
    @OrderBy("id ASC")
    private List<Choice> choices;
}
