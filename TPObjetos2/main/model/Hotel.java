package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import nadaTesteable.Categoria;
import nadaTesteable.Ciudad;
import nadaTesteable.Direccion;
import nadaTesteable.Mail;
import nadaTesteable.MedioDePago;
import nadaTesteable.Pais;
import nadaTesteable.Servicio;
import nadaTesteable.Telefono;
import nadaTesteable.UsuarioHotelero;

public class Hotel {
	private String nombreHotel;
	private Ciudad ciudad;
	private List<Habitacion> habitaciones;
	private List<Servicio> servicios;
	private Categoria categoria;
	private DateTime checkIn;
	private DateTime checkOut;
	private UsuarioHotelero hotelero;
	private Pais pais;
	private Direccion direccion;
	private Telefono telefono;
	private Mail mail;
	private List<MedioDePago> mediosDePago;
	
	public Hotel(String unNombreDeHotel, Ciudad unaCiudad, List<Habitacion> unasHabitaciones, 
				 List<Servicio> unosServicios, Categoria unaCategoria, DateTime unCheckIn, 
				 DateTime unCheckOut, UsuarioHotelero unHotelero, Pais unPais,
				 Direccion unaDireccion, Telefono unTelefono, Mail unMail, 
				 List<MedioDePago> unosMediosDePago) {

		// INICIALIZO LISTAS
		habitaciones	= new ArrayList<Habitacion>();
		servicios 		= new ArrayList<Servicio>();
		mediosDePago 	= new ArrayList<MedioDePago>();
		
		// INICIALIZO VARIABLES DE INSTANCIA
		mediosDePago.addAll(unosMediosDePago);		
		habitaciones.addAll(unasHabitaciones);
		servicios.addAll(unosServicios);
		nombreHotel = unNombreDeHotel;
		ciudad 		= unaCiudad;
		categoria 	= unaCategoria;
		checkIn 	= unCheckIn;
		checkOut 	= unCheckOut;
		hotelero 	= unHotelero;
		pais 		= unPais;
		direccion 	= unaDireccion;
		telefono 	= unTelefono;
		mail 		= unMail;
	}
	
	public List<Reserva> reservasDentroDeFecha(DateTime unaFecha){
		List<Reserva> reservas = new ArrayList<Reserva>();
		Rango unDiaEnRango = new Rango(unaFecha, unaFecha);
		for(Habitacion habitacion: habitaciones){
			if (!habitacion.disponibilidadPara(unDiaEnRango)){
				reservas.add(habitacion.getReservaParaFecha(unaFecha));
			}
		}
		return reservas;
	}

	public List<Reserva> reservasConFechaMayorA(DateTime unaFecha) {

		List<Reserva> reservas = new ArrayList<Reserva>();
		
		for(Habitacion h: this.habitaciones){
				reservas.addAll(h.reservasConFechaMayorA(unaFecha));
		}
		return reservas;
	}

	public boolean tieneHabitacionQueCumpleCapacidad(int unaCapacidad) {
		boolean tieneHabitacionQueCumpleCapacidad = false;
		for (Habitacion habitacion : this.getHabitaciones()) {
			tieneHabitacionQueCumpleCapacidad = tieneHabitacionQueCumpleCapacidad || 
			(habitacion.getCapacidadMaxima() >= unaCapacidad); 
		}
		return tieneHabitacionQueCumpleCapacidad;
	}
	
	//Getters
	public String getNombre() {
		return nombreHotel;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	
	public List<Servicio> getServicios() {
		return servicios;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public DateTime getCheckIn() {
		return checkIn;
	}

	public DateTime getCheckOut() {
		return checkOut;
	}

	public Pais getPais() {
		return pais;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public Mail getMail() {
		return mail;
	}

	public List<MedioDePago> getMediosDePago() {
		return mediosDePago;
	}	
	
	public UsuarioHotelero getHotelero() {
		return this.hotelero;
	}
	
	public String nombreCiudad() {
		return this.getCiudad().getNombre();
	}

	public void agregarReservaEnHabitacion(Habitacion unaHabitacion,
			Reserva unaReserva) {		
	}
	
	public boolean habitacionNoTieneReservaEnFecha(Habitacion unaHabitacion,Rango unRango) {
		//ya sabes agus, aca recorres las habitaciones y me retornas si NO ESTA RESERVADA, true :D
		// TODO Auto-generated method stub
		return false;
	}
	
}
