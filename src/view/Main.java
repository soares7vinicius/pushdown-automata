package view;

import control.PushdownAutomaton;
import java.awt.Color;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    
    JFileChooser jfc;
    File file;
    
    List<String> list;
    PushdownAutomaton automaton;
            
    public Main() {
        initComponents();
        jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("txt", "txt", "text"));
        
        this.btnVerify.setEnabled(false);
        this.btnVerify.setEnabled(false);
        this.fldSentence.setEditable(false);
        this.fldSentence.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelAutomaton = new javax.swing.JPanel();
        panelAutomatonFile = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        fldFile = new javax.swing.JTextField();
        btnFile = new javax.swing.JButton();
        lblMsg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnVerify = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        fldSentence = new javax.swing.JTextArea();
        lblSentence = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador Autômato com Pilha");
        setResizable(false);

        panelAutomatonFile.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblTitle.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        lblTitle.setText("Simulador de Autômato com Pilha");

        fldFile.setEditable(false);
        fldFile.setText("Nenhum autômato selecionado");
        fldFile.setEnabled(false);
        fldFile.setFocusable(false);
        fldFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldFileActionPerformed(evt);
            }
        });

        btnFile.setText("Selecionar Arquivo");
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAutomatonFileLayout = new javax.swing.GroupLayout(panelAutomatonFile);
        panelAutomatonFile.setLayout(panelAutomatonFileLayout);
        panelAutomatonFileLayout.setHorizontalGroup(
            panelAutomatonFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAutomatonFileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAutomatonFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelAutomatonFileLayout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelAutomatonFileLayout.createSequentialGroup()
                        .addComponent(fldFile, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFile, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAutomatonFileLayout.setVerticalGroup(
            panelAutomatonFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAutomatonFileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAutomatonFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fldFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFile))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Verificar Sentença"));

        btnVerify.setText("Verificar");
        btnVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyActionPerformed(evt);
            }
        });

        fldSentence.setColumns(20);
        fldSentence.setLineWrap(true);
        fldSentence.setRows(5);
        jScrollPane1.setViewportView(fldSentence);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVerify, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                    .addComponent(lblSentence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSentence, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerify, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelAutomatonLayout = new javax.swing.GroupLayout(panelAutomaton);
        panelAutomaton.setLayout(panelAutomatonLayout);
        panelAutomatonLayout.setHorizontalGroup(
            panelAutomatonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAutomatonLayout.createSequentialGroup()
                .addComponent(panelAutomatonFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAutomatonLayout.setVerticalGroup(
            panelAutomatonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAutomatonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAutomatonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelAutomatonFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Autômato", panelAutomaton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Autômato");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyActionPerformed
        // TODO add your handling code here:
        
        if(automaton.process(fldSentence.getText())) {
            this.lblSentence.setText("A sentença é válida!");
            this.lblSentence.setForeground(new Color(0, 153, 0));
        } else {
            this.lblSentence.setText("A sentença não é válida!");
            this.lblSentence.setForeground(Color.red);
        }

        //this.lblStepByStep.setText(automaton.getReading());
        
    }//GEN-LAST:event_btnVerifyActionPerformed

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        // TODO add your handling code here:

        if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
            fldFile.setText(file.getName());

            this.setComponentsActiveState(true);

            list = new ArrayList<>();

            try {
                FileReader fr = new FileReader(file.getAbsolutePath());
                BufferedReader bf = new BufferedReader(fr);

                String line = bf.readLine();
                while(line != null && !line.isEmpty()) {
                    list.add(line);
                    line = bf.readLine();
                }

                automaton = new PushdownAutomaton(list);

            } catch (FileNotFoundException e) {
                this.setComponentsActiveState(false);
                this.lblMsg.setText("Arquivo não encontrado!");
                this.lblMsg.setForeground(Color.red);
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }

    }//GEN-LAST:event_btnFileActionPerformed

    private void fldFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldFileActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Main main = new Main();
            main.setLocationRelativeTo(null);
            main.setVisible(true);
        });
    }
    
    private void setComponentsActiveState(boolean bool) {
        this.btnVerify.setEnabled(bool);
        this.btnVerify.setEnabled(bool);
        this.fldSentence.setEditable(bool);
        this.fldSentence.setEnabled(bool);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFile;
    private javax.swing.JButton btnVerify;
    private javax.swing.JTextField fldFile;
    private javax.swing.JTextArea fldSentence;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblSentence;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelAutomaton;
    private javax.swing.JPanel panelAutomatonFile;
    // End of variables declaration//GEN-END:variables
}