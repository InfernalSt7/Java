package com.pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pokemon.constantes.Constantes;
import com.pokemon.entity.Entrenador;
import com.pokemon.model.EntrenadorModel;
import com.pokemon.repository.EntrenadorJpaRepository;
import com.pokemon.service.EntrenadorService;

@Controller
@RequestMapping("/entrenador")
public class EntrenadorController {

	
	@Autowired
	@Qualifier("entrenadorServiceImpl")
	private EntrenadorService entrenadorService;
	
	
	@Autowired
	@Qualifier("entrenadorRepository")
	private EntrenadorJpaRepository entrenadorJpaRepository;
	
	@GetMapping("/listEntrenador")
	public ModelAndView listAllEntrenadores() {
		ModelAndView mav = new ModelAndView(Constantes.ENTRENADOR_VIEW);
		mav.addObject("entrenador",new Entrenador());
		mav.addObject("entrenadores", entrenadorService.listAllEntrenadores());
		return mav;
	}
	
	@PostMapping("/addEntrenador")
	public String addEntrenador(@ModelAttribute("entrenador") EntrenadorModel entrenadorModel) {
		entrenadorService.addEntrenador(entrenadorModel);
		return "redirect:/entrenador/listEntrenador";
		
	}
	
	
	@GetMapping("/create")
	public ModelAndView createEntrenador(){
		ModelAndView mav=new ModelAndView(Constantes.CREATEENTRENADOR_VIEW);
		mav.addObject("entrenador",new Entrenador());
		return mav;
	}
	
	
	@GetMapping("/edit")
	public ModelAndView editEntrenador(@RequestParam(name="id", required=true) int id, EntrenadorModel entrenadorModel) {
		ModelAndView mav = new ModelAndView(Constantes.EDITENTRENADOR_VIEW);
		if (id ==0) {
			mav.addObject("entrenador", new EntrenadorModel());
		} else {
			mav.addObject("entrenador", entrenadorService.updateEntrenador(id));
		}
		return mav;
	}
	
	@PostMapping("/delete")
	public String deleteEntrenador(@RequestParam("id") int id) {
		entrenadorService.removeEntrenador(id);
		return "redirect:/entrenador/listEntrenador";
	}
}
