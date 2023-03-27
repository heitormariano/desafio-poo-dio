package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Capacitacao {
	LocalDate data;

	public Mentoria() {
		super();
	}

	public Mentoria(String titulo, String descricao, LocalDate data) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public double calcularXp() {
		return XP_PADRAO + 20d;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mentoria [titulo=").append(titulo).append(", descricao=").append(descricao).append(", data=")
				.append(data).append("]");
		return builder.toString();
	}

}
