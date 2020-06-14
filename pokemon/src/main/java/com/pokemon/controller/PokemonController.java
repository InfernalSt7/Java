package com.pokemon.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pokemon.component.PDF;
import com.pokemon.constantes.Constantes;
import com.pokemon.entity.Pokemon;
import com.pokemon.model.MovimientoModel;
import com.pokemon.model.PokemonModel;
import com.pokemon.model.TipoModel;
import com.pokemon.repository.PokemonJpaRepository;
import com.pokemon.service.MovimientoService;
import com.pokemon.service.PokemonService;
import com.pokemon.service.TipoService;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {
    
    private PDF pdfPokemon = new PDF();
    
    @Autowired
    @Qualifier("pokemonServiceImpl")
    private PokemonService pokemonService;
    
    @Autowired
    @Qualifier("tipoServiceImpl")
    private TipoService tipoService;
    
    @Autowired
    @Qualifier("movimientoServiceImpl")
    private MovimientoService movimientoService;
    
    @Autowired
    @Qualifier("pokemonRepository")
    private PokemonJpaRepository pokemonJpaRepository;
    
    @GetMapping("/listPokemons")
	public ModelAndView listAllPokemons() {
		ModelAndView mav = new ModelAndView(Constantes.POKEMON_VIEW);
		mav.addObject("pokemon",new Pokemon());
		mav.addObject("pokemons", pokemonService.listAllPokemons());
		return mav;
	}
    
    @PostMapping("/addPokemon")
   	public String addPokemon(@ModelAttribute("file") MultipartFile img, @Valid @ModelAttribute("pokemon") PokemonModel pokemonModel, BindingResult result,
   			RedirectAttributes flash, Model model) {
   			
   			if (result.hasErrors()) {
   				return "redirect:/pokemon/listPokemons";
   			}else {
   				if(!img.isEmpty()) {
   					Path directory=Paths.get(".\\src\\main\\resources\\static\\images");
   					String ruta=directory.toFile().getAbsolutePath();
   					try {
   						byte[] bytes=img.getBytes();
   						Path rutaCompleta=Paths.get(ruta+"\\"+pokemonModel.getId()+pokemonModel.getNombre()+".png");
   						Files.write(rutaCompleta,bytes);
   						pokemonModel.setFoto("/images/"+pokemonModel.getId() + pokemonModel.getNombre()+".png");
   					}catch(IOException e) {
   						e.printStackTrace();
   					}
   				}else {
   					
   					pokemonModel.setFoto("/images/0Pikachu.png");
   				}
   				pokemonService.addPokemon(pokemonModel);
   			}
   			return "redirect:/pokemon/listPokemons";
   		} 
    
    
    @GetMapping("/create")
    public ModelAndView createPokemon(){
        ModelAndView mav=new ModelAndView(Constantes.CREATEPOKEMON_VIEW);
        mav.addObject("pokemon",new Pokemon());
        mav.addObject("tipos",tipoService.listAllTipos());
        mav.addObject("movimientos", movimientoService.listAllMovimientos());
        return mav;
    }
    
    
    @PostMapping("/delete")
    public String deletePokemon(@RequestParam("id") int id) {
    	pokemonService.removePokemon(id);
        return "redirect:/pokemon/listPokemons";
    }
    
    @GetMapping("/edit")
	public ModelAndView editPokemon(@RequestParam(name="id", required=true) int id, PokemonModel pokemonModel) {
		ModelAndView mav = new ModelAndView(Constantes.EDITPOKEMON_VIEW);
		if (id ==0) {
			mav.addObject("pokemon", new PokemonModel());
		} else {
			mav.addObject("pokemon", pokemonService.updatePokemon(id));
		}
		return mav;
	}
    
    @GetMapping("/generarPDF")
    public String generarPDF(RedirectAttributes flash) {
        List<PokemonModel> list=pokemonService.listAllPokemons();
        pdfPokemon.PDFPokemon(list);
        flash.addFlashAttribute("success","PDF generado correctamente");
        return "redirect:/pokemon/listPokemon";
        
    }
    
    
} 

