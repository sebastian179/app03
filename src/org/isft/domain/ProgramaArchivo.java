package org.isft.domain;

/**
 * @author SEBASTIAN
 * @version 1.0
 * @created 02-may-2013 01:14:57 a.m.
 */
public class ProgramaArchivo {

	private Archivo Archivo;
	private String pa_modo = "";
	private Programa Programa;



	public ProgramaArchivo(){

	}

	public void finalize() throws Throwable {

	}

	public Archivo getArchivo(){
		return Archivo;
	}

	public String getModo(){
		return pa_modo;
	}

	public Programa getPrograma(){
		return Programa;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setArchivo(Archivo newVal){
		Archivo = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setModo(String newVal){
		pa_modo = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrograma(Programa newVal){
		Programa = newVal;
	}

}