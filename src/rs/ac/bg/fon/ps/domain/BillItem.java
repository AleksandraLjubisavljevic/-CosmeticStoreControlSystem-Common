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

/**
 *
 * @author Aleksandra
 */
public class BillItem implements Serializable, DomainObject{
    
    private Bill bill;
    private Long billItemID;
    private BigDecimal price;
    private int quantity;
    private Product product;
    private String status;

    public BillItem() {
    }

    public BillItem(Bill bill, Long billItemID, BigDecimal price, int quantity, Product product,String status) {
        this.bill = bill;
        this.billItemID = billItemID;
        this.price = price;
        this.quantity = quantity;
        this.product = product;
        this.status = status;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Long getBillItemID() {
        return billItemID;
    }

    public void setBillItemID(Long billItemID) {
        this.billItemID = billItemID;
    }

     public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     @Override
    public String toString() {
        return product.getName()+" "+price+" "+quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BillItem other = (BillItem) obj;
        if (!Objects.equals(this.bill, other.bill)) {
            return false;
        }
        if (this.billItemID != other.billItemID) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
         return " billItem";
    }

    @Override
    public String getColumnsNames() {
        return " billID, billItemID, price, quantity, productID";
    }
        

    @Override
    public String getAttributeValuesForInsert() {
       
        return bill.getBillID()+","+billItemID+","+price+","+quantity+","+product.getId();
        
    }

    @Override
    public String getAttributeValuesForUpdate() {
 
        return "price="+price+", quantity="+quantity+", productID="+product.getId();
    }

    @Override
    public String getWhereCondition() {
       
        return " billItemID="+billItemID+" and billID="+bill.getBillID();
    }
 
  


    @Override
    public String getColumnsForSelect() {
        return " * ";
    }



    @Override
    public String getAlias() {
        return " bi ";
    }

    @Override
    public String getJoinCondition() {
        return " join Product p on bi.productID=p.productID join Distributor d on p.distributorID=d.distributorID";
    }

@Override
    public String getWhereConditionSelect() {
        if(bill!=null)
            return " where bi.billID="+bill.getBillID();
        
        if(product!=null)
            return " where bi.productID="+product.getId();
        
        return "";
    }

    @Override
    public String getGroup() {
        return "";
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        List<DomainObject> list = new ArrayList<>();
        while(rs.next()){
            
            Distributor d = new Distributor(rs.getLong("d.distributorID"), rs.getString("d.name"), rs.getString("d.address"));
            Product p = new Product(rs.getLong("p.productID"), rs.getString("p.name"), rs.getBigDecimal("p.price"), rs.getString("p.description"),d);
        
            BillItem bi = new BillItem(null,rs.getLong("billItemID"),rs.getBigDecimal("price"),rs.getInt("quantity"),p,"");
            list.add(bi);
        }
        
        return list;
          
    }
 

    @Override
    public String getMaxID() {
        return "";
    }


   


    
    
}
