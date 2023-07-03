package com.akash.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.quizapp.model.Quiz;

public interface QuizDAo extends JpaRepository<Quiz,Integer>{


}
