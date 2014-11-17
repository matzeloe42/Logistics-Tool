/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logisticstool.com.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Matze
 */
@Entity
@Table(name = "OFFER")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Offer.findAll", query = "SELECT o FROM Offer o"),
    @NamedQuery(name = "Offer.findByOfferid", query = "SELECT o FROM Offer o WHERE o.offerid = :offerid"),
    @NamedQuery(name = "Offer.findByCustomerid", query = "SELECT o FROM Offer o WHERE o.customerid = :customerid"),
    @NamedQuery(name = "Offer.findByCreationdate", query = "SELECT o FROM Offer o WHERE o.creationdate = :creationdate"),
    @NamedQuery(name = "Offer.findBySalestax", query = "SELECT o FROM Offer o WHERE o.salestax = :salestax"),
    @NamedQuery(name = "Offer.findByOffertype", query = "SELECT o FROM Offer o WHERE o.offertype = :offertype")
})
public class Offer implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OFFERID")
    private Integer offerid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERID")
    private int customerid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATIONDATE")
    @Temporal(TemporalType.DATE)
    private Date creationdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALESTAX")
    private int salestax;
    @Size(max = 30)
    @Column(name = "OFFERTYPE")
    private String offertype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offerid")
    private Collection<Job> jobCollection;

    public Offer()
    {
    }

    public Offer(Integer offerid)
    {
        this.offerid = offerid;
    }

    public Offer(Integer offerid, int customerid, Date creationdate, int salestax)
    {
        this.offerid = offerid;
        this.customerid = customerid;
        this.creationdate = creationdate;
        this.salestax = salestax;
    }

    public Integer getOfferid()
    {
        return offerid;
    }

    public void setOfferid(Integer offerid)
    {
        this.offerid = offerid;
    }

    public int getCustomerid()
    {
        return customerid;
    }

    public void setCustomerid(int customerid)
    {
        this.customerid = customerid;
    }

    public Date getCreationdate()
    {
        return creationdate;
    }

    public void setCreationdate(Date creationdate)
    {
        this.creationdate = creationdate;
    }

    public int getSalestax()
    {
        return salestax;
    }

    public void setSalestax(int salestax)
    {
        this.salestax = salestax;
    }

    public String getOffertype()
    {
        return offertype;
    }

    public void setOffertype(String offertype)
    {
        this.offertype = offertype;
    }

    @XmlTransient
    public Collection<Job> getJobCollection()
    {
        return jobCollection;
    }

    public void setJobCollection(Collection<Job> jobCollection)
    {
        this.jobCollection = jobCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (offerid != null ? offerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offer))
        {
            return false;
        }
        Offer other = (Offer) object;
        if ((this.offerid == null && other.offerid != null) || (this.offerid != null && !this.offerid.equals(other.offerid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "logisticstool.com.entities.Offer[ offerid=" + offerid + " ]";
    }
    
}
