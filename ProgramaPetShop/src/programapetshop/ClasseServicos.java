package programapetshop;

import java.sql.Timestamp;

public class ClasseServicos {

    //Atributos privados da classe
    private String nomeServico;
    private float precoServico;
    private String dataServico;

    public ClasseFuncionario getFuncionario() {

        return funcionario;

    }

    public void setFuncionario(ClasseFuncionario funcionario) {
        this.funcionario = funcionario;
    }
    private ClasseFuncionario funcionario;

    //Construtor da ClasseFuncionario
    public ClasseServicos(String nomeServico, float precoServico, String dataServico) {

        this.nomeServico = nomeServico;
        this.precoServico = precoServico;
        this.dataServico = dataServico;

    }

    //Getters (servem para coletar a informação do atributo)
    public String getNomeServico() {

        return nomeServico;

    }

    public float getPrecoServico() {

        return precoServico;

    }

    public String getDataServico() {

        return dataServico;

    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public void setPrecoServico(float precoServico) {
        this.precoServico = precoServico;
    }

    public void setDataServico(String dataServico) {
        this.dataServico = dataServico;
    }

}
