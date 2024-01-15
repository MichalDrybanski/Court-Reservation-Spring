package pl.drybanski.court.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import pl.drybanski.court.model.Person;
import pl.drybanski.court.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonFactory {
    private PersonRepository personRepository;
    @Autowired
    public PersonFactory(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    public void createPeople(){
        List<Person> list = new ArrayList<>(List.of(
                new Person("Michal"),
                new Person("Adam"),
                new Person("Michal D"),
                new Person("Andrzej"),
                new Person("Dominika"),
                new Person("Karolina"),
                new Person("Pawel"),
                new Person("Pawel D"),
                new Person("Kamil K"),
                new Person("Kamil P")

        ));
        if(personRepository.count() == 0){
            personRepository.saveAll(list);
        }
    }
}
