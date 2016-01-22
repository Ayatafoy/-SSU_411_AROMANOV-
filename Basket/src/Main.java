import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main implements Basket{
    ArrayList<String> products = new ArrayList<>();
    HashMap<String, Integer> hashMap = new HashMap<>();

    @Override
    public void addProduct(String product, int quantity) {
        products.add(product);
        hashMap.put(product, quantity);
    }

    @Override
    public void removeProduct(String product) {
        products.remove(products.indexOf(product));
        hashMap.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        hashMap.replace(product, quantity);
    }

    @Override
    public void clear() {
        products.clear();
        hashMap.clear();
    }

    @Override
    public List<String> getProducts() {
        return products;
    }

    @Override
    public int getProductQuantity(String product) {
        return hashMap.get(product);
    }

    public static void main(String[] args) {
        Main prod = new Main();
        for (; ; ) {
            System.out.println("Выберите операцию:");
            System.out.println("Добавить продукт: 1");
            System.out.println("Удалить продукт: 2");
            System.out.println("Изменить количество продуктов: 3");
            System.out.println("Очистить корзину: 4");
            System.out.println("Вывести список продуктов: 5");
            System.out.println("Вывести количество: 6");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();

            switch (x) {
                case 1: {
                    System.out.println("Введите название продукта:");
                    scanner = new Scanner(System.in);
                    String s = scanner.nextLine();
                    System.out.println("Введите количество:");
                    scanner = new Scanner(System.in);
                    x = scanner.nextInt();
                    prod.addProduct(s, x);
                    continue;
                }
                case 2: {
                    System.out.println("Введите название продукта:");
                    scanner = new Scanner(System.in);
                    String s = scanner.nextLine();
                    prod.removeProduct(s);
                    continue;
                }
                case 3: {
                    System.out.println("Введите название продукта:");
                    scanner = new Scanner(System.in);
                    String s = scanner.nextLine();
                    System.out.println("Введите количество:");
                    scanner = new Scanner(System.in);
                    x = scanner.nextInt();
                    prod.updateProductQuantity(s, x);
                    continue;
                }
                case 4: {
                    prod.clear();
                    System.out.println("Корзина очищена!:");
                    continue;
                }
                case 5: {
                    System.out.println(prod.getProducts());
                    continue;
                }
                case 6: {
                    System.out.println("Введите название продукта:");
                    scanner = new Scanner(System.in);
                    String s = scanner.nextLine();
                    System.out.println(prod.getProductQuantity(s));
                    continue;
                }
                default:
                    System.out.println("Operator not found!");
                    continue;
            }
        }
    }
}