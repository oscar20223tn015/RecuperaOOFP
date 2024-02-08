package mx.edu.utez.RecuperacionOOFP.Controller;

import mx.edu.utez.RecuperacionOOFP.Model.Cliente;
import mx.edu.utez.RecuperacionOOFP.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public List<Cliente> obtenerTodosClientes() {
        return clienteService.obtenerTodosClientes();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> obtenerClientePorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id);
    }

    @PostMapping("/")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteActualizado) {
        return clienteService.actualizarCliente(id, clienteActualizado);
    }

    @DeleteMapping("/{id}")
    public boolean eliminarCliente(@PathVariable Long id) {
        return clienteService.eliminarCliente(id);
    }

}
