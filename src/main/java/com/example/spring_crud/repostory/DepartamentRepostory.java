package com.example.spring_crud.repostory;

import com.example.spring_crud.model.Departament;

import java.util.List;

public interface DepartamentRepostory {
    List<Departament> getAllDepartament();
    Departament getDepartmentsById(Long id);
    void deleteDepartmentsById(Long id);

}
