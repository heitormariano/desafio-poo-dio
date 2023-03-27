package br.com.dio.desafio.dominio;

public abstract class Capacitacao {

	protected static final double XP_PADRAO = 10d;
	protected String titulo;
	protected String descricao;

	public abstract double calcularXp();
}
