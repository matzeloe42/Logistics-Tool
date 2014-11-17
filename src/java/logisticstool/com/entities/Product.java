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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matze
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductid", query = "SELECT p FROM Product p WHERE p.productid = :productid"),
    @NamedQuery(name = "Product.findByDenotation", query = "SELECT p FROM Product p WHERE p.denotation = :denotation"),
    @NamedQuery(name = "Product.findByPrize", query = "SELECT p FROM Product p WHERE p.prize = :prize")
})
public class Product implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCTID")
    private Integer productid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DENOTATION")
    private String denotation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIZE")
    private int prize;

    public Product()
    {
    }

    public Product(Integer productid)
    {
        this.productid = productid;
    }

    public Product(Integer productid, String denotation, int prize)
    {
        this.productid = productid;
        this.denotation = denotation;
        this.prize = prize;
    }

    public Integer getProductid()
    {
        return productid;
    }

    public void setProductid(Integer productid)
    {
        this.productid = productid;
    }

    public String getDenotation()
    {
        return denotation;
    }

    public void setDenotation(String denotation)
    {
        this.denotation = denotation;
    }

    public int getPrize()
    {
        return prize;
    }

    public void setPrize(int prize)
    {
        this.prize = prize;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (productid != null ? productid.hashCode() : 0);
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
        if ((this.productid == null && other.productid != null) || (this.productid != null && !this.productid.equals(other.productid)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "logisticstool.com.entities.Product[ productid=" + productid + " ]";
    }
    
}
