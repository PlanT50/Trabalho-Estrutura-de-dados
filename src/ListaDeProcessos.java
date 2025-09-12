public class ListaDeProcessos {
    private Node inicio;
    private Node fim;

    private class Node {
        Node proximo;
        Processo processo;

        Node(Processo processo) {
            this.processo = processo;
            this.proximo = new.node;
        }
    }
}
