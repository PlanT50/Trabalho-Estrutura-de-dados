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
    public void  executarCicloDeCPU(){
        cicloAtual++;
        System.out.println("Executando ciclo " + cicloAtual );

        if(!lista_bloqueados.Vazio()){
            Processo processodesbloqueio = lista_bloqueados.RemoverInicio();
            System.out.println("||DESBLOQUEIO|| Processo " + processodesbloqueio.nome);
            AdicionarProcesso(processodesbloqueio);

        }

        Processo processoexecutando = proximoprocesso();

        if(processoexecutando.recurso_necessario.equals("DISCO") && processoexecutando.bloqueio == false){
            System.out.println("||BLOQUEIO|| Processo " +  processoexecutando.nome + " requer DISCO");

            lista_bloqueados.AdicionarFim(processoexecutando);
            processoexecutando.bloqueio = true;
            return;

        }
        System.out.println("Executando processo " + processoexecutando.nome + "Ciclos restantes: " + processoexecutando.ciclos_necessarios);

        processoexecutando.ciclos_necessarios--;

        if (processoexecutando.ciclos_necessarios == 0){
            System.out.println("Processo " + processoexecutando.nome + " executado");
        }else {
            AdicionarProcesso(processoexecutando);
            System.out.println("Processo " + processoexecutando.nome + " reenserido ");
        }

    }
public Processo proximoprocesso(){
        Processo processo = null;

        if (contador_ciclos_alta_prioridade >= 5){
            System.out.println("Quantidade de ciclos de alta prioridade alcançada. Executando media/baixa prioridade.");
            contador_ciclos_alta_prioridade = 0;

            if (lista_media_prioridade != null){
                lista_media_prioridade.RemoverInicio();
            }else if (lista_baixa_prioridade != null){
                lista_baixa_prioridade.RemoverInicio();
            }else {
                System.out.println("Nenhuma prioridade media/baixa disponivel, Executando alta prioridade.");
                lista_alta_prioridade.RemoverInicio();
                contador_ciclos_alta_prioridade++;
            }

        }

        else {
            if (!lista_alta_prioridade.Vazio()){
                lista_alta_prioridade.RemoverInicio();
                contador_ciclos_alta_prioridade++;
            } else if (!lista_media_prioridade.Vazio()) {
                lista_media_prioridade.RemoverInicio();
                contador_ciclos_alta_prioridade = 0;
            }else if (!lista_baixa_prioridade.Vazio()){
                lista_baixa_prioridade.RemoverInicio();
                contador_ciclos_alta_prioridade = 0;
            }

        }
        return processo;

}
    private void Imprimir() {
        System.out.println("\nEstado das listas:");
        System.out.println("Alta: " + lista_alta_prioridade.imprimirLista());
        System.out.println("Média: " + lista_media_prioridade.imprimirLista());
        System.out.println("Baixa: " + lista_baixa_prioridade.imprimirLista());
        System.out.println("Bloqueados: " + lista_bloqueados.imprimirLista());
        System.out.println("Contador anti-inanição: " + contador_ciclos_alta_prioridade + "/5");
    }

}
