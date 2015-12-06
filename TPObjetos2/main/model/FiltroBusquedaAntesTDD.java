package model;

import java.util.ArrayList;
import java.util.List;

public abstract class FiltroBusquedaAntesTDD {
	/*
	 * El Prop�sito de aplicar este patron de dise�o(composite), es para poder componer los 
	 * par�metros de busqueda con filtros simples y en nuestro caso, es excluyente que se 
	 * cumplan todos los filtros solcitados.
	 */
	public abstract List<Hotel> buscar(List<Hotel> lHoteles);
	
	public List<Habitacion> buscarHabitaciones(Hotel hotel){
		return new ArrayList<Habitacion>();
	}
		
	
}
