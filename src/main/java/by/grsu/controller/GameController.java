package by.grsu.controller;

import by.grsu.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("game")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody String getInfo() {
        return "working....";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public @ResponseBody void startGame() {
        gameService.startGame();
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    public @ResponseBody void stopGame() {
        gameService.stopGame();
    }
}
