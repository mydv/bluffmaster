package com.psych.psychGame;

import com.psych.psychGame.config.SpringConfiguration;
import com.psych.psychGame.model.EllenAnswer;
import com.psych.psychGame.model.GameMode;
import com.psych.psychGame.model.Question;
import com.psych.psychGame.repositories.EllenAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Utils {
    private static QuestionRepository questionRepository;
    private static EllenAnswerRepository ellenAnswerRepository;

    static {
        questionRepository = (QuestionRepository) SpringConfiguration
                .contextProvider()
                .getApplicationContext()
                .getBean("questionRepository");
        ellenAnswerRepository = (EllenAnswerRepository) SpringConfiguration
                .contextProvider()
                .getApplicationContext()
                .getBean("ellenAnswerRepository");;
    }

    public static Question getRandomQuestion(GameMode gameMode) {
        return questionRepository.getRandomQuestion(gameMode);
    }

    public static EllenAnswer getRandomEllenAnswer(Question question) {
        return ellenAnswerRepository.getRandomAnswer(question);
    }
}
