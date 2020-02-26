package yte.intern.questioner.question.ClassicQuestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.questioner.question.ClassicQuestion.model.ClassicQuestion;

public interface ClassicQuestionRepository extends JpaRepository<ClassicQuestion, Long> {
}
