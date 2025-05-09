CREATE TABLE doctor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido_paterno VARCHAR(100) NOT NULL,
    apellido_materno VARCHAR(100),
    especialidad VARCHAR(100) NOT NULL
);

CREATE TABLE consultorio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(16) NOT NULL,
    piso INT NOT NULL
);

CREATE TABLE cita (
    id INT AUTO_INCREMENT PRIMARY KEY,
    horario_inicio TIMESTAMP NOT NULL,
    horario_fin TIMESTAMP NOT NULL,
    nombre_paciente VARCHAR(100) NOT NULL,
    doctor_id INT NOT NULL,
    consultorio_id INT NOT NULL,
    CONSTRAINT fk_cita_doctor FOREIGN KEY (doctor_id) REFERENCES doctor(id),
    CONSTRAINT fk_cita_consultorio FOREIGN KEY (consultorio_id) REFERENCES consultorio(id)
);
