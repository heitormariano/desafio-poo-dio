package br.com.dio.desafio.dominio;

public class Curso extends Capacitacao {
	private int cargaHoraria;

	public Curso() {
		super();
	}

	public Curso(String titulo, String descricao, int cargaHoraria) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.cargaHoraria = cargaHoraria;
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

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public double calcularXp() {
		return XP_PADRAO * cargaHoraria;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Curso [titulo=").append(titulo).append(", descricao=").append(descricao)
				.append(", cargaHoraria=").append(cargaHoraria).append("]");
		return builder.toString();
	}

}
