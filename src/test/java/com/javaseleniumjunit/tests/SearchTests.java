package com.javaseleniumjunit.tests;

import com.javaseleniumjunit.pages.Map.SearchMap;
import com.javaseleniumjunit.bases.TestBase;
import org.junit.Test;


public class SearchTests extends TestBase {
    //Objetos
    SearchMap map;


    //Testes
    @Test
    public void pesquisaInicial(){
      map = new SearchMap();
      map.acessarMap();
    }
}
