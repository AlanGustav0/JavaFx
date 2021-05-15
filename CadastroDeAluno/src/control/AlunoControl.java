package control;

import java.util.ArrayList;
import java.util.List;

import entity.Aluno;

public class AlunoControl {

	private List<Aluno> alunos = new ArrayList<>();

	public void adicionaAluno(Aluno aluno) {

		alunos.add(aluno);

	}

	public Aluno pesquisaPorNome(String nome) {

		for (Aluno aluno : alunos) {
			if (aluno.getNome().contains(nome)) {
				return aluno;
			}
		}
		return null;
	}

}
