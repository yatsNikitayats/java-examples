// Пример принципа подстановки Лисков (LSP)
interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    private int width;
    private int height;
    
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public int getArea() {
        return width * height;
    }
}

class Square implements Shape {
    private int side;
    
    public Square(int side) {
        this.side = side;
    }
    
    public void setSide(int side) {
        this.side = side;
    }
    
    @Override
    public int getArea() {
        return side * side;
    }
}

public class LSPExample {
    public static void printArea(Shape shape) {
        System.out.println("Area: " + shape.getArea());
    }
    
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 4);
        Square square = new Square(5);
        
        System.out.println("=== Принцип подстановки Лисков ===");
        System.out.println("Прямоугольник 5x4: " + rect.getArea());
        System.out.println("Квадрат со стороной 5: " + square.getArea());
        
        // Демонстрация полиморфизма
        System.out.println("\n=== Демонстрация через интерфейс ===");
        printArea(rect);
        printArea(square);
    }
}