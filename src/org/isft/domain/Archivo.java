package org.isft.domain;

/**
 * @author SEBASTIAN
 * @version 1.0
 * @created 02-may-2013 01:05:13 a.m.
 */
public class Archivo {

	private int arc_id = 0;
	private String arc_nombre = "";

	public Archivo(){

	}

	public void finalize() throws Throwable {

	}

	public int getId(){
		return arc_id;
	}

	public String getNombre(){
		return arc_nombre;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setId(int newVal){
		arc_id = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNombre(String newVal){
		arc_nombre = newVal;
	}

}