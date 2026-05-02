package src;

/**
 * Узел дерева Хаффмана
 */
public class Node implements Comparable<Node> {
    
    private int symbol;      // символ (байт) - для листовых узлов
    private int frequency;   // частота встречаемости
    private Node left;       // левый потомок
    private Node right;      // правый потомок
    
    public Node(int symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }
    
    public Node(Node left, Node right) {
        this.symbol = -1;
        this.frequency = left.frequency + right.frequency;
        this.left = left;
        this.right = right;
    }
    
    public int getSymbol() { return symbol; }
    public int getFrequency() { return frequency; }
    public Node getLeft() { return left; }
    public Node getRight() { return right; }
    public void setLeft(Node left) { this.left = left; }
    public void setRight(Node right) { this.right = right; }
    
    public boolean isLeaf() {
        return left == null && right == null;
    }
    
    @Override
    public int compareTo(Node other) {
        int freqCompare = Integer.compare(this.frequency, other.frequency);
        if (freqCompare != 0) {
            return freqCompare;
        }
        return Integer.compare(this.symbol, other.symbol);
    }
    
    @Override
    public String toString() {
        if (isLeaf()) {
            return "Node{symbol=" + symbol + ", freq=" + frequency + "}";
        } else {
            return "Node{internal, freq=" + frequency + "}";
        }
    }
}