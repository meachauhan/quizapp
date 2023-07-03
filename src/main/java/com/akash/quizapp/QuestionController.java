package com.akash.quizapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.quizapp.model.Question;
import com.akash.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    
    @GetMapping("allQuestions")
    public List<Question> getAllQestions(){
        return questionService.getAllQestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCateegory(@PathVariable String category){

        return questionService.getQuestionsByCateegory(category);
    }

    @PostMapping("add")
    public String addQuestions(@RequestBody Question question){
       return  questionService.addQuestion(question);
    }

}
