package pico.laundry.view;

/**
 *
 * @author misba
 */
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import pico.laundry.database.DatabaseConnection;
import pico.laundry.entity.Jurnal;
import pico.laundry.entity.JurnalDetail;
import pico.laundry.entity.Pengeluaran;
import pico.laundry.entity.PengeluaranDetail;
import pico.laundry.entity.Pelanggan;
import pico.laundry.entity.Perkiraan;
import pico.laundry.entity.Rekanan;
import pico.laundry.model.JurnalDetailModel;
import pico.laundry.model.JurnalModel;
import pico.laundry.model.PengeluaranDetailModel;
import pico.laundry.model.PengeluaranDetailTableModel;
import pico.laundry.model.PengeluaranModel;
import pico.laundry.model.PerkiraanComboBoxModel;
import pico.laundry.model.PerkiraanKasModel;
import pico.laundry.model.PerkiraanBebanModel;

public class PengeluaranForm extends javax.swing.JDialog {

    private Connection connection;
    private DataPelanggan pelangganData;
    private PerkiraanKasModel perkiraanKasModel;
    private DataRekanan rekananData;
    private PerkiraanComboBoxModel perkiraanKasComboBoxModel;
    private PerkiraanBebanModel perkiraanBebanModel;
    private PerkiraanComboBoxModel perkiraanBebanComboBoxModel;
    private PengeluaranDetailTableModel pengeluaranDetailTableModel;
    private PengeluaranModel pengeluaranModel;
    private PengeluaranDetailModel pengeluaranDetailModel;
    private Jurnal jurnal;
    private JurnalDetail jurnalDetail;
    private JurnalModel jurnalModel;
    private JurnalDetailModel jurnalDetailModel;

    public PengeluaranForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        connection = DatabaseConnection.newInstant();
        pelangganData = new DataPelanggan(null, true);
        pelangganData.setLocationRelativeTo(this);
        perkiraanKasModel = new PerkiraanKasModel(connection);
        perkiraanKasComboBoxModel = new PerkiraanComboBoxModel(connection);
        comboKas.setModel(perkiraanKasComboBoxModel);
        rekananData= new DataRekanan(null,true);
        rekananData.setLocationRelativeTo(this);
        perkiraanBebanModel = new PerkiraanBebanModel(connection);
        perkiraanBebanComboBoxModel = new PerkiraanComboBoxModel(connection);
        comboBeban.setModel(perkiraanBebanComboBoxModel);
        pengeluaranDetailTableModel = new PengeluaranDetailTableModel(new ArrayList<PengeluaranDetail>());
        pengeluaranModel = new PengeluaranModel(connection);
        
