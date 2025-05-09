# Kosmos Coding Test

### Requisitos

Tener **Java y Maven instalados**, solo hay que **ejecutar el siguiente comando** en la raíz del proyecto:

~~~
$ mvn spring-boot:run
~~~

<details>
<summary>En caso de no contar con los requisitos...</summary>

A continuación se muestra una guía de como hacer el setup utilizando la línea de comandos:

~~~
# instalación de JDKMAN! (para instalar Java, Spring Boot y Maven)
$ curl -s "https://get.sdkman.io" | bash
$ source "$HOME/.sdkman/bin/sdkman-init.sh" # en caso de seguir usarndo la misma sesión del shell
$ sdk version # comprobar instalación

# instalación de maven
$ sdk install maven # última versión estable

# instalación de java
$ sdk install java 21.0.2-open # última lts compatible con cloud vendors populares

# instalación de spring boot
$ sdk install springbot # versión estable más reciente
$ echo 'export JAVA_HOME="$HOME/.sdkman/candidates/java/current"' >> ~/.zshrc # Spring CLI ocupa dicha variable, agregar dicha variable al ~/.bashrc en caso de no usar ZSH
$ source ~/.zshrc # en caso de seguir usarndo la misma sesión del shell, usar ~/.bashrc en caso de no usar ZSH
$ echo $JAVA_HOME # comprobar variable

# comprobaciones adicionales
$ java -version
$ mvn -version
$ spring --version
~~~

> **Nota:** No es necesario instalar Spring Boot para ejecutar el proyecto, esta guía son los pasos
> que se siguieron para hacer el setup de desarrollo.

</details>

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
