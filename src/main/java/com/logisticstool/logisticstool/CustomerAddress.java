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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matze
 */
@Entity
@Table(name = "customeraddress")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "CustomerAddress.findAll", query = "SELECT ca FROM CustomerAddress ca"),
    @NamedQuery(name = "CustomerAddress.findByAddressID", query = "SELECT a FROM CustomerAddress a WHERE a.addressID = :addressID"),
    @NamedQuery(name = "CustomerAddress.findByCustomerID", query = "SELECT c FROM CustomerAddress c WHERE c.customerID = :customerID")
})
public class CustomerAddress implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "addressID")
    private Integer addressID;
    @Id
    @Basic(optional = false)
    @Column(name = "CustomerID")
    private Integer customerID;
    
    public CustomerAddress()
    {
    }
    
    public CustomerAddress(Integer addressID, Integer customerID)
    {
        this.addressID = addressID;
        this.customerID = customerID;
    }

    public Integer getAddressID()
    {
        return addressID;
    }

    public void setAddressID(Integer addressID)
    {
        this.addressID = addressID;
    }

    public Integer getCustomerID()
    {
        return customerID;
    }

    public void setCustomerID(Integer customerID)
    {
        this.customerID = customerID;
    }
}
