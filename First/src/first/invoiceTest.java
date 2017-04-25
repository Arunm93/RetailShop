/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import java.awt.Image;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

/**
 *
 * @author ArUn
 */
public class invoiceTest extends JRDefaultScriptlet{
    
    private String referencedCompany;
    private String referencedClient;
    private String companyName;
    private String companyAddress;
    private String companyGST;
    private String companyCST;
    private String pan;
    private String email;
    private String clientName;
    private String clientAddress;
    private String billNo;
    private String billDate;
    private String clientGST;
    private String clientCST;
    
    public invoiceTest(String companyName,String clientName)
    {
        this.referencedCompany=companyName;
        this.referencedClient=clientName;
    }
    public String companyName() throws JRScriptletException
    {
        return this.referencedCompany;
    }
    public String CompanyAddress() throws JRScriptletException
    {
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstDB", "root", "arun"); //Connection establish
  
            String sql = "select address from COMPANYDETAILS where companyname=?"; //query for DB
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, this.referencedCompany);
            ResultSet rs=stmt.executeQuery(); //Run the query
           // rateList=new HashMap<>();
           ArrayList<String> address=new ArrayList<String>();
           
            while(rs.next())
            {
                address.add(rs.getString("address"));
            }
            
            conn.close();
            return address.get(0);
                    
            }catch(ClassNotFoundException ex) {
                Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (SQLException ex) {
            Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "";
    }
    public String CompanyGST() throws JRScriptletException
    {
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstDB", "root", "arun"); //Connection establish
  
            String sql = "select gst from COMPANYDETAILS where companyname=?"; //query for DB
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, this.referencedCompany);
            ResultSet rs=stmt.executeQuery(); //Run the query
           // rateList=new HashMap<>();
           ArrayList<String> gst=new ArrayList<String>();
           
            while(rs.next())
            {
                gst.add(rs.getString("gst"));
            }
            
            conn.close();
            return gst.get(0);
                    
            }catch(ClassNotFoundException ex) {
                Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (SQLException ex) {
            Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "";
    }
    public String CompanyCST() throws JRScriptletException
    {
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstDB", "root", "arun"); //Connection establish
  
            String sql = "select cst from COMPANYDETAILS where companyname=?"; //query for DB
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, this.referencedCompany);
            ResultSet rs=stmt.executeQuery(); //Run the query
           // rateList=new HashMap<>();
           ArrayList<String> cst=new ArrayList<String>();
           
            while(rs.next())
            {
                cst.add(rs.getString("cst"));
            }
            
            conn.close();
            return cst.get(0);
                    
            }catch(ClassNotFoundException ex) {
                Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (SQLException ex) {
            Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "";
    }
    public ImageIcon companyLogo()
    {
      try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstDB", "root", "arun"); //Connection establish
  
            String sql = "select logo,address from COMPANYDETAILS where companyname=?"; //query for DB
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, this.referencedCompany);
            ResultSet rs=stmt.executeQuery(); //Run the query
           // rateList=new HashMap<>();
           while(rs.next()){
           System.out.println("companyAdres"+rs.getString("address"));
            Blob b=rs.getBlob("logo");//2 means 2nd column data  
            byte barr[]=b.getBytes(1,(int)b.length());//1 means first image 
            ImageIcon i=new ImageIcon((byte[])barr);
            
           
            conn.close();
            return i;
           }      
            }catch(ClassNotFoundException ex) {
                Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {  
            Logger.getLogger(invoiceTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
      return null;
    }
    public String CompanyPan() throws JRScriptletException
    {
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstDB", "root", "arun"); //Connection establish
  
            String sql = "select pan from COMPANYDETAILS where companyname=?"; //query for DB
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, this.referencedCompany);
            ResultSet rs=stmt.executeQuery(); //Run the query
           // rateList=new HashMap<>();
           ArrayList<String> pan=new ArrayList<String>();
           
            while(rs.next())
            {
                pan.add(rs.getString("pan"));
            }
            
            conn.close();
            return pan.get(0);
                    
            }catch(ClassNotFoundException ex) {
                Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (SQLException ex) {
            Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "";
    }
    public String CompanyEmail() throws JRScriptletException
    {
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstDB", "root", "arun"); //Connection establish
  
            String sql = "select email from COMPANYDETAILS where companyname=?"; //query for DB
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, this.referencedCompany);
            ResultSet rs=stmt.executeQuery(); //Run the query
           // rateList=new HashMap<>();
           ArrayList<String> email=new ArrayList<String>();
           
            while(rs.next())
            {
                email.add(rs.getString("email"));
            }
            
            conn.close();
            return email.get(0);
                    
            }catch(ClassNotFoundException ex) {
                Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (SQLException ex) {
            Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "";
    }
    public String clientName() throws JRScriptletException
    {
        return this.referencedClient;
    }
    public String clientAddress()
    {
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstDB", "root", "arun"); //Connection establish
  
            String sql = "select address from CLIENTDETAILS where clientname=?"; //query for DB
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, this.referencedClient);
            ResultSet rs=stmt.executeQuery(); //Run the query
           // rateList=new HashMap<>();
           ArrayList<String> address=new ArrayList<String>();
           
            while(rs.next())
            {
                address.add(rs.getString("address"));
            }
            
            conn.close();
            return address.get(0);
                    
            }catch(ClassNotFoundException ex) {
                Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (SQLException ex) {
            Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "";
    }
    public String clientGST() throws JRScriptletException
    {
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstDB", "root", "arun"); //Connection establish
  
            String sql = "select gst from CLIENTDETAILS where clientname=?"; //query for DB
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, this.referencedClient);
            ResultSet rs=stmt.executeQuery(); //Run the query
           // rateList=new HashMap<>();
           ArrayList<String> gst=new ArrayList<String>();
           
            while(rs.next())
            {
                gst.add(rs.getString("gst"));
            }
            
            conn.close();
            return gst.get(0);
                    
            }catch(ClassNotFoundException ex) {
                Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (SQLException ex) {
            Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "";
    }
    public String clientCST() throws JRScriptletException
    {
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstDB", "root", "arun"); //Connection establish
  
            String sql = "select cst from CLIENTDETAILS where clientname=?"; //query for DB
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1, this.referencedClient);
            ResultSet rs=stmt.executeQuery(); //Run the query
           // rateList=new HashMap<>();
           ArrayList<String> cst=new ArrayList<String>();
           
            while(rs.next())
            {
                cst.add(rs.getString("cst"));
            }
            
            conn.close();
            return cst.get(0);
                    
            }catch(ClassNotFoundException ex) {
                Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (SQLException ex) {
            Logger.getLogger(SelectCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
         return "";
    }
    
    public HashMap<String,Object> populateValues()
    {
        HashMap<String,Object> map=new HashMap<>();
        try {
            setCompanyName(companyName());
            setCompanyAddress(CompanyAddress());
            setCompanyGST(CompanyGST());
            setCompanyCST(CompanyCST());
            setPan(CompanyPan());
            setEmail(CompanyEmail());
            setClientName(clientName());
            setClientAddress(clientAddress());
            setBillNo("Test");
            setBillDate("TestDate");
            setClientGST(clientGST());
            setClientCST(clientCST());
            map.put("companyName",this.getCompanyName());
            map.put("companyAddress",this.getCompanyAddress());
            map.put("companyGST",this.getCompanyGST());
            map.put("companyCST",this.getCompanyCST());
            map.put("pan",this.getPan());
            map.put("email",this.getEmail());
            map.put("clientName",this.getClientName());
            map.put("clientAddress", this.getClientAddress());
            map.put("billNo",this.getBillNo());
            map.put("billDate",this.getBillDate());
            map.put("clientGST",this.getClientGST());
            map.put("clientCST",this.getClientCST());
            
        } catch (JRScriptletException ex) {
            Logger.getLogger(invoiceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return map;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the companyAddress
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * @param companyAddress the companyAddress to set
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     * @return the companyGST
     */
    public String getCompanyGST() {
        return companyGST;
    }

    /**
     * @param companyGST the companyGST to set
     */
    public void setCompanyGST(String companyGST) {
        this.companyGST = companyGST;
    }

    /**
     * @return the companyCST
     */
    public String getCompanyCST() {
        return companyCST;
    }

    /**
     * @param companyCST the companyCST to set
     */
    public void setCompanyCST(String companyCST) {
        this.companyCST = companyCST;
    }

    /**
     * @return the pan
     */
    public String getPan() {
        return pan;
    }

    /**
     * @param pan the pan to set
     */
    public void setPan(String pan) {
        this.pan = pan;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return the clientAddress
     */
    public String getClientAddress() {
        return clientAddress;
    }

    /**
     * @param clientAddress the clientAddress to set
     */
    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    /**
     * @return the billNo
     */
    public String getBillNo() {
        return billNo;
    }

    /**
     * @param billNo the billNo to set
     */
    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    /**
     * @return the billDate
     */
    public String getBillDate() {
        return billDate;
    }

    /**
     * @param billDate the billDate to set
     */
    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    /**
     * @return the clientGST
     */
    public String getClientGST() {
        return clientGST;
    }

    /**
     * @param clientGST the clientGST to set
     */
    public void setClientGST(String clientGST) {
        this.clientGST = clientGST;
    }

    /**
     * @return the clientCST
     */
    public String getClientCST() {
        return clientCST;
    }

    /**
     * @param clientCST the clientCST to set
     */
    public void setClientCST(String clientCST) {
        this.clientCST = clientCST;
    }
}
