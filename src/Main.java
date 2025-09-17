import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        Scheduler scheduler = new Scheduler();

        System.out.println("=====INICIANDO O ESCALONADOR=====");

        scheduler.AdicionarProcesso(new Processo(1,"Discord",3,4,"DISCO" ));
        scheduler.AdicionarProcesso(new Processo(2,"GOOGLE",2,3,null));
        scheduler.AdicionarProcesso(new Processo(3,"MOUSE",1,2,null));
        scheduler.AdicionarProcesso(new Processo(4,"TELA",1,2,null));
        scheduler.AdicionarProcesso(new Processo(5,"COOLER",1,5,null));
        scheduler.AdicionarProcesso(new Processo(6,"UI",1,2,null));

        System.out.println("Processos Adicionados, Pressione ENTER para continuar");
        scanf.nextLine();


        int Maxciclos = 20;
        int ciclo = 0;

        while(ciclo < Maxciclos) {
            scheduler.executarCicloDeCPU();
            ciclo++;

            System.out.println("Ciclo Finalizado, Pressione ENTER para proximo ciclo ou r para cancelar.");
            String input = scanf.nextLine();
            if (input.equalsIgnoreCase("r")) {
                break;
            }
        }
        System.out.println("Escalonamento finalizado");
        scanf.close();



    }
}

