package yte.intern.questioner.question.AnswerQuestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.questioner.question.AnswerQuestion.model.AnswerQuestion;

public interface AnswerQuestionRepository extends JpaRepository<AnswerQuestion, Long> {
}
