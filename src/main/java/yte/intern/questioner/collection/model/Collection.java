package yte.intern.questioner.collection.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.intern.questioner.question.model.Question;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Collection {
    /**
     * Use this interface to send only id and name of collections
     * Not need to send collections with their questions
     */
    public interface CollectionWithOnlyIdAndName{
        Long getId();
        String getName();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "collection_id")
    @OrderBy("id ASC")
    private List<Question> questionList = new ArrayList<>();
}
