package com.akash.quizapp.dao;

import org.springframework.stereotype.Repository;

import com.akash.quizapp.model.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


@Repository
public interface QuestionDAO extends JpaRepository<Question,Integer>  {
    
    List<Question> findByCategory(String category);
}
