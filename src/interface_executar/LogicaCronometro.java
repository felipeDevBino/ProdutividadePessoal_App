package interface_executar;

import dias_consecutivos.StatusDiasConsecutivos;

public class LogicaCronometro extends Thread {
	private static int horas = 24;
	private static int minutos = 0;
	private static int segundos = 0;
	public static boolean cronometroEncerrou = false;

	@Override
	public void run() {
		try {
			while (!Start.programaEncerrado) {
				do {
					logicaCronometro();
					Thread.sleep(1000);
					InterfaceGrafica.cronometro.setText(estadoAtual());
				} while (!LogicaCronometro.cronometroEncerrou);

				StatusDiasConsecutivos.salvaDiaAtual();
				Start.diasConsecutivos++;
				
				do {
					resetaCronometro();
					Thread.sleep(1000);
					InterfaceGrafica.cronometroEncerrado();
					InterfaceGrafica.cronometro.setText(estadoAtual());
				} while (LogicaCronometro.cronometroEncerrou);

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void logicaCronometro() {
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

	public static void resetaCronometro() {
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

	public static String estadoAtual() {
		return "h: " + horas + " m: " + minutos + " s: " + segundos;
	}

}
