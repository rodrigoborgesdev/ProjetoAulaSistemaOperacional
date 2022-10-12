package ProjetoAulaSO;

import java.util.Locale;

import javax.swing.JOptionPane;

public class Algoritmo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		// ALGUMAS VARIAVEIS
		int cont, opcao, Prioridade = 0;
		double media = 0;
		int totalEsp = 0, totalExe = 0;

		// NÚMERO DE PROCESSOS
		int numProcesso = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Numero de Processos"));
		int[] unidadeTempo = new int[numProcesso];
		int[] tempoEspera = new int [numProcesso];

		// POPULANDO A UNIDADE DE TEMPO DE CADA PROCESSO
		cont = 1;
		for (int i = 0; i < numProcesso; i++) {
			unidadeTempo[i] = Integer.parseInt(
					JOptionPane.showInputDialog(null, "Digite o tempo de execução do processo [" + cont + "]"));
			cont++;
		}

		do {

			// MENU: TIPOS DE ALGORITMO
			String menu = "*** ESCOLHA O ALGORITMO ***\n" + "[1] FCFS\n" + "[2] SJF\n" + "[3] SJF P\n" + "[4] ROBIN\n"
					+ "[5] PRIORIDADE\n" + "[6] PRIORIDADE P\n" + "[7] SAIR";

			opcao = Integer.parseInt(JOptionPane.showInputDialog(null, menu));

			switch (opcao) {

			// OPÇÃO 1 : ALGORITMO FCFS
			case 1:
				StringBuffer fcfs = new StringBuffer();
				cont = 1;
				int tempo = 0;
				for (int i = 0; i < unidadeTempo.length; i++) {
					fcfs.append("ID p" + cont + "  |  EXECUÇÃO : " + unidadeTempo[i] + "  |  ESPERA : " + tempo
							+ "  |  PRIORIDADE " + Prioridade);
					fcfs.append("\n");
					tempoEspera[i] = tempo;
					tempo = tempo+unidadeTempo[i];
					cont++;
				}
				
				for (int i = 0; i < unidadeTempo.length; i++) {
					totalExe = totalExe+unidadeTempo[i];
				}
						fcfs.append("\n");
				cont = 1;
				int temp = unidadeTempo[0];
				for (int i = 0; i < totalExe; i++) {		
						if (i == temp) {
							temp = temp+unidadeTempo[cont];
							cont = cont+1;
							fcfs.append(+i + "  |  p" +cont+"\n");
						} else {
							fcfs.append(+i + "  |  p" +cont+"\n");
						}
				}
				
				int total = 0;
				for (int i = 0; i < tempoEspera.length; i++) {
					total = total+tempoEspera[i];
				}
				media = total/tempoEspera.length;
				
				fcfs.append("\nMédia Espera : " +String.format("%.2f", media));

				JOptionPane.showMessageDialog(null, fcfs, "Algoritmo FCFS", JOptionPane.INFORMATION_MESSAGE);
				break;

			case 2: {

				break;
			}

			case 3: {

				break;
			}

			}

		} while (opcao == 7);
	}

}

