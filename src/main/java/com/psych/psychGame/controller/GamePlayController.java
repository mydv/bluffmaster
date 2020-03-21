package com.psych.psychGame.controller;

import com.psych.psychGame.exceptions.InvalidGameActionException;
import com.psych.psychGame.model.Game;
import com.psych.psychGame.model.Player;
import com.psych.psychGame.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequestMapping("/play")
public class GamePlayController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/")
    public String play(Authentication authentication) {
        return authentication.getName();
    }

    @GetMapping("/submit-answer/{answer}")
    public void submitAnswer(Authentication authentication, @PathVariable(name = "answer") String answer) throws InvalidGameActionException {
        Player player = playerRepository.findByEmail(authentication.getName()).orElseThrow();
        player.getCurrentGame().submitAnswer(player, answer);
    }
}
