package executar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import tabelas.Entretenimentos;
import tabelas.TempoEmAtividades;
import tabelas.TempoEmEntretenimentos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceGrafica {

	private JFrame frame;

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
		SelecionaAtividades.atividade01 = new StringBuilder();
		SelecionaAtividades.atividade02 = new StringBuilder();
		SelecionaAtividades.atividade03 = new StringBuilder();
		SelecionaAtividades.atividadeOpcional01 = new StringBuilder();
		SelecionaAtividades.atividadeOpcional02 = new StringBuilder();

		SelecionaAtividades.atividade01.append("a");
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 383);
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
		lblNewLabel_2.setBounds(49, 51, 105, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("ATIVIDADE 02");
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2_1.setBounds(173, 51, 105, 14);
		frame.getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("ATIVIDADE 03");
		lblNewLabel_2_2.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2_2.setBounds(299, 51, 105, 14);
		frame.getContentPane().add(lblNewLabel_2_2);

		JButton btnNewButton = new JButton("--");
		btnNewButton.setBounds(49, 137, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("--");
		btnNewButton_1.setBounds(173, 137, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("--");
		btnNewButton_2.setBounds(299, 137, 89, 23);
		frame.getContentPane().add(btnNewButton_2);

		String a = SelecionaAtividades.atividade01.toString();
		System.out.println(a);
		JLabel conteudoAtividade01 = new JLabel(a);
		conteudoAtividade01.setFont(new Font("Tahoma", Font.PLAIN, 10));
		conteudoAtividade01.setBounds(49, 76, 89, 39);
		frame.getContentPane().add(conteudoAtividade01);

		JLabel lblNewLabel_5 = new JLabel("horario");
		lblNewLabel_5.setBounds(69, 112, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("horario");
		lblNewLabel_5_1.setBounds(193, 112, 46, 14);
		frame.getContentPane().add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_1_1 = new JLabel("horario");
		lblNewLabel_5_1_1.setBounds(329, 112, 46, 14);
		frame.getContentPane().add(lblNewLabel_5_1_1);

		JLabel conteudoAtividade02 = new JLabel(SelecionaAtividades.atividade02.toString());
		conteudoAtividade02.setFont(new Font("Tahoma", Font.PLAIN, 10));
		conteudoAtividade02.setBounds(173, 76, 89, 39);
		frame.getContentPane().add(conteudoAtividade02);

		JLabel conteudoAtividade03 = new JLabel(SelecionaAtividades.atividade03.toString());
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

		JLabel atividadeOpcional01 = new JLabel(SelecionaAtividades.atividadeOpcional01.toString());
		atividadeOpcional01.setFont(new Font("Tahoma", Font.PLAIN, 10));
		atividadeOpcional01.setBounds(49, 217, 89, 39);
		frame.getContentPane().add(atividadeOpcional01);

		JLabel atividadeOpcional02 = new JLabel(SelecionaAtividades.atividadeOpcional02.toString());
		atividadeOpcional02.setFont(new Font("Tahoma", Font.PLAIN, 10));
		atividadeOpcional02.setBounds(299, 217, 89, 39);
		frame.getContentPane().add(atividadeOpcional02);

		JLabel lblNewLabel_5_2 = new JLabel("horario");
		lblNewLabel_5_2.setBounds(69, 252, 46, 14);
		frame.getContentPane().add(lblNewLabel_5_2);

		JLabel lblNewLabel_5_3 = new JLabel("horario");
		lblNewLabel_5_3.setBounds(325, 252, 46, 14);
		frame.getContentPane().add(lblNewLabel_5_3);

		JButton btnNewButton_3 = new JButton("--");
		btnNewButton_3.setBounds(49, 277, 89, 23);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("--");
		btnNewButton_4.setBounds(299, 277, 89, 23);
		frame.getContentPane().add(btnNewButton_4);

		JLabel lblNewLabel_3 = new JLabel("cronometro diario");
		lblNewLabel_3.setBounds(177, 319, 94, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JButton btnNewButton_5 = new JButton("distribuir");
		btnNewButton_5.addActionListener(new ActionListener() {
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
		btnNewButton_5.setBounds(173, 248, 89, 23);
		frame.getContentPane().add(btnNewButton_5);

		String tempoAcumulado;
		tempoAcumulado = (TempoEmAtividades.horasAcumuladas + "H - " + TempoEmAtividades.minutosAcumulados + "M - " + TempoEmAtividades.segundosAcumulados + "S.");
		JLabel lblNewLabel_7 = new JLabel(tempoAcumulado);
		lblNewLabel_7.setBounds(173, 229, 123, 14);
		frame.getContentPane().add(lblNewLabel_7);

		JButton btnNewButton_6 = new JButton("diminuir");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entretenimentoEscolhido;
				int contador01 = 0, contador02 = 0;
				
				for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
					JOptionPane.showMessageDialog(null, entretenimento, "Entretenimento " + (contador01 + 1),
							JOptionPane.INFORMATION_MESSAGE);
					contador01++;
				}
				do {
					entretenimentoEscolhido = JOptionPane.showInputDialog(null,
							"Digite o número do entretenimento para decrementar com o tempo gasto:", "decremento",
							JOptionPane.QUESTION_MESSAGE);

					for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
						if (entretenimentoEscolhido.charAt(0) == contador02) {
							String horas = JOptionPane.showInputDialog(null, "Digite as horas gastas: ", "Digite",
									JOptionPane.QUESTION_MESSAGE);
							String minutos = JOptionPane.showInputDialog(null, "Digite os minutos gastos: ", "Digite",
									JOptionPane.QUESTION_MESSAGE);
							String segundos = JOptionPane.showInputDialog(null, "Digite os segundos gastos: ", "Digite",
									JOptionPane.QUESTION_MESSAGE);

							int hora = Integer.parseInt(horas);
							int minuto = Integer.parseInt(minutos);
							int segundo = Integer.parseInt(segundos);

							TempoEmEntretenimentos.tempoDecorridoEmEntretenimentos(entretenimento, hora, minuto,
									segundo);
							return;
						}
						if (contador02 == Entretenimentos.entretenimentos.size() - 1) {
							System.out.println("\nEntretenimento não encontrado.");
						}
						contador02++;
					}
				} while (entretenimentoEscolhido.charAt(0) != contador02);
			}
		});
		btnNewButton_6.setBounds(173, 277, 89, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel_4 = new JLabel("Tempo Acumulado");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(166, 208, 123, 23);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
