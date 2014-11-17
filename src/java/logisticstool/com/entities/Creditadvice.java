/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logisticstool.com.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matze
 */
@Entity
@Table(name = "CREDITADVICE")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Creditadvice.findAll", query = "SELECT c FROM Creditadvice c"),
    @NamedQuery(name = "Creditadvice.findByCreditadviceid", query = "SELECT c FROM Creditadvice c WHERE c.creditadviceid = :creditadviceid"),
    @NamedQuery(name = "Creditadvice.findByCreaditadvicedate", query = "SELECT c FROM Creditadvice c WHERE c.creaditadvicedate = :creaditadvicedate"),
    @NamedQuery(name = "Creditadvice.findByAmount", query = "SELECT c FROM Creditadvice c WHERE c.amount = :amount")
})
public class Creditadvice implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CREDITADVICEID")
    private Integer creditadviceid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREADITADVICEDATE")
    @Temporal(TemporalType.DATE)
    private Date creaditadvicedate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private int amount;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "CUSTOMERID")
    @ManyToOne(optional = false)
    private Customer customerid;

    public Creditadvice()
    {
    }

    public Creditadvice(Integer creditadviceid)
    {
        this.creditadviceid = creditadviceid;
    }

    public Creditadvice(Integer creditadviceid, Date creaditadvicedate, int amount)
    {
        this.creditadviceid = creditadviceid;
        this.creaditadvicedate = creaditadvicedate;
        this.amount = amount;
    }

    public Integer getCreditadviceid()
    {
        return creditadviceid;
    }

    public void setCreditadviceid(Integer creditadviceid)
    {
        this.creditadviceid = creditadviceid;
    }

    public Date getCreaditadvicedate()
    {
        return creaditadvicedate;
    }

    public void setCreaditadvicedate(Date creaditadvicedate)
    {
        this.creaditadvicedate = creaditadvicedate;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public Customer getCustomerid()
    {
        return customerid;
    }

    public void setCustomerid(Customer customerid)
    {
        this.customerid = customerid;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (creditadviceid != null ? creditadviceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creditadvice))
        {
            return false;
        }
        Creditadvice other = (Creditadvice) object;
        if ((this.creditadviceid == null && other.creditadviceid != null) || (this.creditadviceid != null && !this.creditadviceid.equals(other.creditadviceid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "logisticstool.com.entities.Creditadvice[ creditadviceid=" + creditadviceid + " ]";
    }
    
}
