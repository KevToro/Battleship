package com.example.battleship.model;

import javax.swing.*;
import java.util.Random;

public class Maquina extends Jugador{
    public Maquina(){
        Random random = new Random();
        switch (random.nextInt(3)){
            case 0:
                primerCaso();
                break;
            case 1:
                segundoCaso();
                break;
            case 2:
                tercerCaso();
                break;
        }
        llenarMatriz();
    }

    private void primerCaso(){
        super.flota.add(new Barco(0,0,1,"F"));
        super.flota.add(new Barco(8,1,1,"F"));
        super.flota.add(new Barco(6,2,1,"F"));
        super.flota.add(new Barco(1,7,1,"F"));
        super.flota.add(new Barco(0,3,2,"D"));
        super.flota.add(new Barco(1,2,2,"D"));
        super.flota.add(new Barco(0,8,2,"D"));
        super.flota.add(new Barco(9,3,3,"S"));
        super.flota.add(new Barco(5,2,3,"S"));
        super.flota.add(new Barco(7,3,4,"P"));
    }

    private void segundoCaso(){
        super.flota.add(new Barco(2,2,1,"F"));
        super.flota.add(new Barco(1,1,1,"F"));
        super.flota.add(new Barco(0,9,1,"F"));
        super.flota.add(new Barco(3,0,1,"F"));
        super.flota.add(new Barco(0,1,2,"D"));
        super.flota.add(new Barco(1,3,2,"D"));
        super.flota.add(new Barco(9,0,2,"D"));
        super.flota.add(new Barco(7,3,3,"S"));
        super.flota.add(new Barco(6,2,3,"S"));
        super.flota.add(new Barco(8,0,4,"P"));
    }

    private void tercerCaso(){
        super.flota.add(new Barco(0,0,1,"F"));
        super.flota.add(new Barco(0,9,1,"F"));
        super.flota.add(new Barco(9,9,1,"F"));
        super.flota.add(new Barco(9,0,1,"F"));
        super.flota.add(new Barco(3,0,2,"D"));
        super.flota.add(new Barco(6,3,2,"D"));
        super.flota.add(new Barco(9,6,2,"D"));
        super.flota.add(new Barco(1,2,3,"S"));
        super.flota.add(new Barco(2,1,3,"S"));
        super.flota.add(new Barco(5,5,4,"P"));
    }

    private void llenarMatriz(){
        for (Barco barco: super.flota){
            for(int i =  barco.columna; i < barco.columna + barco.largoBarco; i++)
                super.setPosicion(barco.fila, i, barco.nombre);
        }
    }
}
