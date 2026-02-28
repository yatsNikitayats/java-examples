package Accesproject.other;

import Accesproject.access.AccessMod;

public class SubClass extends AccessMod {
  public void testAccess() {
        System.out.println("=== НАСЛЕДНИК В ДРУГОМ ПАКЕТЕ ===");
        // System.out.println(privateVar);   // ОШИБКА!
        // System.out.println(defaultVar);   // ОШИБКА!
        System.out.println("protected: " + protectedVar);    // видно (наследование!)
        System.out.println("public: " + publicVar);          // видно
    }
    
    public static void main(String[] args) {
        SubClass sc = new SubClass();
        sc.testAccess();
    }
}
