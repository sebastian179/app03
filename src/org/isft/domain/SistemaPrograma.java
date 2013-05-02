package org.isft.domain;

/**
 * @author SEBASTIAN
 * @version 1.0
 * @created 02-may-2013 01:07:46 a.m.
 */
public class SistemaPrograma {

	private Programa Programa;
	private Sistema Sistema;
	private double sp_frecuencia;



	public SistemaPrograma(){

	}

	public void finalize() throws Throwable {

	}

	public Programa getPrograma(){
		return Programa;
	}

	public Sistema getSistema(){
		return Sistema;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrograma(Programa newVal){
		Programa = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSistema(Sistema newVal){
		Sistema = newVal;
	}

	public double getFrecuencia(){
		return sp_frecuencia;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFrecuencia(double newVal){
		sp_frecuencia = newVal;
	}

}