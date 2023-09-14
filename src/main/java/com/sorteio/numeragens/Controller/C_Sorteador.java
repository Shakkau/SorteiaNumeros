package com.sorteio.numeragens.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    public String drawNumbers(@RequestParam("quantityNumbers") int quantidade,
                              @RequestParam("minNumber") int primeiroParametro,
                              @RequestParam("maxNumber") int segundoParametro,
                              Model model){
        int qtdSorteada = quantidade;
        int min = Math.min(primeiroParametro, segundoParametro);
        int max = Math.max(primeiroParametro, segundoParametro);
        int numeroSorteado = 0;
        int indiceSorteado;

        List<Integer> numerosNoIntervalo = IntStream.rangeClosed(min, max)
                .boxed()
                .collect(Collectors.toList());

        Random random = new Random();

        List<Integer> numerosSorteados = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            indiceSorteado = random.nextInt(numerosNoIntervalo.size());
            numeroSorteado = numerosNoIntervalo.remove(indiceSorteado);
            numerosSorteados.add(numeroSorteado);
            System.out.println("Número sorteado: " + numeroSorteado);
        }

        model.addAttribute("qtdSorteada", qtdSorteada);
        model.addAttribute("numerosSorteados", numerosSorteados);
        model.addAttribute("numeroMinimo", min);
        model.addAttribute("numeroMaximo", max);

        return "resultPage/resultpage";
    }
}
