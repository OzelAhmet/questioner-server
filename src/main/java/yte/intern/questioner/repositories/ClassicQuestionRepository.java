package yte.intern.questioner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.questioner.models.ClassicQuestion;

public interface ClassicQuestionRepository extends JpaRepository<ClassicQuestion, Long> {
}
