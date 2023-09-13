package com.sorteio.numeragens.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class C_Sorteador {

    @GetMapping("/")
    public String pagInicial() {
        return "inicPage/firstPage";
    }

    @GetMapping("/inicio")
    public String getFirstPage() {
        return "inicPage/firstPage";
    }

    @GetMapping("/paginaResultado")
    public String getResultPage(){
        return "resultPage/resultpage";
    }

    @PostMapping("/paginaResultado")
    @ResponseBody
    public String drawNumbers(@RequestParam("quantityNumbers") int quantidade,
                              @RequestParam("minNumber") int primeiroParametro,
                              @RequestParam("maxNumber") int segundoParametro,
                              Model model){
        int menor = Math.min(primeiroParametro, segundoParametro);
        int maior = Math.max(primeiroParametro, segundoParametro);

        List<Integer> numerosNoIntervalo = IntStream.rangeClosed(menor, maior)
                .boxed()
                .collect(Collectors.toList());

        Random random = new Random();

        // Embaralhe a lista
        for (int i = 0; i < quantidade; i++) {
            int indiceSorteado = random.nextInt(numerosNoIntervalo.size());
            int numeroSorteado = numerosNoIntervalo.remove(indiceSorteado);
            System.out.println("Número sorteado: " + numeroSorteado);
        }

        model.addAttribute("numerosSorteados", numerosNoIntervalo);

        return "/resultpage";
    }
}
