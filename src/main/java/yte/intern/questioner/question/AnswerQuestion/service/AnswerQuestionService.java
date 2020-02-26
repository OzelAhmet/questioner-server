package yte.intern.questioner.question.AnswerQuestion.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.intern.questioner.question.AnswerQuestion.model.AnswerQuestion;
import yte.intern.questioner.httpResponce.HttpResponse;
import yte.intern.questioner.question.AnswerQuestion.repository.AnswerQuestionRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class AnswerQuestionService {

    private final AnswerQuestionRepository answerQuestionRepository;

    public HttpResponse getAllAnswerQuestions(){
        return new HttpResponse<>(200, answerQuestionRepository.findAll());
    }

    public HttpResponse addAnswerQuestion(final AnswerQuestion answerQuestion){
        return new HttpResponse<>(200, answerQuestionRepository.save(answerQuestion));
    }
}
