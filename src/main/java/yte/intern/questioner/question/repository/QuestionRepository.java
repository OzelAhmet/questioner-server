package yte.intern.questioner.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.questioner.question.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
