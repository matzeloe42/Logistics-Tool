/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logisticstool.com.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Matze
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerid", query = "SELECT c FROM Customer c WHERE c.customerid = :customerid"),
    @NamedQuery(name = "Customer.findByForename", query = "SELECT c FROM Customer c WHERE c.forename = :forename"),
    @NamedQuery(name = "Customer.findByLastname", query = "SELECT c FROM Customer c WHERE c.lastname = :lastname")
})
public class Customer implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CUSTOMERID")
    private Integer customerid;
    @Size(max = 30)
    @Column(name = "FORENAME")
    private String forename;
    @Size(max = 30)
    @Column(name = "LASTNAME")
    private String lastname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private Collection<Creditadvice> creditadviceCollection;

    public Customer()
    {
    }

    public Customer(Integer customerid)
    {
        this.customerid = customerid;
    }

    public Integer getCustomerid()
    {
        return customerid;
    }

    public void setCustomerid(Integer customerid)
    {
        this.customerid = customerid;
    }

    public String getForename()
    {
        return forename;
    }

    public void setForename(String forename)
    {
        this.forename = forename;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    @XmlTransient
    public Collection<Creditadvice> getCreditadviceCollection()
    {
        return creditadviceCollection;
    }

    public void setCreditadviceCollection(Collection<Creditadvice> creditadviceCollection)
    {
        this.creditadviceCollection = creditadviceCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (customerid != null ? customerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer))
        {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerid == null && other.customerid != null) || (this.customerid != null && !this.customerid.equals(other.customerid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "logisticstool.com.entities.Customer[ customerid=" + customerid + " ]";
    }
    
}
