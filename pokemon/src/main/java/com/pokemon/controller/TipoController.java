package com.pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pokemon.component.PDF;
import com.pokemon.constantes.Constantes;
import com.pokemon.entity.Tipos;
import com.pokemon.model.TipoModel;
import com.pokemon.repository.TipoJpaRepository;
import com.pokemon.service.TipoService;

@Controller
@RequestMapping("/tipo")
public class TipoController {
	
	
	@Autowired
	@Qualifier("tipoServiceImpl")
	private TipoService tipoService;
	
	private PDF pdftipo = new PDF();
	
	@Autowired
	@Qualifier("tipoRepository")
	private TipoJpaRepository tipoJpaRepository;
	
	
	@GetMapping("/listTipos")
	public ModelAndView listAllTipos() {
		ModelAndView mav = new ModelAndView(Constantes.TIPO_VIEW);
		mav.addObject("tipo",new Tipos());
		mav.addObject("tipos", tipoService.listAllTipos());
		return mav;
	}
	
	@PostMapping("/addTipo")
	public String addTipo(@ModelAttribute("tipo") TipoModel tipoModel) {
		tipoService.addTipo(tipoModel);
		return "redirect:/tipo/listTipos";
		
	}
	
	
	@GetMapping("/create")
	public ModelAndView createTipo(){
		ModelAndView mav=new ModelAndView(Constantes.CREATETIPO_VIEW);
		mav.addObject("tipo",new Tipos());
		return mav;
	}
	
	@GetMapping("/edit")
	public ModelAndView editTipo(@RequestParam(name="id", required=true) int id, TipoModel tipoModel) {
		ModelAndView mav = new ModelAndView(Constantes.EDITTIPO_VIEW);
		if (id ==0) {
			mav.addObject("tipo", new TipoModel());
		} else {
			mav.addObject("tipo", tipoService.updateTipo(id));
		}
		return mav;
	}
	
	@PostMapping("/delete")
	public String deleteTipo(@RequestParam("id") int id) {
		tipoService.removeTipo(id);
		return "redirect:/tipo/listTipos";
	}
	
	@GetMapping("/generarPDF")
	public String generarPDF(RedirectAttributes flash) {
		List<TipoModel> list=tipoService.listAllTipos();
		pdftipo.PDFTipos(list);
		flash.addFlashAttribute("success","PDF generado correctamente");
		return "redirect:/pokedex";
		
	}
}
