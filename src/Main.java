public class Main {
    public static void main(String[] args) throws Exception {
        Phone phone = new Phone("iPhone XS", PhonesColors.Red, 15000, 43);

        phone.setPrice(892);

        System.out.println(phone);
    }
}