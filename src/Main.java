public class Main {
    public static void main(String[] args) throws Exception {
//        Phone phone = new Phone("iPhone XS", PhonesColors.Red, 15000, 43);
//
//        phone.setPrice(892);
//
//        System.out.println(phone);

        PhonesStore phonesStore = new PhonesStore();

        phonesStore.addPhone(new Phone("iPhone XS", PhonesColors.Red, 15000, 43));
        phonesStore.addPhone(new Phone("iPhone XR", PhonesColors.Yellow, 12000, 10));
        phonesStore.addPhone(new Phone("iPhone 13", PhonesColors.SpaceGray, 55000, 43));

        System.out.println(phonesStore.getPhonesInTableView());
    }
}