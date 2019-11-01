 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import Data.Classes.Grupo;
import Data.Classes.Parada;
import Data.Classes.Participacion;
import Data.Classes.RutaRaw;
import Data.Classes.Usuario;
import Data.Classes.Ubicacion;
import Data.Classes.Valoracion;
import Data.Classes.Viaje;
import DataBase.Queries.ConsultasContactos;
import DataBase.Queries.ConsultasGrupos;
import DataBase.Queries.ConsultasParadas;
import DataBase.Queries.ConsultasParticipaciones;
import DataBase.Queries.ConsultasRutas;
import DataBase.Queries.ConsultasUsuarios;
import DataBase.Queries.ConsultasUbicaciones;
import DataBase.Queries.ConsultasValoraciones;
import DataBase.Queries.ConsultasViajes;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
public class MainController {
    
    @PostMapping("/CrearUsuario")
    public boolean insertarUsuario(@RequestBody Map<String, String> body) {
        //enter code here
        ConsultasUsuarios userManager = new ConsultasUsuarios();
        String mail = body.get("mail");
        String password = body.get("password");
        String nombre = body.get("nombre");
        String apellido = body.get("apellido");
        boolean conductor = Boolean.parseBoolean(body.get("conductor"));
        String vehiculo = body.get("vehiculo");
        int estado = 0;
        return userManager.insertar(new Usuario(mail,password,nombre,apellido,conductor,vehiculo,estado));
    }
    
    @PostMapping("/CrearUbicacion")
    public Ubicacion insertarUbicacion(@RequestBody Map<String, String> body) {
        System.out.println(body);
        ConsultasUbicaciones manager = new ConsultasUbicaciones();
        String calle = body.get("calle");
        int nroPuerta = Integer.parseInt(body.get("nroPuerta"));
        return manager.insertar(new Ubicacion(calle,nroPuerta));
    }
    
    @PostMapping("/CrearParada")
    public int insertarParada(@RequestBody Map<String, String> body) {
        System.out.println(body);
        ConsultasParadas manager = new ConsultasParadas();
        int idUbicacion =Integer.parseInt(body.get("idUbicacion"));
        LocalTime aux = LocalTime.parse(body.get("hora"));
        Time hora = Time.valueOf(aux);
        return manager.insertar(new Parada(idUbicacion,hora));
    }
    
    @PostMapping("/CrearRuta")
    public int insertarRuta(@RequestBody Map<String, String> body) {
        System.out.println(body);
        ConsultasRutas manager = new ConsultasRutas();
        int origen = Integer.parseInt(body.get("idOrigen"));
        int destino = Integer.parseInt(body.get("idDestino"));
        return manager.insertar(new RutaRaw(origen,destino));
    }
    
    @PostMapping("/CrearValoracion")
    public boolean insertarValoracion(@RequestBody Map<String, String> body) {
        //enter code here
        ConsultasValoraciones Manager = new ConsultasValoraciones();
        String calificador = body.get("calificador");
        String calificado = body.get("calificado");
        int calificacion = Integer.parseInt(body.get("calificacion"));
        String observaciones = body.get("observaciones");
        return Manager.insertar(new Valoracion(calificador,calificado,calificacion,observaciones));
    }
        
    @PostMapping("/AgregarContacto")
    public boolean agregarContacto(@RequestBody Map<String, String> body) {
        System.out.println(body);
        ConsultasContactos manager = new ConsultasContactos();
        String mail_self = body.get("mailSelf");
        String mail_contact = body.get("mailContacto");
        return manager.insertar(mail_self, mail_contact);
    }
    
    @PostMapping("/CrearGrupo")
    public int insertarGrupo(@RequestBody Map<String, String> body) {
        System.out.println(body);
        ConsultasGrupos manager = new ConsultasGrupos();
        String name = body.get("groupName");
        boolean isPrivate = Boolean.parseBoolean(body.get("isPrivate"));
        String mail_admin = body.get("admin");
        int estado = 0;
        return manager.insertar(new Grupo(name, isPrivate, mail_admin,estado));
    }
    
    @PostMapping("/CrearParticipacion")
    public boolean insertarParticipacion(@RequestBody Map<String, String> body) {
        //enter code here
        ConsultasParticipaciones manager = new ConsultasParticipaciones();
        int parada = Integer.parseInt(body.get("parada"));
        String solicitante = body.get("solicitante");
        int viaje = Integer.parseInt(body.get("viaje"));
        int estado = 0;
        return manager.insertar(new Participacion(parada,solicitante,viaje,estado) );
    }
         
    @PostMapping("/PublicarViaje")
    public int insertarViaje(@RequestBody Map<String, String> body) {
        //enter code here
        ConsultasViajes manager = new ConsultasViajes();       
        int id_ruta  = Integer.parseInt(body.get("rutaID"));;
        String mail_publicante = body.get("mailPublicante");
        int estado = 0;
        Date fecha = Date.valueOf(body.get("fecha")); 
        Time hora = Time.valueOf(body.get("partida"));
        int lugares_disponibles = Integer.parseInt(body.get("lugaresDisponibles"));
        int visibility = Integer.parseInt(body.get("visibility"));
        int grupo = Integer.parseInt(body.get("grupo")); //Si visibilidad es 0, no se agrega el grupo, lo mejor seria setearlo tambien en 0, que nunca corresponde con nignun grupo
      
        return manager.insertar(new Viaje(id_ruta,mail_publicante,estado,hora,fecha,lugares_disponibles), visibility, grupo );
    }
    
    @PostMapping("/UpdatePersonaEnParticipacion")
    public boolean updatePersonaEnParticipacion(@RequestBody Map<String, String> body) {
        //enter code here
        ConsultasParticipaciones manager = new ConsultasParticipaciones();
        String solicitante = body.get("solicitante");
        int parada = Integer.parseInt(body.get("parada"));       
        int nuevo_estado = Integer.parseInt(body.get("nuevo_estado"));
        
        return manager.updatePersonaEnParticipacion(solicitante,parada,nuevo_estado);
    } 
    
    @PostMapping("/UpdateParadaEnParticipacion")
    public boolean updateParadaEnParticipacion(@RequestBody Map<String, String> body) {
        //enter code here
        ConsultasParticipaciones manager = new ConsultasParticipaciones();
        String solicitante = body.get("solicitante");
        int parada = Integer.parseInt(body.get("parada"));       
        int nuevo_estado = Integer.parseInt(body.get("nuevo_estado"));
        
        return manager.updatePersonaEnParticipacion(solicitante,parada,nuevo_estado);
    } 
}
