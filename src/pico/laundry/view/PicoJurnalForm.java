package pico.laundry.view;

/**
 *
 * @author misba
 */
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import pico.laundry.database.DatabaseConnection;
import pico.laundry.entity.Jurnal;
import pico.laundry.entity.JurnalDetail;
import pico.laundry.entity.Perkiraan;
import pico.laundry.model.JurnalDetailModel;
import pico.laundry.model.JurnalDetailTableModel;
import pico.laundry.model.JurnalModel;

public class PicoJurnalForm extends javax.swing.JDialog {

    private Connection connection;
    private PerkiraanData perkiraanData;
    private JurnalDetailTableModel jurnalDetailTableModel;
    private JurnalModel jurnalModel;
    private JurnalDetailModel jurnalDetailModel;

    public PicoJurnalForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        connection = DatabaseConnection.newInstant();
        perkiraanData = new PerkiraanData(null, true);
        perkiraanData.setLocationRelativeTo(this);
        jurnalDetailTableModel = new JurnalDetailTableModel(new ArrayList<JurnalDetail>());
        tableRender();
        jurnalModel = new JurnalModel(connection);
        jurnalDetailModel = new JurnalDetailModel(connection);
    }

    private void tableRender() {
        datatable.setModel(jurnalDetailTableModel);
        datatable.getColumnModel().getColumn(0).setPreferredWidth(40);
        datatable.getColumnModel().getColumn(1).setPreferredWidth(200);
        datatable.getColumnModel().getColumn(2).setPreferredWidth(60);
        datatable.getColumnModel().getColumn(3).setPreferredWidth(60);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        textJurnalNomor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textJurnalKeterangan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textJurnalTanggal = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        textPerkiraanKode = new javax.swing.JTextField();
        textPerkiraanNama = new javax.swing.JTextField();
        buttonData = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        textDebet = new javax.swing.JFormattedTextField();
        textKredit = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        buttonTambah = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        datatable = new javax.swing.JTable();
        textBalance = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        buttonSimpan = new javax.swing.JButton();
        buttonJurnal = new javax.swing.JButton();
        buttonBaru = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Jurnal Form");

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Nomor");

        jLabel3.setText("Keterangan");

        jLabel2.setText("Tanggal");

        textJurnalTanggal.setModel(new javax.swing.SpinnerDateModel());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textJurnalKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textJurnalNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(textJurnalTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textJurnalNomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(textJurnalTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textJurnalKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setText("Rekening");

        textPerkiraanKode.setEnabled(false);

        textPerkiraanNama.setEnabled(false);

        buttonData.setText("data");
        buttonData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataActionPerformed(evt);
            }
        });

        jLabel5.setText("Debet");

        textDebet.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        textDebet.setValue(0);

        textKredit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        textKredit.setValue(0);

        jLabel6.setText("Kredit");

        buttonTambah.setText("+");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textPerkiraanKode, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textPerkiraanNama, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonData))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textDebet, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(textKredit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonTambah)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPerkiraanKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPerkiraanNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonData)
                    .addComponent(textDebet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textKredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTambah))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        datatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        datatable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datatableMouseClicked(evt);
            }
        });
        datatable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                datatableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(datatable);

        textBalance.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        textBalance.setValue(0);
        textBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBalanceActionPerformed(evt);
            }
        });

        jLabel7.setText("Balance");

        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonJurnal.setText("cetak jurnal");
        buttonJurnal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJurnalActionPerformed(evt);
            }
        });

        buttonBaru.setText("New");
        buttonBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBaruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(97, 97, 97))
                            .addComponent(textBalance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonBaru)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonJurnal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonSimpan)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(8, 8, 8)
                .addComponent(textBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpan)
                    .addComponent(buttonJurnal)
                    .addComponent(buttonBaru))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed

        // TODO add your handling code here:
        Perkiraan perkiraan = new Perkiraan();
        perkiraan.setKode(textPerkiraanKode.getText());
        perkiraan.setNama(textPerkiraanNama.getText());

        JurnalDetail jurnalDetailNew = new JurnalDetail();
        jurnalDetailNew.setDebet(Integer.valueOf(String.valueOf(textDebet.getValue())));
        jurnalDetailNew.setKredit(Integer.valueOf(String.valueOf(textKredit.getValue())));
        jurnalDetailNew.setPerkiraan(perkiraan);

        boolean add = true;
        for (JurnalDetail jurnalDetailOld : jurnalDetailTableModel.getRows()) {
            String kodeOld = jurnalDetailOld.getPerkiraan().getKode();
            String kodeNew = jurnalDetailNew.getPerkiraan().getKode();
            if (kodeOld.equals(kodeNew)) {
                add = false;
                jurnalDetailOld.setDebet(jurnalDetailOld.getDebet() + jurnalDetailNew.getDebet());
                jurnalDetailOld.setKredit(jurnalDetailOld.getKredit() + jurnalDetailNew.getKredit());
                break;
            }
        }

        if (add) {
            jurnalDetailTableModel.getRows().add(jurnalDetailNew);
        }
        jurnalDetailTableModel.fireTableDataChanged();

        textPerkiraanKode.setText(null);
        textPerkiraanNama.setText(null);
        textDebet.setValue(0);
        textKredit.setValue(0);
        textBalance.setValue(cekBalance());
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void textBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBalanceActionPerformed

    private void buttonDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        perkiraanData.show();
        Perkiraan perkiraan = perkiraanData.getSelectionRow();
        if (perkiraan != null) {
            textPerkiraanKode.setText(perkiraan.getKode());
            textPerkiraanNama.setText(perkiraan.getNama());
        }
    }//GEN-LAST:event_buttonDataActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        try {
            connection.setAutoCommit(false);

            Jurnal jurnal = new Jurnal();
            jurnal.setNomor(textJurnalNomor.getText());
            jurnal.setKeterangan(textJurnalKeterangan.getText());
            jurnal.setTanggal((Date) textJurnalTanggal.getValue());
            jurnal.setTipe("JU");
            jurnalModel.insert(jurnal);

            //jurnal detail
            for (JurnalDetail detail : jurnalDetailTableModel.getRows()) {
                detail.setJurnal(jurnal);
                jurnalDetailModel.insert(detail);
            }

            connection.commit();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data gagal disimpan!", "KESALAHAN", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBaruActionPerformed
        // TODO add your handling code here:
        textJurnalNomor.setText(null);
        textJurnalTanggal.setValue(new Date());
        textJurnalKeterangan.setText(null);

        textPerkiraanKode.setText(null);
        textPerkiraanNama.setText(null);
        textDebet.setValue(0);
        textKredit.setValue(0);

        jurnalDetailTableModel.getRows().clear();
        jurnalDetailTableModel.fireTableDataChanged();
        textBalance.setValue(cekBalance());
    }//GEN-LAST:event_buttonBaruActionPerformed
    public Integer cekBalance() {
        Integer debet = 0;
        Integer kredit = 0;
        for (JurnalDetail detail : jurnalDetailTableModel.getRows()) {
            debet += detail.getDebet();
            kredit += detail.getKredit();
        }
        return debet - kredit;
    }
    private void datatableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datatableKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() != KeyEvent.VK_DELETE) {
            return;
        }
        int index = datatable.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Pilih data terlebih dahulu!", "PERINGATAN", JOptionPane.WARNING_MESSAGE);
            return;
        }

        jurnalDetailTableModel.getRows().remove(datatable.convertRowIndexToModel(index));
        jurnalDetailTableModel.fireTableDataChanged();
        textPerkiraanKode.setText(null);
        textPerkiraanNama.setText(null);
        textDebet.setValue(0);
        textBalance.setValue(cekBalance());
    }//GEN-LAST:event_datatableKeyReleased

    private void datatableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datatableMouseClicked
        // TODO add your handling code here:
        int index = datatable.getSelectedRow();
        JurnalDetail jurnalDetail = jurnalDetailTableModel.getRows().get(datatable.convertRowIndexToModel(index));
        textPerkiraanKode.setText(jurnalDetail.getPerkiraan().getKode());
        textPerkiraanNama.setText(jurnalDetail.getPerkiraan().getNama());
        textDebet.setValue(jurnalDetail.getKredit());
    }//GEN-LAST:event_datatableMouseClicked

    private void buttonJurnalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJurnalActionPerformed
        // TODO add your handling code here:
        HashMap parameter = new HashMap();
        Vector<HashMap> jurnal = new Vector<HashMap>();
        for (JurnalDetail jurnalDetail : jurnalDetailTableModel.getRows()) {
            HashMap detail = new HashMap();
            detail.put("jurnal_nomor", textJurnalNomor.getText());
            detail.put("jurnal_tanggal", (Date) textJurnalTanggal.getValue());
            detail.put("jurnal_keterangan", "(" + textJurnalKeterangan.getText() + ")");
            detail.put("jurnal_perkiraan_kode", jurnalDetail.getPerkiraan().getKode());
            detail.put("jurnal_perkiraan_nama", jurnalDetail.getPerkiraan().getNama());
            detail.put("jurnal_debit", jurnalDetail.getDebet());
            detail.put("jurnal_kredit", jurnalDetail.getKredit());
            jurnal.add(detail);
        }
        try {
            JRDataSource dataSource = new JRBeanCollectionDataSource(jurnal);
            InputStream file = getClass().getResourceAsStream("PicoJurnalUmum.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(file, parameter, dataSource);
            JasperViewer.viewReport(jasperPrint, true);
            this.dispose();
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonJurnalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PicoJurnalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PicoJurnalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PicoJurnalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PicoJurnalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PicoJurnalForm dialog = new PicoJurnalForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonJurnal;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JToggleButton buttonTambah;
    private javax.swing.JTable datatable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField textBalance;
    private javax.swing.JFormattedTextField textDebet;
    private javax.swing.JTextField textJurnalKeterangan;
    private javax.swing.JTextField textJurnalNomor;
    private javax.swing.JSpinner textJurnalTanggal;
    private javax.swing.JFormattedTextField textKredit;
    private javax.swing.JTextField textPerkiraanKode;
    private javax.swing.JTextField textPerkiraanNama;
    // End of variables declaration//GEN-END:variables
}
