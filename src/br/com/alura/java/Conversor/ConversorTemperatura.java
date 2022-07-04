package br.com.alura.java.Conversor;

public class ConversorTemperatura {

	String valor;
		
	public ConversorTemperatura(String valor){
		this.valor = valor;
	}
	
	public String CalculaConversao(int escolha){
		double valorDouble = Double.parseDouble(valor); ;
		switch (escolha) {
		case 0: { 	//Celsius A Fahrenheit
			return ((1.8 * valorDouble) + 32) + "ºF";
		}
		case 1: {	//Celsius A Kelvin
			return valorDouble + 273.15 + "K";
		}
		case 2: {	//Fahrenheit A Celsius
			return (valorDouble - 32) / 1.8  + "ºC";
		}
		case 3: {	//Kelvin A Celsius
			return valorDouble - 273.15 + "ºC";
		}
		default:
			throw new IllegalArgumentException("Valor inesperado: " + escolha);
		}
	}
}
