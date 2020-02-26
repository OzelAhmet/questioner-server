package yte.intern.questioner.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.intern.questioner.models.ClassicQuestion;
import yte.intern.questioner.models.HttpResponse;
import yte.intern.questioner.repositories.ClassicQuestionRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ClassicQuestionService {

    private final ClassicQuestionRepository classicQuestionRepository;

    public HttpResponse addClassicQuestion(final ClassicQuestion classicQuestion){
        return new HttpResponse<>(200, classicQuestionRepository.save(classicQuestion));
    }
}
