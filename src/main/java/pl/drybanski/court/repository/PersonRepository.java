package pl.drybanski.court.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.drybanski.court.model.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
