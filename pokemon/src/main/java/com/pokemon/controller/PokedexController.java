package com.pokemon.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pokemon.constantes.Constantes;

@Controller
@RequestMapping("/")
public class PokedexController {
	
	private static final Log LOG=LogFactory.getLog(PokedexController.class);
	
	@GetMapping("/pokedex")
	public ModelAndView pokedex() {
		ModelAndView mav=new ModelAndView(Constantes.POKEDEX_VIEW);
		
		return mav;
	}
}
