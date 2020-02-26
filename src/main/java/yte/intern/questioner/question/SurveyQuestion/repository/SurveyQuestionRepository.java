package yte.intern.questioner.question.SurveyQuestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.questioner.question.SurveyQuestion.model.SurveyQuestion;

public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion, Long> {
}
