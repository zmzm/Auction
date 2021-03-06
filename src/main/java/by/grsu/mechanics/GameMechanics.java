package by.grsu.mechanics;

import by.grsu.config.AppInitializer;
import by.grsu.model.Product;
import by.grsu.random.Randomizer;
import by.grsu.service.ProductService;
import by.grsu.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class GameMechanics {
    public boolean isStarted = true;
    public boolean isFinished = false;
    private int matchId;
    private int setId;
    private int gameId;
    private List<Product> products;
    private Product prod;
    private int purchaseCost;

    UserService userService = (UserService) AppInitializer.ctx.getBean("userService");
    ProductService productService = (ProductService) AppInitializer.ctx.getBean("productService");

    public int calculateNewPrice(int currentPrice) {
        int k = Randomizer.randInt(1, 10);
        int newPrice = currentPrice - k;
        return newPrice < 0 ? 0 : newPrice;
    }

    public int getProductCount() {
        return Math.round((float) userService.findAll().size() / 2);
    }

    public Product getProduct() {
        return prod;
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

    private List<Product> initializeProductList() {
        int productCount = getProductCount();
        List<Product> products = new ArrayList<>();
        while (productCount > 0) {
            for (String type : productService.getProductTypes()) {
                products.add(new Product(type, 100));
            }
            productCount--;
        }
        return products;
    }

    public void startGame() {
        isStarted = true;
        matchId++;
        setId = 0;
        gameId = 0;

        products = initializeProductList();

        final Thread gameTread = new Thread(new Runnable() {
            @Override
            public void run() {
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
                stopGame();
            }
        });
        gameTread.start();
    }

    public void stopGame() {
        isStarted = false;
        isFinished = true;

        System.out.println("Game finished.");
    }

    public boolean isStarted() {
        return isStarted;
    }

    public boolean isFinished() {
        return isFinished;
    }
}
