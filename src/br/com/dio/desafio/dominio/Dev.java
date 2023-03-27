package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

	private String nome;
	private Set<Capacitacao> capacitacoesInscritas = new LinkedHashSet<>();
	private Set<Capacitacao> capacitacoesConcluidas = new LinkedHashSet<>();

	public Dev() {

	}

	public Dev(String nome, Set<Capacitacao> capacitacoesInscritas, Set<Capacitacao> capacitacoesConcluidas) {
		this.nome = nome;
		this.capacitacoesInscritas = capacitacoesInscritas;
		this.capacitacoesConcluidas = capacitacoesConcluidas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Capacitacao> getCapacitacoesInscritas() {
		return capacitacoesInscritas;
	}

	public void setCapacitacoesInscritas(Set<Capacitacao> capacitacoesInscritas) {
		this.capacitacoesInscritas = capacitacoesInscritas;
	}

	public Set<Capacitacao> getCapacitacoesConcluidas() {
		return capacitacoesConcluidas;
	}

	public void setCapacitacoesConcluidas(Set<Capacitacao> capacitacoesConcluidas) {
		this.capacitacoesConcluidas = capacitacoesConcluidas;
	}

	public void inscreverBootCamp(Bootcamp bootcamp) {
		this.capacitacoesInscritas.addAll(bootcamp.getCapacitacoes());
		bootcamp.getDevsInscritos().add(this);
	}

	public void progredir() {
		// progredir (finalizar um curso/treinamento) que o dev está inscrito
		Optional<Capacitacao> capacitacao = this.getCapacitacoesInscritas().stream().findFirst();
		if (capacitacao.isPresent()) {
			Capacitacao capacitacaoProgredir = capacitacao.get();
			this.capacitacoesConcluidas.add(capacitacaoProgredir);
			this.capacitacoesInscritas.remove(capacitacaoProgredir);
		} else {
			System.out.println("O desenvolvedor não está matriculado em nenhuma capacitação!");
		}
	}

	public double calcularTotalXp() {
		double totalXp = this.capacitacoesConcluidas.stream().mapToDouble(Capacitacao::calcularXp).sum();

		return totalXp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacitacoesConcluidas, capacitacoesInscritas, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(capacitacoesConcluidas, other.capacitacoesConcluidas)
				&& Objects.equals(capacitacoesInscritas, other.capacitacoesInscritas)

				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dev [name=").append(nome).append(", capacitacoesInscritas=").append(capacitacoesInscritas)
				.append(", capacitacoesConcluidas=").append(capacitacoesConcluidas).append("]");
		return builder.toString();
	}

}
