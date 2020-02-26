package yte.intern.questioner.question.ClassicQuestion.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.intern.questioner.question.ClassicQuestion.model.ClassicQuestion;
import yte.intern.questioner.httpResponce.HttpResponse;
import yte.intern.questioner.question.ClassicQuestion.repository.ClassicQuestionRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ClassicQuestionService {

    private final ClassicQuestionRepository classicQuestionRepository;

    public HttpResponse addClassicQuestion(final ClassicQuestion classicQuestion){
        return new HttpResponse<>(200, classicQuestionRepository.save(classicQuestion));
    }
}
