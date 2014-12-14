package com.logisticstool.logisticstool;

import com.logisticstool.logisticstool.util.JsfUtil;
import com.logisticstool.logisticstool.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("signinController")
@SessionScoped
public class SigninController implements Serializable
{
    private static final long serialVersionUID = 1L;

    @EJB
    private com.logisticstool.logisticstool.UserdataFacade ejbFacade;
    private List<Userdata> items = null;
    private Userdata selected;

    private String username;
    private String password;

    public SigninController()
    {
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Userdata getSelected()
    {
        return selected;
    }

    public void setSelected(Userdata selected)
    {
        this.selected = selected;
    }

    protected void setEmbeddableKeys()
    {
    }

    protected void initializeEmbeddableKey()
    {
    }

    private UserdataFacade getFacade()
    {
        return ejbFacade;
    }

    public Userdata prepareCreate()
    {
        selected = new Userdata();
        initializeEmbeddableKey();
        return selected;
    }

    public List<Userdata> getItems()
    {
        if (items == null)
        {
            items = getFacade().findAll();
        }
        return items;
    }

    public void find()
    {
        try
        {
            if (items == null)
            {
                items = getFacade().findAll();
            }

            if(validateEntries())
            {
                FacesMessage m = new FacesMessage
                                (
                                    "Sie haben sich erfolgreich angemeldet!",
                                    "Sie sind angemeldet als: " + username
                                );
                FacesContext.getCurrentInstance().addMessage("signinForm", m);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            FacesMessage m = new FacesMessage
                                (
                                    FacesMessage.SEVERITY_WARN,
                                    e.getMessage(),
                                    e.getCause().getMessage()
                                );
            FacesContext.getCurrentInstance().addMessage("signinForm", m);
        }
    }

    private boolean validateEntries()
    {
        boolean request = false;
        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getUsername().equals(username))
            {
                if(items.get(i).getPassword().equals(password))
                {
                    request = true;
                    i = items.size();
                }
            }
        }
        
        return request;
    }
}