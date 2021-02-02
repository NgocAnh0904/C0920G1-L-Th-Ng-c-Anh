package com.codegym.demo.service.impl;

import com.codegym.demo.model.QuestionType;
import com.codegym.demo.repository.QuestionTypeRepository;
import com.codegym.demo.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {
    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public void save(QuestionType questionType) {
        questionTypeRepository.save(questionType);
    }

    @Override
    public void update(QuestionType questionType) {
        questionTypeRepository.save(questionType);
    }

    @Override
    public void delete(String id) {
        questionTypeRepository.deleteById(id);
    }

    @Override
    public QuestionType findById(String id) {
        return questionTypeRepository.findById(id).orElse(null);
    }

}
