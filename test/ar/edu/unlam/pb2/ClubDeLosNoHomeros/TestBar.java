package ar.edu.unlam.pb2.ClubDeLosNoHomeros;


import org.junit.Assert;
import org.junit.Test;

public class TestBar {
	
	
	@Test
	public void queSePuedaAbrirElBarSinPersonas() {
		Bar bar = new Bar();
		bar.abrir();
		Assert.assertEquals(bar.getEstaAbierto(), true);
		Assert.assertEquals(bar.getCantidadDePersonasEnElBar(),0, 0.01);
	}

	@Test
	public void queNoSePuedanAgregarDosPersonasConElMismoNombre() {
		Bar bar = new Bar();
		Cliente c1 = new Cliente("Nicolas",18);
		Cliente c2 = new Cliente("Anto",25);
		Cliente c3 = new Cliente("Nicolas",23);
		bar.agregarCliente(c1);
		bar.agregarCliente(c2);
		bar.agregarCliente(c3);
		
		Integer cantidadPersonasEnElBar = 2;
		Assert.assertEquals(cantidadPersonasEnElBar,bar.getCantidadDePersonasEnElBar(),0.01);
		
	}
	
	@Test
	public void queLosClientesSePresentenAlfabeticamente() {
		Bar bar = new Bar();
		Cliente c1 = new Cliente("Nicolas",18);
		Cliente c2 = new Cliente("Anto",25);
		Cliente c3 = new Cliente("Pedro",23);
		
		bar.agregarCliente(c1);
		bar.agregarCliente(c2);
		bar.agregarCliente(c3);
		
		bar.abrir();
		
		Assert.assertEquals(bar.presentarClientesAlfabeticamente().first(),c2);
		Assert.assertEquals(bar.presentarClientesAlfabeticamente().last(), c3);
	}
	
	@Test (expected = BarException.class)
	public void queLosClientesSePresentenPorEdad() throws BarException {
		Bar bar = new Bar();
		Cliente c1 = new Cliente("Nicolas",18);
		Cliente c2 = new Cliente("Anto",25);
		Cliente c3 = new Cliente("Pedro",23);
		
		bar.agregarCliente(c1);
		bar.agregarCliente(c2);
		bar.agregarCliente(c3);
		
		bar.abrir();
		
		Assert.assertEquals(bar.presentarClientesPorEdad().first(),c1);
		Assert.assertEquals(bar.presentarClientesPorEdad().last(), c2);
	}
}
