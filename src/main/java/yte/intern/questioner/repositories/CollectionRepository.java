package yte.intern.questioner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yte.intern.questioner.models.Collection;

import java.util.List;

public interface CollectionRepository extends JpaRepository<Collection, Long> {

    @Query(value = "SELECT C.id, C.name FROM collection C", nativeQuery = true)
    List<Collection.CollectionWithOnlyIdAndName> findAllBySelectingIdAndName();

}
