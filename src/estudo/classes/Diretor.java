package estudo.classes;

import interfaces.PermitirAcesso;

public class Diretor extends Pessoa implements PermitirAcesso {

    private String registroEducacao;
    private int tempoDirecao;
    private String titulacao;

    private String login;
    private String senha;

    public Diretor(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Diretor(){
    }

    public String getRegistroEducacao() {
        return registroEducacao;
    }

    public int getTempoDirecao() {
        return tempoDirecao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setRegistroEducacao(String registroEducacao) {
        this.registroEducacao = registroEducacao;
    }

    public void setTempoDirecao(int tempoDirecao) {
        this.tempoDirecao = tempoDirecao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    @Override
    public String toString() {
        return "Diretor [registroEducacao=" + registroEducacao + ", tempoDirecao=" + tempoDirecao + ", titulacao="
                + titulacao + ", nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento
                + ", registroGeral=" + registroGeral + ", numeroCpf=" + numeroCpf + ", nomeMae=" + nomeMae
                + ", nomePai=" + nomePai + "]";
    }

    @Override
    public double salario() {
        return 3900.78;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        this.login = login;
        this.senha = senha;
        return autenticar();
    }

    @Override
    public boolean autenticar() {
        return login.equals("Jonas") && senha.equals("1234");
    }

}
