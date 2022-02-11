package com.principal.training;

import com.principal.design.Emp;
import com.principal.design.EmpDAO;
import com.principal.design.EmpDAOImpl;

public class DAOMain {
    public static void main(String[] args) {
        Emp emp = new Emp();
        emp.setId(10);
        emp.setName("Harry");
        emp.setAge(39);
        emp.setAddress("USA");

        EmpDAO dao = new EmpDAOImpl();
        dao.create(emp);
        emp.setName("Tim");
        emp.setAge(23);
        dao.update(emp);

        Emp emp2 = dao.get(11);
        if(emp2 != null){
            dao.delete(emp2.getId());
        }
    }
}
