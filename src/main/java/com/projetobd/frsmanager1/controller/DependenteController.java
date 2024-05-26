package com.projetobd.frsmanager1.controller;

import com.projetobd.frsmanager1.DAO.DependenteDAO;
import com.projetobd.frsmanager1.models.Dependente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dependente")
public class DependenteController {

    private final DependenteDAO dependenteDAO;

    @Autowired
    public DependenteController(DependenteDAO dependenteDAO) {
        this.dependenteDAO = dependenteDAO;
    }

    @PostMapping("/novo") // feito
    public boolean addDependente(@RequestBody Dependente dependente) {

        return dependenteDAO.addDependente(dependente);
    }

    @PutMapping("/atualizar/{cpf}") //feito
    public boolean updateDependente(@PathVariable String cpf, @RequestBody Dependente dependente) {

        return dependenteDAO.updateDependente(cpf, dependente);
    }

    @DeleteMapping("/{cpf}") //feito
    public boolean deleteDependente(@PathVariable String cpf) {

        return dependenteDAO.deleteDependente(cpf);
    }

    @GetMapping("/{cpfDependente}") //feito
    public Dependente encontrarDependentePorCpf(@PathVariable String cpfDependente) {
        return dependenteDAO.findByCpf(cpfDependente);
    }

    @GetMapping("/todos") //feito
    public  List<Dependente> getAllDependentes() {
        return dependenteDAO.getAllDependentes();
    }
}
