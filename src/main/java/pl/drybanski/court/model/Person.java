package pl.drybanski.court.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Person {
    private String fullName;
    @Id
    @GeneratedValue
    private int id;

    public Person() {
    }
    public Person(String fullName) {
        this.fullName = fullName;
    }
    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", id=" + id +
                '}';
    }
}
