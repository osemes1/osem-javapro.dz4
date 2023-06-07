package javapro.dz16;

// Клас, що представляє вузол дерева
class Node {
    int value; // Значення вузла
    Node left; // Лівий нащадок
    Node right; // Правий нащадок

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

// Клас, що представляє просте дерево
class SimpleTree {
    Node root; // Кореневий вузол дерева

    public SimpleTree() {
        root = null;
    }

    // Метод додавання значення до дерева
    public void add(int value) {
        root = addRecursive(root, value);
    }

    // Допоміжний рекурсивний метод для додавання значення до дерева
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    // Метод обходу (ітерації) дерева - inorder
    public void iterateInorder() {
        iterateInorderRecursive(root);
    }

    // Допоміжний рекурсивний метод для обходу (ітерації) дерева - inorder
    private void iterateInorderRecursive(Node current) {
        if (current != null) {
            iterateInorderRecursive(current.left);
            System.out.print(current.value + " ");
            iterateInorderRecursive(current.right);
        }
    }
}

// Приклад використання
public class Main {
    public static void main(String[] args) {
        SimpleTree tree = new SimpleTree();
        tree.add(10);
        tree.add(6);
        tree.add(14);
        tree.add(3);
        tree.add(8);
        tree.add(13);
        tree.add(15);

        System.out.println("Ітерація дерева (інордер):");
        tree.iterateInorder();
    }
}
