package com.example.spring_crud.controller;

import com.example.spring_crud.model.Departament;
import com.example.spring_crud.service.DepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class DepartamentController {

    @Autowired
    public DepartamentService departamentService;

//read
    @GetMapping("departments")
    public List<Departament> getAllDepartament() {

        return departamentService.getAllDepartament();
    }


    @GetMapping("departments/{id}")
    public Departament getDepartmentsById(@PathVariable(name = "id") Long idMehmed) {
        System.out.println("Idmehmed postmandan bura geldi " + idMehmed);
        Departament departament = departamentService.getDepartmentsById(idMehmed);
        return departament;
    }

//delete
    @DeleteMapping("departments/{id}")
    public void  deleteDepartmentsById(@PathVariable(name = "id") Long idMehmed) {
        System.out.println("Idmehmed postmandan bura geldi silinecek  " + idMehmed);
         departamentService.deleteDepartmentsById(idMehmed);
    }

    //create
    //update

}
