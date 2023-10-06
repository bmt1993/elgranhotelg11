/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

import Entidades.reserva;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author bmt
 */
public class reservadata {
    
    private Connection con=null;
    
    public reservadata(){   
        this.con=conexion.getconexion();
    }
    
    
    public void nuevareserva(reserva res,int cantidad){
      // Este método se ejecuta cada vez que se realiza una nueva reserva. Pide las fechas de checkin y checkout
      // y muestra las habitaciones disponibles, junto con sus características, para ese período de tiempo. También
      // ejecuta el método buscarhuesped de la clase huespeddata. Si se realiza existosamente, ejecuta el método
      // cambiarestadohabitaciones de la clase habitaciondata.
    }
    
}
