/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodrigo
 */
//Codigo de lectura y regreso de lineas guardadas
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadTxT {
    private String Texto;
    
    public ReadTxT (String texto){
        this.Texto = texto;
    }
    
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
    
}
