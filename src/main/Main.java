package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import classesauxiliares.FuncaoAutenticacao;
import constantes.StatusAluno;
import estudo.classes.Aluno;
import estudo.classes.Diretor;
import estudo.classes.Disciplina;
import estudo.classes.Secretario;
import interfaces.PermitirAcesso;

public class Main {

	/* Método auto executável em Java */
	// @SuppressWarnings
	public static void main(String[] args) {

		try {


		String login = JOptionPane.showInputDialog("Informe o login");
		String senha = JOptionPane.showInputDialog("Informe a senha");

		/*Não vamos usar pois vair ser instanciado diretamente na condição "IF" */
		//FuncaoAutenticacao autenticacao = new FuncaoAutenticacao();

		//PermitirAcesso permitirAcesso = new Secretario(login, senha);
		
		/* Instancia e e já verifica o login pelo método autenticar */
		if (new FuncaoAutenticacao(new Diretor(login, senha)).autenticar()) { /* Se TRUE acessa, se FALSE não acessa */

			List<Aluno> alunos = new ArrayList<Aluno>();

			/*
			 * É uma lista que dentro dela tem uma chave que identifica uma sequência de
			 * valores também
			 */
			HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

			/*
			 * List<Aluno> alunosAprovados = new ArrayList<Aluno>();
			 * List<Aluno> alunosReprovados = new ArrayList<Aluno>();
			 * List<Aluno> alunosRecuperacao = new ArrayList<Aluno>();
			 */

			for (int qtd = 1; qtd <= 3; qtd++) {

				String nome = JOptionPane.showInputDialog("Qual o nome do aluno " + qtd + "?");
				/*
				 * String idade = JOptionPane.showInputDialog("Qual a idade?"); String
				 * dataNascimento =
				 * JOptionPane.showInputDialog("Qual a data de nascimento do aluno?"); String
				 * regGeral = JOptionPane.showInputDialog("Qual o número do RG do aluno?");
				 * String cpf = JOptionPane.showInputDialog("Qual o número do CPF do aluno?");
				 * String nomeMae = JOptionPane.showInputDialog("Qual o nome da mãe do aluno?");
				 * String nomePai = JOptionPane.showInputDialog("Qual o nome da pai do aluno?");
				 * String dataMatricula =
				 * JOptionPane.showInputDialog("Qual a data da matrícula do aluno?"); String
				 * nomeEscola = JOptionPane.showInputDialog("Qual o nome da escola do aluno?");
				 * String serie = JOptionPane.showInputDialog("Qual a série do aluno?");
				 */

				Aluno aluno1 = new Aluno();

				aluno1.setNome(nome);
				/*
				 * aluno1.setIdade(Integer.valueOf(idade));
				 * aluno1.setDataNascimento(dataNascimento); aluno1.setRegistroGeral(regGeral);
				 * aluno1.setNumeroCpf(cpf); aluno1.setNomeMae(nomeMae);
				 * aluno1.setNomePai(nomePai); aluno1.setDataMatricula(dataMatricula);
				 * aluno1.setNomeEscola(nomeEscola); aluno1.setSerieMatriculado(serie);
				 */

				for (int pos = 1; pos <= 2; pos++) {
					String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + pos + " ?");
					String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina " + pos + " ?");

					Disciplina disciplina = new Disciplina();

					disciplina.setDisciplina(nomeDisciplina);
					disciplina.setNota(Double.valueOf(notaDisciplina));

					aluno1.getDisciplinas().add(disciplina);
				}

				/**
				 * JOPtionPane.showConfirmDialog - Sim - 0 Não - 1
				 */

				int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");

				if (escolha == 0) {

					int continuarRemover = 0;
					int posicao = 1;

					while (continuarRemover == 0) {

						String disciplinaRemover = JOptionPane.showInputDialog("Qual disciplina 1, 2, 3 ou 4?");
						aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - 1);
						posicao++;
						continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover?");

					}
				}

				alunos.add(aluno1);
			}

			maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());

			for (Aluno aluno : alunos) {/* Separei em Listas */

				if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
					// alunosAprovados.add(aluno);
					maps.get(StatusAluno.APROVADO).add(aluno);
				} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
					// alunosRecuperacao.add(aluno);
					maps.get(StatusAluno.RECUPERACAO).add(aluno);
				} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.REPROVADO)) {
					// alunosReprovados.add(aluno);
					maps.get(StatusAluno.REPROVADO).add(aluno);
				}

			}

			System.out.println("----------------------- Lista dos Aprovados -----------------------");
			for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
				System.out.println("Aluno: " + aluno.getNome() + " - Resultado " + aluno.getAlunoAprovado2()
						+ " - com média " + aluno.getMediaNota());
			}

			System.out.println("----------------------- Lista dos Reprovados -----------------------");
			for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
				System.out.println("Aluno: " + aluno.getNome() + " - Resultado " + aluno.getAlunoAprovado2()
						+ " - com média " + aluno.getMediaNota());
			}

			System.out.println("----------------------- Lista de Recuperação -----------------------");
			for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
				System.out.println("Aluno: " + aluno.getNome() + " - Resultado " + aluno.getAlunoAprovado2()
						+ " - com média " + aluno.getMediaNota());
			}

		} else {
			JOptionPane.showMessageDialog(null, "Acesso não permitido");
		}
		
	} catch (Exception e) {
		e.printStackTrace(); /*Imprime erro no console Java*/
		JOptionPane.showMessageDialog(null, "Erro ao processar notas");
	}

	}

}
