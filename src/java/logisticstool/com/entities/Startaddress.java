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
@Table(name = "STARTADDRESS")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Startaddress.findAll", query = "SELECT s FROM Startaddress s"),
    @NamedQuery(name = "Startaddress.findByStartaddressid", query = "SELECT s FROM Startaddress s WHERE s.startaddressid = :startaddressid"),
    @NamedQuery(name = "Startaddress.findByStreet", query = "SELECT s FROM Startaddress s WHERE s.street = :street"),
    @NamedQuery(name = "Startaddress.findByHousenumber", query = "SELECT s FROM Startaddress s WHERE s.housenumber = :housenumber")
})
public class Startaddress implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "STARTADDRESSID")
    private Integer startaddressid;
    @Size(max = 90)
    @Column(name = "STREET")
    private String street;
    @Size(max = 10)
    @Column(name = "HOUSENUMBER")
    private String housenumber;
    @JoinColumn(name = "ZIP", referencedColumnName = "ZIP")
    @ManyToOne(optional = false)
    private Place zip;

    public Startaddress()
    {
    }

    public Startaddress(Integer startaddressid)
    {
        this.startaddressid = startaddressid;
    }

    public Integer getStartaddressid()
    {
        return startaddressid;
    }

    public void setStartaddressid(Integer startaddressid)
    {
        this.startaddressid = startaddressid;
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
        hash += (startaddressid != null ? startaddressid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Startaddress))
        {
            return false;
        }
        Startaddress other = (Startaddress) object;
        if ((this.startaddressid == null && other.startaddressid != null) || (this.startaddressid != null && !this.startaddressid.equals(other.startaddressid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "logisticstool.com.entities.Startaddress[ startaddressid=" + startaddressid + " ]";
    }
    
}
