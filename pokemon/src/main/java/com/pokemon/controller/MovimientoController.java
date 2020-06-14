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
import com.pokemon.entity.Movimiento;
import com.pokemon.model.MovimientoModel;
import com.pokemon.repository.MovimientoJpaRepository;
import com.pokemon.service.MovimientoService;

@Controller
@RequestMapping("/movimiento")
public class MovimientoController {

	
	@Autowired
	@Qualifier("movimientoServiceImpl")
	private MovimientoService movimientoService;
	
	private PDF pdfmovimiento = new PDF();
	
	@Autowired
	@Qualifier("movimientoRepository")
	private MovimientoJpaRepository movimientoJpaRepository;
	
	@GetMapping("/listMovimientos")
	public ModelAndView listAllMovimientos() {
		ModelAndView mav = new ModelAndView(Constantes.MOVIMIENTO_VIEW);
		mav.addObject("movimiento",new Movimiento());
		mav.addObject("movimientos", movimientoService.listAllMovimientos());
		return mav;
	}
	
	@PostMapping("/addMovimiento")
	public String addMovimiento(@ModelAttribute("movimiento") MovimientoModel movimientoModel) {
		movimientoService.addMovimiento(movimientoModel);
		return "redirect:/movimiento/listMovimientos";
		
	}
	
	
	@GetMapping("/create")
	public ModelAndView createMovimiento(){
		ModelAndView mav=new ModelAndView(Constantes.CREATEMOVIMIENTO_VIEW);
		mav.addObject("movimiento",new Movimiento());
		return mav;
	}
	
	
	@GetMapping("/edit")
	public ModelAndView editMovimiento(@RequestParam(name="id", required=true) int id, MovimientoModel movimientoModel) {
		ModelAndView mav = new ModelAndView(Constantes.EDITMOVIMIENTO_VIEW);
		if (id ==0) {
			mav.addObject("movimiento", new MovimientoModel());
		} else {
			mav.addObject("movimiento", movimientoService.updateMovimiento(id));
		}
		return mav;
	}
	
	@PostMapping("/delete")
	public String deleteMovimiento(@RequestParam("id") int id) {
		movimientoService.removeMovimiento(id);
		return "redirect:/movimiento/listMovimientos";
	}
	
	
	@GetMapping("/generarPDF")
	public String generarPDF(RedirectAttributes flash) {
		List<MovimientoModel> list=movimientoService.listAllMovimientos();
		pdfmovimiento.PDFMovimiento(list);
		flash.addFlashAttribute("success","PDF generado correctamente");
		return "redirect:/pokedex";
		
	}
}
