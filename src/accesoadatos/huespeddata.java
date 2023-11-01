
package accesoadatos;

import Entidades.huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;


public class huespeddata {
    
    private Connection con=null;
    
    public huespeddata(){
        con=conexion.getconexion();
    }
   
    public boolean comprobarexistencia(int dni){
        
        // Este método recibe un nro. de DNI por parámetro y retorna TRUE si existe en la base de datos, y FALSE
        // de lo contrario.
        
        String sql="SELECT dni FROM huesped WHERE dni=?";
        boolean resultado=false;
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs=ps.executeQuery();
            resultado= rs.next();
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos");
        }
        return resultado;
    }
    
    public void nuevohuesped(huesped nuevohuesped){
        
        // Recibe un huésped por parámetro y lo sube a la base de datos. Sirve para clientes
        // que por primera vez van al hotel.
        
        String sql = "INSERT INTO huesped (dni,nombre,apellido,email,telefono,domicilio,pais) VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, nuevohuesped.getDni());
            ps.setString(2,nuevohuesped.getNombre());
            ps.setString(3,nuevohuesped.getApellido());
            ps.setString(4,nuevohuesped.getEmail());
            ps.setString(5,nuevohuesped.getTelefono());
            ps.setString(6,nuevohuesped.getDomicilio());
            ps.setString(7,nuevohuesped.getPais());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos");
        }
    }
    
    
    public huesped buscarhuespedpordni(int dni){
        
        // Recibe un entero por parámtero y devuelve el huesped cuyo DNI coincide con ese
        // entero en la base de datos.
        
        String sql = "SELECT* FROM huesped WHERE dni=?";
        huesped hues =new huesped();
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                hues.setNombre(rs.getString("nombre"));
                hues.setApellido(rs.getString("apellido"));
                hues.setPais(rs.getString("pais"));
                hues.setDomicilio(rs.getString("domicilio"));
                hues.setTelefono(rs.getString("telefono"));
                hues.setEmail(rs.getString("email"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos");
        }
        return hues;
    }
    
    public void actualizarhuesped(huesped huespedactualizado){
        
        // Recibe un huésped que ya existe en la base de datos (el DNI del actualizado debe coincidir
        // con el existente), y sube la información actuliazada a la misma. Se ejecuta cuando un cliente
        // que ya se hospedó anteriormente en el hotel desea hacerlo nuevamente.
        
        String sql = "UPDATE huesped SET nombre=?,apellido=?,email=?,telefono=?,domicilio=?,pais=? WHERE dni=?";
        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,huespedactualizado.getNombre());
            ps.setString(2,huespedactualizado.getApellido());
            ps.setString(3,huespedactualizado.getEmail());
            ps.setString(4,huespedactualizado.getTelefono());
            ps.setString(5,huespedactualizado.getDomicilio());
            ps.setString(6,huespedactualizado.getPais());
            ps.setInt(7,huespedactualizado.getDni());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos1");
        }
    }
}
