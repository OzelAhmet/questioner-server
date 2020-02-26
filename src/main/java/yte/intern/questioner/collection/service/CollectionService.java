package yte.intern.questioner.collection.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.intern.questioner.collection.model.Collection;
import yte.intern.questioner.httpResponce.HttpResponse;
import yte.intern.questioner.collection.repository.CollectionRepository;
import yte.intern.questioner.question.repository.QuestionRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class CollectionService {

    private final CollectionRepository collectionRepository;
    private final QuestionRepository questionRepository;

    public HttpResponse getAllCollections(){
        return new HttpResponse<>(200, collectionRepository.findAllBySelectingIdAndName());
    };

    public HttpResponse getCollectionById(final Long collectionId){
        return new HttpResponse<>(200, collectionRepository.findById(collectionId));
    };

    public HttpResponse addCollection(final Collection collection){
        return new HttpResponse<>(200, collectionRepository.save(collection), "Collection Added.");
    };

    public HttpResponse addQuestionToCollection(final Long collectionId, final Long questionId){
        HttpResponse<String> httpResponse = new HttpResponse<>();

        collectionRepository.findById(collectionId).ifPresentOrElse(
                collection -> {
                    questionRepository.findById(questionId).ifPresentOrElse(
                            question -> {
                                collection.getQuestionList().add(question);
                                collectionRepository.save(collection);
                                httpResponse.setResponseCode(200);
                                httpResponse.setBody("Question with id:"+questionId+" added to the collection with id:"+collectionId);
                            },
                            // else: no question
                            () -> {
                                httpResponse.setResponseCode(404);
                                httpResponse.addException("Question Not Fount With Id: "+ questionId);
                            }
                    );
                },
                // else: no collection
                () -> {
                    httpResponse.setResponseCode(404);
                    httpResponse.addException("Collection Not Fount With Id: "+ collectionId);
                }
        );
        return httpResponse;
    };

    public HttpResponse deleteCollection(final Long collectionId) {
        collectionRepository.deleteById(collectionId);
        return new HttpResponse<>(200, null, "Collection Deleted");
    }

}
