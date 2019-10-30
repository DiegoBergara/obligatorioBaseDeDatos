/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import Data.Classes.Usuario;
import Data.Classes.Ubicacion;
import DataBase.Queries.ConsultasUsuarios;
import DataBase.Queries.ConsultasUbicaciones;
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
        return userManager.insertarUsuario(new Usuario(mail,password,nombre,apellido,conductor,vehiculo));
    }
    
    @PostMapping("/CrearUbicacion")
    public Ubicacion insertarUbicacion(@RequestBody Map<String, String> body) {
        System.out.println(body);
        ConsultasUbicaciones manager = new ConsultasUbicaciones();
        String calle = body.get("calle");
        int nroPuerta = Integer.parseInt(body.get("nroPuerta"));
        return manager.insertarUsuario(new Ubicacion(calle,nroPuerta));
    }
}
