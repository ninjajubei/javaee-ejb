/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsup.ejb.beans;

import com.tecsup.ejb.dao.CursoDAO;
import com.tecsup.ejb.dao.ProgramaDAO;
import com.tecsup.ejb.model.Curso;
import com.tecsup.ejb.model.Programa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author PCC
 */

@ManagedBean
@RequestScoped
public class CursoMultiBean {
    
    @Inject
    CursoDAO cursoDAO;
    
    private List<Curso> cursos;
    
    private Curso curso = new Curso();
    
    @Inject
    ProgramaDAO programaDAO;
    
    private List<Programa> programas = new ArrayList();
    
    private Programa programa = new Programa();
    
    public String update(Curso curso){
        this.curso=curso;
        
        return "cursoForm.xhtml";
    }
    
    public String save(){
        if(curso.getId() == null){
            cursoDAO.save(curso);
        } else {
            cursoDAO.update(curso);
        }
        
        this.curso = new Curso();
        
        return "cursoIndex.xhtml";
    }
    
    public void delete(Curso curso){
        cursoDAO.delete(curso);
    }

    public List<Curso> getCursos() {
        cursos = cursoDAO.all();
        return cursos;
    }
    
    public Curso getCurso() {
        return curso;
    }

    public List<Programa> getProgramas() {
        programas = programaDAO.all();
        return programas;
    }

    public Programa getPrograma() {
        return programa;
    }
    
    
}
