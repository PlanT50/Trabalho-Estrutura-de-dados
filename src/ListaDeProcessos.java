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

        if(Head == null){
            Head = novonode;
            Tail = novonode;
        }else {
         Tail.proximo = novonode;
         Tail = novonode;
        }
    }
    public Processo RemoverInicio(){
       if(Head == null){
        return null;
       }
       Processo removido = Head.processo;
       Head = Head.proximo;

       if(Head == null){
           Tail = null;
       }
       return removido;

    }

    public String imprimirLista() {
        if (Head == null) {
            return "Vazia";
        }

        String resultado = "";
        Node atual = Head;

        while (atual != null) {
            resultado += atual.processo.nome + "(" + atual.processo.ciclos_necessarios + ")";
            if (atual.proximo != null) {
                resultado += " → ";
            }
            atual = atual.proximo;
        }

        return resultado;
    }

}
