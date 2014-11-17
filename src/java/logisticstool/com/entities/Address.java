/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logisticstool.com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matze
 */
@Entity
@Table(name = "ADDRESS")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByAddressid", query = "SELECT a FROM Address a WHERE a.addressid = :addressid"),
    @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = :street"),
    @NamedQuery(name = "Address.findByHousenumber", query = "SELECT a FROM Address a WHERE a.housenumber = :housenumber")
})
public class Address implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ADDRESSID")
    private Integer addressid;
    @Size(max = 90)
    @Column(name = "STREET")
    private String street;
    @Size(max = 10)
    @Column(name = "HOUSENUMBER")
    private String housenumber;
    @JoinColumn(name = "ZIP", referencedColumnName = "ZIP")
    @ManyToOne(optional = false)
    private Place zip;

    public Address()
    {
    }

    public Address(Integer addressid)
    {
        this.addressid = addressid;
    }

    public Integer getAddressid()
    {
        return addressid;
    }

    public void setAddressid(Integer addressid)
    {
        this.addressid = addressid;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getHousenumber()
    {
        return housenumber;
    }

    public void setHousenumber(String housenumber)
    {
        this.housenumber = housenumber;
    }

    public Place getZip()
    {
        return zip;
    }

    public void setZip(Place zip)
    {
        this.zip = zip;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (addressid != null ? addressid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address))
        {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressid == null && other.addressid != null) || (this.addressid != null && !this.addressid.equals(other.addressid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "logisticstool.com.entities.Address[ addressid=" + addressid + " ]";
    }
    
}
