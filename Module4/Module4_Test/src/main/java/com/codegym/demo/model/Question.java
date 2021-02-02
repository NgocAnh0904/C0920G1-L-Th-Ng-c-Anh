package com.codegym.demo.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "question")
public class Question {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
//    @NotEmpty
    private String title;
//    @NotEmpty
    private String question;
//    @NotEmpty
    private String answer;
//    @NotEmpty
//    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private String date_create;
//    @NotEmpty
    private String user_create;
//    @NotEmpty
    private String user_feedback;
//    @NotEmpty
    private String status;
//    @NotEmpty
    private String id_question_type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public String getUser_create() {
        return user_create;
    }

    public void setUser_create(String user_create) {
        this.user_create = user_create;
    }

    public String getUser_feedback() {
        return user_feedback;
    }

    public void setUser_feedback(String user_feedback) {
        this.user_feedback = user_feedback;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId_question_type() {
        return id_question_type;
    }

    public void setId_question_type(String id_question_type) {
        this.id_question_type = id_question_type;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionType questionType;

    public Question() {
    }
}
