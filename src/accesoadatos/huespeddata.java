
package accesoadatos;

import Entidades.huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class huespeddata {
    
    private Connection con=null;
    
    public huespeddata(){
        con=conexion.getconexion();
    }
   
    public void nuevocliente(huesped huesped){
    
        // Este método se ejecuta cuando se realiza una reservación con el DNI de un huesped no registrado
        // en la base de datos.
        
    }
    
    public huesped buscarhuesped(int dni,int accion){
        
        // Este método se ejecuta cuando:
        // a)_ Un cliente desea hacer una nueva reserva. Si el programa encuentra el cliente en cuestión,
        // le pedirá al personal que controle si los datos están actualizados. De lo contrario, se ejecutará el
        // método nuevocliente.
        // b)_ Se desea buscar un huesped (pasado o presente) por DNI en la base de datos. En tal caso, el programa
        // indica la existencia o inexistencia del mismo.
        
        String sql = "SELECT dni, nombre, apellido, email, telefono, domicilio, pais";
        huesped huesped=null;
      
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                if(accion!=1){
                    huesped = new huesped();
                    huesped.setDni(dni);
                    huesped.setNombre("nombre");
                    huesped.setEmail("email");
                    huesped.setTelefono("telefono");
                    huesped.setDomicilio("domicilio");
                    huesped.setPais("pais");
                }else{
                    huesped = new huesped();
                    huesped.setDni(dni);
                    huesped.setNombre("nombre");
                    huesped.setEmail("email");
                    huesped.setTelefono("telefono");
                    huesped.setDomicilio("domicilio");
                    huesped.setPais("pais");
                    JOptionPane.showMessageDialog(null,"El huésped con el DNI ingresado ya existe en la base de datos. A continuación, verifique que los datos estén actualizados");
                }
                
                
            }else{
                if(accion!=1){
                    JOptionPane.showMessageDialog(null,"No existe en la base de datos un huésped con el DNI ingresado");
                }else{
                    JOptionPane.showMessageDialog(null,"No existe en la base de datos un huésped con el DNI ingresado. A continuación deberá crear un nuevo huésped con ingresando todos sus datos");
                }
                
            }
            ps.close();
            
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la base de datos");
        }
        return huesped;
    }
    
    
}
