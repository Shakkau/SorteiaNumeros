package com.sorteio.numeragens.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
