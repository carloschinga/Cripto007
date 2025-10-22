package com.example.Cripto007.repository;


import com.example.Cripto007.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    // Ejemplo: buscar por login
    Usuario findByLogiUsua(String logiUsua);
}
