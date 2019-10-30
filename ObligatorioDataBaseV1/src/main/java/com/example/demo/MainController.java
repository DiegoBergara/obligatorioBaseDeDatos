/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import Data.Classes.Parada;
import Data.Classes.RutaRaw;
import Data.Classes.Usuario;
import Data.Classes.Ubicacion;
import DataBase.Queries.ConsultasParadas;
import DataBase.Queries.ConsultasRutas;
import DataBase.Queries.ConsultasUsuarios;
import DataBase.Queries.ConsultasUbicaciones;
import java.sql.Time;
import java.time.LocalTime;
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
        return userManager.insertar(new Usuario(mail,password,nombre,apellido,conductor,vehiculo));
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
}
