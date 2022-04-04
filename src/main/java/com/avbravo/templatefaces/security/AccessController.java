
package com.avbravo.templatefaces.security;

import com.avbravo.jmoordbutils.DateUtil;
import com.avbravo.jmoordbutils.JsfUtil;
import com.avbravo.jmoordbutils.paginator.Paginator;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import lombok.Data;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.primefaces.PrimeFaces;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
//import org.eclipse.microprofile.config.Config;
//import org.eclipse.microprofile.config.inject.ConfigProperty;


/**
 *
 * @author avbravo
 */
@Named
@SessionScoped
@Data
public class AccessController implements Serializable {
    // <editor-fold defaultstate="collapsed" desc="field">
   
private String profile;  
        


// <editor-fold defaultstate="collapsed" desc="Microprofile Config">
//   @Inject
//   ConfigProducer configProducer;
   
 // </editor-fold>
        
    /**
     * Creates a new instance of AccessSecurity
     */
    public AccessController() {
        System.out.println("---->constructor ");
    }
      // <editor-fold defaultstate="collapsed" desc="init">
    @PostConstruct
    public void init() {
        try {
            System.out.println("---> init...");
            // Usuario logeado
          
        } catch (Exception e) {
            
            System.out.println(JsfUtil.nameOfClass()  + " "+JsfUtil.nameOfMethod());
        }
    }

    // </editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="String logout()">
    public String logout() {
//        return logout(applicativePath+ "/faces/login.xhtml?faces-redirect=true");
return "";
    }
    // </editor-fold>
    
    
     // <editor-fold defaultstate="collapsed" desc="String logout(String path)">
    public String logout(String path) {
        Boolean loggedIn = false;
        try {

            //Guarda el registro del acceso
            String ip = JsfUtil.getIp() == null ? "" : JsfUtil.getIp();
//            Access access = new Access.Builder()
//                    .idaccess(0)
//                    .date(DateUtil.getFechaHoraActual())
//                    .ip(ip)
//                    .username(user.getUsername())
//                    .idapplicative(applicativeId.get())
//                    .event("logout")
//                    .iddepartament(profile.getIddepartament())
//                    .idprofile(profile.getIdprofile())
//                    .idrole(profile.getIdrole())
//                    .build();
//
//            accessEvent.fire(new AccessEvent(access));
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            if (session != null) {
                session.invalidate();
            }
            String url = (path);
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            ec.redirect(url);
            return path;
        } catch (Exception e) {
        // loggerServices.processException(JsfUtil.nameOfClass(), JsfUtil.nameOfMethod(), e, true);
        }
        return path;
    }
// </editor-fold>

}
