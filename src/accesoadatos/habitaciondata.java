
package accesoadatos;

import Entidades.habitacion;
import Entidades.tipohabitacion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author bmt
 */
public class habitaciondata {
    
    private Connection con=null;

    public habitaciondata() {
        
        con=conexion.getconexion();
        
    }
    
    public void crearhabitaciones(int canttotal,int pisos){
       String sql="INSERT INTO habitacion (idhabitacion,piso,estadohabitacion,categoria,camassimples,camasdobles) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            habitacion habitaciones[]=new habitacion[canttotal];
            tipohabitacion vecttipohabitacion[]=new tipohabitacion[canttotal];
            int piso;
            for(int j=1;j<=canttotal;j++){
                piso=(int)(j / (canttotal / pisos)) + 1;
                int opcion=j-(canttotal/pisos)*(piso-1);
                String cat;
                int simples;
                int dobles;
                switch (opcion) {
            case 1:
                cat="Comfort";
                simples=2;
                dobles=0;
                break;
            case 2:
                cat="Comfort";
                simples=0;
                dobles=1;
                break;
            case 3:
                cat="Privilege";
                simples=2;
                dobles=0;
                break;
            case 4:
                cat="Privilege";
                simples=0;
                dobles=1;
                break;
            case 5:
                cat="Luxury";
                simples=2;
                dobles=0;
                break;
            case 6:
                cat="Luxury";
                simples=0;
                dobles=1;
                break;
            case 7:
                cat="Privilege";
                simples=3;
                dobles=0;
                break;
            case 8:
                cat="Privilege";
                simples=1;
                dobles=1;
                break;
            case 9:
                cat="Luxury";
                simples=3;
                dobles=0;
                break;
            case 10:
                cat="Luxury";
                simples=1;
                dobles=1;
                break;
            case 11:
                cat="Privilege";
                simples=4;
                dobles=0;
                break;
            case 12:
                cat="Privilege";
                simples=2;
                dobles=1;
                break;
            case 13:
                cat="Luxury";
                simples=4;
                dobles=0;
                break;
            default:
                cat="Luxury";
                simples=2;
                dobles=1;
                break;
        }  
                vecttipohabitacion[j-1]=new tipohabitacion(cat,simples,dobles);
                habitaciones[j-1]=new habitacion(j,piso,"Libre",vecttipohabitacion[j-1]);
                ps.setInt(1,habitaciones[j-1].getIdhabitacion());
                ps.setInt(2,habitaciones[j-1].getPiso());
                ps.setString(3,habitaciones[j-1].getEstadohabitacion());
                ps.setString(4,vecttipohabitacion[j-1].getCategoria());
                ps.setInt(5, vecttipohabitacion[j-1].getCamassimples());
                ps.setInt(6, vecttipohabitacion[j-1].getCamasdobles());
                ps.executeUpdate();
                
            }
            JOptionPane.showMessageDialog(null,"Se han cargado exitosamente las "+canttotal+" habitaciones");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
        }
    }
    
    public String estadohab(int idhabitacion){
        
        String estado=null;
        String sql = "SELECT idhabitacion,estadohabitacion FROM habitacion WHERE idhabitacion = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,idhabitacion);
            ResultSet rs= ps.executeQuery();
            estado = rs.getString("estadohabitacion");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
        }
    return estado;
    }
    
    
    public void cambiarestadohabitaciones(int[] habitaciones){
        // Se ejecuta cuando cambia el estado de una habitación:
        // Cuando un cliente la reserva (pasa de LIBRE a RESERVADA, o bien cambia la fecha librahasta).
        // Cuando estando reservada, se cumple la fecha del checkin (pasa de RESERVADA a OCUPADA).
        // Cuando estando ocuapada, se cumple la fecha del checkout (pasa de OCUPADA a LIBRE).
        // Cuando el personal de mantenimiento debe hacer tareas de reparación o refacción (pasa a EN MANTENIMIENTO).
    }
    
    
    
}
