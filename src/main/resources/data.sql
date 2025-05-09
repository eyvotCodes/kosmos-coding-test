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
('2025-05-09 10:30:00', '2025-05-09 11:15:00', 'Ramón Emiliano Cázares López', 4, 1),
('2025-05-09 09:00:00', '2025-05-09 10:00:00', 'Carlos Méndez Escobar', 5, 3),
('2025-05-09 10:00:00', '2025-05-09 11:00:00', 'María Fernanda López Silva', 5, 2),
('2025-05-09 11:00:00', '2025-05-09 12:00:00', 'Luis Rodríguez Paredes', 5, 3),
('2025-05-09 12:00:00', '2025-05-09 13:00:00', 'Fernanda Cruz Morales', 5, 1),
('2025-05-09 13:00:00', '2025-05-09 14:00:00', 'Jorge Andrés Salazar Díaz', 5, 2),
('2025-05-09 15:00:00', '2025-05-09 16:00:00', 'Valeria Torres Ramírez', 5, 3),
('2025-05-09 16:00:00', '2025-05-09 17:00:00', 'Raúl Eduardo Martínez Soto', 5, 1),
('2025-05-09 17:00:00', '2025-05-09 18:00:00', 'Sofía Aguilar Herrera', 5, 2);
