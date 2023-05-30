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
public class Produto_compra {
    private  int idproduto_compra;
     private int fk_produto;
     private int fk_compra;
    private Date data_hora;
     private int valor_total;
     private int valor_unitario;
     private int quantidade;

    /**
     * @return the fk_produto
     */
    public int getFk_produto() {
        return fk_produto;
    }

    /**
     * @param fk_produto the fk_produto to set
     */
    public void setFk_produto(int fk_produto) {
        this.fk_produto = fk_produto;
    }

    /**
     * @return the fk_compra
     */
    public int getFk_compra() {
        return fk_compra;
    }

    /**
     * @param fk_compra the fk_compra to set
     */
    public void setFk_compra(int fk_compra) {
        this.fk_compra = fk_compra;
    }

    /**
     * @return the data_hora
     */
    public Date getData_hora() {
        return data_hora;
    }

    /**
     * @param data_hora the data_hora to set
     */
    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    /**
     * @return the valor_total
     */
    public int getValor_total() {
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValor_total(int valor_total) {
        this.valor_total = valor_total;
    }

    /**
     * @return the valor_unitario
     */
    public int getValor_unitario() {
        return valor_unitario;
    }

    /**
     * @param valor_unitario the valor_unitario to set
     */
    public void setValor_unitario(int valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the idproduto_compra
     */
    public int getIdproduto_compra() {
        return idproduto_compra;
    }

    /**
     * @param idproduto_compra the idproduto_compra to set
     */
    public void setIdproduto_compra(int idproduto_compra) {
        this.idproduto_compra = idproduto_compra;
    }
}
