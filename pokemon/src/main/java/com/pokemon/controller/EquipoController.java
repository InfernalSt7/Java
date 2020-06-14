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
import com.pokemon.entity.Equipo;
import com.pokemon.model.EquipoModel;
import com.pokemon.model.PokemonModel;
import com.pokemon.repository.EquipoJpaRepository;
import com.pokemon.service.EquipoService;
import com.pokemon.service.PokemonService;

@Controller
@RequestMapping("/equipo")
public class EquipoController {

	
	@Autowired
	@Qualifier("equipoServiceImpl")
	private EquipoService equipoService;
	
	@Autowired
	@Qualifier("pokemonServiceImpl")
	private PokemonService pokemonService;
	
	
	@Autowired
	@Qualifier("equipoRepository")
	private EquipoJpaRepository equipoJpaRepository;
	
	@GetMapping("/listEquipos")
	public ModelAndView listAllEquipos() {
		ModelAndView mav = new ModelAndView(Constantes.EQUIPO_VIEW);
		mav.addObject("equipo",new Equipo());
		mav.addObject("equipos", equipoService.listAllEquipos());
		//mav.addObject("pokemon", pokemonService.listAllPokemons());
		return mav;
	}
	
	@PostMapping("/addEquipo")
	public ModelAndView addEquipo(@ModelAttribute("equipo") @RequestParam("equipo") int equipo, EquipoModel equipoModel) {
		
		ModelAndView mav = new ModelAndView(Constantes.EQUIPO_VIEW);
		
		for (PokemonModel pokemonModel: pokemonService.listAllPokemons()) {
			if (equipo == pokemonModel.getId()) {
				equipoModel.setPokemon(pokemonModel);
			}
		}
		
		
		equipoService.addEquipo(equipoModel);
		mav.addObject("equipos", equipoService.listAllEquipos());
		return mav;
		
	}
	
	
	@GetMapping("/create")
	public ModelAndView createEquipo(){
		ModelAndView mav=new ModelAndView(Constantes.CREATEEQUIPO_VIEW);
		mav.addObject("equipo",new Equipo());
		//mav.addObject("pokemon", pokemonService.listAllPokemons());
		return mav;
	}
	
	
	@GetMapping("/edit")
	public ModelAndView editEquipo(@RequestParam(name="id", required=true) int id, EquipoModel equipoModel) {
		ModelAndView mav = new ModelAndView(Constantes.EDITEQUIPO_VIEW);
		if (id ==0) {
			mav.addObject("equipo", new EquipoModel());
		} else {
			mav.addObject("equipo", equipoService.updateEquipo(id));
		}
		return mav;
	}
	
	@PostMapping("/delete")
	public String deleteEquipo(@RequestParam("id") int id) {
		equipoService.removeEquipo(id);
		return "redirect:/equipo/listEquipos";
	}
}
