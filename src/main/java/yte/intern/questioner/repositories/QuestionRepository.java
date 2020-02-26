package yte.intern.questioner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.questioner.models.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
