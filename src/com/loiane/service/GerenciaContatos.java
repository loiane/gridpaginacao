package com.loiane.service;

import java.util.ArrayList;
import java.util.List;

import com.loiane.model.Contato;

/**
 * Gera contatos aleatórios para preencher o grid
 * 
 * @author Loiane Groner
 */
public class GerenciaContatos {
	
	public static int LIMITE = 50;
	
	/**
	 * Gera 10 contatos a partir de um parâmetro de início.
	 * Limite de 50 contatos
	 * @param inicio
	 * @return
	 */
	public static List<Contato> getJson(int inicio){
		
		List<Contato> contatos = new ArrayList<Contato>(10);
		
		for (int i=inicio; i<(inicio+10) && (i<LIMITE); i++){
			contatos.add(geraContato(i));
		}

		return contatos;
	}
	
	private static Contato geraContato(int i){
		return new Contato("Nome"+i,"nome"+i+"@provedor.com");
	}
}
