package yte.intern.questioner.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.intern.questioner.models.HttpResponse;
import yte.intern.questioner.models.SurveyQuestion;
import yte.intern.questioner.repositories.SurveyQuestionRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class SurveyQuestionService {

    private final SurveyQuestionRepository surveyQuestionRepository;

    public HttpResponse getAllSurveyQuestions(){
        return new HttpResponse<>(200, surveyQuestionRepository.findAll());
    }

    public HttpResponse addSurveyQuestion(final SurveyQuestion surveyQuestion){
        return new HttpResponse<>(200, surveyQuestionRepository.save(surveyQuestion));
    };
}
