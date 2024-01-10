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
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Aleksandra
 */
public class Product implements Serializable, DomainObject{
    
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Distributor distributor;

    public Product() {
    }

    public Product(Long id, String name, BigDecimal price, String description, Distributor distributor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.distributor = distributor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return name;
    }

    
    @Override
    public String getTableName() {
        return " product";
    }

    @Override
    public String getColumnsNames() {
        return " name, price, description, distributorID";
    }

    @Override
    public String getAttributeValuesForInsert() {
        return "'"+name+"',"+price+",'"+description+"',"+distributor.getDistributorID();
    }

    @Override
    public String getAttributeValuesForUpdate() {
        return " description='"+description+"',price="+price;
    }

    @Override
    public String getWhereCondition() {
        return " productID="+id;
    }

      @Override
    public String getColumnsForSelect() {
        return " * ";
    }

    @Override
    public String getAlias() {
        return "p";
    }


    @Override
    public String getJoinCondition() {
        return " join Distributor d on p.distributorID=d.distributorID ";
    }

    @Override
    public String getWhereConditionSelect() {
        
            if(name!=null && description!= null){
                return " where p.name LIKE '%"+name+"%' OR description LIKE '%"+description+"%' "; 
            }
       
        return "";
    }

  @Override
    public String getGroup() {
        return "";
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        List<DomainObject> list = new ArrayList<>();
        while (rs.next()) {            
            Distributor d = new Distributor(rs.getLong("d.distributorID"), rs.getString("d.name"), rs.getString("d.address"));
            Product p = new Product(rs.getLong("p.productID"), rs.getString("p.name"),rs.getBigDecimal("p.price"), rs.getString("p.description"),d);
            
            list.add(p);
        }
        
        return list;
    }

   
    @Override
    public String getMaxID() {
        return "";
    }

    
}
