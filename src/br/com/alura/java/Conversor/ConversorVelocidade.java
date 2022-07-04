package br.com.alura.java.Conversor;

public class ConversorVelocidade {

	String valor;
	double QuilometroPorHoraAMilhaPorHora = 0.621371;
	double QuilometroPorHoraAPesPorSegundo = 0.9113441333297608;
	double QuilometroPorHoraAMetroPorSegundo = 0.2777776918389111005;
	double QuilometroPorHoraANo = 0.53995663687041606238;
	double MilhaPorHoraAQuilometroPorHora = 1.60934;
	double PesPorSegundoAQuilometroPorHora = 1.09728;
	double MetroPorSegundoAQuilometroPorHora = 3.6;
	double NoAQuilometroPorHora = 1.852;
	
	public ConversorVelocidade(String valor){
		this.valor = valor;
	}
	
	public String CalculaConversao(int escolha){
		double valorDouble = Double.parseDouble(valor); ;
		switch (escolha) {
		case 0: {
			return valorDouble * QuilometroPorHoraAMilhaPorHora + " mph";
		}
		case 1: {
			return valorDouble * QuilometroPorHoraAPesPorSegundo + " ft/s";
		}
		case 2: {
			return valorDouble * QuilometroPorHoraAMetroPorSegundo + " m/s";
		}
		case 3: {
			return valorDouble * QuilometroPorHoraANo + " nós";
		}
		case 4: {
			return valorDouble * MilhaPorHoraAQuilometroPorHora + " km/h";
		}
		case 5: {
			return valorDouble * PesPorSegundoAQuilometroPorHora + " km/h";
		}
		case 6: {
			return valorDouble * MetroPorSegundoAQuilometroPorHora + " km/h";
		}
		case 7: {
			return valorDouble * NoAQuilometroPorHora + " km/h";
		}
		default:
			throw new IllegalArgumentException("Valor inesperado: " + escolha);
		}
	}
}
