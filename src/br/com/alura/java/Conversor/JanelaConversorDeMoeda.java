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

public class JanelaConversorDeMoeda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	double valor;
	JComboBox comboBox;
	JButton botaoOk, botaoCancelar;

	JanelaConversorDeMoeda(double valor){
		this.valor = valor;		
			
		JLabel label = new JLabel("Escolha uma opção de conversão:");		
		String[] tipo = {"Converter de Reais a Dólar", "Converter de Reais a Euro", "Converter de Reais a Libras Esterlinas", 
				"Converter de Reais a Peso Argentino", "Converter de Reais a Peso Chileno", "Converter de Dólar a Reais", 
				"Converter de Euro a Reais", "Converter de Libras Esterlinas a Reais", "Converter de Peso Argentino a  Reais", 
				"Converter de Peso Chileno a Reais"};
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
		this.setTitle("Moeda");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
        this.setLocationRelativeTo( null );
		this.setVisible(true);			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoOk) {
			ConversorMoeda conversor = new ConversorMoeda(valor) {};
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
			case 4: {
				valorConvertido = conversor.CalculaConversao(4);	
				break;			
			}
			case 5: {
				valorConvertido = conversor.CalculaConversao(5);	
				break;			
			}
			case 6: {
				valorConvertido = conversor.CalculaConversao(6);
				break;				
			}
			case 7: {
				valorConvertido = conversor.CalculaConversao(7);
				break;				
			}
			case 8: {
				valorConvertido = conversor.CalculaConversao(8);
				break;				
			}
			case 9: {
				valorConvertido = conversor.CalculaConversao(9);	
				break;			
			}
			}			
			
			
			this.dispose();
			new JanelaMostrarConversaoMoeda(valorConvertido);		
			System.out.println();
		}
		
		if (e.getSource() == botaoCancelar) {
			this.dispose();
			new JanelaPegarValorMoeda();
		}
		
	}
}
