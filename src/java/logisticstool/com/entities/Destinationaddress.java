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
@Table(name = "DESTINATIONADDRESS")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Destinationaddress.findAll", query = "SELECT d FROM Destinationaddress d"),
    @NamedQuery(name = "Destinationaddress.findByDestinationaddressid", query = "SELECT d FROM Destinationaddress d WHERE d.destinationaddressid = :destinationaddressid"),
    @NamedQuery(name = "Destinationaddress.findByStreet", query = "SELECT d FROM Destinationaddress d WHERE d.street = :street"),
    @NamedQuery(name = "Destinationaddress.findByHousenumber", query = "SELECT d FROM Destinationaddress d WHERE d.housenumber = :housenumber")
})
public class Destinationaddress implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DESTINATIONADDRESSID")
    private Integer destinationaddressid;
    @Size(max = 90)
    @Column(name = "STREET")
    private String street;
    @Size(max = 10)
    @Column(name = "HOUSENUMBER")
    private String housenumber;
    @JoinColumn(name = "ZIP", referencedColumnName = "ZIP")
    @ManyToOne(optional = false)
    private Place zip;

    public Destinationaddress()
    {
    }

    public Destinationaddress(Integer destinationaddressid)
    {
        this.destinationaddressid = destinationaddressid;
    }

    public Integer getDestinationaddressid()
    {
        return destinationaddressid;
    }

    public void setDestinationaddressid(Integer destinationaddressid)
    {
        this.destinationaddressid = destinationaddressid;
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
        hash += (destinationaddressid != null ? destinationaddressid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destinationaddress))
        {
            return false;
        }
        Destinationaddress other = (Destinationaddress) object;
        if ((this.destinationaddressid == null && other.destinationaddressid != null) || (this.destinationaddressid != null && !this.destinationaddressid.equals(other.destinationaddressid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "logisticstool.com.entities.Destinationaddress[ destinationaddressid=" + destinationaddressid + " ]";
    }
    
}
