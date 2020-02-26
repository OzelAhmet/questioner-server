package yte.intern.questioner.question.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.intern.questioner.httpResponce.HttpResponse;
import yte.intern.questioner.question.AnswerQuestion.model.AnswerQuestion;
import yte.intern.questioner.question.ClassicQuestion.model.ClassicQuestion;
import yte.intern.questioner.question.SurveyQuestion.model.SurveyQuestion;
import yte.intern.questioner.question.model.Choice;
import yte.intern.questioner.question.model.Question;
import yte.intern.questioner.question.repository.QuestionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionService {

    private final QuestionRepository questionRepository;

    public HttpResponse getAllQuestions(){
        return new HttpResponse<>(200, questionRepository.findAll());
    }

    public HttpResponse getQuestionById(Long questionId){
        HttpResponse<Question> httpResponse = new HttpResponse<>();

        questionRepository.findById(questionId).ifPresentOrElse(
                question -> {
                    httpResponse.setResponseCode(200);
                    httpResponse.setBody(question);
                },
                () -> {
                    httpResponse.setResponseCode(404);
                    httpResponse.addException("Question With ID "+questionId+" Not Found.");
                }
        );

        return httpResponse;
    }

    public HttpResponse incrementAnswer(Long questionId, String answer){
        HttpResponse<String> httpResponse = new HttpResponse<>();

        questionRepository.findById(questionId).ifPresentOrElse(
                question -> {
                    if (question.getClass() != ClassicQuestion.class) {

                        if (question.getClass() == AnswerQuestion.class) {
                            AnswerQuestion answerQuestion = (AnswerQuestion) question;
                            List<Choice> choices = answerQuestion.getChoices();

                            for (Choice choice : choices){
                                if (choice.getChoice().equals(answer)){
                                    choice.incrementCount();
                                }
                            }
                            ((AnswerQuestion) question).setChoices(choices);
                            questionRepository.save(question);

                        } else if (question.getClass() == SurveyQuestion.class) {
                            SurveyQuestion surveyQuestion = (SurveyQuestion) question;
                            List<Choice>  choices = surveyQuestion.getChoices();

                            for (Choice choice : choices){
                                if (choice.getChoice().equals(answer)){
                                    choice.incrementCount();
                                }
                            }
                            ((SurveyQuestion) question).setChoices(choices);
                            questionRepository.save(question);

                        }

                        httpResponse.setResponseCode(500);
                        httpResponse.setBody("Question updated.");

                    } else {
                        httpResponse.setResponseCode(500);
                        httpResponse.addException("Question With ID "+questionId+" Has No Choices.");
                    }
                },
                // else no question found
                () -> {
                    httpResponse.setResponseCode(404);
                    httpResponse.addException("Question With ID "+questionId+" Not Found.");
                }
        );

        return httpResponse;
    }

    public HttpResponse deleteQuestionById(Long questionId){
        questionRepository.deleteById(questionId);
        return new HttpResponse<>(200, null, "Question Deleted");
    }

}
