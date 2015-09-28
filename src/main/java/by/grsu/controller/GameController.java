package by.grsu.controller;

import by.grsu.model.Product;
import by.grsu.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public ModelAndView startGame() {
        ModelAndView model = new ModelAndView("game");
        gameService.startGame();
        return model;
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    public @ResponseBody void stopGame() {
        gameService.stopGame();
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public ModelAndView getProduct() {
        ModelAndView model = new ModelAndView("product");
        model.addObject("prod", gameService.getProduct());
        return model;
    }
}
