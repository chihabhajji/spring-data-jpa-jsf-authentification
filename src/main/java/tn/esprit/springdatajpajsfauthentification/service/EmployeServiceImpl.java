package tn.esprit.springdatajpajsfauthentification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springdatajpajsfauthentification.entity.Employe;
import tn.esprit.springdatajpajsfauthentification.repository.EmployeRepository;

import java.util.List;

@Service
public class EmployeServiceImpl implements IEmployeService
{

    @Autowired
    EmployeRepository employeRepository;

    public void ajouterEmploye(Employe e){
        employeRepository.save(e);
    }
    public Employe getEmployeByEmailAndPassword(String login, String password) {
        return employeRepository.getEmployeByEmailAndPassword(login, password);
    }

    @Override
    public List<Employe> getAllEmployes() {
        return (List<Employe>) employeRepository.findAll();
    }

    @Override
    public void deleteEmploye(int employeId) {
        employeRepository.deleteById(employeId);
    }

    @Override
    public void updateEmploye(Employe e) {
        employeRepository.save(e);
    }
}
