package com.tecsup.ejb.dao;

import com.tecsup.ejb.model.Programa;
import java.util.List;

public interface ProgramaDAO {

    public List<Programa> all();

    public Programa find(Long id);

    public void save(Programa programa);

    public void update(Programa programa);

    public void delete(Programa programa);

}
