package by.grsu.manager;

import by.grsu.model.Product;
import by.grsu.random.Randomizer;
import by.grsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GameManager implements Runnable {
    private boolean isStarted;
    private boolean isFinished;
    private int matchId;
    private int setId;
    private int gameId;
    private List<Product> products;
    private Product prod;
    private int purchaseCost;

    @Autowired
    private UserService userService;

    public int calculateNewPrice(int currentPrice) {
        int k = Randomizer.randInt(1, 10);
        int newPrice = currentPrice - k;
        return newPrice < 0 ? 0 : newPrice;
    }

    public int getProductCount() {
        return Math.round((float) userService.findAll().size() / 2);
    }

    public int getMaxSets() {
        return 2 * getProductCount();
    }

    public void nextSet() {
        if (setId <= getMaxSets()) {
            setId++;
        } else {
            isStarted = false;
            isFinished = true;
        }
    }

    /*private List<Product> initializeProductList() {
        int productCount = getProductCount();
        List<Product> products = new ArrayList<>();
        while (productCount > 0) {
            for (String type : ConfigFacade.getProductTypes()) {
                products.add(new Product(type, 100));
            }
            productCount--;
        }
        return products;
    }*/ //TODO products init

    @Override
    public void run() {
        isStarted = true;
        matchId++;
        setId = 0;
        gameId = 0;

        //products = initializeProductList();

        while (!products.isEmpty()) {
            int rnd = Randomizer.random.nextInt(products.size());
            prod = products.get(rnd);

            System.out.println("Current lot: " + prod.getTitle());

            while (prod.getPrice() > 0 /*&& !prod.isBought()*/) {
                int currentPrice = prod.getPrice();
                purchaseCost = calculateNewPrice(currentPrice);
                prod.setPrice(purchaseCost);

                System.out.println("Current price: " + prod.getPrice());

                int m = Randomizer.randInt(5, 20);
                try {
                    Thread.sleep(m * 300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            products.remove(rnd);
            nextSet();
        }
        //stopMath();
    }
}
