package com.sorteio.numeragens.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class C_Sorteador {

    @GetMapping("/")
    public String pagInicial(){
        return "inicPage/firstPage";
    }

    @GetMapping("/inicio")
    public String getFirstPage(){
        return "inicPage/firstPage";
    }

    @PostMapping("/")
    public String sorteando(){
        return "";
    }
}
