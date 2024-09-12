package atividades;

import utilizacaodetelas.UtilizarTelas;

public class SelecionaAtividades {

	private String atividade01, atividade02, atividade03;
	private String atividadeOpcional01, atividadeOpcional02;

	private boolean selecionouAtividade01 = false;
	private boolean selecionouAtividade02 = false;
	private boolean selecionouAtividade03 = false;

	private UtilizarTelas tela;

	public SelecionaAtividades() {
		tela = new UtilizarTelas();
	}

	public String selecionarAtividade01(AtividadesObrigatorias atividadesObrigatorias) {
		atividadesObrigatorias.getTodasAsAtividades();
		do {
			atividadesObrigatorias.getAtividade();
			atividade01 = atividadesObrigatorias.getAtividadeSelecionada();

			if (atividade01.equals(atividade02) || atividade01.equals(atividade03)) {
				tela.retornaTextoEmTela("Erro! Essa atividade não existe ou já foi selecionada por algum espaço!");
				selecionouAtividade01 = true;
				return "";
			} else {
				selecionouAtividade03 = false;
			}
			return atividade01;
		} while (atividade01.equals(atividade02) || atividade01.equals(atividade03));

	}

	public String selecionarAtividade02(AtividadesObrigatorias atividadesObrigatorias) {
		atividadesObrigatorias.getTodasAsAtividades();
		do {
			atividadesObrigatorias.getAtividade();
			atividade02 = atividadesObrigatorias.getAtividadeSelecionada();

			if (atividade02.equals(atividade01) || atividade02.equals(atividade03)) {
				tela.retornaTextoEmTela("Erro! Essa atividade não existe ou já foi selecionada por algum espaço!");
				selecionouAtividade02 = true;
				return "";
			} else {
				selecionouAtividade02 = false;
			}
			return atividade02;
		} while (atividade02.equals(atividade01) || atividade02.equals(atividade03));

	}

	public String selecionarAtividade03(AtividadesObrigatorias atividadesObrigatorias) {
		atividadesObrigatorias.getTodasAsAtividades();
		do {
			atividadesObrigatorias.getAtividade();
			atividade03 = atividadesObrigatorias.getAtividadeSelecionada();
			
			if (atividade03.equals(atividade01) || atividade03.equals(atividade02)) {
				tela.retornaTextoEmTela("Erro! Essa atividade não existe ou já foi selecionada por algum espaço!");
				selecionouAtividade03 = true;
				return "";
			} else {
				selecionouAtividade03 = false;
			}
			return atividade03;
		} while (atividade03.equals(atividade01) || atividade03.equals(atividade02));

	}

	public String selecionarAtividadeOpcional01(AtividadesOpcionais atividadesOpcionais) {
		atividadeOpcional01 = atividadesOpcionais.getAtividadeOpcional01();
		return atividadeOpcional01;
	}

	public String selecionarAtividadeOpcional02(AtividadesOpcionais atividadesOpcionais) {
		atividadeOpcional02 = atividadesOpcionais.getAtividadeOpcional02();
		return atividadeOpcional02;
	}

	public void setAtividade01(String atividade) {
		atividade01 = atividade;
	}

	public void setAtividade02(String atividade) {
		atividade02 = atividade;
	}

	public void setAtividade03(String atividade) {
		atividade03 = atividade;
	}

	public void setAtividadeOpcional01(String atividade) {
		atividadeOpcional01 = atividade;
	}

	public void setAtividadeOpcional02(String atividade) {
		atividadeOpcional02 = atividade;
	}

	public String getAtividade01() {
		return atividade01;
	}

	public String getAtividade02() {
		return atividade02;
	}

	public String getAtividade03() {
		return atividade03;
	}

	public String getAtividadeOpcional01() {
		return atividadeOpcional01;
	}

	public String getAtividadeOpcional02() {
		return atividadeOpcional02;
	}

	public boolean seSelecionouAtividade01() {
		return selecionouAtividade01;
	}

	public boolean seSelecionouAtividade02() {
		return selecionouAtividade02;
	}

	public boolean seSelecionouAtividade03() {
		return selecionouAtividade03;
	}

}
