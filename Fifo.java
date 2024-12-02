import java.util.Scanner;

public class Fifo {
	
    public static void main (String[] args) {
        int n;
        Scanner entrada = new Scanner (System.in);

		//Entrada de dados e validação
        do {
            System.out.print("Informe a quantidade de processos: ");
            n = entrada.nextInt();
            if (n < 1) {
				System.out.print("ATENCAO! Informe ao menos 1 processo!");
            }
        } while (n < 1);

		int[] tempoUcp = new int[n];
        int[] tempoCriacao = new int[n];
        
        //Entrada de dados dos processos
        for (int i = 0; i < n; i++) {
            System.out.print("Informe o tempo de UCP do processo " + (i + 1) + ": ");
            tempoUcp[i] = entrada.nextInt();
            System.out.print("Informe o tempo de criacao do processo " + (i + 1) + ": ");
			tempoCriacao[i] = entrada.nextInt();
		}
		
		entrada.close();

        int[] tme = new int[n];
        int[] tmp = new int[n];
		int acumulaTempoUcp = 0;
		double somaTme = 0;
		double somaTmp = 0;
		
		//Cálculo do TMP e TME de cada processo, e impressão da tabela
		System.out.println("\nProcesso: Tempo de UCP:\t Tempo de Criacao: \tTMP: \t\tTME:");
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				tmp[i] = tempoUcp[i];
				tme[i] = tempoCriacao[i];
			}
			acumulaTempoUcp += tempoUcp[i];
			tmp[i] = acumulaTempoUcp - tempoCriacao[i];
			tme[i] = tmp[i] - tempoUcp[i];
			somaTmp += tmp[i];
			somaTme += tme[i];
			System.out.println("P" + (i + 1) + "\t\t" + tempoUcp[i] + "\t\t" + tempoCriacao[i] + "\t\t " + tmp[i] + "\t\t " + tme[i]);
		}
		
		//Cálculo e impressão do TMP médio e TME médio
		double tmpMedio = (double) (somaTmp / n);
		double tmeMedio = (double)(somaTme / n);
		System.out.printf("\nFIFO --> TMP medio = %.1f \nFIFO --> TME medio = %.1f", tmpMedio, tmeMedio);
    }
}
