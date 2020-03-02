package com.psych.psychGame.controller;

import com.psych.psychGame.QuestionRepository;
import com.psych.psychGame.model.*;
import com.psych.psychGame.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dev-test")
public class DevTestController {

    // dependency injection ion spring
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RoundRepository roundRepository;
    @Autowired
    private ContentWriterRepository contentWriterRepository;

    @GetMapping("/")
    public String hello() {
        return "Hello, world!";
    }

    @GetMapping("/populate")
    public String populateDB() {
        for (Player player:playerRepository.findAll()) {
            player.getGames().clear();
            playerRepository.save(player);
        }
        gameRepository.deleteAll();
        questionRepository.deleteAll();
        playerRepository.deleteAll();

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

        Game game = new Game();
        game.setGameMode(GameMode.IS_THIS_A_FACT);
        game.setLeader(luffy);
        game.getPlayers().add(luffy);
        gameRepository.save(game);

        questionRepository.save(new Question(
                "What is the most important Poneglyph",
                "Rio Poneglyph",
                GameMode.IS_THIS_A_FACT
        ));
        return "populated";
    }

    // questions
    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/questions/{id}")
    public Question getQuestionById(@PathVariable(name = "id") Long id) {
        return questionRepository.findById(id).orElseThrow();
    }

    // players
    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/player/{id}")
    public Player getPlayerById(@PathVariable(name = "id") Long id) {
        return playerRepository.findById(id).orElseThrow();
    }

    // users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable(name = "id") Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    // games
    @GetMapping("/games")
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/game/{id}")
    public Game getGameById(@PathVariable(name = "id") Long id) {
        return gameRepository.findById(id).orElseThrow();
    }

    // admins
    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @GetMapping("/admin/{id}")
    public Admin getAdminById(@PathVariable(name = "id") Long id) {
        return adminRepository.findById(id).orElseThrow();
    }

    // rounds
    @GetMapping("/rounds")
    public List<Round> getAllRounds() {
        return roundRepository.findAll();
    }

    @GetMapping("/round/{id}")
    public Round getRoundById(@PathVariable(name = "id") Long id) {
        return roundRepository.findById(id).orElseThrow();
    }

    // contentwriters
    @GetMapping("/contentwriters")
    public List<ContentWriter> getAllContentWriters() {
        return contentWriterRepository.findAll();
    }

    @GetMapping("/contentwriter/{id}")
    public ContentWriter getContentWriterById(@PathVariable(name = "id") Long id) {
        return contentWriterRepository.findById(id).orElseThrow();
    }
}
