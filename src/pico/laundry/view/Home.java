package pico.laundry.view;

/**
 *
 * @author misba
 */
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import pico.laundry.database.DatabaseConnection;
import pico.laundry.entity.Pelanggan;
import pico.laundry.model.PelangganModel;
import pico.laundry.entity.Penerimaan;
import pico.laundry.model.PenerimaanModel;
import pico.laundry.entity.Pemesanan;
import pico.laundry.model.PemesananModel;

public class Home extends javax.swing.JFrame {

    private Connection connection;
    private FormPelanggan formPelanggan;
    private FormPemesanan formPemesanan;
    private DataPelanggan dataPelanggan;
    private PelangganModel pelangganModel;
    private FormPenerimaan formPenerimaan;
    private DataFakturTransaksi dataFaktur;
    private Pemesanan pemesanan;
    private PicoJurnalForm picojurnal;
    private DataTransaksi dataTrx;
    private PemesananModel pemesananModel;
    private PengeluaranForm pengeluaranForm;
    private DataRekanan dataRekanan;
    private PendapatanLaporan pendapatanLaporan;
    public Home() {
        initComponents();
        dataRekanan = new DataRekanan(this,true);
        dataRekanan.setLocationRelativeTo(this);
        pendapatanLaporan = new PendapatanLaporan(this,true);
        pendapatanLaporan.setLocationRelativeTo(this);
        formPelanggan = new FormPelanggan(this, true);
        formPelanggan.setLocationRelativeTo(this);
        dataFaktur = new DataFakturTransaksi(this, true);
        dataFaktur.setLocationRelativeTo(this);
        formPenerimaan = new FormPenerimaan(this, true);
        formPenerimaan.setLocationRelativeTo(this);
        formPemesanan = new FormPemesanan(this, true);
        formPemesanan.setLocationRelativeTo(this);
        dataPelanggan = new DataPelanggan(this, true);
        dataPelanggan.setLocationRelativeTo(this);
        picojurnal = new PicoJurnalForm(this, true);
        picojurnal.setLocationRelativeTo(this);
        connection = DatabaseConnection.newInstant();
        pelangganModel = new PelangganModel(connection);
        dataTrx = new DataTransaksi(this, true);
        dataTrx.setLocationRelativeTo(this);
        pengeluaranForm = new PengeluaranForm(this,true);
        pengeluaranForm.setLocationRelativeTo(this);
//        formPenerimaan = new FormPenerimaan();
        pemesananModel = new PemesananModel(connection);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        formPesanan = new javax.swing.JMenuItem();
        formPenerimaanKas = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        datatransaksimenu = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        pencatatanJurnal = new javax.swing.JMenuItem();
        menuPengeluaran = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        laporandatatransaksi = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pico Laundry Home");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(51, 102, 255));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(50, 471));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pico/laundry/view/Untitled-4pis.png"))); // NOI18N

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(252, 252, 252)
                .addComponent(jLabel1)
                .addGap(288, 288, 288)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        jMenu1.setText("Transaksi");

        formPesanan.setText("Pesanan Baru");
        formPesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formPesananActionPerformed(evt);
            }
        });
        jMenu1.add(formPesanan);

        formPenerimaanKas.setText("Penerimaan Pembayaran");
        formPenerimaanKas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formPenerimaanKasActionPerformed(evt);
            }
        });
        jMenu1.add(formPenerimaanKas);

        jMenuItem1.setText("Input Pelanggan Baru");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Data Master");

        jMenuItem3.setText("Data Pelanggan");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem5.setText("Data Faktur");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        datatransaksimenu.setText("Data Transaksi");
        datatransaksimenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datatransaksimenuActionPerformed(evt);
            }
        });
        jMenu2.add(datatransaksimenu);

        jMenuItem7.setText("Data Rekanan");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Keuangan");

        pencatatanJurnal.setText("Pencatatan Jurnal");
        pencatatanJurnal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pencatatanJurnalActionPerformed(evt);
            }
        });
        jMenu4.add(pencatatanJurnal);

        menuPengeluaran.setText("Pengeluaran");
        menuPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPengeluaranActionPerformed(evt);
            }
        });
        jMenu4.add(menuPengeluaran);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Laporan");

        jMenuItem6.setText("Laporan Pendapatan");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        laporandatatransaksi.setText("Laporan Data Transaksi");
        laporandatatransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporandatatransaksiActionPerformed(evt);
            }
        });
        jMenu3.add(laporandatatransaksi);

        jMenuItem8.setText("Laporan Neraca Saldo");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formPesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formPesananActionPerformed
        formPemesanan.show();
    }//GEN-LAST:event_formPesananActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

//        jDesktopPane1.add(formPelanggan);
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        dataPelanggan.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        dataFaktur.show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void formPenerimaanKasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formPenerimaanKasActionPerformed
        formPenerimaan.show();
    }//GEN-LAST:event_formPenerimaanKasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        formPelanggan.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void laporandatatransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporandatatransaksiActionPerformed
        HashMap parameter = new HashMap();
        Vector<HashMap> data = new Vector<HashMap>();
        for (Pemesanan transaksi : pemesananModel.getData()) {
            HashMap row = new HashMap();
            row.put("id_pemesanan", transaksi.getId_pemesanan());
            row.put("pesanan_masuk", transaksi.getPesanan_masuk());
            row.put("pesanan_selesai", transaksi.getPesanan_selesai());
            row.put("status_pesanan", transaksi.getStatus_pesanan());
            row.put("jenis_layanan", transaksi.getJenis_layanan());
            row.put("total_biaya", transaksi.getTotal_biaya());
            data.add(row);
        }
        try {
            JRDataSource dataSource = new JRBeanCollectionDataSource(data);
            InputStream file = getClass().getResourceAsStream("LaporanDataTransaksi.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(file, parameter, dataSource);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_laporandatatransaksiActionPerformed

    private void pencatatanJurnalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pencatatanJurnalActionPerformed
        // TODO add your handling code here:
        picojurnal.show();

    }//GEN-LAST:event_pencatatanJurnalActionPerformed

    private void datatransaksimenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datatransaksimenuActionPerformed
        dataTrx.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_datatransaksimenuActionPerformed

    private void menuPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPengeluaranActionPerformed
        // TODO add your handling code here:
        pengeluaranForm.show();
    }//GEN-LAST:event_menuPengeluaranActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        dataRekanan.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        HashMap parameter = new HashMap();
        Vector<HashMap> data = new Vector<HashMap>();        
        try {
            InputStream file = getClass().getResourceAsStream("NeracaSaldo.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(file, parameter, connection);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        pendapatanLaporan.show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem datatransaksimenu;
    private javax.swing.JMenuItem formPenerimaanKas;
    private javax.swing.JMenuItem formPesanan;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem laporandatatransaksi;
    private javax.swing.JMenuItem menuPengeluaran;
    private javax.swing.JMenuItem pencatatanJurnal;
    // End of variables declaration//GEN-END:variables
}