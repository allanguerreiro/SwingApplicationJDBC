package br.hibernate.local.model;

public class Descricao {
 private String descricao;
 
 private Integer codidoDescricao;
 private Integer codigoPessoa;

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the codidoDescricao
     */
    public Integer getCodidoDescricao() {
        return codidoDescricao;
    }

    /**
     * @param codidoDescricao the codidoDescricao to set
     */
    public void setCodidoDescricao(Integer codidoDescricao) {
        this.codidoDescricao = codidoDescricao;
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
 
}
