package com.google.calidad.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aplicacion {
	
	private String nombre;
    private String versiones;
    
    private HashMap<String, String> listadoAplicaciones;

    public Aplicacion() {
  
        this.listadoAplicaciones = new HashMap<>();
    }
    public void  agregarAplicativos(String nomnbreAplicativo, String version) {
    	
    	listadoAplicaciones.put(nomnbreAplicativo, version);
    }
   public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/
    public HashMap<String, String> getListadoAplicaciones() {
        return listadoAplicaciones;
    }

    

}
