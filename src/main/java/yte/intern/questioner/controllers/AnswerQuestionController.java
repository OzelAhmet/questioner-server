package yte.intern.questioner.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.questioner.models.AnswerQuestion;
import yte.intern.questioner.models.HttpResponse;
import yte.intern.questioner.services.AnswerQuestionService;

import java.util.List;

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
