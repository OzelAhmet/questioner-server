package yte.intern.questioner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.questioner.models.SurveyQuestion;

public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion, Long> {
}
