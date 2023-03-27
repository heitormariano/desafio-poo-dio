package br.com.dio.desafio;

import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {
		Curso cursoJava = new Curso();
		cursoJava.setTitulo("Curso Java");
		cursoJava.setDescricao("Descrição do curso Java");
		cursoJava.setCargaHoraria(40);

		Curso cursoED = new Curso();
		cursoED.setTitulo("Curso Estrutura de Dados");
		cursoED.setDescricao("Descrição do curso Estrutura de Dados");
		cursoED.setCargaHoraria(30);

		Mentoria mentoriaPOO = new Mentoria();
		mentoriaPOO.setTitulo("Mentoria POO");
		mentoriaPOO.setDescricao("Descrição mentoria POO");
		mentoriaPOO.setData(LocalDate.now());

		System.out.println(cursoJava);
		System.out.println(cursoED);
		System.out.println(mentoriaPOO);

		Bootcamp bootcampJava = new Bootcamp();
		bootcampJava.setNome("Bootcamp Java Developer");
		bootcampJava.setDescricao("Bootcamp voltado para a linguagem Java");

		System.out.println("Dados Bootcamp após criação inicial");
		System.out.println(bootcampJava);

		bootcampJava.getCapacitacoes().add(cursoJava);
		bootcampJava.getCapacitacoes().add(cursoED);
		bootcampJava.getCapacitacoes().add(mentoriaPOO);

		System.out.println("Dados Bootcamp após incluir cursos/mentorias");
		System.out.println(bootcampJava);

		Dev devPedro = new Dev();
		devPedro.setNome("Pedro");

		Dev devMarta = new Dev();
		devMarta.setNome("Marta");

		// matricular devs no BootCamp
		devPedro.inscreverBootCamp(bootcampJava);
		devMarta.inscreverBootCamp(bootcampJava);

		System.out.println("Dados Bootcamp após matricular os devs");
		System.out.println(bootcampJava);

		System.out.println("Dados devs");
		imprimirCapacitacoes(devPedro);
		imprimirCapacitacoes(devMarta);

		// realizar progressão dos devs
		devPedro.progredir();
		devMarta.progredir();

		System.out.println("Dados devs após a progressão");
		imprimirCapacitacoes(devPedro);
		imprimirCapacitacoes(devMarta);

		System.out.println(devPedro.getNome() + " - XP Atual: " + devPedro.calcularTotalXp());
		System.out.println(devMarta.getNome() + " - XP Atual: " + devMarta.calcularTotalXp());

		// realizar nova progressão do dev Pedro
		devPedro.progredir();
		System.out.println(devPedro.getNome() + " - XP Atual: " + devPedro.calcularTotalXp());

	}

	public static void imprimirCapacitacoes(Dev dev) {
		System.out.println("Capacitações " + "- dev " + dev.getNome());

		System.out.println("Inscritos:");
		dev.getCapacitacoesInscritas().forEach(System.out::println);

		System.out.println("Concluídos:");
		dev.getCapacitacoesConcluidas().forEach(System.out::println);
	}
}
