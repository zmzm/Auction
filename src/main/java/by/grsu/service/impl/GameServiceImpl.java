package by.grsu.service.impl;

import by.grsu.mechanics.GameMechanics;
import by.grsu.model.Product;
import by.grsu.service.GameService;
import org.springframework.stereotype.Service;

@Service("gameService")
public class GameServiceImpl implements GameService {

    private GameMechanics gameMechanics = GameMechanics.getInstance();

    @Override
    public void startGame() {
        gameMechanics.startGame();
    }

    @Override
    public void stopGame() {
        gameMechanics.stopGame();
    }

    @Override
    public String getProduct() {
        Product product;
        if (gameMechanics.isStarted()) {
            product = gameMechanics.getProduct();
            if (product != null) {
                return product.getTitle() + " " + product.getPrice();
            }
        }
        return "...";
    }

    @Override
    public boolean isStarted() {
        return gameMechanics.isStarted();
    }

    @Override
    public boolean isFinished() {
        return gameMechanics.isFinished();
    }
}