        jurnalModel = new JurnalModel(connection);
        jurnalDetailModel = new JurnalDetailModel(connection);
        pengeluaranDetailModel = new PengeluaranDetailModel(connection);
        tableRender();
        buttonBaruActionPerformed(null);
    }

    private void tableRender() {
        datatable.setModel(pengeluaranDetailTableModel);
        //pengaturan kolom
        datatable.getColumnModel().getColumn(0).setPreferredWidth(40);
        datatable.getColumnModel().getColumn(1).setPreferredWidth(600);
        datatable.getColumnModel().getColumn(2).setPreferredWidth(60);
        datatable.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public void setValue(Object value) {
                NumberFormat formatter
                        = NumberFormat.getInstance();
                setText((value == null) ? "0"
                        : formatter.format(value));
                setHorizontalAlignment(RIGHT);
            }
        });
    }

    public Integer getTotal() {
        Integer jumlah = 0;
        for (PengeluaranDetail detail
                : pengeluaranDetailTableModel.getRows()) {
            jumlah += detail.getJumlah();
        }
        return jumlah;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textNomor = new javax.swing.JTextField();
        textRekananNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        buttonData = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textCatatan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textTanggal = new javax.swing.JSpinner();
        textRekananKode = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comboKas = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        comboBeban = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        textBebanKeterangan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textBebanJumlah = new javax.swing.JFormattedTextField();
        butonTambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        datatable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        textTotal = new javax.swing.JFormattedTextField();
        buttonSimpan = new javax.swing.JButton();
        buttonBaru = new javax.swing.JButton();
        buttonCetak = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pengeluaran");

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PICO LAUNDRY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Nomor");

        jLabel3.setText("Diterima Oleh");

        buttonData.setText("Data");
        buttonData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDataActionPerformed(evt);
            }
        });

        jLabel4.setText("Catatan");

        jLabel5.setText("Tanggal");

        textTanggal.setModel(new javax.swing.SpinnerDateModel());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textRekananKode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(292, 292, 292)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(textRekananNama, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(textNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(textCatatan, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNomor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCatatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textRekananNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonData)
                    .addComponent(textTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textRekananKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setText("Diterima Oleh");

        comboKas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(comboKas, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboKas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setText("Rekening Beban");

        comboBeban.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Keterangan");

        jLabel9.setText("Jumlah");

        textBebanJumlah.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        textBebanJumlah.setValue(0);

        butonTambah.setText("Add");
        butonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(comboBeban, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textBebanKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(166, 166, 166)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(textBebanJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butonTambah, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBeban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBebanKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBebanJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butonTambah))
                .addContainerGap())
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
        jScrollPane1.setViewportView(datatable);

        jLabel10.setText("Total");

        textTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        textTotal.setEnabled(false);
        textTotal.setValue(0);

        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonBaru.setText("New");
        buttonBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBaruActionPerformed(evt);
            }
        });

        buttonCetak.setText("Cetak bukti pengeluaran");
        buttonCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCetakActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("misbakhulhanif 22.120.0026");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCetak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBaru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonSimpan)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpan)
                    .addComponent(buttonBaru)
                    .addComponent(buttonCetak)
                    .addComponent(jLabel11))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDataActionPerformed
        // TODO add your handling code here:

        rekananData.show();
        Rekanan rekanan = rekananData.getSelectionRow();
        if (rekanan == null) {
            return;
        }
        textRekananNama.setText(rekanan.getNama());
        textRekananKode.setText(rekanan.getKode());

    }//GEN-LAST:event_buttonDataActionPerformed

    private void butonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonTambahActionPerformed
        PengeluaranDetail kasKeluarDetail = new PengeluaranDetail();
        Perkiraan perkiraan = perkiraanBebanComboBoxModel.getData().get(comboBeban.getSelectedIndex());
        kasKeluarDetail.setPerkiraan_beban(perkiraan);
        kasKeluarDetail.setKeterangan(textBebanKeterangan.getText());
        kasKeluarDetail.setJumlah(Integer.valueOf(textBebanJumlah.getValue().toString()));
        pengeluaranDetailTableModel.getRows().add(kasKeluarDetail);
        pengeluaranDetailTableModel.fireTableDataChanged();
        comboBeban.setSelectedIndex(0);
        textBebanKeterangan.setText(null);
        textBebanJumlah.setValue(0);
        textTotal.setValue(getTotal());
    }//GEN-LAST:event_butonTambahActionPerformed

    private void buttonBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBaruActionPerformed
        // TODO add your handling code here:
        textNomor.setText(null);
        textTanggal.setValue(new Date());
        textRekananNama.setText(null);
        textCatatan.setText(null);
        perkiraanKasComboBoxModel.setData(perkiraanKasModel.getData());
        comboKas.setSelectedIndex(0);
        perkiraanBebanComboBoxModel.setData(perkiraanBebanModel.getData());
        comboBeban.setSelectedIndex(0);
        textBebanKeterangan.setText(null);
        textBebanJumlah.setValue(0);
        pengeluaranDetailTableModel.getRows().clear();
        pengeluaranDetailTableModel.fireTableDataChanged();
        textTotal.setValue(getTotal());
        textNomor.requestFocus();
    }//GEN-LAST:event_buttonBaruActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
       try {
            connection.setAutoCommit(false);
            Pengeluaran kasKeluar = new Pengeluaran();
            kasKeluar.setNomor(textNomor.getText());
            kasKeluar.setTanggal((Date) textTanggal.getValue());
            Perkiraan perkiraanKas = perkiraanKasComboBoxModel.getData().get(comboKas.getSelectedIndex());
            kasKeluar.setPerkiraan_kas(perkiraanKas);
            Rekanan rekanan = new Rekanan();
            rekanan.setKode(textRekananKode.getText());
            rekanan.setKode(textRekananNama.getText());
            kasKeluar.setRekanan(rekanan);
            kasKeluar.setTotal(Integer.valueOf(textTotal.getValue().toString()));
            kasKeluar.setCatatan(textCatatan.getText());
            pengeluaranModel.insert(kasKeluar);
            Jurnal jurnal = new Jurnal();
            jurnal.setNomor(kasKeluar.getNomor());
            jurnal.setKeterangan(kasKeluar.getCatatan());
            jurnal.setTanggal(kasKeluar.getTanggal());
            jurnal.setTipe("JKK");
            jurnalModel.insert(jurnal);
            JurnalDetail jurnalDebet = new JurnalDetail();
            jurnalDebet.setDebet(0);
            jurnalDebet.setKredit(kasKeluar.getTotal());
            jurnalDebet.setPerkiraan(kasKeluar.getPerkiraan_kas());
            jurnalDebet.setJurnal(jurnal);
            jurnalDetailModel.insert(jurnalDebet);
            for (PengeluaranDetail detailKas : pengeluaranDetailTableModel.getRows()) {
                detailKas.setKas_keluar(kasKeluar);
                pengeluaranDetailModel.insert(detailKas);
                JurnalDetail jurnalKredit = new JurnalDetail();
                jurnalKredit.setDebet(detailKas.getJumlah());
                jurnalKredit.setKredit(0);
                jurnalKredit.setPerkiraan(detailKas.getPerkiraan_beban());
                jurnalKredit.setJurnal(jurnal);
                jurnalDetailModel.insert(jurnalKredit);
            }
            connection.commit();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data gagal disimpan!", "KESALAHAN", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void buttonCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCetakActionPerformed
        // TODO add your handling code here:
        HashMap parameter = new HashMap();
        Vector<HashMap> jurnal = new Vector<HashMap>();
        for (PengeluaranDetail kasKeluarDetail : pengeluaranDetailTableModel.getRows()) {
            HashMap detail = new HashMap();
            detail.put("kas_keluar_nomor", textNomor.getText());
            detail.put("kas_keluar_tanggal",(Date) textTanggal.getValue());
            detail.put("kas_keluar_rekanan_nama",textRekananNama.getText());
            detail.put("kas_keluar_catatan",textCatatan.getText());
            Perkiraan rekeningKas = perkiraanKasComboBoxModel.getData().get(comboKas.getSelectedIndex());
            detail.put("kas_keluar_rekening_kas", rekeningKas.getKode());
            detail.put("kas_keluar_total", Integer.valueOf(textTotal.getValue().toString()));
            detail.put("kas_keluar_detail_rekening_beban", kasKeluarDetail.getPerkiraan_beban().getKode());
            detail.put("kas_keluar_detail_keterangan", kasKeluarDetail.getKeterangan());
            detail.put("kas_keluar_detail_jumlah", kasKeluarDetail.getJumlah());
            jurnal.add(detail);
        }
        try {
            JRDataSource dataSource = new JRBeanCollectionDataSource(jurnal);
            InputStream file
                    = getClass().getResourceAsStream("BuktiKasKeluar.jasper");
            JasperPrint jasperPrint
                    = JasperFillManager.fillReport(file, parameter, dataSource);
            JasperViewer.viewReport(jasperPrint, true);
            this.dispose();
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_buttonCetakActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pengeluaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PengeluaranForm dialog = new PengeluaranForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton butonTambah;
    private javax.swing.JButton buttonBaru;
    private javax.swing.JButton buttonCetak;
    private javax.swing.JButton buttonData;
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JComboBox<String> comboBeban;
    private javax.swing.JComboBox<String> comboKas;
    private javax.swing.JTable datatable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField textBebanJumlah;
    private javax.swing.JTextField textBebanKeterangan;
    private javax.swing.JTextField textCatatan;
    private javax.swing.JTextField textNomor;
    private javax.swing.JTextField textRekananKode;
    private javax.swing.JTextField textRekananNama;
    private javax.swing.JSpinner textTanggal;
    private javax.swing.JFormattedTextField textTotal;
    // End of variables declaration//GEN-END:variables
}
