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

/**
 *
 * @author Aleksandra
 */
public class User implements Serializable , DomainObject{
    
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    
     public User() {
    }

    public User(Long id, String firstname, String lastname, String username, String password, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return firstname+" "+lastname;
    }

    
    @Override
    public String getTableName() {
        return " user ";
    }

    @Override
    public String getColumnsNames() {
        return "";
    }

    @Override
    public String getAttributeValuesForInsert() {
        return "";
    }

    @Override
    public String getAttributeValuesForUpdate() {
        return "";
    }

    @Override
    public String getWhereCondition() {
        return "";
    }

    @Override
    public String getColumnsForSelect() {
        return " * ";
    }

    @Override
    public String getAlias() {
        return " u ";
    }

    @Override
    public String getJoinCondition() {
        return "";
    }

    @Override
    public String getWhereConditionSelect() {
        return " where username='"+username+"' and password='"+password+"' LIMIT 1";
    }

    @Override
    public String getGroup() {
        return "";
    }

    @Override
    public List<DomainObject> getList(ResultSet rs) throws SQLException {
        List<DomainObject> listUsers = new ArrayList<>();
        while (rs.next()) {            
            listUsers.add(new User(rs.getLong("userID"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("username"), rs.getString("password"),rs.getString("email")));
        }
        
        return listUsers;
    }

    @Override
    public String getMaxID() {
        return "";
    }



    
}
