package main;

import estudo.classes.Aluno;
import estudo.classes.Diretor;
import estudo.classes.Pessoa;
import estudo.classes.Secretario;

public class TestandoClassesFilhas {

    public static void main(String[] args) {

        Aluno aluno = new Aluno();
        aluno.setNome("Jonas");
        aluno.setIdade(16);
        aluno.setNomeEscola("JDev Treinamentos");

        Diretor diretor = new Diretor();
        diretor.setRegistroGeral("asdaf468fas54");
        diretor.setIdade(55);

        Secretario secretario = new Secretario();
        secretario.setExperiencia("Administração");
        secretario.setNumeroCpf("123456789");
        secretario.setIdade(18);

        System.out.println(aluno);
        System.out.println(diretor);
        System.out.println(secretario);

        System.out.println(aluno.pessoaMaiorIdade() + " - " + aluno.msgMaiorIdade());
        System.out.println(diretor.pessoaMaiorIdade());
        System.out.println(secretario.pessoaMaiorIdade());

        System.out.println("Salário do aluno é = " + aluno.salario());
        System.out.println("Salário do diretor é = " + diretor.salario());
        System.out.println("Salário do secretário é = " + secretario.salario());

        teste(aluno);
        teste(diretor);
        teste(secretario);

    }

    public static void teste(Pessoa pessoa) {
        System.out.println("Essa pessoa é demais = " + pessoa.getNome() + " e o salário é de = " + pessoa.salario());
    }

}
