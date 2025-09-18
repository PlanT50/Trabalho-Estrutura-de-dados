import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        Scheduler scheduler = new Scheduler();

        System.out.println("=====INICIANDO O ESCALONADOR=====");

        LeitorDeProcessos.lerArquivo("processos.txt", scheduler);


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
