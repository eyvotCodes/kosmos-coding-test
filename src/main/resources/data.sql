-- Doctores
INSERT INTO doctor (nombre, apellido_paterno, apellido_materno, especialidad) VALUES
('Alicia', 'Perez', 'Camacho', 'Cardiología'),
('Roberto', 'Ramirez', 'Hernández', 'Pediatría'),
('Emilia', 'Campos', 'Ochoa', 'General'),
('David', 'Torres', 'Camarena', 'Neurología'),
('Carlos', 'Rodríguez', 'Cuevas', 'General');

-- Consultorios
INSERT INTO consultorio (numero, piso) VALUES
('101', 1),
('202', 2),
('303', 3);

-- Citas
INSERT INTO cita (horario_inicio, horario_fin, nombre_paciente, doctor_id, consultorio_id) VALUES
('2025-05-09 10:30:00', '2025-05-09 11:15:00', 'Ramón Emiliano Cázares López', 4, 1);
