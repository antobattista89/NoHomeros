package ar.edu.unlam.pb2.ClubDeLosNoHomeros;

import java.util.Set;
import java.util.TreeSet;

public class Bar {

	private Boolean abierto;
	private TreeSet<Cliente> cliente;

	public Bar() {
		this.cliente = new TreeSet<Cliente>();
	}

	public void abrir() {
		this.abierto = true;
	}

	public void cerrar() {
		this.abierto = false;
	}

	public Boolean getEstaAbierto() {
		return this.abierto;
	}

	public Integer getCantidadDePersonasEnElBar() {
		return this.cliente.size();
	}

	public void agregarCliente(Cliente nuevoCliente) {
		this.cliente.add(nuevoCliente);
	}

	public TreeSet<Cliente> presentarClientesAlfabeticamente() {

		return this.cliente;
	}

	public TreeSet<Cliente> presentarClientesPorEdad() throws BarException {
		OrdenPorEdad orden = new OrdenPorEdad();
		TreeSet<Cliente> ordenados = new TreeSet(orden);
		ordenados.addAll(cliente);
		if (this.getEstaAbierto()) {
			return ordenados;
			
		} else {
			throw new BarException("No se presentan");
		}

	}

}
