/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author User
 */
public class Adm {
    private int idadm;
    private String nome;
     private String email;
     private int numero_tel;
     private int fk_usuario;
     private String sexo;

    /**
     * @return the idadm
     */
    public int getIdadm() {
        return idadm;
    }

    /**
     * @param idadm the idadm to set
     */
    public void setIdadm(int idadm) {
        this.idadm = idadm;
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
     * @return the numero_tel
     */
    public int getNumero_tel() {
        return numero_tel;
    }

    /**
     * @param numero_tel the numero_tel to set
     */
    public void setNumero_tel(int numero_tel) {
        this.numero_tel = numero_tel;
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
