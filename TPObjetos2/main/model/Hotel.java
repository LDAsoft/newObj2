package model;

import java.util.List;

import org.joda.time.DateTime;

public class Hotel {
	private String nombreHotel;
	private String nombreCiudad;
	private List<Habitacion> habitaciones;
	
	public Hotel(String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public Object getNombreHotel() {
		return this.nombreHotel;
	}

	public String getNombreCiudad() {
		return this.nombreCiudad;
	}

	public List<Habitacion> getHabitaciones() {
		return this.habitaciones;
	}
	
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public List<Reserva> reservasDentroDeFecha(DateTime unaFecha) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Reserva> reservasConFechaMayorA(DateTime unaFecha) {
		// TODO Auto-generated method stub
		return null;
	}



	

}
