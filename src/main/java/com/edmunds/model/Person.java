package com.edmunds.model;

import javax.persistence.*;

/**
 * Created by alekseymorozov on 9/28/18.
 */
@Entity
@Table(name ="people",uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
public class Person {

    @Id
    @SequenceGenerator(name="PERSON_SEQ", sequenceName="PERSON_ID_SEQ", initialValue=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSON_SEQ")
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    public Person() {
    }

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
