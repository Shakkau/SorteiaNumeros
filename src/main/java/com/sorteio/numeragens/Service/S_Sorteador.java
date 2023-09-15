package com.sorteio.numeragens.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class S_Sorteador {

    public static List<Integer> geraNumeros(int min, int max, int quantidade,
                                            boolean checkedOrdenarN, boolean checkedRepetirN) {


        /*if (checkedRepetirN) {
            List<Integer> numerosSorteados = new ArrayList<>();
            Random random = new Random();

            for (int i = 0; i < quantidade; i++) {
                int numeroSorteado = min + random.nextInt(max - min + 1);
                numerosSorteados.add(numeroSorteado);
            }

            return numerosSorteados;*/
        //} else {
            //if (quantidade > max || quantidade < min) {
                //try {
                    List<Integer> numerosNoIntervalo = IntStream.rangeClosed(min, max)
                            .boxed()
                            .collect(Collectors.toList());

                    Random random = new Random();

                    List<Integer> numerosSorteados = new ArrayList<>();
                    for (int i = 0; i < quantidade; i++) {
                        int indiceSorteado = random.nextInt(numerosNoIntervalo.size());
                        int numeroSorteado = numerosNoIntervalo.remove(indiceSorteado);
                        numerosSorteados.add(numeroSorteado);
                    }
                    return numerosSorteados;
                //} catch (RuntimeException exception){
                    //return null;
                //}
            //}

        //}
        //return null;
    }
}
