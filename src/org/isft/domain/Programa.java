package org.isft.domain;

/**
 * @author SEBASTIAN
 * @version 1.0
 * @created 02-may-2013 12:59:24 a.m.
 */
public class Programa {

	private String prg_descripcion = "";
	private int prg_id = 0;

	public Programa(){

	}

	public void finalize() throws Throwable {

	}

	public String getDescripcion(){
		return prg_descripcion;
	}

	public int getId(){
		return prg_id;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescripcion(String newVal){
		prg_descripcion = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setId(int newVal){
		prg_id = newVal;
	}

}