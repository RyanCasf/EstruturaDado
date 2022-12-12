package br.com.ryan.recursividade;

public class Recursividade {
	
	public double fatorialSobre(long valor) throws IllegalArgumentException {
		if (valor < 0) {
			throw new IllegalArgumentException("Não existe fatorial de número negativo.");
		}
		
		if (valor == 0) {
			return 0;
		}
		
		double resultado = (double) 1 / fatorial(valor);
		return resultado + fatorialSobre(--valor);
	}
	
	public long fatorial(long valor) throws IllegalArgumentException {
		if (valor < 0) {
			throw new IllegalArgumentException("Não existe fatorial de número negativo.");
		}
		
		if (valor < 2) {
			return 1;
		}
		
		return valor * fatorial(valor - 1);
	}
	
	public int fibonacci(int parametro) {
		if (parametro < 0) {
			throw new IllegalArgumentException("Os números negativos em fibonacci são absurdos.");
		}
		
		if (parametro == 0) {
			return 0;
		}
		
		if (parametro == 1 || parametro == 2) {
			return 1;
		}
		
		return fibonacci(parametro - 1) + fibonacci(parametro - 2);
	}
	
	public int somar(int valor) {
		if (valor == 0) {
			return 0;
		}
		
		return valor > 0 ? somarPositivo(valor) : somarNegativo(valor);
	}
	
	private int somarPositivo(int valor) {
		return valor > 0 ? (valor) + somarPositivo(--valor) : 0;
	}
	
	private int somarNegativo(int valor) {
		return valor < 0 ? (valor) + somarNegativo(++valor) : 0;
	}
	
	public double somarSobre(int valor) {
		if (valor == 0) {
			return 0;
		}
		
		return valor > 0 ? somarSobrePositivo(valor) : somarSobreNegativo(valor);
	}

	private double somarSobrePositivo(int valor) {
		return valor > 0 ? ((double) 1 / valor) + somarSobrePositivo(--valor) : 0;
	}

	private double somarSobreNegativo(int valor) {
		return valor < 0 ? ((double) 1 / valor) + somarSobreNegativo(++valor) : 0;
	} 
}