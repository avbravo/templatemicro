/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.templatefaces.security;

import jakarta.inject.Inject;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ServiceLoader.Provider;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author avbravo
 */
public class SecuritySessionListener implements HttpSessionListener, Serializable {
private Integer sessionTimeout=4;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("********************************************************************");
        System.out.println("Session created : " + se.getSession().getId() + " at " + new Date());
        System.out.println("********************************************************************");
        /**
         * Establece el periodo de inactivad para cerrar la sesion.
         */
        HttpSession session = se.getSession();
session.setMaxInactiveInterval(sessionTimeout*60);
        System.out.println("----->>>> seundos "+(sessionTimeout*60));
        System.out.println("---Estableciendo periodo de inactividad.....");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        
        System.out.println("********************************************************************");
        System.out.println("session destroyed :" + session.getId() + " Logging out user... at  " + new Date());
        System.out.println("********************************************************************");
    }
}
