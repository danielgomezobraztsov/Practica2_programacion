package dominio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    private static int dimension =30;
    public int[][] estadoActual = new int[dimension+2][dimension+2];
    public int[][] estadoSiguiente= new int[dimension+2][dimension+2];

    public void leerEstadoActual()throws FileNotFoundException, IOException{
        //ArrayList<Integer> lista = new ArrayList<>();
            FileReader fr = new FileReader("txt.txt");
            BufferedReader br = new BufferedReader(fr);
            for (int x = 1; x <= dimension; x++) {
                for (int y = 1; y <= dimension; y++) {
                    estadoActual[x][y] = br.read()=='0'?0:1;
                }
                br.read();
                br.read();
            }
            br.close();
    }
    public void rellenarBordes(){
        for(int x=0;x<=dimension;x++){
            for(int y=0;y<=dimension;y++){
                estadoActual[x][0]=0;
                estadoActual[0][y]=0;
                estadoActual[x][dimension+1]=0;
                estadoActual[dimension+1][y]=0;
            }
        }
    }
    public void generarEstadoActual(){
        for(int x = 1; x <= dimension; x++){
            for(int y = 1; y <= dimension; y++){
                Random rdm = new Random();
                double random = rdm.nextInt(10);
                if(random >= 5) {
                    estadoActual[x][y] = 1;
                }
                else {
                    estadoActual[x][y] = 0;
                }
            }
        }
    }


    public void transitarEstadoSiguiente(){
        int c=0;
        for(int x = 1; x <= dimension; x++) {
            for (int y = 1; y <= dimension; y++) {
                c = 0;
                c = estadoSiguiente[x][y + 1] + estadoSiguiente[x][y - 1] + estadoSiguiente[x - 1][y] + estadoSiguiente[x + 1][y]
                        + estadoSiguiente[x + 1][y + 1] + estadoSiguiente[x + 1][y - 1] + estadoSiguiente[x - 1][y + 1] + estadoSiguiente[x - 1][y - 1];
                if (estadoSiguiente[x][y] == 1 && (c == 2 || c == 3)) {
                    estadoSiguiente[x][y] = 1;
                } else if (estadoActual[x][y] == 0 && c == 3) {
                    estadoSiguiente[x][y] = 1;
                } else {
                    estadoSiguiente[x][y] = 0;
                }

            }

        //codigo que funciona pero es demasiado largo
        /*for(int x = 1;x<=dimension;x++){
            for(int y = 1;y<=dimension;y++){
                c=0;
                if(estadoSiguiente[x-1][y-1]==1){
                    c++;
                }
                if(estadoSiguiente[x-1][y]==1){
                    c++;
                }
                if(estadoSiguiente[x-1][y+1]==1){
                    c++;
                }
                if(estadoSiguiente[x][y-1]==1){
                    c++;
                }
                if(estadoSiguiente[x][y+1]==1){
                    c++;
                }
                if(estadoSiguiente[x+1][y-1]==1){
                    c++;
                }
                if(estadoSiguiente[x+1][y]==1){
                    c++;
                }
                if(estadoSiguiente[x+1][y+1]==1){
                    c++;
                }
                if(estadoSiguiente[x][y]==1){
                    if(c==2||c==3){
                        estadoSiguiente[x][y]=1;
                    }
                    else{
                        estadoSiguiente[x][y]=0;
                    }
                }
                else{
                    if(c==3){
                        estadoSiguiente[x][y]=1;
                    }
                    else{
                        estadoSiguiente[x][y]=0;
                    }
                }
            }
        }*/
        }

    }



    @Override
    public String toString(){

        String s = "";
        for(int x = 1; x <= dimension; x++) {
            for(int y = 1; y <= dimension; y++) {
                if(estadoSiguiente[x][y] == 1) {
                    s += "\uD83D\uDFE9";
                }
                else {
                    s += "\uD83D\uDFEB";
                }
            }
            s += "\n";
        }
        return s;
    }


}
