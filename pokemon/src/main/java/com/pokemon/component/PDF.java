package com.pokemon.component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.pokemon.model.MovimientoModel;
import com.pokemon.model.PokemonModel;
import com.pokemon.model.TipoModel;

@Component
public class PDF {
	public void PDFPokemon(List<PokemonModel> lista) {
		Document doc = null;
		
		try {
			doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(".\\src\\main\\resources\\static\\pdf\\pokemon.pdf"));
			Table table = new Table(1);
			table.setWidth(150);
			Cell celda = new Cell("Pokemon");
			table.addCell(celda);
			
			table.addCell(new Phrase("Foto"));
			table.addCell(new Phrase("Nombre"));
			table.addCell(new Phrase("Ataque"));
			table.addCell(new Phrase("Defensa"));
			table.endHeaders();
			
			for(PokemonModel pm: lista) {
				table.addCell(pm.getFoto());
				table.addCell(pm.getNombre());
				table.addCell(Integer.toString(pm.getAtaque()));
				table.addCell(Integer.toString(pm.getDefensa()));
			}
			doc.open();
			doc.add(table);
			doc.close();
		} catch (DocumentException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void PDFTipos(List<TipoModel> lista) {
		Document doc = null;
		try {
			doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(".\\src\\main\\resources\\static\\pdf\\tipo.pdf"));
			Table table = new Table(1);
			table.setWidth(150);
			Cell celda = new Cell("Tipo");
			celda.setHeader(true);
			table.addCell(celda);
			
			 table.addCell(new Phrase("Nombre Tipo"));
	         table.endHeaders();
	         for(TipoModel tipoModel : lista) {
	                table.addCell(tipoModel.getNombre());
	            }
	            doc.open();
	            doc.add(table);
	            doc.close();
	        } catch (DocumentException | FileNotFoundException e) {
	            e.printStackTrace();
	        }
	}
	
	public void PDFMovimiento(List<MovimientoModel> lista) {
		Document doc = null;
		try {
			doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(".\\src\\main\\resources\\static\\pdf\\movimiento.pdf"));
			Table table = new Table(1);
			table.setWidth(150);
			Cell celda = new Cell("Movimiento");
			celda.setHeader(true);
			table.addCell(celda);
			
			 table.addCell(new Phrase("Nombre Movimiento"));
			 table.addCell(new Phrase("Nombre Descripcion"));
			 table.addCell(new Phrase("Nombre Categoria"));
			 table.addCell(new Phrase("Potencia"));
			 table.addCell(new Phrase("Precisión"));
	         table.endHeaders();
	         for(MovimientoModel movimientoModel : lista) {
	                table.addCell(movimientoModel.getNombre());
	                table.addCell(movimientoModel.getDescripcion());
	                table.addCell(movimientoModel.getCategoria());
	                table.addCell(Integer.toString(movimientoModel.getPotencia()));
	                table.addCell(Integer.toString(movimientoModel.getPrecission()));
	            }
	            doc.open();
	            doc.add(table);
	            doc.close();
	        } catch (DocumentException | FileNotFoundException e) {
	            e.printStackTrace();
	        }
	}
}
