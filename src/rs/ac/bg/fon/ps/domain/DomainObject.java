/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aleksandra
 */

public interface DomainObject extends Serializable{
    
    public String getTableName();
    public String getColumnsNames();
    public String getAttributeValuesForInsert();
    public String getAttributeValuesForUpdate();
    public String getWhereCondition();
    public String getColumnsForSelect();
    public String getAlias();
    public String getJoinCondition();
    public String getWhereConditionSelect();
    public String getGroup();
    public List<DomainObject> getList(ResultSet rs) throws SQLException;
    public String getMaxID();
  
   
}
