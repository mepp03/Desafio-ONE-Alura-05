package br.com.alura.java.Conversor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaPegarValorMoeda extends JFrame implements ActionListener {

	private static final long serialVersionUID = -7281200491502629385L;
	JButton botaoOk, botaoCancelar;
	JTextField input;

	JanelaPegarValorMoeda() {
		JLabel label = new JLabel("Insira um valor:");
		input = new JTextField();
		botaoOk = new JButton("OK");
		botaoOk.addActionListener(this);
		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.addActionListener(this);

		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setLayout((LayoutManager) new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
		JPanel painelTopo = new JPanel();
		JPanel painelFundo = new JPanel();
		painelTopo.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));
		painelTopo.setLayout(new GridLayout(0, 1));
		painelFundo.setBorder(BorderFactory.createEmptyBorder(0, 120, 10, 120));
		painelPrincipal.add(painelTopo);
		painelPrincipal.add(painelFundo);

		painelTopo.add(label);
		painelTopo.add(input);
		painelFundo.add(botaoOk);
		painelFundo.add(botaoCancelar);

		this.add(painelPrincipal, BorderLayout.CENTER);
		this.setTitle("Valor");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		input.requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String regex = "^(\\d)*(\\.)?([0-9]{1})?$";
		if (e.getSource() == botaoOk) {
			if (input.getText().isBlank() || input.getText().contentEquals(".") || !input.getText().matches(regex)) {
				JOptionPane.showMessageDialog(this, "Informe um valor válido!");
				input.requestFocus();
				input.setText(null);
			} else {
				this.dispose();
				new JanelaConversorDeMoeda(Double.valueOf(input.getText()));
			}
		}

		if (e.getSource() == botaoCancelar) {
			this.dispose();
			new JanelaPrincipal();
		}

		if (e.getSource() == botaoCancelar) {
			this.dispose();
			new JanelaPrincipal();
		}
	}
}
