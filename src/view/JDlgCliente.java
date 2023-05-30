/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Cliente;
import dao.ClienteDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author u04127224290
 */
public class JDlgCliente extends javax.swing.JDialog {
 boolean incl; 
  MaskFormatter maskdata;
    /**
     * Creates new form JDlgUsuarios
     */
    public JDlgCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Clientes");
        setLocationRelativeTo(null);
        desabilitar();
        try {
            maskdata = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtData.setFormatterFactory(new DefaultFormatterFactory(maskdata));
    }
    
    public void limparCampos() {
        jTxtNome.setText("");
        jTxtCodigo.setText("");
        JTxtRG.setText("");
        jFmtData.setText("");
         JTxtEmail.setText("");
        jChbPremiun.setText("");
        jCboFk.setSelectedIndex(-1);
        JTxtEndereco.setText("");
         JTxtPortePessoal.setText("");
          JTxtDescricao.setText("");
          JTxtPreferencias.setText("");
          JTxtHistoticoCompras.setText("");
          JTxtSexo.setText("");
        jCboIndentificacao.setSelectedIndex(-1);
        jChbPremiun.setSelected(false);
        jChbCriminal.setSelected(false);
    }
    
    public void habilitar () {
        jTxtCodigo.setEnabled(true);
        jTxtNome.setEnabled(true);
        JTxtSexo.setEnabled(true);
        JTxtRG.setEnabled(true);
      
        jFmtData.setEnabled(true);
        jChbPremiun.setEnabled(true);
        jChbCriminal.setEnabled(true);
        jCboIndentificacao.setEnabled(true);
        JTxtEmail.setEnabled(true);
        JTxtHistoticoCompras.setEnabled(true);
        jBtnConfirmar.setEnabled(true);
        jBtnCancelar.setEnabled(true);
        JTxtEndereco.setEnabled(true);
        JTxtPortePessoal.setEnabled(true);
         JTxtDescricao.setEnabled(true);
         JTxtPreferencias.setEnabled(true);
         jCboFk.setEnabled(true);
        jBtnIncluir.setEnabled(false);
        jBtnAlterar.setEnabled(false);
        jBtnExcluir.setEnabled(false);
        jBtnPesquisar.setEnabled(false);
    }
    
