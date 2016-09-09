package br.hibernate.local.model;



public class ObjetivoProfissional {
 
    private String escolaridade;
    private String areaAtuacao;
    private String pretensaoSalarial;
    private String cargoDesejavel;
 
    private Integer codigoPessoa;
    private Integer codObjProfissional;

    /**
     * @return the escolaridade
     */
    public String getEscolaridade() {
        return escolaridade;
    }

    /**
     * @param escolaridade the escolaridade to set
     */
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    /**
     * @return the areaAtuacao
     */
    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    /**
     * @param areaAtuacao the areaAtuacao to set
     */
    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    /**
     * @return the pretensaoSalarial
     */
    public String getPretensaoSalarial() {
        return pretensaoSalarial;
    }

    /**
     * @param pretensaoSalarial the pretensaoSalarial to set
     */
    public void setPretensaoSalarial(String pretensaoSalarial) {
        this.pretensaoSalarial = pretensaoSalarial;
    }

    /**
     * @return the cargoDesejavel
     */
    public String getCargoDesejavel() {
        return cargoDesejavel;
    }

    /**
     * @param cargoDesejavel the cargoDesejavel to set
     */
    public void setCargoDesejavel(String cargoDesejavel) {
        this.cargoDesejavel = cargoDesejavel;
    }

    /**
     * @return the codigoPessoa
     */
    public Integer getCodigoPessoa() {
        return codigoPessoa;
    }

    /**
     * @param codigoPessoa the codigoPessoa to set
     */
    public void setCodigoPessoa(Integer codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    /**
     * @return the codObjProfissional
     */
    public Integer getCodObjProfissional() {
        return codObjProfissional;
    }

    /**
     * @param codObjProfissional the codObjProfissional to set
     */
    public void setCodObjProfissional(Integer codObjProfissional) {
        this.codObjProfissional = codObjProfissional;
    }

}
