/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;



public abstract class Calc implements Interface {
    Object[] array = new Object [128];
    int index = 0;
    java.util.Stack pila = new java.util.Stack();
    int lng = 0;
    Object num1 = 1;
    Object num2 = 2;
    Object num3 = 3;
    Object num4 = 4;
    Object num5 = 5;
    Object num6 = 6;
    Object num7 = 7;
    Object num8 = 8;
    Object num9 = 9;
    Object num0 = 0;
    Object sum = "+";
    Object res = "-";
    Object mult = "*";
    Object div = "/";
    int j=0;
    String op = " ";
    
    private String Texto;
    
  public String [] Apertura() throws IOException{
        FileReader archivo = new FileReader(Texto);
        BufferedReader lect_texto = new BufferedReader(archivo);
        
        int lineas = contarLineas();
        String[] informacion = new String[lineas];
        
        int i;
        for (i= 0; i<lineas; i++){
            informacion[i] = lect_texto.readLine();
        }
        
        lect_texto.close();
        return informacion;
    }
    public int contarLineas() throws IOException{
        FileReader archivo_lectu = new FileReader (Texto);
        BufferedReader bf = new BufferedReader (archivo_lectu);
        
        String aLine;
        int lineas = 0;
        
        while ((aLine = bf.readLine())!= null){
            lineas ++;
        }
        bf.close();
        return lineas;
    }
    
    @Override
    public boolean empty(){
        return index == 0;        
    }
    
    @Override
    public Object pop(){
        index--;
        return array[index];
    }
    
    @Override
    public void push (Object item) { 
	if (full ()) resize (); 
	array[index] = item; 
	index++; 
    } 
    
    @Override
    public boolean full () { 
	return array.length == index; 
    } 
    
    @Override
    public void resize () { 
	Object[] newArray = new Object[array.length * 2]; 		
        System.arraycopy(array, 0, newArray, 0, array.length); 
	array = newArray; 
    } 
    
    @Override
    public void defrag(String linea){
	int length = linea.length();
	lng = length;
	int i = 0;
	while (i <= length-1){
		String prt = linea.substring(i, i+1);
		push(prt);
		i++;            
	} 
    }
    
    @Override
    public void comparar (){
	int i = 0;
	while (i <= lng-1){
		Object car = pop();
		if (car==num1 || car==num2 || car==num0 || car==num3 || car==num4 || car==num5 || car==num6 || car==num7 || car==num8 || car==num9) {
			j = (int) car;
			pila.push(j);
		}
		if (car==sum || car==res || car==mult || car==div){
			op = (String) car;
			pila.push(op);
		}
		i++;
	}   
    }
    
    @Override
    public int Calcular ()  {
	int i = 0;
	int x = 0;
	while (i <= lng-1){
		Object o1 = pila.pop();
		int n1= (int) o1;
		Object o2 = pila.pop();
		String operacion = (String) o2;
		Object o3 = pila.pop();
		int n2= (int) o3;
				
		if (operacion.equals("+")){
			x=n1+n2;
		}else{
			if (operacion.equals("-"))
				x=n1-n2;
		}
	}
                      return x;
    }
    
    
    public static void main(String args[]) throws IOException {
        String texto = "datos.txt";
        
    }
}
