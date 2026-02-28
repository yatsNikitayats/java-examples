package Accesproject.access;

public class AccessMod {
private int privateVar = 1;       // только внутри этого класса
    int defaultVar = 2;               // только внутри пакета
    protected int protectedVar = 3;   // пакет + наследники
    public int publicVar = 4;          // всем
    
    public void showFromInside() {
        System.out.println("=== ВНУТРИ ТОГО ЖЕ КЛАССА ===");
        System.out.println("private: " + privateVar);     // видно
        System.out.println("default: " + defaultVar);     // видно
        System.out.println("protected: " + protectedVar); // видно
        System.out.println("public: " + publicVar);       // видно
    }
}
