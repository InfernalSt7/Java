package com.pokemon.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pokemon.constantes.Constantes;

@Controller
@RequestMapping("/")
public class PerfilController {

private static final Log LOG=LogFactory.getLog(PerfilController.class);

	@GetMapping("/perfil")
	public ModelAndView perfil() {
		ModelAndView mav=new ModelAndView(Constantes.PERFIL_VIEW);
		LOG.info("Estamos método del perfil y nos devuelve la vista"+Constantes.PERFIL_VIEW);
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("nombre",user.getUsername());
		return mav;
	}
}
