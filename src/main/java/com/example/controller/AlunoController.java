package com.example.conexaojdbc;


import dao.AlunoDAO;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("alunos")

public class AlunoController {
    AlunoDAO dao = new AlunoDAO();

    @ResponseBody
    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("alunos", dao.buscarAlunos());
        return new ModelAndView("/alunos/list", model);
    }
}
