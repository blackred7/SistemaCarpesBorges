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
public class Vendas {
    private int id_vendas;
     private int fk_funcionario;
     private int fk_cliente;
    private Date data_hora;

    /**
     * @return the id_vendas
     */
    public int getId_vendas() {
        return id_vendas;
    }

    /**
     * @param id_vendas the id_vendas to set
     */
    public void setId_vendas(int id_vendas) {
        this.id_vendas = id_vendas;
    }

    /**
     * @return the fk_funcionario
     */
    public int getFk_funcionario() {
        return fk_funcionario;
    }

    /**
     * @param fk_funcionario the fk_funcionario to set
     */
    public void setFk_funcionario(int fk_funcionario) {
        this.fk_funcionario = fk_funcionario;
    }

    /**
     * @return the fk_cliente
     */
    public int getFk_cliente() {
        return fk_cliente;
    }

    /**
     * @param fk_cliente the fk_cliente to set
     */
    public void setFk_cliente(int fk_cliente) {
        this.fk_cliente = fk_cliente;
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
   
}
