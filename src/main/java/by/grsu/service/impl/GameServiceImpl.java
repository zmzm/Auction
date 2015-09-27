package by.grsu.service.impl;

import by.grsu.mechanics.GameMechanics;
import by.grsu.service.GameService;
import org.springframework.stereotype.Service;

@Service("gameService")
public class GameServiceImpl implements GameService {

    private GameMechanics gameMechanics = new GameMechanics();

    @Override
    public void startGame() {
        Thread gameMechanicsThread = new Thread(gameMechanics);
        gameMechanicsThread.start();
    }

    @Override
    public void stopGame() {
        gameMechanics.stopMath();
    }

    @Override
    public boolean isStarted() {
        return false;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
