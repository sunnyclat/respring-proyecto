package fullst.fullst.models;

//nos trae todos los getters y setters con la dependencia de lombok
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")  //hace referencia a la tabla usuarios
@ToString @EqualsAndHashCode

//con la dependencia de lombok nos evitamos escribir todos los getters y setters y solo agregamos las anotaciones sobre cada atributo
//column sirve para que hibernate identifique cada atributo con su respectiva columna en la base de datos

public class Usuario {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name ="nombre")
    private String nombre;

    @Getter
    @Setter
    @Column(name ="apellido")
    private String apellido;

    @Getter
    @Setter
    @Column(name ="email")
    private String email;


    @Getter
    @Setter
    @Column(name ="password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
















}
