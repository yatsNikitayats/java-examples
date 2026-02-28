package Accesproject.other;

import Accesproject.access.AccessMod;

public class OtherPackage {
public void testAccess() {
        AccessMod obj = new AccessMod();
        
        System.out.println("=== В ДРУГОМ ПАКЕТЕ (other) ===");
        // System.out.println(obj.privateVar);   // ОШИБКА!
        // System.out.println(obj.defaultVar);   // ОШИБКА!
        // System.out.println(obj.protectedVar); // ОШИБКА!
        System.out.println("public: " + obj.publicVar);      // видно
    }
    
    public static void main(String[] args) {
        OtherPackage dp = new OtherPackage();
        dp.testAccess();
    }
}
