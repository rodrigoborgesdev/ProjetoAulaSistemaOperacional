package ProjetoAulaSO;

import java.util.Locale;

import javax.swing.JOptionPane;

public class Algoritmo {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		// ALGUMAS VARIAVEIS
		Processo pro = new Processo();
		int opcao, cont = 1, uT=0;

		// POPULANDO PROCESSOS 
		pro.setNumProcesso(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Numero de Processos")));

		// POPULANDO UNIDADE DE TEMPO DE CADA PROCESSO
		pro.criaUnidadeTempo();
		for (int i = 0; i < pro.getNumProcesso(); i++) {
			uT = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tempo de execução do processo [" + cont + "]"));
			pro.pegaUnidadeTempo(i, uT);
			cont++;
		}

		do {
			// MENU: EXECUTA ALGORITMO
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null, pro.getMenu()));

			switch (opcao) {

			// OPÇÃO 1 : ALGORITMO FCFS
			case 1:
				pro.limparStringBuffer();
				pro.criaTempoEspera();
				pro.FCFS();
				pro.listaProcessos();
				pro.totalUnidadeTempo();
				pro.calculaMedia();
				JOptionPane.showMessageDialog(null, pro.algoritmo , "Algoritmo FCFS", JOptionPane.INFORMATION_MESSAGE);
				break;

			// 	OPÇÃO 2 : ALGORITMO SJF NÃO PREEMPTIVO
			case 2: {
				pro.limparStringBuffer();
				pro.criaTempoEspera();
				pro.SJF_n_primitivo();
				pro.totalUnidadeTempo();
				pro.calculaMedia();
				JOptionPane.showMessageDialog(null, pro.algoritmo, "Algoritmo SJF (não preemptivo)", JOptionPane.INFORMATION_MESSAGE);
				break;
			}

//		 	OPÇÃO 2 : ALGORITMO SJF PREEMPTIVO
			case 3: {

				break;
			}

			}

		} while (!(opcao == 7));
	}

}
