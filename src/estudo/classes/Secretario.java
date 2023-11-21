package estudo.classes;

import interfaces.PermitirAcesso;

public class Secretario extends Pessoa implements PermitirAcesso {

    private String registro;
    private String nivelCargo;
    private String experiencia;

    private String login;
    private String senha;

    /*Construtor com parâmetro */
    public Secretario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    /*Construtor sem parâmetro */
    public Secretario() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRegistro() {
        return registro;
    }

    public String getNivelCargo() {
        return nivelCargo;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public void setNivelCargo(String nivelCargo) {
        this.nivelCargo = nivelCargo;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public double salario() {
        return (1800.80 + (1800.80 * 0.9));
    }

    @Override
    public boolean autenticar(String login, String senha) {
        this.login = login;
        this.senha = senha;
        return autenticar();
    }

    @Override
    public boolean autenticar() {
        return login.equals("admin") && senha.equals("admin");
    }

}