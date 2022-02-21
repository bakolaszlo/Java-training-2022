package com.principal.design;

import java.util.Collection;
import java.util.Collections;

public class EmpDAOImpl implements EmpDAO{
    @Override
    public int create(Emp e) {
        // Connect to datastore, insert data for employee;
        return 0;
    }

    @Override
    public Emp get(int id) {
        // Connect to datastore, retrieve and return data for employee based on id;
        return new Emp();
    }

    @Override
    public boolean delete(int id) {
        // Connect to datastore, remove employee based on id;
        return false;
    }

    @Override
    public boolean update(Emp e) {
        // Connect to datastore, and update data fields for employee;
        return false;
    }

    @Override
    public Collection<Emp> getAll() {
        // Connect to datastore, retrieve and employee data as collection;
        return Collections.EMPTY_LIST;
    }
}
