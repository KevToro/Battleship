package com.example.battleship.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Jugador {
    protected List<List<String>> matriz = new ArrayList<>();
    protected List<Barco> flota = new ArrayList<>();

    public Barco barcoActual;
    public Jugador(){
        for (int i=0;i<10;i++){
            List<String> fila = new ArrayList<>();
            for (int j=0;j<10;j++){
                fila.add(" ");
            }
            matriz.add(fila);
        }
    }

    public String getPosicion(int fila, int columna){
        return matriz.get(fila).get(columna);
    }

    public void setPosicion(int fila, int columna, String texto){
        this.matriz.get(fila).set(columna, texto);
    }

    public void agregarBarco(Barco barco){
        flota.add(barco);
    }

    public void mostrarMatriz(){
        for(List<String> fila: matriz){
            for (String string: fila){
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public boolean lanzarBomba(Pane pane, Jugador jugador){
        int fila = GridPane.getRowIndex(pane);
        int columna = GridPane.getColumnIndex(pane);
        String letra = jugador.matriz.get(fila).get(columna);
        if(!Objects.equals(letra, "0")){
            if(!Objects.equals(letra, " ")){
                pane.getChildren().removeAll();
                pane.getChildren().add(ponerImagen("bomba"));
                ponerImagen("bomba");
            } else{
                pane.getChildren().add(ponerImagen("agua"));
                ponerImagen("agua");
            }
            jugador.setPosicion(fila,columna,"0");
            return true;
        } else {
            return false;
        }
    }

    public ImageView ponerImagen(String status){
        Image image = new Image(String.valueOf(getClass().getResource("/com/example/battleship/images/" + status + ".png")));
        ImageView imagen = new ImageView(image);
        imagen.setFitHeight(30);
        imagen.setFitWidth(30);
        return imagen;
    }
}
