package com.example.battleship.Controller;

import com.example.battleship.model.Barco;
import com.example.battleship.model.Maquina;
import com.example.battleship.model.Persona;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {

    @FXML
    private GridPane matrizPersona;

    @FXML
    private GridPane matrizMaquina;

    @FXML
    private ToggleGroup opcion;

    @FXML
    private VBox buttonBox;

    Persona persona = new Persona();
    Maquina maquina = new Maquina();

    private int largoBarco = 1;
    private String nombre = "F";
    private List<List<Pane>> matrizP;
    private List<List<Pane>> matrizM = new ArrayList<>();

    @FXML
    public void initialize() {
        matrizP = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Pane> fila = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                Pane pane = new Pane();
                pane.setOnMouseClicked(this::clickPane);
                matrizPersona.add(pane, i, j);
                fila.add(pane);
            }
            matrizP.add(fila);
        }
    }

    private void clickPane(MouseEvent event) {
        Pane pane = (Pane) event.getSource();
        ToggleButton button = null;
        button = (ToggleButton) opcion.getSelectedToggle();
        int columna = GridPane.getColumnIndex(pane);
        int fila = GridPane.getRowIndex(pane);

        if (button != null) {
            setLargoBarco(button);
            List<Pane> pseudoBarco = new ArrayList<>();
            boolean repetido = false;

            if(columna + largoBarco > 9)
                columna = 10 - largoBarco;

            for(int i=columna; i<columna + largoBarco; i++){
                pseudoBarco.add(matrizP.get(i).get(fila));
                if (persona.getPosicion(fila, i) != " "){
                    repetido = true;
                }
            }

            if(!repetido){
                int col = columna;
                Barco barco = new Barco(fila, columna, largoBarco, nombre);

                Node node = barco.dibujarBarco();
                matrizPersona.add(node, col, fila);
                GridPane.setHalignment(node, HPos.CENTER);
                GridPane.setValignment(node, VPos.CENTER);
                GridPane.setColumnSpan(node, barco.largoBarco);

                persona.agregarBarco(barco);
                for (Pane pPane : pseudoBarco){
                    pPane.setStyle("-fx-background-color: orange");
                    persona.setPosicion(fila, col, nombre);
                    col++;
                }

                opcion.getToggles().remove(button);
                button.setDisable(true);

                if(!opcion.getToggles().isEmpty())
                    opcion.getToggles().get(0).setSelected(true);
                else
                    iniciarJuego();
            }

        }
    }

    private void setLargoBarco(ToggleButton button){
        switch (button.getText()){
            case "Fragata":
                largoBarco = 1;
                nombre = "F";
                break;
            case "Destructor":
                largoBarco = 2;
                nombre = "D";
                break;
            case "Submarino":
                largoBarco = 3;
                nombre = "S";
                break;
            default:
                largoBarco = 4;
                nombre = "P";
        }
    }

    private void iniciarJuego(){
        buttonBox.getChildren().clear();
        Button botonInicio = new Button("Iniciar Juego");
        botonInicio.setPrefWidth(100);
        buttonBox.getChildren().add(botonInicio);
        botonInicio.setOnMouseClicked(this::comenzarPartida);
    }

    private void comenzarPartida(MouseEvent event){
        matrizMaquina();
        for(List<Pane> fila : matrizP){
            for (Pane pane: fila){
                pane.setStyle("");
            }
        }

        this.initialize();
        matrizPersona.setDisable(true);

        Button button = (Button) event.getSource();
        buttonBox.getChildren().clear();
    }

    private void matrizMaquina(){
        for (int i = 0; i < 10; i++) {
            List<Pane> fila = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                Pane pane = new Pane();
                pane.setOnMouseClicked(this::lanzarBombaPersona);
                matrizMaquina.add(pane, i, j);
                fila.add(pane);
            }
            matrizM.add(fila);
        }
    }

    private void lanzarBombaPersona(MouseEvent event){
        Pane pane = (Pane) event.getSource();
        if(persona.lanzarBomba(pane, maquina))
            lanzarBombaMaquina();
    }

    private void lanzarBombaMaquina(){
        Random random = new Random();
        Pane pane = matrizP.get(random.nextInt(10)).get(random.nextInt(10));
        maquina.lanzarBomba(pane, persona);
    }
}