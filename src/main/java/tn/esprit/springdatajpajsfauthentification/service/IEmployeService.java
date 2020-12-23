package tn.esprit.springdatajpajsfauthentification.service;

import tn.esprit.springdatajpajsfauthentification.entity.Employe;

import java.util.List;

public interface IEmployeService {
    void ajouterEmploye(Employe e);
    Employe getEmployeByEmailAndPassword(String login, String password) ;
    List<Employe> getAllEmployes();
    void deleteEmploye(int employeId);
    void updateEmploye(Employe e);
}
