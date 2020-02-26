package yte.intern.questioner.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.questioner.models.ClassicQuestion;
import yte.intern.questioner.models.HttpResponse;
import yte.intern.questioner.services.ClassicQuestionService;

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
