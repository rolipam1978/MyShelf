import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RAMIRO
 */
public class MyShelf extends javax.swing.JFrame {
    
    String tipoRegistro;
    
    PreparedStatement pstm;
    
    ResultSet rs;
    
    List<ShelfBean> Shelf;
    
    DefaultTableModel tmShelf = new DefaultTableModel(null, new String[]{"TÍTULOS"}) {

        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };

    ListSelectionModel lsmShelf;    

    /**
     * Creates new form MyShelf
     */
    public MyShelf() {
        initComponents();
        PreencheCBTipoListaInicial();
    }
    
    public void PreencheCBTipoListaInicial (){
        String sql = "select * from tipos order by tipo";
        ConexaoBD con = new ConexaoBD();
        
        try{
            con.conecta();
            con.executeSQL(sql);
            cbTipoLista.addItem("Selecione");
            
            while(con.rs.next()){
                cbTipoLista.addItem(con.rs.getString("tipo"));
            }
            
        }catch(Exception  e){
            e.printStackTrace();
        }finally{
            con.desconecta();
        }
        cbTipoLista.setSelectedItem("Selecione");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLista = new javax.swing.JTable();
        cbTipoLista = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        tfTipo = new javax.swing.JTextField();
        btTipo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfTitulo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
        tfGenero = new javax.swing.JTextField();
        btGenero = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tfAno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfArtista = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfDiretor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfAutor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taSinopse = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        taElenco = new javax.swing.JTextArea();
        btPesquisar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyShelf - Catalogador Pessoal de CDs, DVDs, Blue-Rays, Livros, etc");
        setLocation(new java.awt.Point(300, 100));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Desenvolvido por rolipam Informática");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbLista.setModel(tmShelf);
        tbLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        lsmShelf = tbLista.getSelectionModel();  
        lsmShelf.addListSelectionListener(new ListSelectionListener() {          
            public void valueChanged(ListSelectionEvent e){          
                if(!e.getValueIsAdjusting()){          
                    mostraDadosTF(tbLista);  
                }  
            }  
        });
        jScrollPane1.setViewportView(tbLista);

        cbTipoLista.setFocusable(false);

        jLabel2.setText("Selecione o Tipo de Listagem:");

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cadastro");

        jLabel4.setText("Tipo:");

        cbTipo.setEnabled(false);

        tfTipo.setEditable(false);

        btTipo.setText("Incluir");
        btTipo.setEnabled(false);
        btTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTipoActionPerformed(evt);
            }
        });

        jLabel5.setText("Título:");

        tfTitulo.setEditable(false);

        jLabel6.setText("Gênero:");

        cbGenero.setEnabled(false);

        tfGenero.setEditable(false);

        btGenero.setText("Incluir");
        btGenero.setEnabled(false);
        btGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGeneroActionPerformed(evt);
            }
        });

        jLabel7.setText("Ano:");

        tfAno.setEditable(false);

        jLabel8.setText("Artista:");

        tfArtista.setEditable(false);
        tfArtista.setToolTipText("Preencha em caso de CDs de Música");

        jLabel9.setText("Diretor:");

        tfDiretor.setEditable(false);
        tfDiretor.setToolTipText("Preencha em caso de DVDs ou Blue-Rays de Filmes");

        jLabel10.setText("Elenco:");

        jLabel11.setText("Autor:");

        tfAutor.setEditable(false);
        tfAutor.setToolTipText("Preencha em caso de Livros");

        jLabel12.setText("Sinopse:");

        btNovo.setText("Novo");
        btNovo.setToolTipText("Criar novo Cadastro");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.setToolTipText("Salvar um Novo Cadastro ou Salvar Alterações de Cadastro já Existente");
        btSalvar.setEnabled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btAlterar.setText("Aterar");
        btAlterar.setToolTipText("Alterar um Cadastro Selecionado");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.setToolTipText("Cancelar Edição ou Limpar Campos");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.setToolTipText("Exluir um Cadastro Selecionado");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        taSinopse.setEditable(false);
        taSinopse.setColumns(20);
        taSinopse.setLineWrap(true);
        taSinopse.setRows(5);
        taSinopse.setToolTipText("Preencha em caso de Filmes e Livros");
        jScrollPane2.setViewportView(taSinopse);

        taElenco.setEditable(false);
        taElenco.setColumns(20);
        taElenco.setLineWrap(true);
        taElenco.setRows(5);
        taElenco.setToolTipText("Preeencha em caso de DVDs e Blue-Rays de Filmes");
        jScrollPane3.setViewportView(taElenco);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfTitulo)
                            .addComponent(tfArtista)
                            .addComponent(tfDiretor)
                            .addComponent(tfAutor)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfAno, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbGenero, javax.swing.GroupLayout.Alignment.LEADING, 0, 150, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btGenero)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btExcluir)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btGenero, btTipo});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAlterar, btCancelar, btExcluir, btNovo, btSalvar});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTipo))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btGenero))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(tfArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(tfDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btSalvar)
                    .addComponent(btAlterar)
                    .addComponent(btCancelar)
                    .addComponent(btExcluir))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btTipo, cbTipo, tfTipo, tfTitulo});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btGenero, cbGenero, tfAno, tfArtista, tfAutor, tfDiretor, tfGenero});

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        btLimpar.setText("Limpar Pesquisa");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipoLista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btLimpar)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btPesquisar)
                            .addComponent(btLimpar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu1.setText("Arquivo");

        jMenuItem1.setMnemonic('S');
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        // Selecione um Item da Tabela
        if(tbLista.getSelectedRow() != -1){
            tipoRegistro = "editar";
            HabilitarCampos();
            btNovo.setEnabled(false);
            btSalvar.setEnabled(true);
            btAlterar.setEnabled(false);
            btExcluir.setEnabled(false);
            AtualizarCBTipo();
            AtualizarCBGenero();
            SetarTipoGenero();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um Registro na Tabela para Alterar.");
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    public void SetarTipoGenero(){
        String sql = "select tipo, genero from titulos where titulo like '"+tfTitulo.getText()+"'";
        ConexaoBD con = new ConexaoBD();
        try{
            con.conecta();
            con.executeSQL(sql);
            if(con.rs.first()){
                cbTipo.setSelectedItem(con.rs.getString("tipo"));
                cbGenero.setSelectedItem(con.rs.getString("genero"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            con.desconecta();
        }
    }
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        tipoRegistro = "novo";
        LimparCampos();
        HabilitarCampos();
        btNovo.setEnabled(false);
        btSalvar.setEnabled(true);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        AtualizarCBTipo();
        AtualizarCBGenero();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        LimparCampos();
        DesabilitarCampos();
        cbTipo.removeAllItems();
        cbGenero.removeAllItems();
        btNovo.setEnabled(true);
        btSalvar.setEnabled(false);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // Selecione um item da Tabela
        if(tbLista.getSelectedRow() != -1){
            Deletar();
            LimparCampos();
            cbTipo.removeAllItems();
            cbGenero.removeAllItems();
            tmShelf.removeRow(0);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um Registro na Tabela para Excluir.");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if(tipoRegistro.equals("novo")){
            Salvar();
        }else{
            Editar();
        }
        LimparCampos();
        DesabilitarCampos();
        btNovo.setEnabled(true);
        btSalvar.setEnabled(false);
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTipoActionPerformed
        ShelfBean sb = new ShelfBean();
        ShelfControl sc = new ShelfControl();
        sb.setTipo(tfTipo.getText());
        sc.incluirTipo(sb);
        AtualizarCBTipo();
        tfTipo.setText("");
        AtualizarCBTipoLista();
    }//GEN-LAST:event_btTipoActionPerformed

    public void AtualizarCBTipoLista(){
        String sql = "select * from tipos order by tipo";
        ConexaoBD con = new ConexaoBD();
        cbTipoLista.setSelectedIndex(-1);
        cbTipoLista.removeAllItems();
        cbTipoLista.addItem("Selecione");
        try{
            con.conecta();
            con.executeSQL(sql);

            while(con.rs.next()){
                cbTipoLista.addItem(con.rs.getString("tipo"));
            }
            
        }catch(Exception  e){
            e.printStackTrace();
        }finally{
            con.desconecta();
        }
    }
    
    private void btGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGeneroActionPerformed
        ShelfBean sb = new ShelfBean();
        ShelfControl sc = new ShelfControl();
        sb.setGenero(tfGenero.getText());
        sc.incluirGenero(sb);
        AtualizarCBGenero();
        tfGenero.setText("");
    }//GEN-LAST:event_btGeneroActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        AtualizarTBLista();
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        tmShelf.removeRow(0);
        LimparCampos();
        cbTipoLista.setSelectedItem("Selecione");
    }//GEN-LAST:event_btLimparActionPerformed

    private void LimparCampos(){
        cbTipo.removeAllItems();
        tfTipo.setText("");
        tfTitulo.setText("");
        cbGenero.removeAllItems();
        tfAno.setText("");
        tfArtista.setText("");
        tfDiretor.setText("");
        taElenco.setText("");
        tfAutor.setText("");
        taSinopse.setText("");
    }
    
    private void HabilitarCampos(){
        cbTipo.setEnabled(true);
        tfTipo.setEditable(true);
        btTipo.setEnabled(true);
        tfTitulo.setEditable(true);
        cbGenero.setEnabled(true);
        tfGenero.setEditable(true);
        btGenero.setEnabled(true);
        tfAno.setEditable(true);
        tfArtista.setEditable(true);
        tfDiretor.setEditable(true);
        taElenco.setEditable(true);
        tfAutor.setEditable(true);
        taSinopse.setEditable(true);
        cbTipo.requestFocus();
    }
    
    private void DesabilitarCampos(){
        cbTipo.setEnabled(false);
        tfTipo.setEditable(false);
        btTipo.setEnabled(false);
        tfTitulo.setEditable(false);
        cbGenero.setEnabled(false);
        tfGenero.setEditable(false);
        btGenero.setEnabled(false);
        tfAno.setEditable(false);
        tfArtista.setEditable(false);
        tfDiretor.setEditable(false);
        taElenco.setEditable(false);
        tfAutor.setEditable(false);
        taSinopse.setEditable(false);
    }
    
    private void Salvar(){
        ShelfBean sb = new ShelfBean();
        ShelfControl sc = new ShelfControl();
        sb.setTipo(String.valueOf(cbTipo.getSelectedItem()));
        sb.setTitulo(tfTitulo.getText());
        sb.setGenero(String.valueOf(cbGenero.getSelectedItem()));
        sb.setAno(tfAno.getText());
        sb.setArtista(tfArtista.getText());
        sb.setDiretor(tfDiretor.getText());
        sb.setElenco(taElenco.getText());
        sb.setAutor(tfAutor.getText());
        sb.setSinopse(taSinopse.getText());
        sc.salvar(sb);
    }
    
    private void Editar(){
        ShelfBean sb = new ShelfBean();
        ShelfControl sc = new ShelfControl();
        sb.setTipo(String.valueOf(cbTipo.getSelectedItem()));
        sb.setGenero(String.valueOf(cbGenero.getSelectedItem()));
        sb.setAno(tfAno.getText());
        sb.setArtista(tfArtista.getText());
        sb.setDiretor(tfDiretor.getText());
        sb.setElenco(taElenco.getText());
        sb.setAutor(tfAutor.getText());
        sb.setSinopse(taSinopse.getText());
        sb.setTitulo(tfTitulo.getText());
        sc.alterar(sb);
    }
    
    private void Deletar(){
        ShelfBean sb = new ShelfBean();
        ShelfControl sc = new ShelfControl();
        sb.setTitulo(tfTitulo.getText());
        sc.excluir(sb);
    }
    
    private void AtualizarCBTipo(){
        String sql = "select * from tipos order by tipo";
        ConexaoBD con = new ConexaoBD();
        cbTipo.removeAllItems();
        cbTipo.addItem("Selecione");
        try{
            con.conecta();
            con.executeSQL(sql);
            
            while(con.rs.next()){
                cbTipo.addItem(con.rs.getString("tipo"));
            }
            
            
        }catch(Exception  e){
            e.printStackTrace();
        }finally{
            con.desconecta();
        } 
    }
    
    private void AtualizarCBGenero(){
        String sql = "select * from generos order by genero";
        ConexaoBD con = new ConexaoBD();
        cbGenero.removeAllItems();
        cbGenero.addItem("Selecione");
        try{
            con.conecta();
            con.executeSQL(sql);
            while(con.rs.next()){
                cbGenero.addItem(con.rs.getString("genero"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            con.desconecta();
        }
    }
    
    private void AtualizarTBLista(){
        ShelfControl sc = new ShelfControl();
        Shelf = new ArrayList();
        String titulo;
        titulo = String.valueOf(cbTipoLista.getSelectedItem());
        Shelf = sc.listarTitulos(titulo);
        
        tbLista.getColumnModel().getColumn(0).setPreferredWidth(10);
        
        while(tmShelf.getRowCount() > 0){
            tmShelf.removeRow(0);
        }        
        
        if(Shelf.size() == 0){
            
        }else{
            String[] campos = new String[]{null};
            for (int i = 0; i < Shelf.size(); i++) {

            tmShelf.addRow(campos);
            tmShelf.setValueAt(Shelf.get(i).getTitulo(), i, 0);
            } 
        }
    }
    
    public void mostraDadosTF(JTable tb){
        if (tb.getSelectedRow() != -1) {
            cbTipo.addItem(Shelf.get(tb.getSelectedRow()).getTipo());
            tfTitulo.setText(Shelf.get(tb.getSelectedRow()).getTitulo());
            cbGenero.addItem(Shelf.get(tb.getSelectedRow()).getGenero());
            tfAno.setText(Shelf.get(tb.getSelectedRow()).getAno());
            tfArtista.setText(Shelf.get(tb.getSelectedRow()).getArtista());
            tfDiretor.setText(Shelf.get(tb.getSelectedRow()).getDiretor());
            taElenco.setText(Shelf.get(tb.getSelectedRow()).getElenco());
            tfAutor.setText(Shelf.get(tb.getSelectedRow()).getAutor());
            taSinopse.setText(Shelf.get(tb.getSelectedRow()).getSinopse());
        }
    }
    
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
            java.util.logging.Logger.getLogger(MyShelf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyShelf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyShelf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyShelf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyShelf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btGenero;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btTipo;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JComboBox<String> cbTipoLista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea taElenco;
    private javax.swing.JTextArea taSinopse;
    private javax.swing.JTable tbLista;
    private javax.swing.JTextField tfAno;
    private javax.swing.JTextField tfArtista;
    private javax.swing.JTextField tfAutor;
    private javax.swing.JTextField tfDiretor;
    private javax.swing.JTextField tfGenero;
    private javax.swing.JTextField tfTipo;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables
}
