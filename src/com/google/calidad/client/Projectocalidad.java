package com.google.calidad.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;

import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 

import com.google.gwt.core.client.EntryPoint;  
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * *
 */
public class Projectocalidad implements EntryPoint {
	
	
	  private VerticalPanel mainPanel = new VerticalPanel();
	  private FlexTable tablaControlCalidad= new FlexTable();
	  private HorizontalPanel addPanelHorizontal1 = new HorizontalPanel();
	  private HorizontalPanel addPanelHorizontal = new HorizontalPanel();
	  private TextBox versionInput = new TextBox();
	  private TextBox aplicacionInput = new TextBox();
	  private TextBox cicloInput= new TextBox();
	  private Button agregarAppButton = new Button("Agregar");
	  private Button addStockButton = new Button("Agregar Metrica");
	  private Button cancelarButton = new Button("Cancelar");
	  private Label lastUpdatedLabel = new Label();
	  private ListBox aplicationesListBox = new ListBox();
	  private ListBox versionListBox = new ListBox();
	  private TextBox porcentajeCasoExistos= new TextBox(); 
	  private TextBox cantidadCasos= new TextBox(); 
	  private TextBox casosFallidos= new TextBox(); 
	  private TextBox casosExitosos= new TextBox(); 
	  private TextBox casosEjecutados= new TextBox(); 
	  private  FlexTable formulario = new FlexTable();
	  private  FlexTable formularioCrecionProyectos = new FlexTable();
	  private FlowPanel contenedor1 = new FlowPanel();
	  private FlowPanel contenedor2 = new FlowPanel();
	  private FlowPanel contenedor3 = new FlowPanel();
	  private HTML tituloFormularioRegistro = new HTML("<h2>Formulario de registro Aplicaciones </h2>");
	  private HTML tituloFormularioRegistroMetricas = new HTML("<h2>Formulario de registro Metricas </h2>");
	  private HTML tituloTablaMetricas = new HTML("<h2>Control de Metricas y Analisis de QA </h2>");

	 
	  private ArrayList<String> stocks = new ArrayList<String>();
	  private Aplicacion aplicacion= new Aplicacion();
	  private HashMap<String, String> listaApp=aplicacion.getListadoAplicaciones();
	  
	  
	public void onModuleLoad() {
	
		cantidadCasos.setEnabled(false);
		porcentajeCasoExistos.setEnabled(false);
		

		formularioCrecionProyectos.setHTML(1, 0, "Aplicacion ");
		formularioCrecionProyectos.setWidget(1, 1, aplicacionInput);
		formularioCrecionProyectos.setHTML(2, 0, "Version");
		formularioCrecionProyectos.setWidget(2, 1, versionInput);
	   

		 addPanelHorizontal1.add(agregarAppButton);
		

	    FlexCellFormatter cellFormatter = formulario.getFlexCellFormatter();
	    formulario.setHTML(1, 0, "Aplicacion ");
	    formulario.setWidget(1, 1, aplicationesListBox);
	    formulario.setHTML(2, 0, "Version");
	    formulario.setWidget(2, 1, versionListBox);
	    formulario.setHTML(3, 0, "Nombre Ciclo ");
	    formulario.setWidget(3, 1, cicloInput);
	    formulario.setHTML(4, 0, "Numero  casos Exitosos ");
	    formulario.setWidget(4, 1, casosExitosos);
	    formulario.setHTML(5, 0, "Numero casos Fallidos  ");
	    formulario.setWidget(5, 1, casosFallidos);
	    formulario.setHTML(6, 0, "Numero casos Ejecutados ");
	    formulario.setWidget(6, 1, casosEjecutados);
	    formulario.setHTML(7, 0, "Total casos  ");
	    formulario.setWidget(7, 1, cantidadCasos);
	    formulario.setHTML(8, 0, "Porcentaje Casos Existosos ");
	    formulario.setWidget(8, 1, porcentajeCasoExistos);
	    

	    addPanelHorizontal.add(cancelarButton);
	    addPanelHorizontal.add(addStockButton);
	    
	    
	    tablaControlCalidad.setText(0, 0, "Aplicacion");
	    tablaControlCalidad.setText(0, 1, "Version");
	    tablaControlCalidad.setText(0, 2, "Nombre Ciclo");
	    tablaControlCalidad.setText(0, 3, "Exitosos");
	    tablaControlCalidad.setText(0, 4, "% Exitosos");
	    tablaControlCalidad.setText(0, 5, "Fallidos");
	    tablaControlCalidad.setText(0, 6, "% Fallidos");
	    tablaControlCalidad.setText(0, 7, "Ejecutados");
	    tablaControlCalidad.setText(0, 8, "Total casos");
	    tablaControlCalidad.setText(0, 9, "Remove");
	    tablaControlCalidad.setText(0, 10, "Editar");
	    
	
	    tablaControlCalidad.getRowFormatter().addStyleName(0, "watchListHeader");
	    tablaControlCalidad.addStyleName("watchList"); 
	    tablaControlCalidad.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
	    tablaControlCalidad.getCellFormatter().addStyleName(0, 2, "watchListNumericColumn");
	    tablaControlCalidad.getCellFormatter().addStyleName(0, 3, "watchListRemoveColumn");
	    
	    
	    
	    contenedor1.add(tituloFormularioRegistro);
	    contenedor2.add(tituloFormularioRegistroMetricas);
	    contenedor3.add(tituloTablaMetricas);
		  
	 
	    mainPanel.add( contenedor1);
	    mainPanel.add( formularioCrecionProyectos);
	    mainPanel.add(addPanelHorizontal1);
	    mainPanel.add( contenedor2);
	    mainPanel.add( formulario);
	    mainPanel.add(addPanelHorizontal);
	    mainPanel.add( contenedor3);
	    mainPanel.add(tablaControlCalidad);
	    
  
	    mainPanel.add(lastUpdatedLabel);
	   
		RootPanel.get("controlCalidad").add(mainPanel);
		RootPanel.get().addStyleName("container");		

	 
		addStockButton.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  addMetricas();
		      
		      }
		    });
				
		
		agregarAppButton.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    
		        registrarAplicacion();
		        actualizarRegistro();
		      }
		    });
		
		
		cancelarButton.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    
		    	  limpiarFomurlario();
		      }
		    });
	
		versionInput.addKeyDownHandler(new KeyDownHandler() {
	        public void onKeyDown(KeyDownEvent event) {
	          if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	        
	            registrarAplicacion();
	          }
	        }
	      });
		
		casosEjecutados.addKeyDownHandler(new KeyDownHandler() {
	        public void onKeyDown(KeyDownEvent event) {
	          if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	          	  addMetricas();
	          }
	        }
	      });
	    	
	}
	
	
		private void addMetricas() {


		      final String ciclo= cicloInput.getText().toUpperCase().trim();
		      cicloInput.setFocus(true);
		      versionListBox.setFocus(true);
		      casosExitosos.setFocus(true);
		      casosFallidos.setFocus(true);
		      casosEjecutados.setFocus(true);

		      final String version= versionListBox.getSelectedValue();
		      final String exitosos= casosExitosos.getText().toUpperCase().trim();
		      final String fallidos= casosFallidos.getText().toUpperCase().trim();
		      final String ejecutados= casosEjecutados.getText().toUpperCase().trim();
		      final String aplicacion= aplicationesListBox.getSelectedValue();
		      final String aplicacionKey= aplicationesListBox.getSelectedItemText();
		      
		      
		      
		      double exitososDouble= Double.parseDouble(exitosos);
		      double fallidosDoble= Double.parseDouble(fallidos);
		      double ejecutadosDouble= Double.parseDouble(ejecutados);
		    
		      		      
		      Metricas metricas=new Metricas( exitososDouble,fallidosDoble, ejecutadosDouble );
				
		      metricas.validacionMetricas(ciclo,  exitosos, fallidos, ejecutados );
		   
		       String porcentageExitososStr= String.valueOf(metricas.getPorcentageExitosos());
		       String porcentagefallidosStr= String.valueOf(metricas.getPorcentageFallidos());
		       String totalCasosStr= String.valueOf(metricas.getTotalcantidadcasos());
			    
		      String llave2="";
		      String valor2="";

		      
		 
		      
		      boolean correspondenciaEncontrada = false;
		      for (Map.Entry<String, String> entry : listaApp.entrySet()) {
		          String llave = entry.getKey();
		          String valor = entry.getValue();
		          
		         
		          
		          llave2=llave;
		          valor2=valor;
		          if (aplicacionKey.equals(llave) ) {
		        	 	 
		        	  if(version.equals(valor) && aplicacionKey.equals(llave)) {	  
		        		  correspondenciaEncontrada = true;
		        	  }
		              break;
		          }
		      }

		      if(correspondenciaEncontrada) {
		    	
			
			      if (stocks.contains(aplicacion) && stocks.contains(version)&&stocks.contains(ciclo)    ) {
			    	   
			    	  Window.alert(" Ya existe una version de esa aplicacion en ese ciclo o etapa  " );
			    	  return;				    	  
			      }
			    	  
			    	  
			
			       int row = tablaControlCalidad.getRowCount();
			      stocks.add(aplicacion);
			      stocks.add(version);
			      stocks.add(ciclo);
			      stocks.add(exitosos);
			      stocks.add(porcentageExitososStr);
			      stocks.add(fallidos);
			      stocks.add(porcentagefallidosStr);
			      stocks.add(ejecutados);
			      stocks.add(totalCasosStr);
			   
			      
			      tablaControlCalidad.setText(row, 0, aplicacion);
			      tablaControlCalidad.setText(row, 1, version);
			      tablaControlCalidad.setText(row, 2, ciclo);
			      tablaControlCalidad.setText(row, 3, exitosos);
			      tablaControlCalidad.setText(row, 4, porcentageExitososStr);  
			      tablaControlCalidad.setText(row, 5, fallidos);
			      tablaControlCalidad.setText(row, 6, porcentagefallidosStr);
			      tablaControlCalidad.setText(row, 7, ejecutados);
			      tablaControlCalidad.setText(row, 8, totalCasosStr);
	
		    	  
			      
			      cicloInput.setText(" ");
			      versionListBox.setSelectedIndex(0);
			      aplicationesListBox.setSelectedIndex(0);
			      
			      casosExitosos.setText("");
			      casosFallidos.setText("");
			      casosEjecutados.setText("");
			      cantidadCasos.setText("");
			      porcentajeCasoExistos.setText("");
			
			      eliminarMetricaTabla(row);
			      actualizarMetricaTabla(row);
		      }
		      else {
		          Window.alert( " La aplicación "+ llave2 + " y version  " + valor2 + " no existen en el sistema, valide nuevamente.");
		      }
		
		    }
		
		
		private void eliminarMetricaTabla(int row) {
			  
	
		      Button removeItemTableButton = new Button("x");
		      removeItemTableButton.addClickHandler(new ClickHandler() {
		        public void onClick(ClickEvent event) {
		        	
		        	int rowIndex = tablaControlCalidad.getCellForEvent(event).getRowIndex();
		            tablaControlCalidad.removeRow(rowIndex);
		        	
		        }
		      });
	      tablaControlCalidad.setWidget(row, 9, removeItemTableButton);
		   
			
		}
		
	
		private void actualizarMetricaTabla(int row) {
		    Button updateItemTableButton = new Button("Editar");
		    updateItemTableButton.addClickHandler(new ClickHandler() {
		        public void onClick(ClickEvent event) {
		          
		            int rowIndex = tablaControlCalidad.getCellForEvent(event).getRowIndex();

		        }
		    });
		    tablaControlCalidad.setWidget(row, 10, updateItemTableButton);
		}
		
	 
		 private void updateTable(Metricas metricas) {
			
			 
			 if (!stocks.contains(metricas.getNombre())) {
			       return;
			     }

			     int row = stocks.indexOf(metricas.getNombre()) + 1;

		
			     String aplicacionStr = NumberFormat.getFormat("#,##0.00").format(
			    		 metricas.getCasoExitosos());
			     NumberFormat changeFormat = NumberFormat.getFormat("+#,##0.00;-#,##0.00");
			     String changeText = changeFormat.format(metricas.getCasoFallidos());
			     String changePercentText = changeFormat.format(metricas.getPorcentageExitosos());

		
			     tablaControlCalidad.setText(row, 1, aplicacionStr);
			     tablaControlCalidad.setText(row, 2, changeText + " (" + changePercentText
			         + "%)");
			     
			}
		 
		 private void updateTable(Metricas[] metrica) {

		      for (int i = 0; i < metrica.length; i++) {
		        updateTable(metrica[i]);
		      }
		
		      DateTimeFormat dateFormat = DateTimeFormat.getFormat(
		        DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM);
		      lastUpdatedLabel.setText("Last update : " 
		        + dateFormat.format(new Date()));
		    }
		 
		 private void actualizarRegistro() {
			   aplicationesListBox.clear();
			    versionListBox.clear();
			 
			 for (Map.Entry<String, String> entry :listaApp.entrySet()) {
				 
				    String llave = entry.getKey();
				    String valor = entry.getValue();
	
					aplicationesListBox.addItem(llave);
					versionListBox.addItem(valor);
				}
			
		 }
		
		 
		 private void registrarAplicacion( ) {
			 
			 String nombre= aplicacionInput.getText();
			 String version= versionInput.getText();
			 aplicacionInput.setFocus(true);
			 versionInput.setFocus(true);
		
			
			aplicacion.agregarAplicativos(nombre,version);
		 			 
		     aplicacionInput.setText(" ");
		     versionInput.setText(" ");
		    
		  
		 }


		 private void limpiarFomurlario() {
			 
		
		 aplicationesListBox.setSelectedIndex(0);
		 versionListBox.setSelectedIndex(0);
		 cicloInput.setText("");
		 casosExitosos.setText("");
		 casosFallidos.setText("");
		 casosEjecutados.setText("");
		 cantidadCasos.setText("");
		 porcentajeCasoExistos.setText("");
			    
			 
		 }
		 
	}

