package programapetshop;

public class ClasseServicosRealizados {

    private String historicoServicoRealizado;
    private float valoresTotais;

    public ClasseServicosRealizados(String historicoServicoRealizado, float valoresTotais) {

        this.historicoServicoRealizado = historicoServicoRealizado;
        this.valoresTotais = valoresTotais;

    }

    public String getHistoricoServicoRealizado() {

        return historicoServicoRealizado;

    }

    public float getValoresTotais() {

        return valoresTotais;

    }

    public void setHistoricoServicoRealizado(String historicoServicoRealizado) {
        this.historicoServicoRealizado = historicoServicoRealizado;
    }

    public void setValoresTotais(float valoresTotais) {
        this.valoresTotais = valoresTotais;
    }
    
    

}
