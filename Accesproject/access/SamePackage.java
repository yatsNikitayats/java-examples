package Accesproject.access;

public class SamePackage {
public void testAccess() {
        AccessMod obj = new AccessMod();
        
        System.out.println("=== В ТОМ ЖЕ ПАКЕТЕ (access) ===");
        // System.out.println(obj.privateVar);   // ОШИБКА! 
        System.out.println("default: " + obj.defaultVar);    // видно
        System.out.println("protected: " + obj.protectedVar); // видно
        System.out.println("public: " + obj.publicVar);       // видно
    }
    
    public static void main(String[] args) {
        SamePackage sp = new SamePackage();
        sp.testAccess();
        
        AccessMod am = new AccessMod();
        am.showFromInside();
    }
}
