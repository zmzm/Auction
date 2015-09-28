package by.grsu.service.impl;

import by.grsu.mechanics.GameMechanics;
import by.grsu.model.Product;
import by.grsu.service.GameService;
import org.springframework.stereotype.Service;

@Service("gameService")
public class GameServiceImpl implements GameService {

    private GameMechanics gameMechanics = new GameMechanics();

    @Override
    public void startGame() {
        gameMechanics.startGame();
    }

    @Override
    public void stopGame() {
        gameMechanics.stopGame();
    }

    @Override
    public Product getProduct() {
        Product product = null;
        if (gameMechanics.isStarted()) {
            product = gameMechanics.getProduct();
            if (product != null) {
                return product;
            }
        }
        return product;
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