    public void desabilitar() {
             
        jTxtCodigo.setEnabled(false);
        jTxtNome.setEnabled(false);
        JTxtSexo.setEnabled(false);
        JTxtRG.setEnabled(false);
       
        jFmtData.setEnabled(false);
        jChbPremiun.setEnabled(false);
        jChbCriminal.setEnabled(false);
        jCboIndentificacao.setEnabled(false);
        JTxtEmail.setEnabled(false);
        JTxtHistoticoCompras.setEnabled(false);
        jBtnConfirmar.setEnabled(false);
        jBtnCancelar.setEnabled(false);
        JTxtEndereco.setEnabled(false);
        JTxtPortePessoal.setEnabled(false);
         JTxtDescricao.setEnabled(false);
         JTxtPreferencias.setEnabled(false);
         jCboFk.setEnabled(false);
          jBtnIncluir.setEnabled(true);
        jBtnAlterar.setEnabled(true);
        jBtnExcluir.setEnabled(true);
        jBtnPesquisar.setEnabled(true);
    }
     public Cliente viawbean(){
      //int\/
        Cliente cliente = new Cliente();
        int id = Integer.valueOf(jTxtCodigo.getText());
        cliente.setId_cliente(id);
        
        
         //string\/
        cliente.setNome(jTxtNome.getText());
        cliente.setEmail(JTxtEmail.getText());
        cliente.setEnd(JTxtEndereco.getText());
         cliente.setDescricao(JTxtDescricao.getText());
        cliente.setPorte_pessoal(JTxtPortePessoal.getText());
        cliente.setPreferencias(JTxtPreferencias.getText());
        cliente.setRg(JTxtRG.getText());
         cliente.setHistorico_compra(JTxtHistoticoCompras.getText());
         cliente.setSexo(JTxtSexo.getText());
         
         //iindex\/
        cliente.setIndentificacao(jCboIndentificacao.getSelectedIndex());
        cliente.setFk_usuario(1);
         //selected/boolean
        if (jChbPremiun.isSelected()== true) {
            cliente.setPremiun("S");
        }else{cliente.setPremiun("N");}
        if (jChbCriminal.isSelected()== true) {
            cliente.setCriminal("S");
        }else{cliente.setCriminal("N");}
       
         //data\/
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        jFmtData.getText();
        try {
          cliente.setData_cadastro(formato.parse(jFmtData.getText()));
           } catch (ParseException ex) {
        System.out.println("Erro:" + ex.getMessage());
            }
        
        return cliente;
    }
    public Cliente beanviaw(Cliente cliente){
         //int\/
       jTxtCodigo.setText( String.valueOf(cliente.getId_cliente() ) );
       
        //string\/
       jTxtNome.setText(cliente.getNome());
        JTxtEmail.setText(cliente.getEmail());
         JTxtEndereco.setText(cliente.getEnd());
         JTxtEmail.setText(cliente.getEmail());
        JTxtDescricao.setText(cliente.getDescricao());
         JTxtPortePessoal.setText(cliente.getPorte_pessoal());
         JTxtPreferencias.setText(cliente.getPreferencias());
        JTxtRG.setText(cliente.getRg());
         JTxtSexo.setText(cliente.getSexo());
         JTxtHistoticoCompras.setText(cliente.getHistorico_compra());
          //index\/
       jCboIndentificacao.setSelectedIndex(cliente.getIndentificacao());
       jCboFk.setSelectedIndex(cliente.getFk_usuario());
       //selected/boolean
       if (cliente.getPremiun().equals("S")) {
            jChbPremiun.setSelected(true);
       }else{jChbPremiun.setSelected(false);}
       if (cliente.getCriminal().equals("S")) {
            jChbCriminal.setSelected(true);
       }else{jChbCriminal.setSelected(false);}
        //data\/
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        jFmtData.setText(formato.format(cliente.getData_cadastro()));
        return cliente;
      
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTxtCodigo = new javax.swing.JTextField();
        jTxtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTxtRG = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jFmtData = new javax.swing.JFormattedTextField();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        JTxtSexo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JTxtEndereco = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTxtDescricao = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        JTxtPortePessoal = new javax.swing.JTextField();
        jChbPremiun = new javax.swing.JCheckBox();
        jCboIndentificacao = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTxtPreferencias = new javax.swing.JTextArea();
        jChbCriminal = new javax.swing.JCheckBox();
        JTxtEmail = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTxtHistoticoCompras = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jCboFk = new javax.swing.JComboBox<>();

        jLabel4.setText("Apelido");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código");

        jTxtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodigoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        JTxtRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxtRGActionPerformed(evt);
            }
        });

        jLabel3.setText("RG");

        jFmtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtDataActionPerformed(evt);
            }
        });

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ok_1.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar_1.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        JTxtSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxtSexoActionPerformed(evt);
            }
        });

        jLabel10.setText("sexo");

        jLabel8.setText("Endereço");

        jLabel11.setText("Descrição");

        JTxtDescricao.setColumns(20);
        JTxtDescricao.setRows(5);
        jScrollPane1.setViewportView(JTxtDescricao);

        jLabel12.setText("Porte pessoal");

        JTxtPortePessoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxtPortePessoalActionPerformed(evt);
            }
        });

        jChbPremiun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChbPremiunActionPerformed(evt);
            }
        });

        jCboIndentificacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pessoa", "Empresa" }));
        jCboIndentificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboIndentificacaoActionPerformed(evt);
            }
        });

        jLabel9.setText("Indentificação");

        jLabel13.setText("preferencias");

        JTxtPreferencias.setColumns(20);
        JTxtPreferencias.setRows(5);
        jScrollPane2.setViewportView(JTxtPreferencias);

        jChbCriminal.setText("Historico criminal");

        JTxtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxtEmailActionPerformed(evt);
            }
        });

        jLabel7.setText("email");

        jLabel14.setText("Premium");

        jLabel15.setText("Historico de compras");

        JTxtHistoticoCompras.setColumns(20);
        JTxtHistoticoCompras.setRows(5);
        jScrollPane3.setViewportView(JTxtHistoticoCompras);

        jLabel16.setText("Data de cadastro");

        jCboFk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jBtnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnExcluir)
                        .addGap(41, 41, 41)
                        .addComponent(jBtnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jBtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jBtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jChbPremiun)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCboFk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7)
                            .addComponent(JTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JTxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jChbCriminal))
                                    .addComponent(jLabel16)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jCboIndentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(JTxtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(97, 97, 97)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTxtPortePessoal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jChbPremiun)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCboFk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))))))
                .addGap(5, 5, 5)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCboIndentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTxtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTxtPortePessoal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChbCriminal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        // TODO add your handling code here:
        habilitar();
        limparCampos();
          incl= true;
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        // TODO add your handling code here:
        habilitar();
        incl= false;
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
        int resp =  JOptionPane.showConfirmDialog(null,  "deseja excluir?", "Pergunta", JOptionPane.YES_NO_OPTION);
       if(resp == JOptionPane.YES_OPTION){
      Cliente cliente = viawbean();
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.delete(cliente);
      }else{
           JOptionPane.showMessageDialog(null, "exclusão cancelada");
           desabilitar();
          
       }
        
        limparCampos();       
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        // TODO add your handling code here:
          if (incl ==true) {
             Cliente cliente = viawbean();
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.insert(cliente);
        }else{ 
             Cliente cliente = viawbean();
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.update(cliente);}
        
        
        desabilitar();
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
         desabilitar();
     
        JOptionPane.showMessageDialog(null, "operação cancelada");
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
         String resp =  JOptionPane.showInputDialog(null, "Insira a chave primaria", "pesquisa");
        

        ClienteDAO clienteDAO = new ClienteDAO();
          int id = Integer.valueOf(resp);
          
            Cliente cliente= (Cliente) clienteDAO.list(id);
         
          beanviaw(cliente);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void JTxtRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxtRGActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_JTxtRGActionPerformed

    private void jTxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigoActionPerformed

    private void JTxtSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxtSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxtSexoActionPerformed

    private void JTxtPortePessoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxtPortePessoalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxtPortePessoalActionPerformed

    private void JTxtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxtEmailActionPerformed

    private void jChbPremiunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChbPremiunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jChbPremiunActionPerformed

    private void jFmtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtDataActionPerformed

    private void jCboIndentificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboIndentificacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboIndentificacaoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgCliente dialog = new JDlgCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JTxtDescricao;
    private javax.swing.JFormattedTextField JTxtEmail;
    private javax.swing.JTextField JTxtEndereco;
    private javax.swing.JTextArea JTxtHistoticoCompras;
    private javax.swing.JTextField JTxtPortePessoal;
    private javax.swing.JTextArea JTxtPreferencias;
    private javax.swing.JTextField JTxtRG;
    private javax.swing.JTextField JTxtSexo;
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<String> jCboFk;
    private javax.swing.JComboBox<String> jCboIndentificacao;
    private javax.swing.JCheckBox jChbCriminal;
    private javax.swing.JCheckBox jChbPremiun;
    private javax.swing.JFormattedTextField jFmtData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtNome;
    // End of variables declaration//GEN-END:variables
}
