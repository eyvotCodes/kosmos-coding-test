# Kosmos Coding Test

### Relación Entre Clases

~~~mermaid
classDiagram
    
    class Doctor {
        -Integer id
        -String nombre
        -String apellidoPaterno
        -String apellidoMaterno
        -String especialidad
        
        +getters()
        +setters()
    }

    class Consultorio {
        -Integer id
        -String numero
        -Integer piso

        +getters()
        +setters()
    }

    class Cita {
        -Integer id
        -LocalDateTime horarioInicio
        -LocalDateTime horarioFin
        -String nombrePaciente

        +getters()
        +setters()
    }

    Doctor "1" <-- "many" Cita
    Consultorio "1" <-- "many" Cita
    
~~~
