public class BinaryTree {
    public static void main(String[] args) {
        Tree root = new Tree(2);
        Tree l1 = new Tree(21);
        Tree r1 = new Tree(31);
        Tree l1l1 = new Tree(221);
        Tree l1r1 = new Tree(331);
        Tree r1l1 = new Tree (431);
        Tree r1l1l1 = new Tree(6431);
         

        root.left = l1;
        root.right = r1;
        l1.left = l1l1;
        l1.right = l1r1;
        r1.left = r1l1;
        r1l1.left = r1l1l1;
        // r1.right = r1r1;
        r1l1l1.left = new Tree(86431);
        r1l1.right = new Tree(7431);
        root.value = 1;
        System.out.println();
        System.out.println("Pre-order format of the bi-tree: ");
        RowPrintlerPreOrder.print("", root);
        System.out.println();
        System.out.println("\nIn-order format of the bi-tree: ");
        RowPrintlerInOrder.print("", root);
        System.out.println();
        System.out.println("Post-order format of the bi-tree: ");
        RowPrintlerPostOrder.print("", root);
        System.out.println();
    }

}

class Tree {
    public Tree(int v) {
        value = v;
    }
    int value;
    Tree left;
    Tree right;
}

// print in lines with tabs in PRE-order
class Printler {
    static void print(Tree treeName, String space) {
        if (treeName != null) {
            System.out.printf("%s%d\n", space, treeName.value);
            if (treeName.left != null || treeName.left != null) {
                print(treeName.left, space + ".");
                print(treeName.right, space + ".");
            }
        } else {
            System.out.printf(space + "None\n");
        }
    }
}
 // print in row with brackets and spaces in PRE-order
class RowPrintlerPreOrder {
    static void print(String space, Tree treeName) {
        if (treeName != null) {
            System.out.printf("%s%d", space, treeName.value);
            if (treeName.left != null || treeName.right != null) {
                System.out.printf(" (");
                print(space, treeName.left);
                System.out.printf(", ");
                print(space, treeName.right);
                System.out.printf(")");
            }
        } else {
            System.out.printf(space + "None");
        }
    }
}

 // print in IN-order
 class RowPrintlerInOrder {
    static void print(String space, Tree treeName) {
        if (treeName != null) {
            // if (treeName.left != null || treeName.right != null) { // not print the last node
            print(space + ".", treeName.left);
            System.out.printf("%s%d\n", space, treeName.value);
            print(space + ":", treeName.right);
        }
    }
}

 // print in POST-order
 class RowPrintlerPostOrder {
    static void print(String space, Tree treeName) {
        if (treeName != null) {
            print(space + ".", treeName.left);
            print(space + ":", treeName.right);
            System.out.printf("%s%d\n", space, treeName.value);
        }
    }
}
