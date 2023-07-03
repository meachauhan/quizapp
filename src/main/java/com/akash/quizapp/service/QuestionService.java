package com.akash.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akash.quizapp.model.Question;
import com.akash.quizapp.dao.QuestionDAO;

@Service
public class QuestionService {
    
    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<List<Question>> getAllQestions(){
        try {
            return new ResponseEntity<>(questionDAO.findAll(),HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
       return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCateegory(String category) {
        try {
            return new ResponseEntity<>( questionDAO.findByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question){
        try {
            questionDAO.save(question);
         
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);

    }
}
