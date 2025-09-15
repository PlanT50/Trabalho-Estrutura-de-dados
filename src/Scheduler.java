public class Scheduler {
    private ListaDeProcessos lista_alta_prioridade;
    private ListaDeProcessos  lista_media_prioridade;
    private ListaDeProcessos lista_baixa_prioridade;
    private ListaDeProcessos lista_bloqueados;
    private int contador_ciclos_alta_prioridade;
    private int cicloAtual;


    public Scheduler(){
        lista_alta_prioridade = new ListaDeProcessos();
        lista_media_prioridade = new ListaDeProcessos();
        lista_baixa_prioridade = new ListaDeProcessos();
        lista_bloqueados = new ListaDeProcessos();
        contador_ciclos_alta_prioridade = 0;
        cicloAtual = 0;
    }

    public void AdicionarProcesso(Processo processo){
        switch (processo.prioridade){
            case 1:
                lista_alta_prioridade.AdicionarFim(processo);
                break;
            case 2:
                lista_media_prioridade.AdicionarFim(processo);
                break;
            case 3:
                lista_baixa_prioridade.AdicionarFim(processo);
                break;
        }

    }



}
