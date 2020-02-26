package yte.intern.questioner.question.SurveyQuestion.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.intern.questioner.httpResponce.HttpResponse;
import yte.intern.questioner.question.SurveyQuestion.model.SurveyQuestion;
import yte.intern.questioner.question.SurveyQuestion.repository.SurveyQuestionRepository;

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
