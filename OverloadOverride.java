public class OverloadOverride {
   static class Calculator {
    // Перегрузка: разные типы параметров
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public void show() {
        System.out.println("Обычный калькулятор");
    }
}

static class AdvancedCalculator extends Calculator {
    @Override
    public void show() {
        System.out.println("Продвинутый калькулятор");
    }
}

public static class OverloadOverrideDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Перегрузка:");
        System.out.println("add(2,3) = " + calc.add(2, 3));
        System.out.println("add(2.5,3.7) = " + calc.add(2.5, 3.7));
        System.out.println("add(1,2,3) = " + calc.add(1, 2, 3));
        
        System.out.println("\nПереопределение:");
        calc.show();  // Обычный калькулятор
        
        AdvancedCalculator adv = new AdvancedCalculator();
        adv.show();    // Продвинутый калькулятор
    }

}
}
