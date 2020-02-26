package yte.intern.questioner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.questioner.models.AnswerQuestion;

public interface AnswerQuestionRepository extends JpaRepository<AnswerQuestion, Long> {
}
