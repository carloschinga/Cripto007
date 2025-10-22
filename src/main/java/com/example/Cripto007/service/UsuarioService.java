package com.example.Cripto007.service;

import com.example.Cripto007.entity.Usuario;
import com.example.Cripto007.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorCodigo(String codiUsua) {
        Optional<Usuario> op = usuarioRepository.findById(codiUsua);
        return op.orElse(null);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminar(String codiUsua) {
        usuarioRepository.deleteById(codiUsua);
    }
}
