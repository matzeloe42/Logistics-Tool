/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logisticstool.logisticstool;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Raphael
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductID", query = "SELECT p FROM Product p WHERE p.productID = :productID"),
    @NamedQuery(name = "Product.findByDenotation", query = "SELECT p FROM Product p WHERE p.denotation = :denotation"),
    @NamedQuery(name = "Product.findByPrize", query = "SELECT p FROM Product p WHERE p.prize = :prize")
})
public class Product implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProductID")
    private Integer productID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Denotation")
    private String denotation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Prize")
    private BigDecimal prize;
    @JoinTable(name = "transportproduct", joinColumns =
    {
        @JoinColumn(name = "Product_ProductID", referencedColumnName = "ProductID")
    }, inverseJoinColumns =
    {
        @JoinColumn(name = "Transport_TransportID", referencedColumnName = "TransportID")
    })
    @ManyToMany
    private Collection<Transport> transportCollection;

    public Product()
    {
    }

    public Product(Integer productID)
    {
        this.productID = productID;
    }

    public Product(Integer productID, String denotation, BigDecimal prize)
    {
        this.productID = productID;
        this.denotation = denotation;
        this.prize = prize;
    }

    public Integer getProductID()
    {
        return productID;
    }

    public void setProductID(Integer productID)
    {
        this.productID = productID;
    }

    public String getDenotation()
    {
        return denotation;
    }

    public void setDenotation(String denotation)
    {
        this.denotation = denotation;
    }

    public BigDecimal getPrize()
    {
        return prize;
    }

    public void setPrize(BigDecimal prize)
    {
        this.prize = prize;
    }

    @XmlTransient
    public Collection<Transport> getTransportCollection()
    {
        return transportCollection;
    }

    public void setTransportCollection(Collection<Transport> transportCollection)
    {
        this.transportCollection = transportCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product))
        {
            return false;
        }
        Product other = (Product) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.logisticstool.logisticstool.Product[ productID=" + productID + " ]";
    }
    
}
