package yte.intern.questioner.question.AnswerQuestion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.questioner.question.AnswerQuestion.model.AnswerQuestion;
import yte.intern.questioner.httpResponce.HttpResponse;
import yte.intern.questioner.question.AnswerQuestion.service.AnswerQuestionService;

@RestController
@RequestMapping("/aq")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AnswerQuestionController {

    private final AnswerQuestionService answerQuestionService;

    @GetMapping("/all")
    public HttpResponse getAllAnswerQuestions(){
        return answerQuestionService.getAllAnswerQuestions();
    }

    @PostMapping
    public HttpResponse addAnswerQuestion(@RequestBody final AnswerQuestion answerQuestion){
        return answerQuestionService.addAnswerQuestion(answerQuestion);
    }
}
