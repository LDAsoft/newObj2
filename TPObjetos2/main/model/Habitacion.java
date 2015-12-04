package model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class Habitacion {
	/*
	 * CONSIDERACIONES DE LA CLASE: En la lista de precios, los rangos no se solapan.
	 */
	private int capacidadMaxima;
	private String baseDoble;
	private List<Servicio> servicios;
	private List<Reserva> reservas;
	private Hotel hotelPertenece;
	private List<Precio> preciosPorFechas;
	
	public Habitacion(int unaCapacidad, String unaBase, List<Servicio> servicios, 
						List<Reserva> reservas, Hotel hotel, List<Precio> precios) {
		
		this.setCapacidadMaxima(unaCapacidad);
		this.setBaseDobleOSimple(unaBase);
		this.setServicios(servicios);
		this.setReservas(reservas);
		this.setHotelPertenece(hotel);
		this.setPrecios(precios);
	}

	public boolean disponibilidadPara(DateTime fechaDesde, DateTime fechaHasta) {
		boolean ret = true;
		Rango rangoAConsultar = new Rango(fechaDesde, fechaHasta);
		for (Reserva r : this.getReservas()) {
			ret = ret & !(r.ocupadaEn(rangoAConsultar)); 
		}
		return ret;
	}

	public List<Reserva> reservasDeUnaCiudadDelUsuario(String unaCiudad, Usuario unUsuario) {
		List<Reserva> ret = new ArrayList<Reserva>();
		if (this.getHotelPertenece().getNombreCiudad().equals(unaCiudad)){
			ret.addAll(this.reservasDelUsuario(unUsuario));
		}
		return ret;
	}

	public List<Reserva> reservasDelUsuario(Usuario unUsuario) {
		List<Reserva> ret = new ArrayList<Reserva>();
		for (Reserva reserva : this.getReservas()) {
			if (reserva.getUsuarioQueReserva().equals(unUsuario)){
				ret.add(reserva);
			}
		}
		return ret;
	}

	public String ciudadDelHotelDondeEstas() {
		return this.hotelPertenece.getNombreCiudad();
	}

	public List<Reserva> reservasFuturasDelUsuario(Usuario unUsuario) {
		
		List<Reserva> ret = new ArrayList<Reserva>();
		for (Reserva reserva : this.getReservas()) {
			if (reserva.fechaDeReservaPosteriorA(new DateTime())
					& reserva.getUsuarioQueReserva().equals(unUsuario)){
				ret.add(reserva);
			}
		}
		return ret;
	}
	
	
	public List<Reserva> reservasConFechaMayorA(DateTime unaFecha) {
		
		List<Reserva> ret = new ArrayList<Reserva>();
		for (Reserva reserva : this.getReservas()) {
			if (reserva.fechaDeReservaPosteriorA(unaFecha)){
				ret.add(reserva);
			}
		}
		return ret;
	}

	public void reservar(DateTime fechaDesde, DateTime fechaHasta, UsuarioPasajero unUsuario) {
		Rango r = new Rango(fechaDesde,fechaHasta);
		Double monto = this.calcularMonto(r);
		Reserva reserva = new Reserva(r,monto,unUsuario);
		this.getReservas().add(reserva);
		unUsuario.agregarHabitacionReservada(this);
	}

	private Double calcularMonto(Rango unRango){
		Double ret = 0.0;
		for (Precio precio : this.getPrecios()) {
			if(unRango.intercepta(precio.getRango())){
				ret = ret + precio.calcularMontoPara(unRango);
			}
		}
		return ret;
	}
	
	public Reserva getReservaParaFecha(DateTime unaFecha){
		
		Reserva reservaFinal = null;
		Rango rangoAConsultar = new Rango(unaFecha, unaFecha);
		
		for (Reserva r : this.getReservas()) {
			if (r.ocupadaEn(rangoAConsultar)){
				reservaFinal = r;
				break;
			}
		}
		return reservaFinal;
	}
	
	/*Getters and Setters
	 **/
	public String getBaseDobleOSimple() {
		return this.baseDoble;
	}

	public void setBaseDobleOSimple(String baseDobleOSimple) {
		this.baseDoble = baseDobleOSimple;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public int getCapacidadMaxima() {
		return this.capacidadMaxima;
	}

	public Hotel getHotelPertenece() {
		return hotelPertenece;
	}

	public void setHotelPertenece(Hotel hotelPertenece) {
		this.hotelPertenece = hotelPertenece;
	}
	
	public List<Precio> getPrecios() {
		return preciosPorFechas;
	}

	public void setPrecios(List<Precio> precios) {
		this.preciosPorFechas = precios;
	}

	// si la reserva no llega a existir, esto explota
	public void cancelaSiPodes(Reserva unaReserva) {
		this.reservas.remove(unaReserva);
		
	}
}
