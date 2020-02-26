package yte.intern.questioner.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.questioner.models.HttpResponse;
import yte.intern.questioner.models.SurveyQuestion;
import yte.intern.questioner.services.SurveyQuestionService;

import java.util.List;

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
