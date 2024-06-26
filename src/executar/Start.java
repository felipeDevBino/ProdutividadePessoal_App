package executar;

import java.util.Scanner;

import atividades.AtividadesObrigatorias;
import atividades.Entretenimentos;

public class Start {

	// Variáveis para o arquivo (dias consecutivos, etc...)
	static Scanner scanner = new Scanner(System.in);

	/**
	 * 
	 * author felipeDevBino
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		buscaListaEmDiretorios();

		System.out.println(
				"\n---------------------------------------------------------------ProdutividadePessoal_App---------------------------------------------------------------");
		AtividadesObrigatorias.defineAsAtividades();
		Entretenimentos.defineOsEntretenimentos();
		System.out.println("\nAtividades Obrigatórias e Entretenimentos registrados com sucesso.");

		System.out.println("\nSelecione as 3 atividades para concluir em sua interface!");

		AtividadesObrigatorias.getTodasAsAtividades();

		SelecionaAtividades.selecionaAtividade01();
		SelecionaAtividades.selecionaAtividade02();
		SelecionaAtividades.selecionaAtividade03();

		InterfaceGrafica.main(args);

		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------------------------------------------------------");

	}

	/*
	 * QUESTIONA O USUÁRIO SE ELE GOSTARIA DE INSERIR A LOCALIZAÇÃO DE UM ARQUIVO
	 * CONTENDO INFORMAÇÕES PARA UMA LISTA EXISTENTE, O PROGRAMA BUSCARÁ PELA
	 * SEQUÊNCIA DE CARACTERES DAS ATIVIDADES E ENTRETENIMENTOS E IRÁ VERIFICAR SE A
	 * FRASE FORMADA/INFORMAÇÃO É VALIDA, INICIANDO O PROGRAMA SEM NECESSITAR DE
	 * INSERIR TODAS AS ATIVIDADES E HORÁRIOS NOVAMENTE, AO FIM DO PROGRAMA, CASO O
	 * USUÁRIO TERMINE O PROGRAMA, O PROGRAMA SALVARÁ UM ARQUIVO AS VARIÁVEIS
	 * ATUAIS, ATIVIDADES SELECIONADAS E TEMPOS ACUMULADOS PARA ENTRETENIMENTOS.
	 */
	public static void buscaListaEmDiretorios() {
		// TODO
	}

}
