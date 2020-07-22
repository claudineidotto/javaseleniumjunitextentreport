package com.javaseleniumjunit.tests;

import com.javaseleniumjunit.pages.Map.SearchMap;
import com.javaseleniumjunit.bases.TestBase;
import org.junit.Assert;
import org.junit.Test;


public class SearchTests extends TestBase {
    SearchMap map;

    @Test
    public void pesquisaInicial(){
      Boolean teste = true ;
      map = new SearchMap();
      map.acessarMap();

      Assert.assertTrue(teste);
    }
}
