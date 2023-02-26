package com.example.spring_crud.service;

import com.example.spring_crud.model.Departament;

import java.util.List;

public interface DepartamentService {
    List<Departament> getAllDepartament();

    Departament getDepartmentsById(Long id);

    void deleteDepartmentsById(Long id);
}
