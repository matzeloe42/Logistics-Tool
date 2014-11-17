/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logisticstool.com.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import logisticstool.com.entities.Address;

/**
 *
 * @author Matze
 */
@Stateless
public class AddressFacade extends AbstractFacade<Address>
{
    @PersistenceContext(unitName = "Logistics-ToolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public AddressFacade()
    {
        super(Address.class);
    }
    
}
