package com.logisticstool.logisticstool;

import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

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

    FacesContext context = FacesContext.getCurrentInstance();

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

    public void loginControl(ActionEvent event)
    {
        try
        {
            RequestContext requestContext = RequestContext.getCurrentInstance();
            FacesMessage message = null;
            boolean loggedIn = false;
            if (items == null)
            {
                items = getFacade().findAll();
            }

            if(validateEntries())
            {
                loggedIn = true;
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Willkommen ", username);
            }
            else
            {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Anmelden fehlgeschlagen.", "Benutzername / Passwort ungültig.");
            }
            
            FacesContext.getCurrentInstance().addMessage(null, message);
            requestContext.addCallbackParam("loggedIn", loggedIn);
        }
        catch(Exception e)
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Ausnahmefehler aufgetreten.", "Ungültige Eingaben.");
            FacesContext.getCurrentInstance().addMessage(null, message);
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
                    Userdata user = new Userdata(items.get(i).getUserDataID(), items.get(i).getUsername(), items.get(i).getPassword());
                    setSelected(user);
                    //context.getExternalContext().getSessionMap().put(selected.getUsername(), user);
                    break;
                }
            }
        }
        
        return request;
    }    
}