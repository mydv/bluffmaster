package com.psych.psychGame.repositories;

import com.psych.psychGame.model.EllenAnswer;
import com.psych.psychGame.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EllenAnswerRepository extends JpaRepository<EllenAnswer, Long> {
    @Query(value = "", nativeQuery = true)
    // todo
    EllenAnswer getRandomAnswer(Question question);
}
