package com.codegym.demo.service.impl;


import com.codegym.demo.model.Question;
import com.codegym.demo.repository.QuestionRepository;
import com.codegym.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Page<Question> findCustomer(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Question findById(String id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void update(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void delete(String id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Page<Question> findAllByQuestion_nameContaining(Pageable pageable, String searchName) {
//        return questionRepository.findByQuestionNameContaining(pageable, searchName);
        return null;
    }
}
