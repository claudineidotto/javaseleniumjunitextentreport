package com.javaseleniumjunit.pages.Funcoes;

import com.javaseleniumjunit.bases.PageBase;
import org.openqa.selenium.By;

public class SearchMapFunc extends PageBase {


    public void entrarEsporte(  By teste ){
      sendKeys (teste,"Teste");
    }

}
