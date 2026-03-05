public class DayDemo {
    
    // enum внутри класса
    public enum Day {
        MONDAY("Понедельник", 1),
        TUESDAY("Вторник", 2),
        WEDNESDAY("Среда", 3),
        THURSDAY("Четверг", 4),
        FRIDAY("Пятница", 5),
        SATURDAY("Суббота", 6),
        SUNDAY("Воскресенье", 7);
        
        private final String russianName;
        private final int dayNumber;
        
        Day(String russianName, int dayNumber) {
            this.russianName = russianName;
            this.dayNumber = dayNumber;
        }
        
        public String getRussianName() { return russianName; }
        public int getDayNumber() { return dayNumber; }
        public boolean isWeekend() { 
            return this == SATURDAY || this == SUNDAY; 
        }
    }
    
    public static void main(String[] args) {
        Day today = Day.WEDNESDAY;
        
        System.out.println("Сегодня: " + today);
        System.out.println("По-русски: " + today.getRussianName());
        System.out.println("Номер дня: " + today.getDayNumber());
        System.out.println("Выходной? " + today.isWeekend());
        
        System.out.println("\nВсе дни:");
        for (Day day : Day.values()) {
            System.out.println(day + " - " + day.getRussianName() + 
                             " (номер " + day.getDayNumber() + ")");
        }
    }
}