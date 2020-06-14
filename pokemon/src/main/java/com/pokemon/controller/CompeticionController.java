package com.pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pokemon.constantes.Constantes;
import com.pokemon.entity.Competicion;
import com.pokemon.model.CompeticionModel;
import com.pokemon.repository.CompeticionJpaRepository;
import com.pokemon.service.CompeticionService;


@Controller
@RequestMapping("/competicion")
public class CompeticionController {

	
	
	@Autowired
	@Qualifier("competicionServiceImpl")
	private CompeticionService competicionService;
	
	
	@Autowired
	@Qualifier("competicionRepository")
	private CompeticionJpaRepository competicionJpaRepository;
	
	@GetMapping("/listCompeticion")
	public ModelAndView listCompeticion() {
		ModelAndView mav = new ModelAndView(Constantes.COMPETICION_VIEW);
		mav.addObject("competicion",new Competicion());
		mav.addObject("competiciones", competicionService.listCompeticion());
		return mav;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addCompeticion")
	public String addCompeticion(@ModelAttribute("competicion") CompeticionModel competicionModel) {
		competicionService.addCompeticion(competicionModel);
		return "redirect:/competicion/listCompeticion";
		
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/create")
	public ModelAndView createCompeticion(){
		ModelAndView mav=new ModelAndView(Constantes.CREATECOMPETICION_VIEW);
		mav.addObject("competicion",new Competicion());
		return mav;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/edit")
	public ModelAndView editCompeticion(@RequestParam(name="id", required=true) int id, CompeticionModel competicionModel) {
		ModelAndView mav = new ModelAndView(Constantes.EDITCOMPETICION_VIEW);
		if (id ==0) {
			mav.addObject("competicion", new CompeticionModel());
		} else {
			mav.addObject("competicion", competicionService.updateCompeticion(id));
		}
		return mav;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/delete")
	public String deleteCompeticion(@RequestParam("id") int id) {
		competicionService.removeCompeticion(id);
		return "redirect:/competicion/listCompeticion";
	}
}
