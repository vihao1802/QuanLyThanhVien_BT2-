/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.ThanhVienBLL;
import BLL.XuLyBLL;
import DAL.XuLy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author ANH KHOA
 */
public class FormXuLy extends javax.swing.JFrame {

    /**
     * Creates new form FormXuLy
     */
    private String func;
    private JTable table;
    private XuLyBLL xulybll;
    public FormXuLy(String id, String func, JTable jTable) {
        System.out.println(""+id);
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.func = func;
        this.table = jTable;
        if(func.equals("showinforXuLy")){
            jButton1.setText("Edit");
            jtf_maxl.setEditable(false);
            renderDataFormShow(id);
        }
        else{
            renderDataFormAdd();
        }
    }
    public void renderDataFormShow(String id){
        setTitle("Thông tin xử lý vi phạm"); 
        xulybll = new XuLyBLL();
        XuLy x = xulybll.getXuLy(Integer.parseInt(id));
        jtf_maxl.setText(x.getMaXL()+"");
        jtf_matv.setText(x.getThanhvien().getMaTV()+"");
        jtf_hinhthuc.setText(x.getHinhThucXL());
        if(x.getSoTien()!=null){
            jtf_tien.setText(x.getSoTien()+"");
        }
        if(x.getTrangThaiXL()==0){
            jcb_trangthai.setSelectedIndex(0);
        }else jcb_trangthai.setSelectedIndex(1);
        
        Date date = x.getNgayXL();
        // Chuyển đổi Date thành LocalDateTime
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        // Định dạng cho LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        // Chuyển đổi LocalDateTime thành chuỗi
        String dateTimeString = dateTime.format(formatter);
        int year = dateTime.getYear();
        int month = dateTime.getMonthValue();
        int day = dateTime.getDayOfMonth();
        int hour = dateTime.getHour();
        int minute = dateTime.getMinute();
        int second = dateTime.getSecond();
        jdc_date.setDate(date);
        // Tạo một đối tượng Calendar
        Calendar calendar = Calendar.getInstance();
        // Thiết lập giá trị của năm, tháng và ngày
        calendar.set(year, month - 1, day); // Tháng trong Calendar là từ 0-11
        // Lấy đối tượng Date từ Calendar
        Date dateset = calendar.getTime();
        // Đặt giá trị date cho jdc_date
        jdc_date.setDate(dateset);
        spn_hour.setValue(hour);
        spn_minute.setValue(minute);
        
    }
    public void renderDataFormAdd(){
        setTitle("Thêm xử lý");  
        List list = new XuLyBLL().getAllXuly();
        int countmaXl = list.size()+1;
        jtf_maxl.setText(countmaXl+"");
        jtf_maxl.setEditable(false);
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
        jtf_maxl = new javax.swing.JTextField();
        jtf_matv = new javax.swing.JTextField();
        jtf_hinhthuc = new javax.swing.JTextField();
        jtf_tien = new javax.swing.JTextField();
        jdc_date = new com.toedter.calendar.JDateChooser();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = calendar.get(Calendar.MINUTE);

        // Tạo Spinner cho giờ
        SpinnerNumberModel hourModel = new SpinnerNumberModel(currentHour, 0, 23, 1);
        spn_hour = new javax.swing.JSpinner();
        // Tạo Spinner cho giờ
        SpinnerNumberModel minuteModel = new SpinnerNumberModel(currentMinute, 0, 59, 1);
        spn_minute = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jcb_trangthai = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thông Tin Xử Lý");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        jtf_maxl.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã xử lý"));
        jtf_maxl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_maxlActionPerformed(evt);
            }
        });

        jtf_matv.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã Thành Viên (*)"));
        jtf_matv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_matvActionPerformed(evt);
            }
        });

        jtf_hinhthuc.setBorder(javax.swing.BorderFactory.createTitledBorder("Hình thức xử lý vi phạm (*)"));
        jtf_hinhthuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_hinhthucActionPerformed(evt);
            }
        });

        jtf_tien.setBorder(javax.swing.BorderFactory.createTitledBorder("Tiền phạt (nêú có)"));

        jdc_date.setBackground(new java.awt.Color(255, 255, 255));
        jdc_date.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngày (yyyy-MM-dd)"));

        spn_hour.setModel(hourModel);
        spn_hour.setBorder(javax.swing.BorderFactory.createTitledBorder("Giờ"));
        spn_hour.setInheritsPopupMenu(true);
        spn_hour.setPreferredSize(new java.awt.Dimension(70, 25));

        spn_minute.setModel(minuteModel);
        spn_minute.setBorder(javax.swing.BorderFactory.createTitledBorder("Phút"));
        spn_minute.setInheritsPopupMenu(true);
        spn_minute.setPreferredSize(new java.awt.Dimension(70, 25));

        jButton1.setBackground(new java.awt.Color(0, 204, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jcb_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa xử lý", "Đã xử lý" }));
        jcb_trangthai.setBorder(javax.swing.BorderFactory.createTitledBorder("Trạng thái"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_hinhthuc, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jtf_maxl, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jtf_matv, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_tien, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdc_date, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(spn_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(spn_minute, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jcb_trangthai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_maxl, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_matv, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jtf_hinhthuc, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_tien, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jcb_trangthai))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdc_date, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spn_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spn_minute, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        LocalDate dateDefaultjdc = java.time.LocalDate.now();
        Date datejdc = java.sql.Date.valueOf(dateDefaultjdc);
        jdc_date.setDate(datejdc);
        jdc_date.setDateFormatString("yyyy-MM-dd");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_maxlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_maxlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_maxlActionPerformed

    private void jtf_matvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_matvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_matvActionPerformed

    private void jtf_hinhthucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_hinhthucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_hinhthucActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        xulybll = new XuLyBLL();
        if (func.equals("addformxuly")) {
            String maTVStr = jtf_matv.getText();
            String hinhThucXL = jtf_hinhthuc.getText();
            String tien = jtf_tien.getText();
            int trangThaiXL = jcb_trangthai.getSelectedItem().toString().equals("Chưa xử lý") ? 0 : 1;
            int hour = (int) spn_hour.getValue();
            int minute = (int) spn_minute.getValue();
            if(!xulybll.validateInput(maTVStr, hinhThucXL)){
                JOptionPane.showMessageDialog(null, "Không để trống các trường bắt buộc (*)", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else if(new ThanhVienBLL().getThanhVien(Integer.parseInt(maTVStr))==null){
                JOptionPane.showMessageDialog(null, "Mã thành viên không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else if(!tien.isEmpty()&& !xulybll.validatePositiveNumber(tien)){
                    JOptionPane.showMessageDialog(null, "Số tiền phạt là số nguyên dương", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else if(jdc_date.getDate() ==null ||!xulybll.validateDateFormat(jdc_date.getDate())){
                JOptionPane.showMessageDialog(null, "Ngày phải đúng định dạng yyyy-MM-dd", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else{    
                XuLy x = new XuLy();
                x.setSoTien(null);
                if (!tien.isEmpty()) {
                    x.setSoTien(Integer.valueOf(tien));
                }
                x.setThanhvien(new ThanhVienBLL().getThanhVien(Integer.parseInt(maTVStr)));
                x.setHinhThucXL(hinhThucXL);
                x.setTrangThaiXL(trangThaiXL);

                SimpleDateFormat formatterString = new SimpleDateFormat("yyyy-MM-dd");
                String stringdatexuly = formatterString.format(jdc_date.getDate()) + " " + hour + ":" + minute + ":00";
                SimpleDateFormat formatterdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    Date datexuly = formatterdate.parse(stringdatexuly);
                    x.setNgayXL(datexuly);
                } catch (ParseException ex) {
                    Logger.getLogger(FormXuLy.class.getName()).log(Level.SEVERE, null, ex);
                }
                xulybll.addXuLy(x);
                JOptionPane.showMessageDialog(null, "Thêm xử lý thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                MainForm.loadDataTableXuLy(table);
                dispose();
            }
        }else{
            String maTVStr = jtf_matv.getText();
            String hinhThucXL = jtf_hinhthuc.getText();
            String tien = jtf_tien.getText();
            int trangThaiXL = jcb_trangthai.getSelectedItem().toString().equals("Chưa xử lý") ? 0 : 1;
            int hour = (int) spn_hour.getValue();
            int minute = (int) spn_minute.getValue();
            if(!xulybll.validateInput(maTVStr, hinhThucXL)){
                JOptionPane.showMessageDialog(null, "Không để trống các trường bắt buộc (*)", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else if(new ThanhVienBLL().getThanhVien(Integer.parseInt(maTVStr))==null){
                JOptionPane.showMessageDialog(null, "Mã thành viên không tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else if(!tien.isEmpty()&& !xulybll.validatePositiveNumber(tien)){
                    JOptionPane.showMessageDialog(null, "Số tiền phạt là số nguyên dương", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else if(jdc_date.getDate() ==null ||!xulybll.validateDateFormat(jdc_date.getDate())){
                JOptionPane.showMessageDialog(null, "Ngày phải đúng định dạng yyyy-MM-dd", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            else{    
                XuLy x = new XuLy();
                x.setSoTien(null);
                if (!tien.isEmpty()) {
                    x.setSoTien(Integer.valueOf(tien));
                }
                x.setThanhvien(new ThanhVienBLL().getThanhVien(Integer.parseInt(maTVStr)));
                x.setHinhThucXL(hinhThucXL);
                x.setTrangThaiXL(trangThaiXL);
                x.setMaXL(Integer.parseInt(jtf_maxl.getText()));
                SimpleDateFormat formatterString = new SimpleDateFormat("yyyy-MM-dd");
                String stringdatexuly = formatterString.format(jdc_date.getDate()) + " " + hour + ":" + minute + ":00";
                SimpleDateFormat formatterdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    Date datexuly = formatterdate.parse(stringdatexuly);
                    x.setNgayXL(datexuly);
                } catch (ParseException ex) {
                    Logger.getLogger(FormXuLy.class.getName()).log(Level.SEVERE, null, ex);
                }
                xulybll.updateXuLy(x);
                JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                MainForm.loadDataTableXuLy(table);
                dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcb_trangthai;
    private com.toedter.calendar.JDateChooser jdc_date;
    private javax.swing.JTextField jtf_hinhthuc;
    private javax.swing.JTextField jtf_matv;
    private javax.swing.JTextField jtf_maxl;
    private javax.swing.JTextField jtf_tien;
    private javax.swing.JSpinner spn_hour;
    private javax.swing.JSpinner spn_minute;
    // End of variables declaration//GEN-END:variables
}
