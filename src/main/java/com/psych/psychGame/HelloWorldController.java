package com.psych.psychGame;

import com.psych.psychGame.model.GameMode;
import com.psych.psychGame.model.Player;
import com.psych.psychGame.model.Question;
import com.psych.psychGame.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dev-test")
public class HelloWorldController {

    // dependency injection ion spring
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/")
    public String hello() {
        return "Hello, world!";
    }

    @GetMapping("/populate")
    public String populateDB() {
        Player luffy = new Player.Builder()
                .alias("Monkey D. Luffy")
                .email("luffy@interviewbit.com")
                .saltedHashedPassword("strawhat")
                .build();
        playerRepository.save(luffy);

        Player robin = new Player.Builder()
                .alias("Nico Robin")
                .email("robin@interviewbit.com")
                .saltedHashedPassword("poneglyph")
                .build();
        playerRepository.save(robin);

        questionRepository.save(new Question(
                "What is the most important Poneglyph",
                "Rio Poneglyph",
                GameMode.IS_THIS_A_FACT
        ));
        return "populated";
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/questions/{id}")
    public Question getQuestionById(@PathVariable(name = "id") Long id) {
        return questionRepository.findById(id).orElseThrow();
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable(name = "id") Long id) {
        return playerRepository.findById(id).orElseThrow();
    }
    // games
    // players
    // admins
    // questions
    // rounds
    // contentwriters

}
