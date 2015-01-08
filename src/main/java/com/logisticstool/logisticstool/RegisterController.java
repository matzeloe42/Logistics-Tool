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
import org.primefaces.context.RequestContext;

@Named("registerController")
@SessionScoped
public class RegisterController implements Serializable
{
    private static final long serialVersionUID = 1L;

    @EJB
    private com.logisticstool.logisticstool.UserdataFacade ejbFacade;
    private List<Userdata> items = null;
    //private Userdata selected;

    private String username;
    private String password;

    public RegisterController()
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

    /*public Userdata getSelected()
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
    }*/

    private UserdataFacade getFacade()
    {
        return ejbFacade;
    }

    /*public Userdata prepareCreate()
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
    }*/

    public void create()
    {
        try
        {
            RequestContext context = RequestContext.getCurrentInstance();
            FacesMessage message = null;
            boolean registered = false;
            items = getFacade().findAll();

            if(validateEntries())
            {
                registered = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Fehler", "Benutzername bereits vorhanden.");
                /*FacesMessage m = new FacesMessage
                                (
                                    "Benutzer bereits vorhanden!",
                                    "Bitte verwenden Sie einen anderen Benutzernamen."
                                );
                FacesContext.getCurrentInstance().addMessage("RegisterForm", m);*/
            }
            else
            {
                /*FacesMessage m = new FacesMessage
                                (
                                    "Erfolgreich registriert.",
                                    "Benutzer '" + username + "' erfolgreich angelegt."
                                );
                FacesContext.getCurrentInstance().addMessage("RegisterForm", m);*/
                
                Userdata newUser = new Userdata();
                newUser.setUsername(username);
                newUser.setPassword(password);
                
                getFacade().edit(newUser);
                
                registered = true;
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrierung erfolgreich!", username);
            }
            
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", registered);
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
            FacesContext.getCurrentInstance().addMessage("RegisterForm", m);
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