package programapetshop;

public class ClasseCliente {

    //Atributos privados da classe    
    private String nomeCliente;
    private String CPF;
    private String enderecoCliente;
    private long telefoneCliente;

    //Construtor da ClassePessoa
    public ClasseCliente(String nome, String CPF, String enderecoCLiente, int telefoneCliente) {

        this.nomeCliente = nomeCliente;
        this.CPF = CPF;
        this.enderecoCliente = enderecoCliente;
        this.telefoneCliente = telefoneCliente;

    }

    //Getters (servem para coletar a informação do atributo)
    public String getNomeCliente() {

        return nomeCliente;

    }

    public String getCPF() {

        return CPF;

    }

    public String getEnderecoCliente() {

        return enderecoCliente;

    }

    public long getTelefoneCliente() {

        return telefoneCliente;

    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public void setTelefoneCliente(long telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
    
    

}
