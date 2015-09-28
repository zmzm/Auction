package by.grsu.service;

import by.grsu.model.Product;

public interface GameService {
    public void startGame();
    public void stopGame();
    public Product getProduct();
    public boolean isStarted();
    public boolean isFinished();
}
