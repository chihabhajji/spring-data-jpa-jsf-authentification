package tn.esprit.springdatajpajsfauthentification.controller;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tn.esprit.springdatajpajsfauthentification.entity.Employe;
import tn.esprit.springdatajpajsfauthentification.entity.Role;
import tn.esprit.springdatajpajsfauthentification.service.IEmployeService;

import java.util.List;


@Scope(value = "session")
@Controller(value = "employeController")
@ELBeanName(value = "employeController")
@Join(path = "/", to = "/login.jsf")
public class EmployeController {

    @Autowired
    IEmployeService iEmployeService;

    private String login;
    private String password;
    private Employe employe;
    private Boolean loggedIn;
    private String email;
    private Boolean isActive;
    private Role role;
    private Integer employeIdToBeUpdated;
    private List<Employe> employes;

    public String dologin() {
        String navigateTo = "null";
        Employe employe=iEmployeService.getEmployeByEmailAndPassword(login, password);
        if (employe != null && employe.getRole() == Role.ADMINISTRATEUR) {
            navigateTo = "/welcome.xhtml?faces-redirect=true";
            loggedIn = true;
        }
        else {
            FacesMessage facesMessage = new FacesMessage("Login Failed: please check your username/password and try again.");
            FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
        }
        return navigateTo;
    }
    public String doLogout()
    {FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }
    public String ajouterEmploye(){
        String navigateTo ="null";
        if(!loggedIn) return "/login.xhtml";
            iEmployeService.ajouterEmploye(new Employe(login, password, email, role, isActive));
            navigateTo = "/welcome.xhtml?faces-redirect=true";
        return navigateTo;
    }
    public void removeEmploye(int employeId){
        iEmployeService.deleteEmploye(employeId);
    }

    public void mettreAjourEmploye() {
        iEmployeService.updateEmploye(new Employe(employeIdToBeUpdated,login,password,email,role,isActive));
    }

    public EmployeController(){
        super();
        employe = new Employe();
        loggedIn = false;
    }

    public void modifier(Employe employe) {
        this.setEmail(employe.getEmail());
        this.setActive(employe.getActive());
        this.setLogin(employe.getLogin());
        this.setPassword(employe.getPassword());
        this.setRole(employe.getRole());
        this.setEmployeIdToBeUpdated(employe.getId());
    }

    public IEmployeService getiEmployeService() {
        return iEmployeService;
    }

    public Integer getEmployeIdToBeUpdated() { return employeIdToBeUpdated; }
    public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) { this.employeIdToBeUpdated = employeIdToBeUpdated; }
    public List<Employe> getEmployes() { return iEmployeService.getAllEmployes(); }
    public void setEmployes(List<Employe> employes) { this.employes = employes; }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Employe getEmploye() {
        return employe;
    }
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    public Boolean getLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Boolean getActive() { return isActive; }
    public void setActive(Boolean active) { isActive = active; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

}
