import java.util.Scanner;

public class Sjf {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n, start = 0, quantidadeProcessos = 0;
        double tme = 0, tmp = 0;
        
        //Entrada de dados e validação
        do {
            System.out.print("Informe a quantidade de processos: ");
            n = entrada.nextInt();
            if (n < 1) {
				System.out.print("ATENCAO! Informe ao menos 1 processo!");
            }
        } while (n < 1);
        
        int processo[] = new int[n];
        int tempoChegada[] = new int[n];
        int tempoUcp[] = new int[n];
        int tempoCompleto[] = new int[n];
        int turnAround[] = new int[n];
        int tempoEspera[] = new int[n];
        int f[] = new int[n];

		//Entrada de dados dos processos
        for (int i = 0; i < n; i++) {
            System.out.print("Informe o tempo de criacao do processo " + (i+1) + ": ");
            tempoChegada[i] = entrada.nextInt();
            System.out.print("Informe o tempo de CPU do processo " + (i+1) + ": ");
            tempoUcp[i] = entrada.nextInt();
            processo[i] = i + 1;
            f[i] = 0;
        }
        
        entrada.close();

		//Cálculo de TMP e TME de cada processo
        for (int h = 0; h < n; h++) {
            int c = n, min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (quantidadeProcessos == n) {//Se o numero total de processos for igual a quantidade de processos completados, o programa termina
                break;
				}
                if ((tempoChegada[i] <= start) && (f[i] == 0) && (tempoUcp[i] < min)) {
                    min = tempoUcp[i];
                    c = i;
                }
            }
            
            if (c == n) {
                start++;
            } else {
                tempoCompleto[c] = start + tempoUcp[c];
                start += tempoUcp[c];
                turnAround[c] = tempoCompleto[c]- tempoChegada[c];
                tempoEspera[c] = turnAround[c] - tempoUcp[c];
                f[c] = 1;
                processo[quantidadeProcessos] = c + 1;
                quantidadeProcessos++;
            }
        }

		//Impressão da tabela
        System.out.println("\nProcesso: \tTempo de Chegada:  \tTempo de UCP: \t\tTMP: \t\tTME:");
        for (int i = 0; i < n; i++) {
            tme += tempoEspera[i];
            tmp += turnAround[i];
            System.out.println(processo[i] + "\t\t" + tempoChegada[i] + "\t\t\t" + tempoUcp[i] + "\t\t\t" + turnAround[i] + "\t\t" + tempoEspera[i]);
        }
        
        //Cálculo e impressão do TMP médio e TME médio
        System.out.println ("\nTMP medio: "+ (double)(tmp/n));
        System.out.println ("TME medio: "+ (double)(tme/n));
        
        //Impressão da orddem de execução dos processos
        System.out.print("Ordem de Execucao dos Processos: ");
        for (int i = 0; i < n; i++) {
            System.out.print(processo[i] + " ");
        }
    }
}
