/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logisticstool.logisticstool;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raphael
 */
@Entity
@Table(name = "userdata")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Userdata.findAll", query = "SELECT u FROM Userdata u"),
    @NamedQuery(name = "Userdata.findByUserDataID", query = "SELECT u FROM Userdata u WHERE u.userDataID = :userDataID"),
    @NamedQuery(name = "Userdata.findByUsername", query = "SELECT u FROM Userdata u WHERE u.username = :username"),
    @NamedQuery(name = "Userdata.findByPassword", query = "SELECT u FROM Userdata u WHERE u.password = :password")
})
public class Userdata implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserDataID")
    private Integer userDataID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Password")
    private String password;

    public Userdata()
    {
    }

    public Userdata(Integer userDataID)
    {
        this.userDataID = userDataID;
    }

    public Userdata(Integer userDataID, String username, String password)
    {
        this.userDataID = userDataID;
        this.username = username;
        this.password = password;
    }

    public Integer getUserDataID()
    {
        return userDataID;
    }

    public void setUserDataID(Integer userDataID)
    {
        this.userDataID = userDataID;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (userDataID != null ? userDataID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userdata))
        {
            return false;
        }
        Userdata other = (Userdata) object;
        if ((this.userDataID == null && other.userDataID != null) || (this.userDataID != null && !this.userDataID.equals(other.userDataID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.logisticstool.logisticstool.Userdata[ userDataID=" + userDataID + " ]";
    }
    
}
