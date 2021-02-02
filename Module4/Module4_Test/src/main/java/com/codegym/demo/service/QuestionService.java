package com.codegym.demo.service;

import com.codegym.demo.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {
    Page<Question> findCustomer(Pageable pageable);

    Question findById(String id);

    void save(Question customer);
    void update(Question customer);
    void delete(String id);

    Page<Question> findAllByQuestion_nameContaining(Pageable pageable, String searchName);
}
