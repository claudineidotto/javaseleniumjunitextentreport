package com.javaseleniumjunit.pages.Map;

import com.javaseleniumjunit.pages.Funcoes.SearchMapFunc;
import org.openqa.selenium.By;

public class SearchMap extends SearchMapFunc {

    By testeMap = By.xpath("//input[@type='text']");


    public void acessarMap (){

        entrarEsporte(testeMap);
        try { Thread.sleep(10000); } catch (InterruptedException ex) {
            System.out.println ("Puxa, estava dormindo! Você me acordou");
        }
    }
}
