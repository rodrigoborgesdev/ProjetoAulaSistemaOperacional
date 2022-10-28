package ProjetoAulaSO;

import java.util.Random;

public class Processo {
	
	private int numProcesso;
	private int[] unidadeTempo;
	private int[] tempoEspera;
	StringBuffer algoritmo = new StringBuffer();
	
	private String menu = "*** ESCOLHA O ALGORITMO ***\n" + "[1] FCFS\n" + "[2] SJF (não preemptivo)\n" + "[3] SJF (preemptivo)\n" + "[4] ROBIN\n"
			+ "[5] PRIORIDADE\n" + "[6] PRIORIDADE P\n" + "[7] SAIR";
	int total = 0, cont = 1, tempo = 0, prioridade = 0, x = 1, media = 0;
	
	Random numero = new Random(5);
	
	Processo () {
		
	}
	
	public void criaUnidadeTempo() {
		unidadeTempo = new int[numProcesso];
	}
	
	public void criaTempoEspera() {
		tempoEspera = new int[numProcesso];
	}

	public int getNumProcesso() {
		return numProcesso;
	}

	public void setNumProcesso(int numProcesso) {
		this.numProcesso = numProcesso;
	}

	public int[] getUnidadeTempo() {
		return unidadeTempo;
	}

	public void setUnidadeTempo(int[] unidadeTempo) {
		this.unidadeTempo = unidadeTempo;
	}
	
	public void setUnidadeTempo(int parseInt) {
	}
	
	public void pegaUnidadeTempo(int i, int valor) {
		this.unidadeTempo[i] = valor;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public void totalUnidadeTempo() {
		for (int i = 0; i < numProcesso; i++) {
			total = total+unidadeTempo[i];
		}
				
	}
	
	public void FCFS() {
		cont = 1;
		for (int i = 0; i < numProcesso; i++) {
			algoritmo.append("ID p" + cont + "  |  EXECUÇÃO : " + getUnidadeTempo()[i] + "  |  ESPERA : " + tempo
					+ "  |  PRIORIDADE " + prioridade);
			algoritmo.append("\n");
			tempoEspera[i] = tempo;
			tempo = tempo + getUnidadeTempo()[i];
			cont++;
		}
		algoritmo.append("\n");
	}
	
	public void SJF_n_primitivo() {
		cont = 1;
		for (int i = 0; i < numProcesso; i++) {
			int aleatorio = numero.nextInt(5);
			algoritmo.append("ID p" +cont+ "  |  TEMPO DE CHEGADA : "+tempo+"  |  EXECUÇÃO : "+getUnidadeTempo()[i]);
			algoritmo.append("\n");
			tempoEspera[i] = tempo;
			tempo = tempo + aleatorio;
			cont++;
		}
		algoritmo.append("\n");
		
	}
	
	public void listaProcessos() {
		tempo = unidadeTempo[0];
		x = 1;
		int valor = 1;
		for (int i = 0; i < total; i++) {
			
			if (i == tempo) {
				tempo = tempo + getUnidadeTempo()[valor];
				x = x + 1;
				algoritmo.append(+i + "  |  p" + x + "\n");
			} else {
				algoritmo.append(+i + "  |  p" + x + "\n");
			}
		}
	}

	public void calculaMedia() {
		total = 0;
		for (int i = 0; i < numProcesso; i++) {
			total = total + tempoEspera[i];
		}
		media = total / tempoEspera.length;
		algoritmo.append("\nMédia Espera : " + media);
	}
	
	public void limparStringBuffer() {
		algoritmo.setLength(0);
	}
	
	
	
}
