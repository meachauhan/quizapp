package com.akash.quizapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.quizapp.model.Question;
import com.akash.quizapp.dao.QuestionDAO;

@Service
public class QuestionService {
    
    @Autowired
    QuestionDAO questionDAO;

    public List<Question> getAllQestions(){
       return questionDAO.findAll();
    }

    public List<Question> getQuestionsByCateegory(String category) {
        return questionDAO.findByCategory(category);
    }

    public String addQuestion(Question question){
         questionDAO.save(question);
         return "Success";

    }
}
