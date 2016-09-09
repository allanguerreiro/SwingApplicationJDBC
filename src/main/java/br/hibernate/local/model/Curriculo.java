/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.hibernate.local.model;

/**
 *
 * @author Trusty
 */
public class Curriculo {
    
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String email;
    private String estado;
    private String sexo;
    private Integer codigoPessoa;
    
    private String descricao; 
    private Integer codidoDescricao;
    
    private String escolaridade;
    private String areaAtuacao;
    private String pretensaoSalarial;
    private String cargoDesejavel;
    private Integer codObjProfissional;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
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
