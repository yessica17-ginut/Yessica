/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sena.banco;

import java.util.Locale;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author portatil hp
 */
public class Cajeros {

    private int saldo = 7000000, saldoCJ = 20000000, retiroDIA = 2100000;
    private boolean continuar = true;//para salir del programa

    public Cajeros() { //el constructor siempre debe ir, y es el metodo principal de la class, puede estar vacio o con información
    }

    public int getSaldo() { //  get:traer datos
        return saldo;
    }

    public void setSaldo(int saldo) { // es una variable dentro de un metodo () es un argumento
        this.saldo = saldo;
    }

    public int getSaldoCJ() {
        return saldoCJ;
    }

    public void setSaldoC(int saldoC) { // set: cambiar, añadir o ingresar
        this.saldoCJ = saldoC;
    }

    public int getRetiroD() {
        return retiroDIA;
    }

    public void setRetiroD(int retiroD) {
        this.retiroDIA = retiroD;
    }

    public void cajeroautomatico() {

        while (continuar) {
            try {
                StringBuilder menu = new StringBuilder("MENÚ CAJERO AUTOMÁTICO \n"); // StringBuider es para poner varios mensajes reduciendo el espacio de memoria,a diferencia del Sring normal  que por cada mensaje se crea un espacio en la memoria y asi es mas pesado.
                menu.append("Seleccione una opción del 1 al 4 así: \n")// el punto appen se llama para ingrsar mas informacion
                        .append("1. Consultar saldo \n")
                        .append("2. Consignar dinero \n")
                        .append("3.Retirar dinero \n")
                        .append("4. salir \n");
                String opcion = JOptionPane.showInputDialog(null, menu, "Cajero automático", JOptionPane.QUESTION_MESSAGE);
                if (opcion == null) {
                    if (confirmarSalida()) {
                        continuar = false;
                    }
                    continue;
                }
                int opc = Integer.parseInt(opcion);

                switch (opc) {
                    case 1:
                        consultaSaldo();
                        break;
                    case 2:
                        consignarDinero();
                        break;
                    case 3:
                         retirarDinero();
                         break;
                    case 4:

                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opcion invalida.Por favor seleccione una opción del 1 al 4", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public boolean confirmarSalida() { //void significa que no necesita resivir o enviar un dato.
        int confirmar = JOptionPane.showConfirmDialog(null, "Está seguro que desea salir?", "Confirmar salida",
                JOptionPane.YES_NO_OPTION);

        return confirmar == JOptionPane.YES_OPTION;
    }

    public String idvalidacion() {
        Random random = new Random();
        int numero = random.nextInt(9000) + 1000; // el 9000 nos va a decir hasta donde va a llegar y el 1000 es para alargalos numeros para que no haya coincidencia y no de numeros repetidos
        return "ID de la operacion  #" + numero + "\n"; //return esenviar y envia el ID mas el numero

    }

    public void consultaSaldo() {
        String validacion = idvalidacion();
        StringBuilder mensaje = new StringBuilder("Consultar saldo \n");
        mensaje.append(validacion)
                .append("Saldo actual: $")
                .append(String.format("%,d", saldo));
        JOptionPane.showMessageDialog(null, mensaje, "Consultar saldo",
                JOptionPane.INFORMATION_MESSAGE);

    }
       
    public void consignarDinero() {
        try {
     
         StringBuilder mensaje = new StringBuilder();
         JOptionPane.showInternalMessageDialog(null, "Por favor recuerda no igresar monedas", "Advertencia", JOptionPane.WARNING_MESSAGE);
         mensaje.append("Consignar dinero");
         String con = JOptionPane.showInputDialog(null,"Consignar dinero", JOptionPane.DEFAULT_OPTION);
         if (con == null){
             return;
         }
         
        int valor = Integer.parseInt(con);
       
        if (valor < 10000){
            JOptionPane.showInternalMessageDialog(null, "Por favor recuerda no ingresar valor menor a 10000","ERROR", JOptionPane.WARNING_MESSAGE);
            return;
    }
        saldo += valor ;
        
}catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Opcion invalida.Por favor ingrese un valor correcto", "Error",
                        JOptionPane.ERROR_MESSAGE);    
}
}public void retirarDinero() {
    try{
        
         String retiro = JOptionPane.showInputDialog(null,"Por favor ingrese la cantidad de dinero a retirar", JOptionPane.DEFAULT_OPTION);
         int vretirar= Integer.parseInt(retiro);
     if (vretirar > saldo){
          JOptionPane.showInternalMessageDialog(null, "Por favor recuerda que debes retirar un valor igual o menor a tu saldo actual","ERROR", JOptionPane.WARNING_MESSAGE);
         }
     if (vretirar < 10000) {
         JOptionPane.showInternalMessageDialog(null, "Por favor recuerda no retirar valor menor a 10000","ERROR", JOptionPane.WARNING_MESSAGE);
            
         
     }
          if (vretirar <= saldo){
          JOptionPane.showMessageDialog(null,"Retiro Exitoso.Gracias por preferirnos", "RetiroS",JOptionPane.INFORMATION_MESSAGE);
          return;
          }
                  
         
     saldo -= vretirar;
     
}
       catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Opcion invalida.Por favor ingrese un valor correcto", "Error",
                        JOptionPane.ERROR_MESSAGE);    
}
    
   
}
}