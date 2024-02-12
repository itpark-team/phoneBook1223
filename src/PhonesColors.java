public class PhonesColors {
    public static final String Red = "Красный";
    public static final String Yellow = "Жёлтый";
    public static final String SpaceGray = "Тёмносерый";

    public static String getColorByNumber(int number) {
        switch (number) {
            case 1:
                return Red;
            case 2:
                return Yellow;
            case 3:
                return SpaceGray;
        }

        return "None";
    }
}
