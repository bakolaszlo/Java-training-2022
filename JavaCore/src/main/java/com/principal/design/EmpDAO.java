package com.principal.design;

import java.util.Collection;

public interface EmpDAO {
    public int create(Emp e);
    public Emp get(int id);
    public boolean delete(int id);
    public boolean update(Emp e);
    public Collection<Emp> getAll();
}
