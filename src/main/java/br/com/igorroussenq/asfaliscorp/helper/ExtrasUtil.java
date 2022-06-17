package br.com.igorroussenq.asfaliscorp.helper;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class ExtrasUtil {
    public static void transfereParaTexto(String acidente,Integer iterator) {
        try {
            FileWriter acidenteTexto = new FileWriter("/home/igorroussenq/java/cadastro-de-acidentes/src/main/resources/datas/Acidente" + iterator + ".txt");
            acidenteTexto.write("Data de registro do acidente: "+ LocalDate.now() + "\n--------------------------------------\n" + acidente + "\n--------------------------------------");
            acidenteTexto.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro");
            e.printStackTrace();
        }
    }
}
