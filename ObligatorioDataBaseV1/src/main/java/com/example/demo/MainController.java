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
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
        
        ConsultasUsuarios userManager = new ConsultasUsuarios();
        String mail = body.get("mail");
        String password = body.get("password");
        String nombre = body.get("nombre").toUpperCase();
        String apellido = body.get("apellido").toUpperCase();
        boolean conductor = Boolean.parseBoolean(body.get("conductor"));
        String vehiculo = body.get("vehiculo").toUpperCase();
        int estado = 0;
        return userManager.insertar(new Usuario(mail,password,nombre,apellido,conductor,vehiculo,estado));
    }
    
    @PostMapping("/CrearUbicacion")
    public Ubicacion insertarUbicacion(@RequestBody Map<String, String> body) {
        
        ConsultasUbicaciones manager = new ConsultasUbicaciones();
        String calle = body.get("calle").toUpperCase();
        int nroPuerta = Integer.parseInt(body.get("nroPuerta"));
        return manager.insertar(new Ubicacion(calle,nroPuerta));
    }
    
    @PostMapping("/CrearParada")
    public int insertarParada(@RequestBody Map<String, String> body) {
        
        ConsultasParadas manager = new ConsultasParadas();
        int idUbicacion =Integer.parseInt(body.get("idUbicacion"));
        LocalTime aux = LocalTime.parse(body.get("hora"));
        Time hora = Time.valueOf(aux);
        return manager.insertar(new Parada(idUbicacion,hora));
    }
    
    @PostMapping("/CrearRuta")
    public RutaRaw insertarRuta(@RequestBody Map<String, String> body) {
        
        ConsultasRutas manager = new ConsultasRutas();
        int origen = Integer.parseInt(body.get("idOrigen"));
        int destino = Integer.parseInt(body.get("idDestino"));
        return manager.insertar(new RutaRaw(origen,destino));
    }
    
    @PostMapping("/CrearValoracion")
    public boolean insertarValoracion(@RequestBody Map<String, String> body) {
       
        ConsultasValoraciones Manager = new ConsultasValoraciones();
        String calificador = body.get("calificador");
        String calificado = body.get("calificado");
        int calificacion = Integer.parseInt(body.get("calificacion"));
        String observaciones = body.get("observaciones");
        return Manager.insertar(new Valoracion(calificador,calificado,calificacion,observaciones));
    }
        
    @PostMapping("/AgregarContacto")
    public boolean agregarContacto(@RequestBody Map<String, String> body) {
        
        ConsultasContactos manager = new ConsultasContactos();
        String mail_self = body.get("mailSelf");
        String mail_contact = body.get("mailContacto");
        return manager.insertar(mail_self, mail_contact);
    }
    
    @PostMapping("/CrearGrupo")
    public int insertarGrupo(@RequestBody Map<String, String> body) {
        
        ConsultasGrupos manager = new ConsultasGrupos();
        String name = body.get("groupName").toUpperCase();
        boolean isPrivate = Boolean.parseBoolean(body.get("isPrivate"));
        String mail_admin = body.get("admin");
        int estado = 0;
        return manager.insertar(new Grupo(name, isPrivate, mail_admin,estado));
    }
    
    @PostMapping("/CrearParticipacion")
    public boolean insertarParticipacion(@RequestBody Map<String, String> body) {
        
        ConsultasParticipaciones manager = new ConsultasParticipaciones();
        int parada = Integer.parseInt(body.get("parada"));
        String solicitante = body.get("solicitante");
        int viaje = Integer.parseInt(body.get("viaje"));
        int estado = 0;
        return manager.insertar(new Participacion(parada,solicitante,viaje,estado) );
    }
         
    @PostMapping("/PublicarViaje")
    public int insertarViaje(@RequestBody Map<String, String> body) {
        
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
    
    @PatchMapping("/CambiarEstadoParticipacion")
    public boolean updateEstadoParticipacion(@RequestBody Map<String, String> body) {
        
        ConsultasParticipaciones manager = new ConsultasParticipaciones();
        String solicitante = body.get("solicitante");
        int parada = Integer.parseInt(body.get("parada"));  
        int viaje = Integer.parseInt(body.get("viaje"));  
        int nuevo_estado = Integer.parseInt(body.get("estado"));
        
        return manager.updateEstadoParticipacion(solicitante,parada,nuevo_estado,viaje);
    } 
    
    @PatchMapping("/CambiarEstadoViaje")
    public boolean cambiarEstadoViaje(@RequestBody Map<String, String> body) {
        
        ConsultasViajes manager = new ConsultasViajes();
        int id_viaje = Integer.parseInt(body.get("id_viaje"));
        int estado = Integer.parseInt(body.get("estado"));
       
        return manager.cambiarEstadoViaje(id_viaje,estado);
    }
    
    @PatchMapping("/CambiarEstadoGrupoUsuario")
    public boolean CambiarEstadoGrupoUsuario(@RequestBody Map<String, String> body) {
       
        ConsultasGrupos manager = new ConsultasGrupos();
        int grupo = Integer.parseInt(body.get("grupo"));
        String usuario = body.get("usuario");
        int estado = Integer.parseInt(body.get("estado"));
       
        return manager.cambiarEstadoGrupoUsuario(grupo,usuario,estado);
    }
    
    @PatchMapping("/CambiarEstadoUsuario")
    public boolean CambiarEstadoPersona(@RequestBody Map<String, String> body) {
       
        ConsultasUsuarios manager = new ConsultasUsuarios();
        String usuario = body.get("usuario");
        int estado = Integer.parseInt(body.get("estado"));
       
        return manager.cambiarEstado(usuario,estado);
    }
    
    @PatchMapping("/CambiarEstadoGrupo")
    public boolean CambiarEstadoGrupo(@RequestBody Map<String, String> body) {
       
        ConsultasGrupos manager = new ConsultasGrupos();
        String grupo = body.get("grupo");
        int estado = Integer.parseInt(body.get("estado"));
       
        return manager.cambiarEstado(grupo,estado);
    }
    
    @GetMapping("/ObtenerGruposDeUsuario")
    public Vector<Grupo> getUserGroups(@RequestBody Map<String, String> body){
        ConsultasGrupos manager = new ConsultasGrupos();
        String usuario = body.get("mail");
        return manager.getUserGroups(usuario);
    }
    
    @GetMapping("/ObtenerParada")
    public Parada buscarParada(@RequestBody Map<String, String> body){
        ConsultasParadas manager = new ConsultasParadas();
        int ubic = Integer.parseInt(body.get("ubicacion"));
        Time hora = Time.valueOf(body.get("hora"));
        return manager.buscarParada(ubic, hora);
    }
    
    @GetMapping("/ObtenerParticipacionesUsuario")
    public List<Participacion> getParticipacionesUsuario(@RequestBody Map<String, String> body){
        ConsultasParticipaciones manager = new ConsultasParticipaciones();
        String mail = body.get("usuario");
        return manager.getParticipacionesUsuario(mail);
    }
    
    @GetMapping("/BuscarRuta")
    public RutaRaw buscarRuta(@RequestBody Map<String, String> body){
        ConsultasRutas manager = new ConsultasRutas();
        int origen = Integer.parseInt(body.get("idOrigen"));
        int destino = Integer.parseInt(body.get("idDestino"));
        return manager.buscarRuta(origen,destino);
    }
    
    @GetMapping("/BuscarUbicacion")
    public Ubicacion buscarUbicacion(@RequestBody Map<String, String> body){
        ConsultasUbicaciones manager = new ConsultasUbicaciones();
        String calle = body.get("calle").toUpperCase();
        int nroPuerta = Integer.parseInt(body.get("nroPuerta"));
        return manager.buscarUbicacion(calle, nroPuerta);
    }
    
    @GetMapping("/ObtenerUsuario")
    public Usuario getUser(@RequestBody Map<String, String> body){
        ConsultasUsuarios manager = new ConsultasUsuarios();
        String mail = body.get("mail");
        String password = body.get("password");
        return manager.getUser(mail, password);
    }
    
    @GetMapping("/ObtenerContactosDeUsuario")
    public List<String> getUserContacts(@RequestBody Map<String, String> body){
        ConsultasUsuarios manager = new ConsultasUsuarios();
        String mail = body.get("mail");
        return manager.getUserContacts(mail);
    }
    
    @GetMapping("/ObtenerIdsGruposDeUsuarios")
    public List<Integer> getUserIdGroups(@RequestBody Map<String, String> body){
        ConsultasUsuarios manager = new ConsultasUsuarios();
        String mail = body.get("mail");
        return manager.getUserGroups(mail);
    }
    
    @GetMapping("/ObtenerViajesDeGrupo")
    public List<Viaje> getViajesGroups(@RequestBody Map<String, String> body){
        ConsultasViajes manager = new ConsultasViajes();     
        int grupo = Integer.parseInt(body.get("grupo"));
        return manager.getViajesGroups(grupo);
    }
    
    @GetMapping("/ObtenerParadasDeViaje")
    public  List<Map<String, String>> ObtenerParadasDeViaje(@RequestBody Map<String, String> body){
        ConsultasParadas manager = new ConsultasParadas();     
        int viaje = Integer.parseInt(body.get("viaje"));
        return manager.paradasByViajeId(viaje);
    }
}
