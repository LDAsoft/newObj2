package model;

import java.util.List;
import java.util.Observable;

import clasesSinTest.Ciudad;

public class SistemaHotelero extends Observable{
	private List<Usuario> listaDeUsuarios; 
	private GestorConsultas gestor;
	//private GestorCorreo gestorCorreo;
	
	
	public SistemaHotelero(List<Usuario> listaDeUsuarios, GestorConsultas gestor) {
		this.setUsuarios(listaDeUsuarios);
		//this.setGestorCorreo(gestorCorreo);
		this.setGestor(gestor); 
	}

	public void agregarReserva(Reserva unaReserva) {
		this.getGestor().agregarReserva(unaReserva);
		setChanged();
		notifyObservers(this);
		//Aca debe haber tipo un observer con el mail asi envia los mails correspondientes.
	}

	public void agregarHotel(Hotel unHotel) {
		this.getGestor().agregarHotel(unHotel);
	}

	public void agregarUsuario(Usuario unUsuario) {
		this.getListaDeUsuarios().add(unUsuario);
	}

	public List<Hotel> buscarHotelesPorFiltros(FiltroBusqueda filtro) {
		return filtro.buscar(this.getGestor().getHoteles());
	}

	public List<Habitacion> filtrarHabitaciones(FiltroBusqueda filtro, Hotel hotel) {
		return filtro.buscarHabitaciones(hotel);
	}

	public List<Reserva> todasReservasDePasajero(UsuarioPasajero unUsuario) {
		return this.getGestor().todasReservasDePasajero(unUsuario);
	}

	public List<Reserva> reservaDePasajeroParaCiudad(UsuarioPasajero unPasajero, Ciudad unaCiudad) {
		return this.getGestor().reservaDePasajeroParaCiudad(unPasajero, unaCiudad);
	}

	public List<Ciudad> ciudadesConReservaDePasajero(UsuarioPasajero unPasajero) {
		return this.getGestor().ciudadesDondePasajeroTieneReserva(unPasajero);
	}

	public List<Reserva> todasReservasFuturasDePasajero(UsuarioPasajero unPasajero) {
		return this.getGestor().todasReservasFuturasDePasajero(unPasajero);
	}

	public List<Reserva> todasReservasActualesDeHotelero(UsuarioHotelero bruno) {
		// TODO Auto-generated method stub
		return null;
	}
	/*	
	public List<Reserva> todasReservasActualesDeHotelero(UsuarioHotelero unHotelero) {
		return this.gestorHotelero.ReservasActualesDeHotelero(unHotelero);
	}

	public List<Reserva> ReservasFuturasDeHotelero(UsuarioHotelero unHotelero) {
		return this.gestorHotelero.ReservasFuturasDeHotelero(unHotelero);
	}

	public List<Reserva> ReservasInicioEnNFuturosDiasHotelero(UsuarioHotelero unHotelero, int i) {
		return this.gestorHotelero.ReservasInicioEnNFuturosDiasHotelero(unHotelero, i);
	}
*/

	public GestorConsultas getGestor() {
		return gestor;
	}

	public void setGestor(GestorConsultas gestor) {
		this.gestor = gestor;
	}
	
	public List<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}

	private void setUsuarios(List<Usuario> listaDeUsuarios) {
		this.listaDeUsuarios = listaDeUsuarios;
	}

	public List<Reserva> ReservasFuturasDeHotelero(UsuarioHotelero bruno) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reserva> ReservasInicioEnNFuturosDiasHotelero(
			UsuarioHotelero bruno, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	

	/*public GestorCorreo getGestorCorreo() {
		return gestorCorreo;
	}
	
	private void setGestorCorreo(GestorCorreo gestorCorreo) {
		this.gestorCorreo = gestorCorreo;
	}*/

}
