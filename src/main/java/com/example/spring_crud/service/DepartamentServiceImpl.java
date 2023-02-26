package com.example.spring_crud.service;

import com.example.spring_crud.model.Departament;
import com.example.spring_crud.repostory.DepartamentRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentServiceImpl implements DepartamentService {

    @Autowired
    public DepartamentRepostory departamentRepostory;

    @Override
    public List<Departament> getAllDepartament() {
        return departamentRepostory.getAllDepartament();
    }

    @Override
    public Departament getDepartmentsById(Long id) {
        return departamentRepostory.getDepartmentsById(id);
    }

    @Override
    public void deleteDepartmentsById(Long id) {
        departamentRepostory.deleteDepartmentsById(id);
    }
}
