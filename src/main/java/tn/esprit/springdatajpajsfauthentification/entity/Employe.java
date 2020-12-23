package tn.esprit.springdatajpajsfauthentification.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employe implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Boolean isActive;

    public Employe(String login, String password, String email, Role role, Boolean isActive) {
        super();
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        this.isActive = isActive;
    }
    public Employe(Integer id,String login, String password, String email, Role role, Boolean isActive) {
        super();
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        this.isActive = isActive;
    }
    public Employe() { super(); }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Boolean getActive() { return isActive; }
    public void setActive(Boolean active) { isActive = active; }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

}
