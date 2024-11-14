package com.example.battleship.model;

import com.example.battleship.view.GameStage;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

public class Barco {
    public int fila;
    public int columna;
    public int largoBarco;
    public String nombre;
    public int vidas;
    public Barco(int fila, int columna, int largoBarco, String nombre) {
        this.fila = fila;
        this.columna = columna;
        this.largoBarco = largoBarco;
        this.nombre = nombre;
        this.vidas = largoBarco;
    }
    public boolean perdeVidas(){
        vidas--;
        return vidas == 0;
    }
    public Group dibujarBarco(){
        Group group = new Group();
        Polyline polyline = new Polyline();
        Group grupoInterno = new Group();

        switch (nombre){
            case "F":
                polyline.getPoints().addAll(
                        0.0,2.0,
                        15.0,0.0,
                        25.0,10.0,
                        15.0,20.0,
                        0.0,18.0,
                        0.0,2.0);
                polyline.setStroke(Color.BLACK);
                polyline.setFill(Color.LIGHTGREY);

                Rectangle rectangle = new Rectangle(2,5,10,10);
                rectangle.setFill(Color.DARKRED);

                grupoInterno.getChildren().add(rectangle);
                break;

            case "D":
                polyline.getPoints().addAll(
                        0.0, 0.0,
                        30.0,0.0,
                        45.0,10.0,
                        30.0,20.0,
                        0.0,20.0,
                        0.0,0.0);
                polyline.setStroke(Color.BLACK);
                polyline.setFill(Color.DIMGRAY);

                Rectangle rectangle2 = new Rectangle(5,5,20,10);
                rectangle2.setFill(Color.LIGHTGREY);

                Rectangle rectangle3 = new Rectangle(7.5,7.5,25,5);
                rectangle3.setFill(Color.BLACK);

                grupoInterno.getChildren().addAll(rectangle2, rectangle3);

                break;

            case "S":
                polyline.getPoints().addAll(
                        0.0, 10.0,
                        10.0,0.0,
                        60.0,0.0,
                        70.0,5.0,
                        80.0,10.0,
                        70.0,15.0,
                        60.0,20.0,
                        10.0,20.0,
                        0.0,10.0);
                polyline.setStroke(Color.BLACK);
                polyline.setFill(Color.DARKGRAY);

                Rectangle rectangle4 = new Rectangle(70,0,10,20);

                Circle circle = new Circle(40,10,8);

                grupoInterno.getChildren().addAll(rectangle4, circle);

                break;

            case "P":
                polyline.getPoints().addAll(
                        100.0, 0.0,
                        30.0,0.0,
                        10.0,5.0,
                        0.0,10.0,
                        10.0,15.0,
                        30.0,20.0,
                        100.0,20.0,
                        100.0,0.0);
                polyline.setStroke(Color.BLACK);
                polyline.setFill(Color.LIGHTGREY);

                Rectangle rectangle5 = new Rectangle(75,5,20,10);

                Line line = new Line(70,0,70,20);
                Line line1 = new Line(60,0,60,10);
                Line line2 = new Line(50,10,50,20);
                Line line3 = new Line(40,0,40,10);
                Line line4 = new Line(30,10,30,20);
                Line line5 = new Line(20,3,20,10);
                Line line6 = new Line(10,5,10,15);
                Line line7 = new Line(0,10,70,10);

                grupoInterno.getChildren().addAll(rectangle5, line, line1, line2, line3, line4, line5, line6, line7);
                break;
        }

        group.getChildren().addAll(polyline, grupoInterno);

        return group;
    }
}
