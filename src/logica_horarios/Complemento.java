package logica_horarios;

import atividades.AtividadesObrigatorias;
import atividades.AtividadesOpcionais;
import atividades.Entretenimentos;
import atividades.TempoEmAtividades;
import atividades.TempoEmEntretenimentos;

public class Complemento {

	public boolean decrementouHora = false;
	public boolean decrementouMinuto = false;
	public boolean decrementouSegundo = false;

	public void horariosAdicionaisDecrementados(int horas, int minutosEmQuestao, int segundosEmQuestao, int index,
			Object obj) {
		int decrementaHora = 0;
		int decrementaMinuto = 0;
		int decrementaSegundo = 0;

		if (obj instanceof TempoEmAtividades) {
			decrementaHora = AtividadesObrigatorias.horasMutaveis.get(index);
			decrementaMinuto = AtividadesObrigatorias.minutosMutaveis.get(index);
			decrementaSegundo = AtividadesObrigatorias.segundosMutaveis.get(index);

		} else if (obj instanceof TempoEmEntretenimentos) {
			decrementaHora = Entretenimentos.horas.get(index);
			decrementaMinuto = Entretenimentos.minutos.get(index);
			decrementaSegundo = Entretenimentos.segundos.get(index);

		} else if (obj instanceof AtividadesOpcionais) {
			decrementaHora = AtividadesOpcionais.horas[index];
			decrementaMinuto = AtividadesOpcionais.minutos[index];
			decrementaSegundo = AtividadesOpcionais.segundos[index];

		}

		boolean condicaoParaMinutos = false;
		boolean condicaoParaSegundos = false;

		if (obj instanceof TempoEmAtividades) {
			condicaoParaMinutos = ((AtividadesObrigatorias.minutosMutaveis.get(index) - minutosEmQuestao) < 0) ? true
					: false;
		} else if (obj instanceof TempoEmEntretenimentos) {
			condicaoParaMinutos = ((Entretenimentos.minutos.get(index) - minutosEmQuestao) < 0) ? true : false;
		} else if (obj instanceof AtividadesOpcionais) {
			condicaoParaMinutos = ((AtividadesOpcionais.minutos[index] - minutosEmQuestao) < 0) ? true : false;
		}

		if (condicaoParaMinutos && decrementaHora > 0) {
			int contadorDeResto = 0;
			do {
				if (decrementaMinuto == 0) {
					decrementaHora--;
					decrementouHora = true;
					decrementaMinuto = 60;
				}
				decrementaMinuto--;
				contadorDeResto++;
			} while (contadorDeResto < minutosEmQuestao);
			decrementouMinuto = true;

			if (decrementaHora < 0) {
				decrementaHora = 0;
			} else if (decrementaMinuto == 60) {
				decrementaHora++;
				decrementaMinuto = 0;
			}

			if (obj instanceof TempoEmAtividades) {
				AtividadesObrigatorias.horasMutaveis.remove(index);
				AtividadesObrigatorias.horasMutaveis.add(index, decrementaHora);
				AtividadesObrigatorias.minutosMutaveis.remove(index);
				AtividadesObrigatorias.minutosMutaveis.add(index, decrementaMinuto);

			} else if (obj instanceof TempoEmEntretenimentos) {
				Entretenimentos.horas.remove(index);
				Entretenimentos.horas.add(index, decrementaHora);
				Entretenimentos.minutos.remove(index);
				Entretenimentos.minutos.add(index, decrementaMinuto);

			} else if (obj instanceof AtividadesOpcionais) {
				AtividadesOpcionais.horas[index] = decrementaHora;
				AtividadesOpcionais.minutos[index] = decrementaMinuto;

			}

		}

		if (obj instanceof TempoEmAtividades) {
			condicaoParaSegundos = ((AtividadesObrigatorias.segundosMutaveis.get(index) - segundosEmQuestao) < 0) ? true
					: false;
		} else if (obj instanceof TempoEmEntretenimentos) {
			condicaoParaSegundos = ((Entretenimentos.segundos.get(index) - segundosEmQuestao) < 0) ? true : false;
		} else if (obj instanceof AtividadesOpcionais) {
			condicaoParaSegundos = ((AtividadesOpcionais.segundos[index] - segundosEmQuestao) < 0) ? true : false;
		}
														
		if (condicaoParaSegundos && decrementaMinuto > 0 && decrementaSegundo > 0) {
			int contadorDeResto = 0;
			do {
				if (decrementaSegundo == 0) {
					decrementaMinuto--;
					decrementouMinuto = true;
					decrementaSegundo = 60;
				}
				decrementaSegundo--;
				contadorDeResto++;
			} while (contadorDeResto < segundosEmQuestao);
			decrementouSegundo = true;

			if (decrementaMinuto < 0) {
				decrementaMinuto = 0;
			} else if (decrementaMinuto == 60) {
				decrementaMinuto = 0;
				horas++;
			}
			if (decrementaSegundo < 0) {
				decrementaSegundo = 0;
			} else if (decrementaSegundo == 60) {
				decrementaSegundo = 0;
				decrementaMinuto++;
			}

			if (obj instanceof TempoEmAtividades) {
				AtividadesObrigatorias.minutosMutaveis.remove(index);
				AtividadesObrigatorias.minutosMutaveis.add(index, decrementaMinuto);
				AtividadesObrigatorias.segundosMutaveis.remove(index);
				AtividadesObrigatorias.segundosMutaveis.add(index, decrementaSegundo);

			} else if (obj instanceof TempoEmEntretenimentos) {
				Entretenimentos.minutos.remove(index);
				Entretenimentos.minutos.add(index, decrementaMinuto);
				Entretenimentos.segundos.remove(index);
				Entretenimentos.segundos.add(index, decrementaSegundo);

			} else if (obj instanceof AtividadesOpcionais) {
				AtividadesOpcionais.minutos[index] = decrementaMinuto;
				AtividadesOpcionais.segundos[index] = decrementaSegundo;

			}
		}
	}

	public boolean confirmacaoDeDecrementoDeHoras() {
		if (decrementouHora) {
			return true;
		}
		return false;
	}

	public boolean confirmacaoDeDecrementoDeMinutos() {
		if (decrementouMinuto) {
			return true;
		}
		return false;
	}

	public boolean confirmacaoDeDecrementoDeSegundos() {
		if (decrementouSegundo) {
			return true;
		}
		return false;
	}
}
