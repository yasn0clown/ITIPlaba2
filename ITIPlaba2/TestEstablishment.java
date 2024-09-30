// Абстрактный класс "Заведение"
abstract class Establishment {
    private String name;
    private String address;
    private String workingHours;

    // Статическая переменная для подсчета количества объектов
    private static int totalObjectsCreated = 0;

    // Конструктор
    public Establishment(String name, String address, String workingHours) {
        this.name = name;
        this.address = address;
        this.workingHours = workingHours;
        totalObjectsCreated++;
    }

    // Конструктор по умолчанию
    public Establishment() {
        this.name = "Unknown";
        this.address = "Unknown";
        this.workingHours = "Unknown";
        totalObjectsCreated++;
    }

    // Абстрактный метод для вывода информации
    public abstract void displayInfo();

    // Статический метод для получения количества созданных объектов
    public static int getTotalObjectsCreated() {
        return totalObjectsCreated;
    }

    // Геттеры и сеттеры для доступа к приватным полям
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getWorkingHours() { return workingHours; }
    public void setWorkingHours(String workingHours) { this.workingHours = workingHours; }
}

// Дочерний класс Кафе
class Cafe extends Establishment {
    private String menuType;  // Дополнительное поле

    public Cafe(String name, String address, String workingHours, String menuType) {
        super(name, address, workingHours);
        this.menuType = menuType;
    }

    public Cafe() {
        super();
        this.menuType = "Unknown";
    }


    // Метод для добавления меню
    public void addMenuType(String newMenuType) {
        this.menuType += ", " + newMenuType;
        System.out.println("Типы меню: " + menuType);
    }

    //Метод добавления сезонного меню
    public void addSeasonalMenu(String season) {
        if (season.equalsIgnoreCase("winter")) {
            System.out.println("Сезонное меню добавлено: " + season);
            this.menuType += ", Winter Specials";
        }
        else if (season.equalsIgnoreCase("summer")) {
            System.out.println("Сезонное меню добавлено: " + season);
            this.menuType += ", Summer Refreshments";
        }
        else {
            System.out.println("Неподдерживаемый сезон.");
        }
        System.out.println("Типы меню: " + menuType);
    }

    //Метод для приготовления напитка с выбором ингредиентов
    public void prepareSpecialDrink(String drink, String[] ingredients) {
        System.out.println("Приготовление напитка: " + drink);
        System.out.print("Используемые ингредиенты: ");
        for (int i = 0; i < ingredients.length; i++) {
            if (i == ingredients.length - 1) {
                System.out.print(ingredients[i] + ".");
            }
            else {
                System.out.print(ingredients[i] + ", ");
            }
        }
        System.out.println();
    }

    @Override
    public void displayInfo() {
        // Используем геттеры для доступа к полям базового класса
        System.out.println("Кафе: " + getName() + ", Адрес: " + getAddress() + ", Часы работы: " + getWorkingHours() + ", Тип меню: " + menuType);
    }

    // Геттер и сеттер для menuType
    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

}

// Дочерний класс Магазин
class Shop extends Establishment {
    private String productType;

    public Shop(String name, String address, String workingHours, String productType) {
        super(name, address, workingHours);
        this.productType = productType;
    }

    public Shop() {
        super();
        this.productType = "Unknown";
    }

    // Метод для добавления продукта
    public void addProduct(String product) {
        System.out.println("Добавление продукта: " + product);
    }

    //Метод для продажи продукта
    public void sellProduct(String product) {
        System.out.println("Продажа продукта: " + product);
    }

    //Метод для добавления скидки на определенные товары
    public void applyDiscount(String product, int discountPercentage) {
        System.out.println("Скидка " + discountPercentage + "% применена на продукт: " + product);
    }

    //Метод для расчёта итоговой стоимости с учётом налога
    public double calculateFinalPrice(double price, double taxRate) {
        double finalPrice = price + (price * taxRate / 100);
        System.out.println("Итоговая стоимость продукта: " + finalPrice);
        return finalPrice;
    }

    @Override
    public void displayInfo() {
        // Используем геттеры для доступа к полям базового класса
        System.out.println("Магазин: " + getName() + ", Адрес: " + getAddress() + ", Часы работы: " + getWorkingHours() + ", Тип продуктов: " + productType);
    }

    //Геттер и сеттер для ProductType
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}

// Дочерний класс Библиотека
class Library extends Establishment {
    private int numberOfBooks;

    public Library(String name, String address, String workingHours, int numberOfBooks) {
        super(name, address, workingHours);
        this.numberOfBooks = numberOfBooks;
    }

    public Library() {
        super();
        this.numberOfBooks = 0;
    }

    // Метод для добаления книги
    public void addBook(String book) {
        this.numberOfBooks++;
        System.out.println("Добавление книги: " + book);
    }

    // Метод для добавления нескольких книг (перегрузка addBook)
    public void addBook(String[] books) {
        for (String book : books) {
            this.numberOfBooks++;
            System.out.println("Добавлена книга: " + book);
        }
        System.out.println("Добавлено книг: " + books.length);
    }

    //Метод для выдачи книги
    public void lendBook(String book) {
        if (numberOfBooks > 0) {
            numberOfBooks--;
            System.out.println("Книга " + book + " выдана пользователю.");
        }
        else {
            System.out.println("Нет доступных книг для выдачи.");
        }
    }

    @Override
    public void displayInfo() {
        // Используем геттеры для доступа к полям базового класса
        System.out.println("Библиотека: " + getName() + ", Адрес: " + getAddress() + ", Часы работы: " + getWorkingHours() + ", Книг в наличии: " + numberOfBooks);
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

}

// Главный класс
public class TestEstablishment {
    public static void main(String[] args) {
        Cafe cafe = new Cafe("Восточное", "Авиамоторная 8А", "8:00 - 22:00", "Кофе и закуски");
        Shop shop = new Shop("re:store", "Мира 9", "10:00 - 20:00", "Электроника");
        Library library = new Library("Александрийская библиотека", "Строителей 4", "9:00 - 18:00", 30000);

        cafe.displayInfo();
        shop.displayInfo();
        library.displayInfo();


        cafe.addSeasonalMenu("winter");
        cafe.addMenuType("Пиво");
        cafe.prepareSpecialDrink("Разнос", new String[] {"Абсент", "Вода негазированная"});

        shop.addProduct("Томатная паста");
        shop.sellProduct("Энергетический напиток Burn 'Сочная энергия'");
        shop.applyDiscount("Хлеб", 50);
        shop.calculateFinalPrice(400.0, 13.0);

        library.addBook("Божественная комедия");
        library.addBook(new String[]{"Над пропастью во ржи", "Бог как иллюзия", "1984"});
        library.lendBook("Бойцовский клуб");

        System.out.println("Всего заведений: " + Establishment.getTotalObjectsCreated());
    }
}
