package com.akash.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akash.quizapp.dao.QuestionDAO;
import com.akash.quizapp.dao.QuizDAo;
import com.akash.quizapp.model.*;


@Service
public class QuizService {
    @Autowired
    QuizDAo quizDAo;

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<String> createQuiz(String category, int noOfQuestions, String title){

        List<Question> questions=questionDAO.findRandomQuestionsByCategory(category,noOfQuestions);
       
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizDAo.save(quiz);
        
        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz= quizDAo.findById(id);
        List<Question> questionsFromDB=quiz.get().getQuestion();
        List<QuestionWrapper> questionForUser=new ArrayList<>();
        for(Question q: questionsFromDB){
            QuestionWrapper qw=new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionForUser.add(qw);
        }

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz=quizDAo.findById(id).get();
        List<Question> questions = quiz.getQuestion();
        int right=0;
        int i=0;
        for(Response response:responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;
        }

        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
