
public class Test {
    public static void main(String[] args) {
        try {
            // Crear un objeto BSTree de tipo Integer
            BSTree<Integer> bstInteger = new BSTree<>();

            // Insertar elementos en el BSTree
            bstInteger.insert(15);
            bstInteger.insert(9);
            bstInteger.insert(20);
            bstInteger.insert(6);
            bstInteger.insert(14);
            bstInteger.insert(17);
            bstInteger.insert(64);
            bstInteger.insert(13);
            bstInteger.insert(26);
            bstInteger.insert(72);

            // Imprimir el BSTree utilizando el recorrido inOrden
            System.out.println("Recorrido inOrden del BSTree de enteros:");
            bstInteger.inOrder();
            System.out.println();

            // Eliminar elementos del BSTree
            bstInteger.remove(9);
            bstInteger.remove(14);

            // Imprimir el BSTree actualizado
            System.out.println("BSTree de enteros después de eliminar elementos:");
            System.out.println(bstInteger);
            System.out.println();

            // Crear un objeto BSTree de tipo String
            BSTree<String> bstString = new BSTree<>();

            // Insertar elementos en el BSTree
            bstString.insert("Lapiz");
            bstString.insert("Borrador");
            bstString.insert("Regla");
            bstString.insert("Corrector");
            bstString.insert("Lapicero");
            bstString.insert("Cuaderno");
            bstString.insert("Libro");
            bstString.insert("Diccionario");

            // Imprimir el BSTree utilizando el recorrido inOrden
            System.out.println("Recorrido inOrden del BSTree de cadenas:");
            bstString.inOrder();
            System.out.println();

            // Eliminar elementos del BSTree
            bstString.remove("Lapiz");
            bstString.remove("Regla");

            // Imprimir el BSTree actualizado
            System.out.println("BSTree de cadenas después de eliminar elementos:");
            System.out.println(bstString);

            // Imprimir la representación entre paréntesis con sangría del árbol BST
            System.out.println("Representación entre paréntesis con sangría del BSTree:");
            bstString.parenthesize();
        } catch (ItemDuplicated e) {
            System.out.println("Error: Elemento duplicado en el BSTree.");
        } catch (ItemNoFound e) {
            System.out.println("Error: Elemento no encontrado en el BSTree.");
        }
    }
}


