import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PhonesStore phonesStore = new PhonesStore();

        while (true) {
            System.out.println(phonesStore.getPhonesInTableView());
            System.out.println("----------");

            System.out.println("Меню:");
            System.out.println("1.Загрузить список из файла");
            System.out.println("2.Сохранить список в файл");
            System.out.println("3.Добавить новый телефон");
            System.out.println("4.Удалить выбранный телефон");
            System.out.println("5.Изменить выбранный телефон");
            System.out.println("0.Выйти из программы");

            System.out.println("Введите действие");
            int action = scanner.nextInt();

            switch (action) {
                case 0: {
                    System.exit(0);
                }
                break;
                case 1: {
                    phonesStore.loadPhonesFromFile();
                    System.out.println("Список успешно загружен");
                }
                break;
                case 2: {
                    phonesStore.savePhonesToFile();
                    System.out.println("Список успешно сохранён");
                }
                break;
                case 3: {
                    System.out.println("Введите модель телефона");
                    scanner.nextLine();
                    String model = scanner.nextLine();

                    System.out.println("Введите цвет телефона(1-2-3)");
                    String color = PhonesColors.getColorByNumber(scanner.nextInt());

                    System.out.println("Введите цену телфона");
                    int price = scanner.nextInt();

                    System.out.println("Введите количество телефонов на складе");
                    int balance = scanner.nextInt();

                    Phone phone = new Phone(model,color, price,balance);

                    phonesStore.addPhone(phone);
                }
                break;
                case 4: {

                }
                break;
                case 5: {

                }
                break;

            }
        }
    }
}