import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PhonesStore {
    private ArrayList<Phone> phones;
    private final String phonesFileName = "phones.txt";

    public PhonesStore() {
        phones = new ArrayList<>();
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    public Phone getPhoneByNumber(int number) throws Exception {
        int index = number - 1;

        if (index < 0 || index > phones.size() - 1) {
            throw new Exception("Ошибка. Телефон с таким номером не существует");
        }

        return phones.get(index);
    }

    public void deletePhoneByNumber(int number) throws Exception {
        int index = number - 1;

        if (index < 0 || index > phones.size() - 1) {
            throw new Exception("Ошибка. Телефон с таким номером не существует");
        }

        phones.remove(index);
    }

    public String getPhonesInTableView() {
        String output = "";

        output = String.format("%3s%20s%15s%15s%20s\n", "№", "Модель", "Цвет", "Цена(руб.)", "Кол-во на складе");

        if (phones.size() > 0) {
            for (int i = 0; i < phones.size(); i++) {
                Phone currentPhone = phones.get(i);

                output += String.format("%3d%20s%15s%15d%20d\n", i + 1, currentPhone.getModel(), currentPhone.getColor(), currentPhone.getPrice(), currentPhone.getBalance());
            }
        } else {
            output += "Список пуст\n";
        }

        return output;
    }

    public void savePhonesToFile() throws Exception {
        FileWriter fileWriter = new FileWriter(phonesFileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(Integer.toString(phones.size()));
        bufferedWriter.newLine();

        for (int i = 0; i < phones.size(); i++) {
            Phone currentPhone = phones.get(i);

            bufferedWriter.write(currentPhone.getModel());
            bufferedWriter.newLine();

            bufferedWriter.write(currentPhone.getColor());
            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(currentPhone.getPrice()));
            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(currentPhone.getBalance()));
            bufferedWriter.newLine();

        }

        bufferedWriter.close();
        fileWriter.close();
    }

    public void loadPhonesFromFile() throws Exception {
        FileReader fileReader = new FileReader(phonesFileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int size = Integer.parseInt(bufferedReader.readLine());
        phones.clear();

        for (int i = 0; i < size; i++) {
            String model = bufferedReader.readLine();
            String color = bufferedReader.readLine();

            int price = Integer.parseInt(bufferedReader.readLine());
            int balance = Integer.parseInt(bufferedReader.readLine());

            Phone phone = new Phone(model, color, price, balance);

            phones.add(phone);
        }


        bufferedReader.close();
        fileReader.close();
    }

}
