package com.tecsup.ejb.beans;

import com.tecsup.ejb.dao.ProgramaDAO;
import com.tecsup.ejb.model.Programa;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class ProgramaMultiBean {

    @Inject
    ProgramaDAO programaDAO;

    private List<Programa> programas;

    private Programa programa = new Programa();

    public String update(Programa pro) {
        this.programa = pro;
        
        return "programaForm.xhtml";
    }

    public String save() {
        if (programa.getId() == null) {
            programaDAO.save(programa);
        } else {
            programaDAO.update(programa);
        }

        this.programa = new Programa();
        
        return "programaIndex.xhtml";
    }

    public void delete(Programa programa) {
        programaDAO.delete(programa);
    }

    public List<Programa> getProgramas() {
        programas = programaDAO.all();
        return programas;
    }

    public Programa getPrograma() {
        return programa;
    }

}
