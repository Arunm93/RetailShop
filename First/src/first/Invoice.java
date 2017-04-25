/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashMap;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author ArUn
 */
public class Invoice extends javax.swing.JFrame {

    /**
     * Creates new form Invoice
     */
    private String referencedClient;
    private String referencedCompany;
    private static int sNum=1;
    private HashMap<String,Double> rateList;
    private String billNum;
    public Invoice(String clientName,String companyName) {
        initComponents();
        this.setVisible(true);
        this.setSize(800, 800);
        this.referencedClient=clientName;
      this.referencedCompany=companyName;
      productList();
      unitList();
      billNo();
      retriveBillNo();
      
    }
    //code for auto populating the bill no
    public void billNo()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstDB", "root", "arun");
            String sql = "Insert into BIllNO(companyname) values(?)"; //query for DB
            PreparedStatement statement = conn.prepareStatement(sql); //Run the query 
            
            statement.setString(1, this.referencedCompany);
            int row = statement.executeUpdate();
            
//Connection establish
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void retriveBillNo()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstDB", "root", "arun");
            String sqlSelect="Select no from billno where companyName=? order by no desc";
            PreparedStatement stmt=conn.prepareStatement(sqlSelect);
            stmt.setString(1, this.referencedCompany);
            ResultSet rs=stmt.executeQuery();
            String billName=this.referencedCompany.substring(0, 2);
                while(rs.next())
                {
                    this.billNum=billName+rs.getInt("no");
                    System.out.println("bil no"+(billName+rs.getInt("no")));
                    this.billNo.setText(billName+rs.getInt("no"));
                    break;
                }
        
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//code for auto populating the product names from the referenced client
    public void productList()
    {
     
        productName.removeAllItems();
        productName.addItem("Select");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstDB", "root", "arun"); //Connection establish
  
            String sql = "select productname,rate from PRODUCTDETAILS where companyname =?"; //query for DB
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, this.referencedCompany);
            ResultSet rs=stmt.executeQuery(); //Run the query
            rateList=new HashMap<>();
            while(rs.next())
            {
                productName.addItem(rs.getString("PRODUCTNAME"));
                rateList.put(rs.getString("PRODUCTNAME"), rs.getDouble("RATE"));
            }
            
