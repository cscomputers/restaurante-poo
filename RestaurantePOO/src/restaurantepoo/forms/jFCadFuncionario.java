/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jFCadFuncionario.java
 *
 * Created on 15/11/2010, 20:55:26
 */

package restaurantepoo.forms;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import restaurantepoo.dao.FuncionarioDao;
import restaurantepoo.logica.Funcionario;

/**
 *
 * @author red
 */
public class jFCadFuncionario extends javax.swing.JFrame {

    /** Creates new form jFCadFuncionario */
    public jFCadFuncionario() throws SQLException {
        initComponents();
        populaTabela("");
    }

   DefaultTableModel tmFuncionario = new DefaultTableModel(
            new Object [][]{
            },
            new String[]{"funcionario","nome"});

    private List<Funcionario> funcionarios;
    ListSelectionModel lsmFuncionario;

    public void populaTabela(String busca) throws SQLException{

        FuncionarioDao fd = new FuncionarioDao();
        funcionarios = fd.getLista("%"+busca+"%");

        for (Funcionario f1 : funcionarios) {
            insereTabela(f1);
        }
    }

    public void insereTabela(Funcionario f1){

        tmFuncionario.addRow(new String[]{
            String.valueOf(f1.getFuncionario()),
            f1.getNome(),
        });
    }

     private void novoCadastro(){

        Funcionario f1 = new Funcionario();

        preencherObjeto(f1);

         try {
            FuncionarioDao dao = new FuncionarioDao();
            dao.adiciona(f1);
            tmFuncionario.setNumRows(0);
            populaTabela("");
        } catch (SQLException ex) {
            Logger.getLogger(jFCadFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     private void preencherObjeto(Funcionario f1){
       
        f1.setCpf(cpf.getText());
        f1.setNome(nome.getText());
        f1.setEndereco(endereco.getText());
        f1.setTelefone(telefone.getText());
        f1.setSalario(Float.parseFloat(salario.getText()));
        f1.setFuncao(funcao.getSelectedItem().toString());
          
     }

     private void alteraCadastro (){
        Funcionario f1 = new Funcionario();
        f1.setFuncionario(Integer.parseInt(id.getText()));
        preencherObjeto(f1);

        try {
            FuncionarioDao dao = new FuncionarioDao();
            dao.altera(f1);
            tmFuncionario.setNumRows(0);
            populaTabela("");
        } catch (SQLException ex) {
            Logger.getLogger(jFCadProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

     private void limparCampos(){
        id.setText("");
        nome.setText("");
        cpf.setText("");
        endereco.setText("");
        telefone.setText("");
        funcao.setSelectedItem("Caixa");
        salario.setText("");
    }

    private void escolherLinha(){

        int linha = tabela.getSelectedRow();
        System.out.println(linha);

        Funcionario f1 = new Funcionario();
        String temp;

        temp = String.valueOf(tabela.getValueAt(linha, 0));
        f1.setFuncionario(Integer.parseInt(temp));

        preencherCampos(f1);

    }

    private void preencherCampos(Funcionario f1){
        System.out.println(f1);

        try {
            FuncionarioDao dao = new FuncionarioDao();
            dao.busca(f1);
        } catch (SQLException ex) {
            Logger.getLogger(jFCadFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(f1);

        id.setEditable(true);
        id.setText(String.valueOf(f1.getFuncionario()));
        id.setEditable(false);

        nome.setText(f1.getNome());
        cpf.setText(String.valueOf(f1.getCpf()));
        endereco.setText(f1.getEndereco());
        telefone.setText(f1.getTelefone());
        funcao.setSelectedItem(f1.getFuncao());
        salario.setText(String.valueOf(f1.getSalario()));

    }


     private boolean verificaStrings(){

        if (!nome.getText().equals("") && !cpf.getText().equals("") && !salario.getText().equals("") && !funcao.getSelectedItem().equals("")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Campos obrigatórios não preenchidos");
            return false;
        }
    }

     private boolean verificaDouble(){
        double temp;
        try{
            temp = Double.valueOf(salario.getText());
            return true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Campo de salario deve ter o formato \"9999.99\"");
            return false;
        }
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nome = new javax.swing.JTextField();
        cpf = new javax.swing.JTextField();
        telefone = new javax.swing.JTextField();
        salario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        salvar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        funcao = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        atualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        endereco = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nome.setNextFocusableComponent(cpf);
        jPanel1.add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 270, -1));

        cpf.setNextFocusableComponent(endereco);
        jPanel1.add(cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 146, -1));

        telefone.setNextFocusableComponent(funcao);
        jPanel1.add(telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 194, -1));

        salario.setNextFocusableComponent(atualizar);
        jPanel1.add(salario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 132, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("CPF:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Endereço:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel4.setText("Telefone:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel5.setText("Função:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel6.setText("Salário:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        salvar.setText("Salvar");
        salvar.setNextFocusableComponent(cancelar);
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });
        jPanel1.add(salvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, -1));

        cancelar.setText("Cancelar");
        cancelar.setNextFocusableComponent(nome);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel7.setText("Cadastro de Funcionário");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        funcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Caixa", "Garçon(ete)", "Gerente", "Cozinheiro(a)", "Lavador(a) de Pratos" }));
        funcao.setNextFocusableComponent(salario);
        jPanel1.add(funcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 194, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Personal-information-48.png"))); // NOI18N
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 49));

        tabela.setModel(tmFuncionario);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 213, 230));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel8.setText("Funcionários Existentes");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, 22));
        jLabel8.getAccessibleContext().setAccessibleName("");

        jTextPane1.setBackground(new java.awt.Color(240, 240, 240));
        jTextPane1.setEditable(false);
        jTextPane1.setText("Clique sobre o nome para editar os dados.");
        jScrollPane3.setViewportView(jTextPane1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 213, -1));

        atualizar.setText("Atualizar");
        atualizar.setEnabled(false);
        atualizar.setNextFocusableComponent(salvar);
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });
        jPanel1.add(atualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        endereco.setColumns(20);
        endereco.setRows(5);
        endereco.setName("endereco"); // NOI18N
        endereco.setNextFocusableComponent(telefone);
        jScrollPane2.setViewportView(endereco);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 270, 100));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Número:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 60, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
   //     if (verificaDados()){
            novoCadastro();
   //         limparCampos();
   //         desabilitaDados();
        //}
    }//GEN-LAST:event_salvarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_atualizarActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        escolherLinha();
        atualizar.setEnabled(true);
        salvar.setEnabled(false);
    }//GEN-LAST:event_tabelaMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new jFCadFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cpf;
    private javax.swing.JTextArea endereco;
    private javax.swing.JComboBox funcao;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField salario;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField telefone;
    // End of variables declaration//GEN-END:variables

}