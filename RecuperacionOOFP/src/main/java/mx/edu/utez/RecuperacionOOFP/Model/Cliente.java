package mx.edu.utez.RecuperacionOOFP.Model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String direccion;
    private String contacto;

}
