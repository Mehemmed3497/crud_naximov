package com.example.spring_crud.repostory;

import com.example.spring_crud.model.Departament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DepartamentRepostoryImpl implements DepartamentRepostory {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Departament> getAllDepartament() {
        String sql = "select * from departament";
        List<Departament> departaments = jdbcTemplate.query(sql, new DepartamentRowMapper());
        return departaments;
    }

    @Override
    public Departament getDepartmentsById(Long id) {
        String sql = "select * from departament d where d.id= " + id;
        List<Departament> departaments = jdbcTemplate.query(sql, new DepartamentRowMapper());
        if (!departaments.isEmpty()) {
            return departaments.get(0);
        }
        return null;
    }

    @Override
    public void deleteDepartmentsById(Long id) {
//        String sql ="delete  from departament d where d.id = "+id;
//        System.out.println("sql-----> "+sql);
//        jdbcTemplate.update(sql);
        //yeni yol


        String sql = "delete  from departament d where d.id = ?";
//        String sql = "select deletedepartmenbyid(?)"; //novbeti
        Object[] bazayaGedecekDeyisenler = new Object[]{id};
        jdbcTemplate.update(sql, bazayaGedecekDeyisenler);


    }

    private class DepartamentRowMapper implements RowMapper<Departament> {


        @Override
        public Departament mapRow(ResultSet rs, int rowNum) throws SQLException {
            Departament departament = new Departament();
            departament.setId(rs.getLong("id"));
            departament.setName(rs.getString("name"));
            departament.setAge(rs.getInt("age"));

            return departament;
        }
    }
}
