public class SwitchTypes {
    public static void main(String[] args) {
        // int
        int num = 2;
        switch(num) {
            case 1: System.out.println("int 1"); break;
            case 2: System.out.println("int 2"); break;
        }
        
        // String
        String day = "Monday";
        switch(day) {
            case "Monday": System.out.println("Понедельник"); break;
            case "Tuesday": System.out.println("Вторник"); break;
        }
        
        // enum
        enum Day {MONDAY, TUESDAY}
        Day today = Day.MONDAY;
        switch(today) {
            case MONDAY: System.out.println("MONDAY"); break;
        }
        
        // char
        char c = 'A';
        switch(c) {
            case 'A': System.out.println("char A"); break;
        }
    }
}
