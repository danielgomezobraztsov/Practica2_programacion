package aplicacion;
import dominio.Tablero;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;
public class Main{
    public static void main(String[] args) throws IOException {
        try
        {
            Tablero tablero = new Tablero();
            System.out.println("SIMULACIÓN CON TABLERO LEÍDO ");
            tablero.rellenarBordes();
            try {
                tablero.leerEstadoActual();//manejo de excepciones
            }catch (Exception e){
                System.out.println("Error: "+ e);
            }
            tablero.estadoSiguiente = tablero.estadoActual;
            System.out.println(tablero);
            for(int i = 0; i <= 5; i++)
            {
                TimeUnit.SECONDS.sleep(1);
                tablero.transitarEstadoSiguiente();
                System.out.println(tablero);
            }
            System.out.println("SIMULACIÓN CON TABLERO GENERADO MEDIANTE MONTECARLO");
            tablero.rellenarBordes();
            tablero.generarEstadoActual();
            tablero.estadoSiguiente = tablero.estadoActual;
            System.out.println(tablero);

            for(int i = 0; i <= 15; i++)
            {
                TimeUnit.SECONDS.sleep(1);
                tablero.transitarEstadoSiguiente();
                System.out.println(tablero);
            }
            System.out.println(tablero);
        }catch(InterruptedException e)
        {
            System.out.println(e);
        }
        /*Tablero tablero = new Tablero();
        tablero.generarEstadoActual();
        System.out.println(tablero);*/
    }
}