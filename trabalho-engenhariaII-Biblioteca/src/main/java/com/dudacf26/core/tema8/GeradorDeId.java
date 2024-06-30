package com.dudacf26.core.tema8;

public class GeradorDeId {
	private int cont;
	public GeradorDeId(int idQueParou) {
		 cont = idQueParou;
	}
	public int gerarId() {
		cont++;
		return cont;
	}
}

