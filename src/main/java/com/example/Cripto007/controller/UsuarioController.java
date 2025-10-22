package com.example.Cripto007.controller;


import com.example.Cripto007.dto.CredencialDTO;
import com.example.Cripto007.dto.MensajeCredencialDTO;
import com.example.Cripto007.entity.Usuario;
import com.example.Cripto007.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // permite acceso desde cualquier frontend
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public MensajeCredencialDTO validarUsuario(@RequestBody CredencialDTO credencialDTO) {

        Usuario u=usuarioService.buscarPorLogin(credencialDTO.getLogin());
        if(u!=null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if(encoder.matches(credencialDTO.getPassword(), u.getPassUsua())){
                return new MensajeCredencialDTO("ok","Credencial ok");
            }
            else{
                return new MensajeCredencialDTO("error","Credencial error");
            }
        }
        else{
            return new MensajeCredencialDTO("error","Credencial error");
        }
    }



}
    /*

    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }


     @GetMapping("/{codiUsua}")
    public Usuario obtenerPorCodigo(@PathVariable String codiUsua) {
        return usuarioService.buscarPorCodigo(codiUsua);
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }



    @PutMapping("/{codiUsua}")
    public Usuario actualizar(@PathVariable String codiUsua, @RequestBody Usuario usuario) {
        usuario.setCodiUsua(codiUsua);
        return usuarioService.guardar(usuario);
    }

    @DeleteMapping("/{codiUsua}")
    public void eliminar(@PathVariable String codiUsua) {
        usuarioService.eliminar(codiUsua);
    }*/
