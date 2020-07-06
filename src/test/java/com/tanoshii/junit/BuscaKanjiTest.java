package com.tanoshii.junit;

import org.junit.Test;

public class BuscaKanjiTest extends ParentTest {

	@Test
	public void getKanji(){
		veA("https://www.tanoshiijapanese.com/home/");
		verificaInicio();
		buscaPalabra("horobiru");
		if(verificaMultiples()){
			veAPrimerResultado();
			verificaKanji();
		}else{
			verificaKanji();
		}
	}
	
	@Test
	public void getKanji2(){
		veA("https://www.tanoshiijapanese.com/home/");
		verificaInicio();
		buscaPalabra("toufu");
		if(verificaMultiples()){
			veAPrimerResultado();
			verificaKanji();
		}else{
			verificaKanji();
		}
	}
}
