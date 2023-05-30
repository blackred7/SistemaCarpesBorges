/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import java.util.Date;
/**
 *
 * @author User
 */
public class Cliente {
     private int id_cliente;
    private String nome;
     private int indentificacao;
     private String premiun;
     private String email;
     private String criminal;
     private String end;
     private String rg;
     private String porte_pessoal;
     private String descricao;
     private String preferencias;
     private String historico_compra;
     private Date data_cadastro;
     private String foto;
     private int fk_usuario;
     private String sexo;

    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

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
     * @return the indentificacao
     */
    public int getIndentificacao() {
        return indentificacao;
    }

    /**
     * @param indentificacao the indentificacao to set
     */
    public void setIndentificacao(int indentificacao) {
        this.indentificacao = indentificacao;
    }

    /**
     * @return the premiun
     */
    public String getPremiun() {
        return premiun;
    }

    /**
     * @param premiun the premiun to set
     */
    public void setPremiun(String premiun) {
        this.premiun = premiun;
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
     * @return the criminal
     */
    public String getCriminal() {
        return criminal;
    }

    /**
     * @param criminal the criminal to set
     */
    public void setCriminal(String criminal) {
        this.criminal = criminal;
    }

    /**
     * @return the end
     */
    public String getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the porte_pessoal
     */
    public String getPorte_pessoal() {
        return porte_pessoal;
    }

    /**
     * @param porte_pessoal the porte_pessoal to set
     */
    public void setPorte_pessoal(String porte_pessoal) {
        this.porte_pessoal = porte_pessoal;
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
     * @return the preferencias
     */
    public String getPreferencias() {
        return preferencias;
    }

    /**
     * @param preferencias the preferencias to set
     */
    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    /**
     * @return the historico_compra
     */
    public String getHistorico_compra() {
        return historico_compra;
    }

    /**
     * @param historico_compra the historico_compra to set
     */
    public void setHistorico_compra(String historico_compra) {
        this.historico_compra = historico_compra;
    }

    /**
     * @return the data_cadastro
     */
    public Date getData_cadastro() {
        return data_cadastro;
    }

    /**
     * @param data_cadastro the data_cadastro to set
     */
    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the fk_usuario
     */
    public int getFk_usuario() {
        return fk_usuario;
    }

    /**
     * @param fk_usuario the fk_usuario to set
     */
    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
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
}
