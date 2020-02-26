package yte.intern.questioner.question.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.questioner.httpResponce.HttpResponse;
import yte.intern.questioner.question.service.QuestionService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/all")
    public HttpResponse getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{questionId}")
    public HttpResponse getQuestionById(@PathVariable Long questionId) {
        return questionService.getQuestionById(questionId);
    }

    @PostMapping("/incrementAnswer")
    public HttpResponse incrementAnswer(@RequestParam Long questionId, @RequestParam String answer) {
        return questionService.incrementAnswer(questionId, answer);
    }

    @DeleteMapping("/{questionId}")
    public HttpResponse deleteQuestionById(@PathVariable Long questionId) {
        return questionService.deleteQuestionById(questionId);
    }

}