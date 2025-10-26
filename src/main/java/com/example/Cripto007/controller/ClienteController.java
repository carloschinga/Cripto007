package com.example.Cripto007.controller;

import com.example.Cripto007.entity.Cliente;
import com.example.Cripto007.service.ClienteService;
import com.example.Cripto007.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    // Método auxiliar para validar el token
    private boolean validarToken(String token) {
        try {
            if (token != null && token.startsWith("Bearer ")) {
                String jwt = token.substring(7);
                String usuario = jwtTokenUtil.obtenerUsuarioDeToken(jwt);
                return usuario != null && !jwtTokenUtil.validarToken(jwt, ""); // Se puede personalizar
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @GetMapping
    public ResponseEntity<?> listarClientes(@RequestHeader("Authorization") String token) {
        if (!validarToken(token)) {
            return ResponseEntity.status(401).body("Token inválido o expirado");
        }
        List<Cliente> lista = clienteService.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCliente(@RequestHeader("Authorization") String token,
                                            @PathVariable String id) {
        if (!validarToken(token)) {
            return ResponseEntity.status(401).body("Token inválido o expirado");
        }
        Optional<Cliente> cliente = clienteService.obtenerPorId(id);
        return cliente.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> guardarCliente(@RequestHeader("Authorization") String token,
                                            @RequestBody Cliente cliente) {
        if (!validarToken(token)) {
            return ResponseEntity.status(401).body("Token inválido o expirado");
        }
        Cliente nuevo = clienteService.guardar(cliente);
        return ResponseEntity.ok(nuevo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCliente(@RequestHeader("Authorization") String token,
                                             @PathVariable String id) {
        if (!validarToken(token)) {
            return ResponseEntity.status(401).body("Token inválido o expirado");
        }
        clienteService.eliminar(id);
        return ResponseEntity.ok("Cliente eliminado correctamente");
    }
}