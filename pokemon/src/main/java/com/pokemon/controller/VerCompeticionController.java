package com.pokemon.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pokemon.constantes.Constantes;

@Controller
@RequestMapping("/")
public class VerCompeticionController {
	
	private static final Log LOG=LogFactory.getLog(VerCompeticionController.class);
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_ENTRENADOR')")
	@GetMapping("/vercompeticion")
	public ModelAndView competiciones() {
		ModelAndView mav=new ModelAndView(Constantes.VERCOMPETICION_VIEW);
		LOG.info("Funciona");
		return mav;
	}
}
