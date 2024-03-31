package executar;

import tabelas.AtividadesAntiOciosidade;
import tabelas.AtividadesNecessarias;
import tabelas.TempoEmAtividades;

public class SelecionaAtividades {

	public static StringBuilder atividade01, atividade02, atividade03;
	public static StringBuilder atividadeOpcional01, atividadeOpcional02;
	
	// ESCOLHE ATÉ 3 ATIVIDADES PRINCIPAIS PARA FAZER DE UMA VEZ, FORNECENDO AO
	// USUÁRIO UMA PEQUENA INTERFACE PARA DECREMENTAR O TEMPO DAS ATIVIDADES
	// DIÁRIAS, E 2 ATIVIDADES SECUNDÁRIAS
	public static void selecionaAtividades() {

		//LÓGICA SOBRE HORA, MINUTO E SEGUNDO
		
		TempoEmAtividades.escolheAtividade();
		SelecionaAtividades.atividade01.append(TempoEmAtividades.atividade + ": ");
		SelecionaAtividades.atividade01
				.append(AtividadesNecessarias.atividadesObrigatorias.get(TempoEmAtividades.atividade));
		
		TempoEmAtividades.escolheAtividade();
		SelecionaAtividades.atividade02.append(TempoEmAtividades.atividade + ": ");
		SelecionaAtividades.atividade02
				.append(AtividadesNecessarias.atividadesObrigatorias.get(TempoEmAtividades.atividade));
		
		TempoEmAtividades.escolheAtividade();
		SelecionaAtividades.atividade03.append(TempoEmAtividades.atividade + ": ");
		SelecionaAtividades.atividade03
				.append(AtividadesNecessarias.atividadesObrigatorias.get(TempoEmAtividades.atividade));

	}
	
	public static void atividadesOpcionais() {
		AtividadesAntiOciosidade atividadesAntiOciosidade = new AtividadesAntiOciosidade();
		atividadesAntiOciosidade.defineAtividadesAntiOciosidade();
	}
	
	public static void interfaceVisivel() {
		
	}

}
