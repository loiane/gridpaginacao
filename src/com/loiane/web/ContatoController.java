package com.loiane.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.loiane.model.Contato;
import com.loiane.service.GerenciaContatos;

/**
 * Controller - Spring
 * 
 * @author Loiane Groner
 */
public class ContatoController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//obtém o parâmetro de início
		String iniParam = request.getParameter("start");
		int inicio = (iniParam == null) ? 0 : Integer.parseInt(iniParam);
		
		//gera os contatos
		List<Contato> contatos = GerenciaContatos.getJson(inicio);

		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("total", GerenciaContatos.LIMITE);
		modelMap.put("rows", contatos);
		
		return new ModelAndView("jsonView", modelMap);
		
	}

}
