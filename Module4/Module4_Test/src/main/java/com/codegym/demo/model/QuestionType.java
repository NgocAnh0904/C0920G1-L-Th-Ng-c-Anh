package com.codegym.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "question_type")
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @NotEmpty
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Question> customer) {
        this.customer = customer;
    }

    @OneToMany()
    private List<Question> customer;

    public QuestionType() {
    }
}

