package logicadehorarios.cronometro;

import app.Start;
import atividades.TempoEmAtividades;
import diasconsecutivos.InformacoesDiarias;
import diasconsecutivos.StatusDiasConsecutivos;
import gui.InterfaceGrafica;
import instancias.InstanceManager;

public class Cronometro implements Runnable {

	private int horas;
	private int minutos;
	private int segundos;
	public boolean cronometroEncerrou = false;

	private InterfaceGrafica gui;
	private StatusDiasConsecutivos diasConsecutivos;
	private InformacoesDiarias informacoesDiarias;
	private TempoEmAtividades tempoEmAtividades;

	public Cronometro(InterfaceGrafica pGui) {
		diasConsecutivos = new StatusDiasConsecutivos();
		informacoesDiarias = new InformacoesDiarias();
		tempoEmAtividades = InstanceManager.getTempoEmAtividades();
		gui = pGui;
		
		horas = 24;
		minutos = 0;
		segundos = 0;
	}

	@Override
	public void run() {
		try {
			do {
				do {
					executarCronometro();
					Thread.sleep(1000);
					gui.variavelCronometro.setText(estadoAtual());
					gui.cronometroEncerrado();
				} while (!cronometroEncerrou);

				do {
					resetarCronometro();
					Thread.sleep(1000);
				} while (cronometroEncerrou);
				
				tempoEmAtividades.mostrarTempoRestaurado(gui);
				tempoEmAtividades.restaurarTempoOriginal();
				
			} while (!Start.terminouPrograma);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void executarCronometro() {
		segundos--;
		if (segundos < 0) {
			minutos--;
			segundos = 59;
			if (minutos < 0) {
				horas--;
				minutos = 59;
			}
		}

		if (horas < 0) {
			horas = 0;
		} else if (minutos < 0) {
			minutos = 0;
		} else if (segundos < 0) {
			segundos = 0;
		}

		if (horas == 0 && minutos == 0 && segundos == 0) {
			cronometroEncerrou = true;
		}

	}

	public void resetarCronometro() {
		segundos++;
		if (segundos > 59) {
			minutos++;
			segundos = 0;
			if (minutos > 59) {
				horas++;
				minutos = 0;
			}
		}

		if (minutos > 59) {
			minutos = 59;
		} else if (segundos > 59) {
			segundos = 59;
		}

		if (horas == 24 && minutos == 0 && segundos == 0) {
			cronometroEncerrou = false;
		}

	}

	public String estadoAtual() {
		return String.format("%dH: %dM: %dS.", horas, minutos, segundos);
	}

}
