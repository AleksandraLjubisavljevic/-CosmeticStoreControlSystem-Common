/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/*
 *
 * @author Aleksandra
 */
public class Bill implements Serializable, DomainObject{
    
    private Long billID;
    private Date date;
    private BigDecimal amount;
    private boolean processed;
    private User user;
    private ArrayList<BillItem> items;

    public Bill() {
        items = new ArrayList<>();
    }

    public Bill(Long billID, Date date, BigDecimal  amount, boolean processed, User user, ArrayList<BillItem> items) {
        this.billID = billID;
        this.date = date;
        this.amount = amount;
        this.processed = processed;
        this.user = user;
        this.items = items;
    }

    public Long getBillID() {
        return billID;
    }

    public void setBillID(Long billID) {
        this.billID = billID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
     public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
   
    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<BillItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<BillItem> items) {
        this.items = items;
    }

   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bill other = (Bill) obj;
        if (!Objects.equals(this.billID, other.billID)) {
            return false;
        }
        return true;
    }
@Override
    public String getTableName() {
        return " bill ";
    }

    @Override
    public String getColumnsNames() {
        return " date,amount,processed,userID";
    }

    @Override
    public String getAttributeValuesForInsert() {
        return " '"+new java.sql.Date(new Date().getTime())+"',"+amount+","+processed+","+user.getId();
    }

    @Override
    public String getAttributeValuesForUpdate() {
        return " date='"+new java.sql.Date(new Date().getTime())+"',amount='"+amount+"',processed="+processed+",userID="+user.getId();
                
    }

    @Override
    public String getWhereCondition() {
        return " billID="+billID;
    }

    @Override
    public String getColumnsForSelect() {
        return " * ";
    }
 
    @Override
    public String getAlias() {
        return " b ";
    }

  
    @Override
    public String getJoinCondition() {
        return " join user u on b.userID=u.userID ";
    }
   

    @Override
    public String getWhereConditionSelect() {
       if(billID!=null && billID!=0l){
                return " where b.billID LIKE '%"+billID+"%' "; 
            }
        return "";
    }

    @Override
    public String getGroup() {
        return "";
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        List<DomainObject> listBills1 = new ArrayList<>();
       
        while (rs.next()) {            
            listBills1.add(new Bill(rs.getLong("billID"), new Date(rs.getDate("date").getTime()),rs.getBigDecimal("amount"), rs.getBoolean("processed"),new User(rs.getLong("userID"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("username"), rs.getString("password"),rs.getString("email")),null));
           
        }
        return listBills1;
    }
  
@Override
    public String getMaxID() {
        return "billID";
    }

    
    
}
