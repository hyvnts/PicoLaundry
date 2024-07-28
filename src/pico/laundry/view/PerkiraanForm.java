package pico.laundry.view;

/**
 *
 * @author misba
 */
import java.sql.Connection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pico.laundry.database.DatabaseConnection;
import pico.laundry.entity.Perkiraan;
import pico.laundry.model.PerkiraanModel;

public class PerkiraanForm extends javax.swing.JDialog {

    private Connection connection;
    private PerkiraanModel perkiraanModel;
    private PerkiraanData perkiraanData;

    public PerkiraanForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        connection = DatabaseConnection.newInstant();
        perkiraanModel = new PerkiraanModel(connection);
        perkiraanData = new PerkiraanData(parent, true);
        perkiraanData.setLocationRelativeTo(this);
    }

    private void comboTipeItemStateChanged(java.awt.event.ItemEvent evt) {
        // TODO add your handling code here:
        String tipe = String.valueOf(comboTipe.getSelectedItem());
        String kodeTipe = null;
        switch (tipe) {
            case "Kas atau bank":
                kodeTipe = "11";
                break;
            case "Piutang usaha":
                kodeTipe = "12";
                break;
            case "Harta lancar lainnya":
                kodeTipe = "13";
                break;
            case "Harta tetap":
                kodeTipe = "14";
                break;
            case "Harta lain-lain":
                kodeTipe = "15";
                break;
            case "Kartu kredit":
                kodeTipe = "21";
                break;
            case "Hutang usaha":
                kodeTipe = "22";
                break;
            case "Hutang lancar lainnya":
                kodeTipe = "23";
                break;
            case "Hutang jangka panjang":
                kodeTipe = "24";
                break;
            case "Hutang lain-lain":
                kodeTipe = "25";
                break;
            case "Modal":
                kodeTipe = "31";
                break;
            case "Pendapatan":
                kodeTipe = "41";
                break;
            case "Harga pokok penjualan":
                kodeTipe = "51";
                break;
            case "Beban":
                kodeTipe = "61";
                break;
            case "Pendapata di luar usaha":
                kodeTipe = "71";
                break;
            case "Beban di luar usaha":
                kodeTipe = "81";
                break;
            default:
                kodeTipe = "00";
                break;
        }
        textKode.setText(kodeTipe);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboTipe = new javax.swing.JComboBox<>();
        textKode = new javax.swing.JTextField();
        textNama = new javax.swing.JTextField();
        buttonBaru = new javax.swing.JButton();
        buttonSimpan = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonData = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jLabel1.setText("Tipe");

        jLabel3.setText("Kode");

        jLabel4.setText("Nama Perkiraan");

        comboTipe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kas atau bank", "Piutang usaha", "Harta lancar lainnya", "Harta tetap", "Harta lain-lain", "Kartu kredit", "Hutang usaha", "Hutang lancar lainnya", "Hutang jangka panjang", "Hutang lain-lain", "Modal", "Pendapatan", "Harga pokok penjualan", "Beban", "Pendapatan di luar usaha", "Beban di luar usaha" }));

        buttonBaru.setText("New");
        buttonBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBaruActionPerformed(evt);
            }
        });

        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonEdit.setText("Edit");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonData.setText("Data Perkiraan");
        buttonData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textNama)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonBaru)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonData))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textKode, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboTipe, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboTipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBaru)
                    .addComponent(buttonSimpan)
                    .addComponent(buttonEdit)
                    .addComponent(buttonDelete)
                    .addComponent(buttonData))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBaruActionPerformed
        comboTipe.setSelectedIndex(0);
        textKode.setText(null);
        textNama.setText(null);
        comboTipeItemStateChanged(null);
        comboTipe.requestFocus();
    }//GEN-LAST:event_buttonBaruActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        // TODO add your handling code here:
        //ubah nilai entity
        Perkiraan perkiraan = new Perkiraan();
        perkiraan.setTipe(String.valueOf(comboTipe.getSelectedItem()));
        perkiraan.setKode(textKode.getText());
        perkiraan.setNama(textNama.getText());
        try {
            //tambah data
            connection.setAutoCommit(false);
            perkiraanModel.insert(perkiraan);
            connection.commit();
            JOptionPane.showMessageDialog(this, "Data berhasil ditambah", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data gagal ditambah", "KESALAHAN", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PerkiraanForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        // TODO add your handling code here:
        Perkiraan perkiraan = new Perkiraan();
        perkiraan.setTipe(String.valueOf(comboTipe.getSelectedItem()));
        perkiraan.setKode(textKode.getText());
        perkiraan.setNama(textNama.getText());
        try {
            //tambah data
            connection.setAutoCommit(false);
            perkiraanModel.update(perkiraan);
            connection.commit();
            JOptionPane.showMessageDialog(this, "Data berhasil diubah", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data gagal diubah", "KESALAHAN", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PerkiraanForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed

        // TODO add your handling code here:
        Perkiraan perkiraan = new Perkiraan();
        perkiraan.setTipe(String.valueOf(comboTipe.getSelectedItem()));
        perkiraan.setKode(textKode.getText());        
        perkiraan.setNama(textNama.getText());
        try {
            //tambah data
            connection.setAutoCommit(false);
            perkiraanModel.delete(perkiraan);
            connection.commit();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data gagal dihapus", "KESALAHAN", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PerkiraanForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
        perkiraanData.show();
        Perkiraan perkiraan = perkiraanData.getSelectionRow();
        if (perkiraan != null) {
            comboTipe.setSelectedItem(perkiraan.getTipe());            
            textKode.setText(perkiraan.getKode());
            textNama.setText(perkiraan.getNama());
        }
    }//GEN-LAST:event_buttonDataActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PerkiraanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerkiraanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerkiraanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerkiraanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PerkiraanForm dialog = new PerkiraanForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonBaru;
    private javax.swing.JButton buttonData;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox<String> comboTipe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textKode;
    private javax.swing.JTextField textNama;
    // End of variables declaration//GEN-END:variables
}
