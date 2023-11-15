package programapetshop;

public class ClasseServicos {
    
    //Atributos privados da classe
    private String nomeServico;
    private float precoServico;
    private float duracaoServico;
    private String historicoServico;

    public ClasseFuncionario getFuncionario() {
        
        return funcionario;
        
    }

    public void setFuncionario(ClasseFuncionario funcionario) {
        this.funcionario = funcionario;
    }
    private ClasseFuncionario funcionario;
    
    //Construtor da ClasseFuncionario
    public ClasseServicos(String nomeServico, float precoServico, float duracaoServico, String historicoServico) {

        this.nomeServico = nomeServico;
        this.precoServico = precoServico;
        this.duracaoServico = duracaoServico;
        this.historicoServico = historicoServico;

    }
    
    //Getters (servem para coletar a informação do atributo)
    public String getNomeServico() {
        
        return nomeServico;
        
    }
    
    public float getPrecoServico() {
        
        return precoServico;
        
    }
    
    public float getDuracaoServico() {
        
        return duracaoServico;
        
    }
    
    public String getHistoricoServico() {
        
        return historicoServico;
        
    }

}
