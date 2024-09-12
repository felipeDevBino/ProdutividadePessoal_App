package gui.funcoesgui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import atividades.Entretenimentos;
import atividades.TempoEmAtividades;
import atividades.TempoEmEntretenimentos;
import logicadetempo.SistemaDeTempo;
import utilizacaodetelas.UtilizarTelas;

public class FuncoesInterface {

	private String horas = null;
	private String minutos = null;
	private String segundos = null;
	private boolean diminuiu;

	private void inserirTempoParaDistribuir() {
		horas = JOptionPane.showInputDialog(null, "Digite as horas acumuladas que deseja distribuir: ", "Digite",
				JOptionPane.QUESTION_MESSAGE);
		minutos = JOptionPane.showInputDialog(null, "Digite os minutos acumulados que deseja distribuir: ", "Digite",
				JOptionPane.QUESTION_MESSAGE);
		segundos = JOptionPane.showInputDialog(null, "Digite os segundos acumulados que deseja distribuir: ", "Digite",
				JOptionPane.QUESTION_MESSAGE);

		if (horas == null || minutos == null || segundos == null) {
			JOptionPane.showMessageDialog(null, "Campos de Horário Inválidos! (Algum é Nulo)", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void distribuirTempoEmEntretenimento(Entretenimentos entretenimentos, TempoEmAtividades tempoEmAtividades,
			TempoEmEntretenimentos tempoEmEntretenimentos, UtilizarTelas tela, JLabel variavelTempoAcumulado) {
		if (tempoEmAtividades.horasAcumuladas == 0 && tempoEmAtividades.minutosAcumulados == 0
				&& tempoEmAtividades.segundosAcumulados == 0) {
			tela.retornaTextoEmTela("Erro! Você não possui tempo acumulado disponível");
			return;
		}

		entretenimentos.getTodosOsEntretenimentos();

		do {
			inserirTempoParaDistribuir();
		} while (horas == null || minutos == null || segundos == null);

		int horasEmInteiros = Integer.parseInt(horas);
		int minutosEmInteiros = Integer.parseInt(minutos);
		int segundosEmInteiros = Integer.parseInt(segundos);
		
		SistemaDeTempo sistemaDeTempo = new SistemaDeTempo();
		sistemaDeTempo.sistemaDeTempoOrganizado(horasEmInteiros, minutosEmInteiros, segundosEmInteiros);

		horasEmInteiros = sistemaDeTempo.getHorasOrganizadas();
		minutosEmInteiros = sistemaDeTempo.getMinutosOrganizados();
		segundosEmInteiros = sistemaDeTempo.getSegundosOrganizados();

		tempoEmEntretenimentos.incrementarTempo(horasEmInteiros, minutosEmInteiros, segundosEmInteiros);

		variavelTempoAcumulado.setText(String.format("%dH: %dM: %dS.", tempoEmAtividades.horasAcumuladas,
				tempoEmAtividades.minutosAcumulados, tempoEmAtividades.segundosAcumulados));

	}

	public void diminuirTempoEmEntretenimento(TempoEmEntretenimentos tempoEmEntretenimentos) {
		do {
			horas = JOptionPane.showInputDialog(null, "Digite as horas gastas: ", "Digite",
					JOptionPane.QUESTION_MESSAGE);
			minutos = JOptionPane.showInputDialog(null, "Digite os minutos gastos: ", "Digite",
					JOptionPane.QUESTION_MESSAGE);
			segundos = JOptionPane.showInputDialog(null, "Digite os segundos gastos: ", "Digite",
					JOptionPane.QUESTION_MESSAGE);

			if (horas == null || minutos == null || segundos == null) {
				diminuiu = false;
				continue;
			}

			int hora = Integer.parseInt(horas);
			int minuto = Integer.parseInt(minutos);
			int segundo = Integer.parseInt(segundos);

			SistemaDeTempo sistemaDeTempo = new SistemaDeTempo();
			sistemaDeTempo.sistemaDeTempoOrganizado(hora, minuto, segundo);

			hora = sistemaDeTempo.getHorasOrganizadas();
			minuto = sistemaDeTempo.getMinutosOrganizados();
			segundo = sistemaDeTempo.getSegundosOrganizados();

			tempoEmEntretenimentos.decrementarTempoEmEntretenimentos(hora, minuto, segundo);
			
			diminuiu = true;
		} while (!diminuiu);

	}

}
