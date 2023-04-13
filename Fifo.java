

import java.util.Scanner;

public class Fifo {
	
    public static void main (String[] args) {
        int n;
        Scanner entrada = new Scanner (System.in);

        do {
            System.out.print("Informe a quantidade de processos: ");
            n = entrada.nextInt();
            if (n < 1) {
				System.out.print("ATENCAO! Informe ao menos 1 processo!");
            }
        } while (n < 1);

		int[] tempoUcp = new int[n];
        int[] tempoCriacao = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Informe o tempo de UCP do processo " + (i + 1) + ": ");
            tempoUcp[i] = entrada.nextInt();
            System.out.print("Informe o tempo de criacao do processo " + (i + 1) + ": ");
			tempoCriacao[i] = entrada.nextInt();
		}

        int[] tme = new int[n];
        int[] tmp = new int[n];
		int acumulaTempoUcp = 0;
		double somaTme = 0;
		double somaTmp = 0;
		
		System.out.println("Processo:\t Tempo de UCP:\t Tempo de Criacao:\t TMP: \t TME:");
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
			System.out.println("TMP do P" + (i + 1) + ": " + tmp[i] + "\t\tTME do P" + (i + 1) + ": " + tme[i]);
		}
		
		double tmpMedio = (double) (somaTmp / n);
		double tmeMedio = (double)(somaTme / n);
		System.out.printf("TMP medio = %.1f \tTME medio = %.1f", tmpMedio, tmeMedio);
    }
}
