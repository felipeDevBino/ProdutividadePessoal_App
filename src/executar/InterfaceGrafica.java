package executar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import tabelas.AtividadesAntiOciosidade;
import tabelas.AtividadesNecessarias;
import tabelas.Entretenimentos;
import tabelas.TempoEmAtividades;
import tabelas.TempoEmEntretenimentos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceGrafica {

	private JFrame frame;
	static String opcional01;
	static String opcional02;
	static String at1, at2, at3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGrafica window = new InterfaceGrafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfaceGrafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 7));
		frame.setBounds(100, 100, 452, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ProdutividadePessoal_App");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(99, 11, 233, 23);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("@author: felipeDevBino (GitHub)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(135, 0, 136, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ATIVIDADE 01");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(49, 42, 105, 23);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("ATIVIDADE 02");
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2_1.setBounds(173, 46, 105, 14);
		frame.getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("ATIVIDADE 03");
		lblNewLabel_2_2.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2_2.setBounds(299, 46, 105, 14);
		frame.getContentPane().add(lblNewLabel_2_2);

		JButton diminuiAt01 = new JButton("Diminuir");
		diminuiAt01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtividadesNecessarias.atividade = SelecionaAtividades.atividade01;

				String horas = JOptionPane.showInputDialog(null, "Digite as horas concluídas da atividade 01: ",
						"Digite", JOptionPane.QUESTION_MESSAGE);
				String minutos = JOptionPane.showInputDialog(null, "Digite os minutos concluídos da atividade 01: ",
						"Digite", JOptionPane.QUESTION_MESSAGE);
				String segundos = JOptionPane.showInputDialog(null, "Digite os segundos concluídos da atividade 01: ",
						"Digite", JOptionPane.QUESTION_MESSAGE);

				int hora = Integer.parseInt(horas);
				int minuto = Integer.parseInt(minutos);
				int segundo = Integer.parseInt(segundos);

				TempoEmAtividades.tempoDecorridoEmAtividades(hora, minuto, segundo);

			}
		});
		diminuiAt01.setBounds(49, 137, 89, 23);
		frame.getContentPane().add(diminuiAt01);

		JButton diminuiAt02 = new JButton("Diminuir");
		diminuiAt02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtividadesNecessarias.atividade = SelecionaAtividades.atividade02;

				String horas = JOptionPane.showInputDialog(null, "Digite as horas concluídas da atividade 02: ",
						"Digite", JOptionPane.QUESTION_MESSAGE);
				String minutos = JOptionPane.showInputDialog(null, "Digite os minutos concluídos da atividade 02: ",
						"Digite", JOptionPane.QUESTION_MESSAGE);
				String segundos = JOptionPane.showInputDialog(null, "Digite os segundos concluídos da atividade 02: ",
						"Digite", JOptionPane.QUESTION_MESSAGE);

				int hora = Integer.parseInt(horas);
				int minuto = Integer.parseInt(minutos);
				int segundo = Integer.parseInt(segundos);

				TempoEmAtividades.tempoDecorridoEmAtividades(hora, minuto, segundo);
			}
		});
		diminuiAt02.setBounds(173, 137, 89, 23);
		frame.getContentPane().add(diminuiAt02);

		JButton diminuiAt03 = new JButton("Diminuir");
		diminuiAt03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtividadesNecessarias.atividade = SelecionaAtividades.atividade03;

				String horas = JOptionPane.showInputDialog(null, "Digite as horas concluídas da atividade 03: ",
						"Digite", JOptionPane.QUESTION_MESSAGE);
				String minutos = JOptionPane.showInputDialog(null, "Digite os minutos concluídos da atividade 03: ",
						"Digite", JOptionPane.QUESTION_MESSAGE);
				String segundos = JOptionPane.showInputDialog(null, "Digite os segundos concluídos da atividade 03: ",
						"Digite", JOptionPane.QUESTION_MESSAGE);

				int hora = Integer.parseInt(horas);
				int minuto = Integer.parseInt(minutos);
				int segundo = Integer.parseInt(segundos);

				TempoEmAtividades.tempoDecorridoEmAtividades(hora, minuto, segundo);
			}
		});
		diminuiAt03.setBounds(299, 137, 89, 23);
		frame.getContentPane().add(diminuiAt03);

		JLabel conteudoAtividade01 = new JLabel(SelecionaAtividades.atividade01);
		conteudoAtividade01.setFont(new Font("Tahoma", Font.PLAIN, 10));
		conteudoAtividade01.setBounds(49, 76, 89, 39);
		frame.getContentPane().add(conteudoAtividade01);

		JLabel horarioAtividade01 = new JLabel(
				AtividadesNecessarias.atividadesObrigatorias.get(SelecionaAtividades.atividade01));
		horarioAtividade01.setBounds(49, 112, 89, 14);
		frame.getContentPane().add(horarioAtividade01);

		JLabel horarioAtividade02 = new JLabel(
				AtividadesNecessarias.atividadesObrigatorias.get(SelecionaAtividades.atividade02));
		horarioAtividade02.setBounds(173, 112, 89, 14);
		frame.getContentPane().add(horarioAtividade02);

		JLabel horarioAtividade03 = new JLabel(
				AtividadesNecessarias.atividadesObrigatorias.get(SelecionaAtividades.atividade03));
		horarioAtividade03.setBounds(299, 112, 89, 14);
		frame.getContentPane().add(horarioAtividade03);

		JLabel conteudoAtividade02 = new JLabel(SelecionaAtividades.atividade02);
		conteudoAtividade02.setFont(new Font("Tahoma", Font.PLAIN, 10));
		conteudoAtividade02.setBounds(173, 76, 89, 39);
		frame.getContentPane().add(conteudoAtividade02);

		JLabel conteudoAtividade03 = new JLabel(SelecionaAtividades.atividade03);
		conteudoAtividade03.setFont(new Font("Tahoma", Font.PLAIN, 10));
		conteudoAtividade03.setBounds(299, 76, 89, 39);
		frame.getContentPane().add(conteudoAtividade03);

		JLabel lblNewLabel_2_3 = new JLabel("ATIVIDADE OPCIONAL 01");
		lblNewLabel_2_3.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2_3.setBounds(49, 192, 160, 14);
		frame.getContentPane().add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_3_1 = new JLabel("ATIVIDADE OPCIONAL 02");
		lblNewLabel_2_3_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2_3_1.setBounds(234, 192, 160, 14);
		frame.getContentPane().add(lblNewLabel_2_3_1);

		JLabel atividadeOpcional01 = new JLabel(SelecionaAtividades.atividadeOpcional01);
		atividadeOpcional01.setFont(new Font("Tahoma", Font.PLAIN, 10));
		atividadeOpcional01.setBounds(49, 217, 89, 39);
		frame.getContentPane().add(atividadeOpcional01);

		JLabel atividadeOpcional02 = new JLabel(SelecionaAtividades.atividadeOpcional02);
		atividadeOpcional02.setFont(new Font("Tahoma", Font.PLAIN, 10));
		atividadeOpcional02.setBounds(299, 217, 89, 39);
		frame.getContentPane().add(atividadeOpcional02);

		JLabel horarioAtividadeOpcional01 = new JLabel(
				AtividadesAntiOciosidade.atividadesAntiOciosidade.get(SelecionaAtividades.atividade01));
		horarioAtividadeOpcional01.setBounds(49, 252, 89, 14);
		frame.getContentPane().add(horarioAtividadeOpcional01);

		JLabel horarioAtividadeOpcional02 = new JLabel(
				AtividadesAntiOciosidade.atividadesAntiOciosidade.get(SelecionaAtividades.atividade02));
		horarioAtividadeOpcional02.setBounds(299, 252, 89, 14);
		frame.getContentPane().add(horarioAtividadeOpcional02);

		InterfaceGrafica.opcional01 = "Adicione";
		for (String atividade : AtividadesAntiOciosidade.atividadesAntiOciosidade.keySet()) {
			if (AtividadesAntiOciosidade.atividadesAntiOciosidade.get(atividade) == null) {
				InterfaceGrafica.opcional01 = "Diminuir";
			}
		}

		JButton diminuiAtOp01 = new JButton(opcional01);
		diminuiAtOp01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (InterfaceGrafica.opcional01.equals("Adicione")) {

					SelecionaAtividades.selecionaAtividadeOpcional01();
					InterfaceGrafica.opcional01 = SelecionaAtividades.atividadeOpcional01;
					int contador = 0;
					for (String atividade : AtividadesAntiOciosidade.atividadesAntiOciosidade.keySet()) {
						if (atividade.equals(SelecionaAtividades.atividadeOpcional01)) {
							break;
						}
						contador++;
					}
					System.out.println(
							"\nAtividade opcional gerada com sucesso! " + SelecionaAtividades.atividadeOpcional01
									+ ", Tempo restante: " + AtividadesAntiOciosidade.atividadesAntiOciosidade
											.get(SelecionaAtividades.atividadeOpcional01)
									+ ".");

				} else {
					AtividadesAntiOciosidade.atividade = SelecionaAtividades.atividadeOpcional01;

					String horas = JOptionPane.showInputDialog(null,
							"Digite as horas concluídas da atividade opcional 01: ", "Digite",
							JOptionPane.QUESTION_MESSAGE);
					String minutos = JOptionPane.showInputDialog(null, "Digite os minutos concluídos da atividade 01: ",
							"Digite", JOptionPane.QUESTION_MESSAGE);
					String segundos = JOptionPane.showInputDialog(null,
							"Digite os segundos concluídos da atividade 01: ", "Digite", JOptionPane.QUESTION_MESSAGE);

					int hora = Integer.parseInt(horas);
					int minuto = Integer.parseInt(minutos);
					int segundo = Integer.parseInt(segundos);

					AtividadesAntiOciosidade.tempoDecorridoEmAtividadesAntiOciosidade(hora, minuto, segundo);
				}
			}
		});
		diminuiAtOp01.setBounds(49, 277, 89, 23);
		frame.getContentPane().add(diminuiAtOp01);

		InterfaceGrafica.opcional02 = "Adicione";
		for (String atividade : AtividadesAntiOciosidade.atividadesAntiOciosidade.keySet()) {
			if (AtividadesAntiOciosidade.atividadesAntiOciosidade.get(atividade) == null) {
				InterfaceGrafica.opcional02 = "Diminuir";
			}
		}

		JButton diminuiAtOp02 = new JButton(opcional02);
		diminuiAtOp02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (InterfaceGrafica.opcional02.equals("Adicione")) {

					SelecionaAtividades.selecionaAtividadeOpcional02();
					InterfaceGrafica.opcional02 = SelecionaAtividades.atividadeOpcional02;
					int contador = 0;
					for (String atividade : AtividadesAntiOciosidade.atividadesAntiOciosidade.keySet()) {
						if (atividade.equals(SelecionaAtividades.atividadeOpcional02)) {
							break;
						}
						contador++;
					}
					System.out.println(
							"\nAtividade opcional gerada com sucesso! " + SelecionaAtividades.atividadeOpcional02
									+ ", Tempo restante: " + AtividadesAntiOciosidade.atividadesAntiOciosidade
											.get(SelecionaAtividades.atividadeOpcional02)
									+ ".");

				} else {
					AtividadesAntiOciosidade.atividade = SelecionaAtividades.atividadeOpcional02;

					String horas = JOptionPane.showInputDialog(null,
							"Digite as horas concluídas da atividade opcional 02: ", "Digite",
							JOptionPane.QUESTION_MESSAGE);
					String minutos = JOptionPane.showInputDialog(null, "Digite os minutos concluídos da atividade 02: ",
							"Digite", JOptionPane.QUESTION_MESSAGE);
					String segundos = JOptionPane.showInputDialog(null,
							"Digite os segundos concluídos da atividade 02: ", "Digite", JOptionPane.QUESTION_MESSAGE);

					int hora = Integer.parseInt(horas);
					int minuto = Integer.parseInt(minutos);
					int segundo = Integer.parseInt(segundos);

					AtividadesAntiOciosidade.tempoDecorridoEmAtividadesAntiOciosidade(hora, minuto, segundo);
				}
			}
		});
		diminuiAtOp02.setBounds(299, 277, 89, 23);
		frame.getContentPane().add(diminuiAtOp02);

		// TODO
		// DATA E HORA
		JLabel cronometro = new JLabel("cronometro diario");
		cronometro.setBounds(294, 345, 94, 14);
		frame.getContentPane().add(cronometro);

		JButton distribuir = new JButton("Distribuir");
		distribuir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		distribuir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int contador = 0;
				for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
					JOptionPane.showMessageDialog(null, entretenimento, "Entretenimento " + (contador + 1),
							JOptionPane.INFORMATION_MESSAGE);
					TempoEmEntretenimentos.incrementaTempo(TempoEmAtividades.horasAcumuladas,
							TempoEmAtividades.minutosAcumulados, TempoEmAtividades.segundosAcumulados);
					contador++;
				}
			}
		});
		distribuir.setBounds(166, 277, 105, 31);
		frame.getContentPane().add(distribuir);
		String tempoAcumulado = TempoEmAtividades.horasAcumuladas + "H : " + TempoEmAtividades.minutosAcumulados
				+ "M : " + TempoEmAtividades.segundosAcumulados + "S.";
		JLabel variavelTempoAcumulado = new JLabel(tempoAcumulado);
		variavelTempoAcumulado.setBounds(187, 252, 80, 14);
		frame.getContentPane().add(variavelTempoAcumulado);

		JButton diminuir = new JButton("Diminuir");
		diminuir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		diminuir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int contador01 = 0, contador02 = 0;

				for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
					JOptionPane.showMessageDialog(null, entretenimento, "Entretenimento " + (contador01 + 1),
							JOptionPane.INFORMATION_MESSAGE);
					contador01++;
				}
				do {
					Entretenimentos.getEntretenimento();

					String horas = JOptionPane.showInputDialog(null, "Digite as horas gastas: ", "Digite",
							JOptionPane.QUESTION_MESSAGE);
					String minutos = JOptionPane.showInputDialog(null, "Digite os minutos gastos: ", "Digite",
							JOptionPane.QUESTION_MESSAGE);
					String segundos = JOptionPane.showInputDialog(null, "Digite os segundos gastos: ", "Digite",
							JOptionPane.QUESTION_MESSAGE);

					int hora = Integer.parseInt(horas);
					int minuto = Integer.parseInt(minutos);
					int segundo = Integer.parseInt(segundos);

					TempoEmEntretenimentos.tempoDecorridoEmEntretenimentos(hora, minuto, segundo);

					contador02++;
					// LÓGICA CASO NÃO SEJA NENHUM VALOR VALIDO DO ARRAY ENTRETENIMENTOS
				} while (contador02 < Entretenimentos.entretenimentos.size() - 1);
			}
		});
		diminuir.setBounds(166, 336, 103, 31);
		frame.getContentPane().add(diminuir);

		JLabel lblNewLabel_4 = new JLabel("Tempo Acumulado");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(166, 224, 116, 23);
		frame.getContentPane().add(lblNewLabel_4);

		JButton opcoes = new JButton("OPÇÕES");
		opcoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// TODO

			}
		});
		opcoes.setBounds(49, 341, 89, 23);
		frame.getContentPane().add(opcoes);

		JLabel lblNewLabel_3 = new JLabel("^");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_3.setBounds(211, 327, 35, 0);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("v");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_3_1.setBounds(221, 319, 0, 31);
		frame.getContentPane().add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("^");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_3_1_1.setBounds(218, 299, 35, 23);
		frame.getContentPane().add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_6_1 = new JLabel("ENTRETENIMENTOS");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6_1.setBounds(173, 297, 98, 51);
		frame.getContentPane().add(lblNewLabel_6_1);

		JLabel lblNewLabel_5 = new JLabel("v");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_5.setBounds(221, 328, 13, 14);
		frame.getContentPane().add(lblNewLabel_5);
	}
}
