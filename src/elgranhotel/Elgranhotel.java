
package elgranhotel;

import Entidades.habitacion;
import Entidades.huesped;
import Entidades.reserva;
import java.time.LocalDate;
import accesoadatos.conexion;
import accesoadatos.habitaciondata;
import accesoadatos.huespeddata;
import accesoadatos.mantenimientodata;
import accesoadatos.reservadata;
import java.sql.Connection;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;


public class Elgranhotel {

  
    public static void main(String[] args) {
        
//        INSTANCIANDO OBJETOS DE TODAS LAS CLASES DEL PAQUETE ACCESO A DATOS, QUE NOS PERMITIRÁN CONECTARNOS CON LA BASE DE DATOS:
//        
        habitaciondata nuevashab = new habitaciondata();
        huespeddata hues=new huespeddata();
        reservadata res=new reservadata();
        mantenimientodata mtto=new mantenimientodata();
//        
//        
//        CREANDO HABITACIONES AL PRINCIPIO:
    
        int[] types = new int[14];
        types[0]=1;
        types[1]=1;
        types[2]=1;
        types[3]=1;
        types[4]=1;
        types[5]=1;
        types[6]=1;
        types[7]=2;
        types[8]=2;
        types[9]=2;
        types[10]=3;
        types[11]=3;
        types[12]=3;
        types[13]=3;
//             
        nuevashab.crearhabitaciones(types, 8);



//        ARRAYLIST DE HABITACIONES DE UNA DETERMINADA CAPACIDAD, QUE TIENEN RESERVAS Y/O MANTENIMIENTOS EN CURSO Y/O FUTUROS:

//        System.out.println("ArrayList de habitaciones de una determinada capacidad, que tienen reservas y/o mantenimientos en curso y/o futuros:");
//        System.out.println("");
//        ArrayList<Integer> vect1=new ArrayList();
//        vect1=nuevashab.vecthabitacionesid(3);
//        System.out.println(""+vect1);
//        System.out.println("");



//        LISTA DE LISTAS, CON LAS FECHAS DE CHECKIN/INICIO DE LAS RESERVAS/MANTENIMIENTOS CORRESPONDIENTES A CADA UNA DE LAS HABITACIONES DE LA LISTA ANTERIOR:

//        System.out.println("Lista de listas, con las fechas de check-in/inicio de las reservas/mantenimientos correspondientes a cada una de las habitaciones de la lista anterior:");
//        System.out.println("");
//        ArrayList <ArrayList<Integer>> vect2= new ArrayList();
//        vect2 = nuevashab.matrizfcheckin2(vect1);
//        System.out.println(""+vect2);
//        System.out.println("");



//        LISTA DE LISTAS, CON LAS FECHAS DE CHECKOUT/FIN DE LAS RESERVAS/MANTENIMIENTOS CORRESPONDIENTES A CADA UNA DE LAS HABITACIONES DE LA LISTA ANTERIOR:

//        System.out.println("Lista de listas, con las fechas de checkOUT/FIN de las reservas/mantenimientos correspondientes a cada una de las habitaciones de la lista anterior:");
//        System.out.println("");
//        ArrayList <ArrayList<Integer>> vect3= new ArrayList();
//        vect3 = nuevashab.matrizfcheckout2(vect1);
//        System.out.println(""+vect3);
//        System.out.println("");



//        LISTA CON LAS HABITACIONES DISPONIBLES PARA RESERVAR, DE UNA DETERMINADA CAPACIDAD, Y DURANTE UN DETERMINADO PERÍODO DE TIEMPO:
       
//        System.out.println("Lista con las habitaciones disponibles para reservar, de una determinada capacidad, y durante un determinado período de tiempo:");
//        System.out.println("");
//        LocalDate fecha1 = LocalDate.of(2023, Month.JANUARY,8);
//        LocalDate fecha2 = LocalDate.of(2023, Month.JANUARY,10);
//        ArrayList<habitacion> vect4=new ArrayList();
//        vect4 = nuevashab.habitacionesdisponiblesparareservar(fecha1,fecha2,vect1,vect2,vect3,3);
//        System.out.println(""+vect4);
//        System.out.println("");
//        System.out.println("Descripción detallada de las habitaciones disponibles:");
        
//        for(int i=0;i<=vect4.size()-1;i++){
//            System.out.println("");
//            System.out.println("Id habitación: "+vect4.get(i).getIdhabitacion());
//            System.out.println("Tipo: "+vect4.get(i).getTipohabitacion().getTipo());
//            System.out.println("Categoría: "+vect4.get(i).getTipohabitacion().getCategoria());
//            System.out.println("Camas dobles: "+vect4.get(i).getTipohabitacion().getCamasdobles());
//            System.out.println("Camas simples: "+vect4.get(i).getTipohabitacion().getCamassimples());
//            System.out.println("Piso: "+vect4.get(i).getPiso());
//            System.out.println("");
//        }
    }
}
