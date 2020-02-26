package yte.intern.questioner.question.ClassicQuestion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.questioner.question.ClassicQuestion.model.ClassicQuestion;
import yte.intern.questioner.httpResponce.HttpResponse;
import yte.intern.questioner.question.ClassicQuestion.service.ClassicQuestionService;

@RestController
@RequestMapping("/cq")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ClassicQuestionController {

    private final ClassicQuestionService classicQuestionService;

    @PostMapping
    public HttpResponse addClassicQuestion(@RequestBody final ClassicQuestion classicQuestion){
        return classicQuestionService.addClassicQuestion(classicQuestion);
    }
}
