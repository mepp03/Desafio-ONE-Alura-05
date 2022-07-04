package br.com.alura.java.Conversor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaConversorDeTemperatura extends JFrame implements ActionListener {

	private static final long serialVersionUID = 4487766050271826675L;
	String valor;
	JComboBox comboBox;
	JButton botaoOk, botaoCancelar;

	JanelaConversorDeTemperatura(String valor){
		this.valor = valor;
		
		JLabel label = new JLabel("Escolha uma opção de conversão:");		
		String[] tipo = {"Converter de Celsius para Fahrenheit", "Converter de Celsius para Kelvin",
				"Converter de Fahrenheit para Celsius", "Converter de Kelvin para Celsius"};
		comboBox = new JComboBox(tipo);		
		botaoOk = new JButton("OK");
		botaoCancelar = new JButton("Cancelar");
		
		JPanel painelPrincipal = new JPanel();
	    painelPrincipal.setLayout((LayoutManager) new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
	    JPanel painelTopo = new JPanel();
	    JPanel painelFundo = new JPanel();
	    painelTopo.setBorder(BorderFactory.createEmptyBorder(0, 60 , 0, 60));
	    painelTopo.setLayout(new GridLayout(0, 1));
	    painelFundo.setBorder(BorderFactory.createEmptyBorder(10, 120 , 10, 120));
	    painelPrincipal.add(painelTopo);
	    painelPrincipal.add(painelFundo);
		
	    painelTopo.add(label);
	    painelTopo.add(comboBox);
	    painelFundo.add(botaoOk);
	    painelFundo.add(botaoCancelar);
		comboBox.addActionListener(this);
		botaoOk.addActionListener(this);
		botaoCancelar.addActionListener(this);
		
		this.add(painelPrincipal, BorderLayout.CENTER);
		this.setTitle("Temperatura");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
        this.setLocationRelativeTo( null );
		this.setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoOk) {
			ConversorTemperatura conversor = new ConversorTemperatura(valor) {};
			String valorConvertido = null;
			
			switch (comboBox.getSelectedIndex()) {
			case 0: {
				valorConvertido = conversor.CalculaConversao(0);	
				break;
			}
			case 1: {
				valorConvertido = conversor.CalculaConversao(1);
				break;				
			}
			case 2: {
				valorConvertido = conversor.CalculaConversao(2);	
				break;			
			}
			case 3: {
				valorConvertido = conversor.CalculaConversao(3);	
				break;			
			}
			}			
			
			
			this.dispose();
			new JanelaMostrarConversaoTemperatura(valorConvertido);		
			System.out.println();
		}
		
		if (e.getSource() == botaoCancelar) {
			this.dispose();
			new JanelaPegarValorTemperatura();
		}
		
	}
}
