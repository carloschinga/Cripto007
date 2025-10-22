package com.example.Cripto007.controller;


import com.example.Cripto007.entity.Usuario;
import com.example.Cripto007.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // permite acceso desde cualquier frontend
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{codiUsua}")
    public Usuario obtenerPorCodigo(@PathVariable String codiUsua) {
        return usuarioService.buscarPorCodigo(codiUsua);
    }

    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }

    @PutMapping("/{codiUsua}")
    public Usuario actualizar(@PathVariable String codiUsua, @RequestBody Usuario usuario) {
        usuario.setCodiUsua(codiUsua);
        return usuarioService.guardar(usuario);
    }

    @DeleteMapping("/{codiUsua}")
    public void eliminar(@PathVariable String codiUsua) {
        usuarioService.eliminar(codiUsua);
    }
}