package yte.intern.questioner.question.SurveyQuestion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.questioner.httpResponce.HttpResponse;
import yte.intern.questioner.question.SurveyQuestion.model.SurveyQuestion;
import yte.intern.questioner.question.SurveyQuestion.service.SurveyQuestionService;

@RestController
@RequestMapping("/sq")
@CrossOrigin("*")
@RequiredArgsConstructor
public class SurveyQuestionController {

    private final SurveyQuestionService surveyQuestionService;

    @GetMapping("/all")
    public HttpResponse getAllAnswerQuestions(){
        return surveyQuestionService.getAllSurveyQuestions();
    }

    @PostMapping
    public HttpResponse addSurveyQuestion(@RequestBody final SurveyQuestion surveyQuestion){
        return surveyQuestionService.addSurveyQuestion(surveyQuestion);
    }
}