            conn.close();
            }catch(ClassNotFoundException ex) {
                Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (SQLException ex) {
            Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void unitList()
    {
     
        unit.removeAllItems();
        //productName.addItem("Select");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstDB", "root", "arun"); //Connection establish
  
            String sql = "select unitname from UNITDETAILS"; //query for DB
            PreparedStatement stmt=conn.prepareStatement(sql);
           // stmt.setString(1, this.referencedCompany);
            ResultSet rs=stmt.executeQuery(); //Run the query
           // rateList=new HashMap<>();
            while(rs.next())
            {
                unit.addItem(rs.getString("UNITNAME"));
              //  rateList.put(rs.getString("PRODUCTNAME"), rs.getDouble("RATE"));
            }
            
            conn.close();
            }catch(ClassNotFoundException ex) {
                Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (SQLException ex) {
            Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        billNo = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        rate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        invoice = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        productName = new javax.swing.JComboBox<>();
        unit = new javax.swing.JComboBox<>();
        VAT = new javax.swing.JTextField();
        additionalTax = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Bill No");

        billNo.setEditable(false);

        jLabel2.setText("Product Name");

        jLabel3.setText("Rate");

        jLabel4.setText("Qty");

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        invoice.setText("Invoice");
        invoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceActionPerformed(evt);
            }
        });

        jLabel5.setText("Unit");

        jLabel6.setText("VAT");

        productName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameActionPerformed(evt);
            }
        });

        unit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Additional Tax");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(invoice, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(billNo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(additionalTax, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addComponent(VAT, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(billNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(unit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(additionalTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoice)
                    .addComponent(add))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. No", "Product Desc", "Quantity", "Rate", "Unit", "Amount", "VAT", "Add. Tax"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(invoiceTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameActionPerformed
        // TODO add your handling code here:
        if(!productName.getSelectedItem().equals("Select"))
        {
            for (Map.Entry<String, Double> entry : rateList.entrySet()) 
            {
                String key = entry.getKey();
                Double value = entry.getValue();
                if(key.equals(productName.getSelectedItem()))
                {
                    rate.setText(value.toString());
                }
    
            }
        }
        else
        {
            rate.setText("Please select an product");
        }
    }//GEN-LAST:event_productNameActionPerformed
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
        
        int sNo=sNum;
        sNum++;
        String prodDesc=productName.getSelectedItem().toString();
        int qty=Integer.parseInt(this.qty.getText());
        //rate,unit,amount,vat,add
        double rateA=Double.parseDouble(this.rate.getText());
        String unitN=unit.getSelectedItem().toString();
        double amount =qty*rateA;
        double vatPer=Double.parseDouble(VAT.getText());
        double vat=((amount*vatPer)/100);
        double addiTax=Double.parseDouble(additionalTax.getText());
        double aTax=((amount*addiTax)/100);
        
        Object row[]={
            sNo,prodDesc,qty,rateA,unitN,amount,vat,aTax//,invoiceTable.getColumn("Edit").setCellEditor(new DefaultCellEditor(checkBox))
        };
        DefaultTableModel dtm=(DefaultTableModel)invoiceTable.getModel();
        dtm.addRow(row);
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstDB", "root", "arun"); //Connection establish
  
            String sql = "insert into billdetails(sno,prodDesc,qty,rate,amount,vat,addTax,billno,unit,companyname,clientname)values(?,?,?,?,?,?,?,?,?,?,?)"; //query for DB
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setInt(1, sNo);
            stmt.setString(2, prodDesc);
            stmt.setInt(3,qty);
            stmt.setDouble(4, rateA);
            stmt.setDouble(5, amount);
            stmt.setDouble(6, vat);
            stmt.setDouble(7, aTax);
            stmt.setString(8, billNum);
            stmt.setString(9, unitN);
            stmt.setString(10, this.referencedCompany);
            stmt.setString(11, this.referencedClient);
            int rowint=stmt.executeUpdate(); //Run the query
            System.out.println("billdetails successfully added");
            
            }catch(ClassNotFoundException ex) {
                Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (SQLException ex) {
            Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addActionPerformed

    private void invoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceActionPerformed
        // TODO add your handling code here:
        try{
        invoiceTest it = new invoiceTest(this.referencedCompany, this.referencedClient);
        //test the datatable functionality
        HashMap<String,Object>hashmap=new HashMap<>();
      
        //end of functionality
        JasperPrint jasperPrint=null;
        
        
        String[] column={"COLUMN_0","COLUMN_1","COLUMN_2","COLUMN_3","COLUMN_4","COLUMN_5","COLUMN_6","COLUMN_7","COLUMN_8","COLUMN_9","COLUMN_10","COLUMN_11"};
        String[][] data={{it.companyName(),it.CompanyAddress(),it.CompanyEmail(),it.CompanyPan(),it.CompanyGST(),it.CompanyCST(),it.clientName(),it.clientAddress(),"BillNo","Date",it.clientGST(),it.clientCST()}};
        DefaultTableModel tableModel=new DefaultTableModel(data,column);
        JasperReport jr=JasperCompileManager.compileReport("D:\\OM\\First\\src\\first\\BillGeneration.jrxml");
            jasperPrint = JasperFillManager.fillReport(jr, hashmap,
                    new JRTableModelDataSource(tableModel));
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            jasperViewer.setVisible(true);
        }catch(Exception ex)
        {
            Logger.getLogger(Invoice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_invoiceActionPerformed
    
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
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Invoice("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField VAT;
    private javax.swing.JButton add;
    private javax.swing.JTextField additionalTax;
    private javax.swing.JTextField billNo;
    private javax.swing.JButton invoice;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> productName;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField rate;
    private javax.swing.JComboBox<String> unit;
    // End of variables declaration//GEN-END:variables
}
