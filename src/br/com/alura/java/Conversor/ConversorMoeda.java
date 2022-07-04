package br.com.alura.java.Conversor;

public class ConversorMoeda {

	double valor;
	double ReaisADolar = 5.24;
	double ReaisAEuro = 5.54;
	double ReaisALibrasEsterlinas = 6.43;
	double ReaisAPesoArgentino = 0.042;
	double ReaisAPesoChileno = 0.0057;
	double DolarAReais = 0.19;
	double EuroAReais = 0.18;
	double LibrasEsterlinasAReais = 0.16;
	double PesoArgentinoAReais = 23.70;
	double PesoChilenoAReais = 175.05;
	
	public ConversorMoeda(double valor){
		this.valor = valor;
	}
	
	public String CalculaConversao(int escolha){
		switch (escolha) {
		case 0: {
			return "R$ " + valor * ReaisADolar;
		}
		case 1: {
			return "R$ " + valor * ReaisAEuro;
		}
		case 2: {
			return "R$ " + valor * ReaisALibrasEsterlinas;
		}
		case 3: {
			return "R$ " + valor * ReaisAPesoArgentino;
		}
		case 4: {
			return "R$ " + valor * ReaisAPesoChileno;
		}
		case 5: {
			return "US$ " + valor * DolarAReais;
		}
		case 6: {
			return "€ " + valor * EuroAReais;
		}
		case 7: {
			return "£ " + valor * LibrasEsterlinasAReais;
		}
		case 8: {
			return "$ " + valor * PesoArgentinoAReais;
		}
		case 9: {
			return "$ " + valor * PesoChilenoAReais;
		}
		default:
			throw new IllegalArgumentException("Valor não permitido: " + escolha);
		}
	}
}
