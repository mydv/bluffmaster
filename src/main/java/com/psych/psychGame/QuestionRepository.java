package com.psych.psychGame;

import com.psych.psychGame.model.GameMode;
import com.psych.psychGame.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    // todo
    @Query(value = "SELECT * FROM questions WHERE gameMode = :gameMode ORDER BY RAND() LIMIT 1" , nativeQuery = true)
    Question getRandomQuestion(GameMode gameMode);
}
