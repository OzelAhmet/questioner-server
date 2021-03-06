package yte.intern.questioner.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.questioner.models.Collection;
import yte.intern.questioner.models.HttpResponse;
import yte.intern.questioner.services.CollectionService;

@RestController
@RequestMapping("/collection")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;

    @GetMapping("/all")
    public HttpResponse getAllCollections(){
        return collectionService.getAllCollections();
    }

    @GetMapping("/{collectionId}")
    public HttpResponse getCollectionById(@PathVariable Long collectionId){
        return collectionService.getCollectionById(collectionId);
    }

    @PostMapping
    public HttpResponse addCollection(@RequestBody Collection collection){
        return collectionService.addCollection(collection);
    }

    @PostMapping("/addQuestion")
    public HttpResponse addQuestionToCollection(@RequestParam Long collectionId, @RequestParam Long questionId){
        return collectionService.addQuestionToCollection(collectionId, questionId);
    }

    @DeleteMapping("/{collectionId}")
    public HttpResponse deleteCollection(@PathVariable Long collectionId){
        return collectionService.deleteCollection(collectionId);
    }
}
