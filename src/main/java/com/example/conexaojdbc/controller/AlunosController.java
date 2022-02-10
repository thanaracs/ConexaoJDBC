package com.example.conexaojdbc.controller;

import com.example.conexaojdbc.dao.AlunoDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("alunos")
public class AlunosController {
    AlunoDAO dao;
    public AlunosController(){
        dao = new AlunoDAO();
    }
    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("alunos", dao.buscarAlunos());
        return new ModelAndView("/alunos/list", model);
    }
}
