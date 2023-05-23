package com.google.calidad.client;

import java.util.Map;

import com.google.gwt.user.client.Window;

import java.util.List;
import java.util.*;

public class Metricas {
	
	 private String nombre;
	 private double porcentageExitosos;
	 private double casoExitosos;
	 private double casoFallidos;
	 private double casoEjecutados;
	 private double porcentageFallidos;
	 private double totalCantidadCasos;


	    
	    public Metricas() {}
	    
	   
	    public Metricas(double casoExitosos,
	    		double casoFallidos,
	    		double casoEjecutados
	
	    		) {
	        this.casoExitosos = casoExitosos;
	        this.casoFallidos=casoFallidos;
	        this.casoEjecutados= casoEjecutados;
	        this.totalCantidadCasos= casoExitosos+casoFallidos+casoEjecutados;
	        
	      
	      
	    }
   
	    
	    public double getPorcentageExitosos() {
			  return 100.0 * this.casoExitosos / this.totalCantidadCasos;
		}
	   public void setPorcentageExitosos(double porcentageExitosos) {
		this.porcentageExitosos = porcentageExitosos;
	   }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setTotalcantidadcasos(double  totalcantidadcasos) {
			this.totalCantidadCasos = totalcantidadcasos;
		}
	    
	    public double getTotalcantidadcasos() {
			return totalCantidadCasos;
		}
	    
	   public double getCasoExitosos() {
		return casoExitosos;
	   }
	   public void setCasoExitosos( double  casoExitosos) {
		this.casoExitosos = casoExitosos;
	   }
	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	   
	  
	    public void setCasoFallidos(double  casoFallidos) {
			this.casoFallidos = casoFallidos;
		}
	   
	    public double  getCasoFallidos() {
			return casoFallidos;
		}
	    
	    public double getPorcentageFallidos() {
			  return 100.0 * this.casoFallidos / this.totalCantidadCasos;
		}
	    public void setPorcentageFallidos(double porcentageFallidos) {
			this.porcentageFallidos = porcentageFallidos;
		}
	    
	    
	    public void validacionMetricas( String ciclo, 
	
	    		String  exitosos,
	    		String fallidos, 
	    		String ejecutados
	   
	    	
	    ) {
	    	
	    	
	    	
	    	  if (!ciclo.matches("^[0-9A-Z\\.]{1,10}$") )  {
			        Window.alert(" Ingrese el ciclo o etapa proyecto");
			      
			        return;
			      }
	    	  
	    	   	
	    	
	    	  

	    	  if (!exitosos.matches("^[0-9A-Z\\\\.]{1,10}$") )    {
			        Window.alert("Por favor ingrese el numero de casos de exito");
			      
			        return;
			      }
	    	  
	    	  if (!fallidos.matches("^[0-9A-Z\\\\.]{1,10}$") )    {
			        Window.alert("Ingrese el numero de casos de fallidos");
			      
			        return;
			      }
	    	  
	    	  if (!ejecutados.matches("^[0-9A-Z\\\\.]{1,10}$") )    {
			        Window.alert(" Ingrese el numero de casos de ejecutados");
			      
			        return;
			      }
	    	  
   	 
	    	  

	    	  
	    }
	    
    
}
