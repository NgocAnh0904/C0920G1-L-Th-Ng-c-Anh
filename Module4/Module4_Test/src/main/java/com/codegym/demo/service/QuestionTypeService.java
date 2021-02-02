package com.codegym.demo.service;

import com.codegym.demo.model.QuestionType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionTypeService {
    List<QuestionType> findAll();
    void save(QuestionType questionType);
    void update(QuestionType questionType);
    void delete(String id);
    QuestionType findById(String id);
}
