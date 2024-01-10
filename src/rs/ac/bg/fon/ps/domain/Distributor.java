/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Aleksandra
 */
public class Distributor implements Serializable, DomainObject{
    private Long distributorID;
    private String name;
    private String adress;

    public Distributor() {
    }

    public Distributor(Long distributorID, String name, String adress) {
        this.distributorID = distributorID;
        this.name = name;
        this.adress = adress;
    }
    

    public Long getDistributorID() {
        return distributorID;
    }

    public void setDistributorID(Long distributorID) {
        this.distributorID = distributorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Distributor other = (Distributor) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.adress, other.adress)) {
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
        return " distributor";
    }

    @Override
    public String getColumnsNames() {
        return "";
    }

    @Override
    public String getAttributeValuesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAttributeValuesForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnsForSelect() {
        return  "*";
    }

    @Override
    public String getAlias() {
        return  "d";
    }

    @Override
    public String getJoinCondition() {
        return  "";
    }


    @Override
    public String getWhereConditionSelect() {
        return  "";
    }

    @Override
    public String getGroup() {
        return  "";
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        List<DomainObject> list = new ArrayList<>();
        while(rs.next()){
            list.add(new Distributor(rs.getLong("distributorID"), rs.getString("name"), rs.getString("address")));
        }
    
        return list;
    }

    @Override
    public String getMaxID() {
        return "";
    }

  
    
}
