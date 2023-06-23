import java.io.File;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String[] products = {"Молоко", "Хлеб", "Гречка"};
    static int[] prices = {78, 50, 64};


    static File saveFile = new File("Basket.bin");


    public static void main(String[] args) {
        //Basket basket = new Basket(products, prices);

        Basket basket = null;

        if (saveFile.exists()) {
            basket = Basket.loadFromBinFile(saveFile);
        } else {

            {
                basket = new Basket(products, prices);
            }

            while (true) {
                showPrice();
                System.out.println("Выберите товар и количество через пробел или введите end");
                String input = scanner.nextLine();
                if ("end".equals(input)) {
                    break;
                }
                String[] parts = input.split(" ");
                int productNumber = Integer.parseInt(parts[0]) - 1;
                int productCount = Integer.parseInt(parts[1]);
                basket.addToCart(productNumber, productCount);

                basket.saveBin(saveFile);

            }

            basket.printCart();
        }


    }


    public static void showPrice() {
        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i] + " " + prices[i] + " руб/шт");
        }


    }}