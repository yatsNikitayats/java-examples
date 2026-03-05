public class SeasonDemo {
    

    public enum Season {
        SPRING("Весна", 15, "Цветут сады"),
        SUMMER("Лето", 25, "Жарко, купаться"),
        AUTUMN("Осень", 10, "Листопад, дожди"),
        WINTER("Зима", -10, "Снег, мороз");
        
        private final String russianName;
        private final int averageTemp;
        private final String description;
        
        Season(String russianName, int averageTemp, String description) {
            this.russianName = russianName;
            this.averageTemp = averageTemp;
            this.description = description;
        }
        
        public String getRussianName() {
            return russianName;
        }
        
        public int getAverageTemp() {
            return averageTemp;
        }
        
        public String getDescription() {
            return description;
        }
        
        public boolean isCold() {
            return averageTemp < 0;
        }
        
        public boolean isWarm() {
            return averageTemp > 15;
        }
        
        public static Season findByTemp(int temp) {
            for (Season s : Season.values()) {
                if (s.averageTemp == temp) {
                    return s;
                }
            }
            return null;
        }
        
        public String getActivity() {
            switch (this) {
                case SPRING: return "Сажать цветы";
                case SUMMER: return "Купаться в море";
                case AUTUMN: return "Собирать грибы";
                case WINTER: return "Кататься на лыжах";
                default: return "Отдыхать";
            }
        }
    }
    
    public static void main(String[] args) {
        Season current = Season.SUMMER;
        
        System.out.println("=== ТЕКУЩЕЕ ВРЕМЯ ГОДА ===");
        System.out.println("Текущее время года: " + current);
        System.out.println("По-русски: " + current.getRussianName());
        System.out.println("Средняя температура: " + current.getAverageTemp() + "°C");
        System.out.println("Описание: " + current.getDescription());
        System.out.println("Холодно? " + current.isCold());
        System.out.println("Тепло? " + current.isWarm());
        System.out.println("Активность: " + current.getActivity());
        
        System.out.println("\n=== ВСЕ ВРЕМЕНА ГОДА ===");
        System.out.println("----------------------------------------");
        System.out.printf("%-7s | %-6s | %-4s | %s%n", "Англ", "Русский", "Темп", "Описание");
        System.out.println("----------------------------------------");
        
        for (Season s : Season.values()) {
            System.out.printf("%-7s | %-6s | %3d°C | %s%n", 
                s, s.getRussianName(), s.getAverageTemp(), s.getDescription());
        }
        
        System.out.println("\n=== ПОИСК ПО ТЕМПЕРАТУРЕ ===");
        System.out.println("Поиск по температуре 10°C: " + Season.findByTemp(10));
        System.out.println("Поиск по температуре 0°C: " + Season.findByTemp(0));
        
        System.out.println("\n=== ДЕМОНСТРАЦИЯ МЕТОДОВ ===");
        for (Season s : Season.values()) {
            System.out.printf("%s: isCold=%b, isWarm=%b, activity=%s%n",
                s, s.isCold(), s.isWarm(), s.getActivity());
        }
    }
}