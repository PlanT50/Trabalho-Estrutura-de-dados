public class ListaDeProcessos {
    private Node Head;
    private Node Tail;

    private class Node {
        Node proximo;
        Processo processo;

        Node(Processo processo) {
            this.processo = processo;
            this.proximo = null;
        }
    }

    public ListaDeProcessos(){
        this.Head = null;
        this.Tail = null;

    }

    public void AdicionarFim(Processo processo){
        Node novonode = new Node(processo);

        if(this.Head == null){
            Head = novonode;
            Tail = novonode;
        }else {
         Tail.proximo = novonode;
         Tail = novonode;
        }
    }
}