/*package com.pokemon.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pokemon.component.PDF;
import com.pokemon.constantes.Constantes;
import com.pokemon.entity.Pokemon;
import com.pokemon.model.PokemonModel;
import com.pokemon.model.TipoModel;
import com.pokemon.repository.PokemonJpaRepository;
import com.pokemon.service.PokemonService;
import com.pokemon.service.TipoService;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {

	
	
	private static final Log LOG=LogFactory.getLog(PokemonController.class);
	@Autowired
	@Qualifier("pokemonServiceImpl")
	private PokemonService pokemonService;
	
	@Autowired
	@Qualifier("tipoServiceImpl")
	private TipoService tipoService;
	
	private PDF pdfpokemon = new PDF();
	
	@Autowired
	@Qualifier("pokemonRepository")
	private PokemonJpaRepository pokemonJpaRepository;
	
	@GetMapping("/listPokemons")
	public ModelAndView listAllPokemons() {
		ModelAndView mav = new ModelAndView(Constantes.POKEMON_VIEW);
		mav.addObject("pokemon",new Pokemon());
		mav.addObject("pokemons", pokemonService.listAllPokemons());
		return mav;
	}
	
	
	@PostMapping("/addPokemon")
	public ModelAndView addPokemon(@ModelAttribute("file") MultipartFile img, @Valid @ModelAttribute("pokemon") PokemonModel pokemonModel,@RequestParam(name="tip") int tip, BindingResult result,
			RedirectAttributes flash, Model model) {
    	
    		ModelAndView mav = new ModelAndView(Constantes.POKEMON_VIEW);
  
				if(!img.isEmpty()) {
					Path directory=Paths.get(".\\src\\main\\resources\\static\\images");
					String ruta=directory.toFile().getAbsolutePath();
					try {
						byte[] bytes=img.getBytes();
						Path rutaCompleta=Paths.get(ruta+"\\"+pokemonModel.getId()+pokemonModel.getNombre()+".png");
						Files.write(rutaCompleta,bytes);
						pokemonModel.setFoto("/images/"+pokemonModel.getId() + pokemonModel.getNombre()+".png");
					}catch(IOException e) {
						e.printStackTrace();
					}
				}else {
					
					pokemonModel.setFoto("/images/0infernape.png");
				}
				for (TipoModel tipoModel: tipoService.listAllTipos()) {
					if (tip == tipoModel.getId()) {
						pokemonModel.setTipo(tipoModel);
					}
				}
				
			pokemonService.addPokemon(pokemonModel);
			mav.addObject("pokemons", pokemonService.listAllPokemons());
			return mav;
		} 


	
	
	@GetMapping("/create")
	public ModelAndView createPokemon(){
		ModelAndView mav=new ModelAndView(Constantes.CREATEPOKEMON_VIEW);
		mav.addObject("pokemon",new Pokemon());
		return mav;
	}
	
	
	@PostMapping("/delete")
	public String deletePokemon(@RequestParam("id") int id) {
		pokemonService.removePokemon(id);
		return "redirect:/pokemon/listPokemons";
	}
	
	@GetMapping("/edit")
	public ModelAndView editPokemon(@RequestParam(name="id", required=true) int id, PokemonModel pokemonModel) {
		ModelAndView mav = new ModelAndView(Constantes.EDITPOKEMON_VIEW);
		if (id ==0) {
			mav.addObject("pokemon", new PokemonModel());
		} else {
			mav.addObject("pokemon", pokemonService.updatePokemon(id));
		}
		return mav;
	}
	
	
	@GetMapping("/generarPDF")
	public String generarPDF(RedirectAttributes flash) {
		List<PokemonModel> list=pokemonService.listAllPokemons();
		pdfpokemon.PDFPokemon(list);
		flash.addFlashAttribute("success","PDF generado correctamente");
		return "redirect:/pokedex";
		
	}
}*/
