import java.io.File;
import java.util.Scanner;

class BSTNode {
    public String key;
    public Object value;
    public BSTNode left, right;

    public BSTNode(String key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class Dictionary {

    public String word[] = new String[61336];
    public String meaning[] = new String[61336];

    public void input() throws Exception {
        // pass the path to the file as a parameter
        File file1 = new File("data/61336words.txt");
        File file2 = new File("data/61336meanings.txt");
        Scanner sc = new Scanner(file1);
        Scanner sc2 = new Scanner(file2);

        int i = 0, j = 0;
        while (sc.hasNextLine() && i<61336) {
            word[i++] = sc.nextLine();
        }
        while (sc2.hasNextLine() && j<61336) {
            meaning[j++] = sc2.nextLine();
        }
    }

    BSTNode root;

    public BSTNode insert(BSTNode node, String key, String value) {
        if (node == null) return new BSTNode(key, value);
        if (key.compareTo(node.key) < 0) node.left = insert(node.left, key, value);
        if (key.compareTo(node.key) > 0) node.right = insert(node.right, key, value);
        return node;
    }

    public void buildBST() {
        for (int i = 0; i < 61336; i++) {
            root = insert(root, word[i], meaning[i]);
        }
    }
    public void swap(int i, int j) {
        String tmp = this.word[i];
        this.word[i] = this.word[j];
        this.word[j] = tmp;
    }

    public int partition(int L, int R) {
        String pivot = this.word[R];
        int i = L - 1;

        for(int j = L; j <= R - 1; ++j) {
            if (word[j].compareTo(pivot) < 0) {
                ++i;
                this.swap(i, j);
            }
        }

        this.swap(i + 1, R);
        return i + 1;
    }

    public void quickSort(int L, int R) {
        if (L < R) {
            int pi = this.partition(L, R);
            this.quickSort(L, pi - 1);
            this.quickSort(pi + 1, R);
        }
    }

    void preOrder(BSTNode node) {
        if (node != null) {
            System.out.println(node.key + ": " + node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    BSTNode find(BSTNode root, String key) {
        if (root == null) return null;
        int rs = root.key.compareTo(key);
        if (rs == 0) return root;
        if (rs < 0) return find(root.right, key);
        else return find(root.left, key);
    }

    public static void main(String[] args) throws Exception {
        Dictionary app = new Dictionary();
        app.input();
        app.quickSort(0, 61335);
        app.buildBST();
//        app.preOrder(app.root);
        System.out.println("Enter a word:");
        String key = new Scanner(System.in).nextLine();
        BSTNode p = app.find(app.root, key);
        if (p == null) System.out.println("Not found!");
        else System.out.println("Found! The meaning of your word is: " + p.value);
    }
}
