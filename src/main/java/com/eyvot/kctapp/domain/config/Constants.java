package com.eyvot.kctapp.domain.config;

public class Constants {

    public static final int NUMERO_MAXIMO_CARACTERES_NOMBRES = 100;
    public static final int NUMERO_MAXIMO_CARACTERES_NUMERO_CONSULTORIO = 16;
    public static final int NUMER_MAXIMO_CITAS_DOCTOR_PERMITIDAS_EL_MISMO_DIA = 8;
    public static final int NUMERO_MINIMO_HORAS_ENTRE_CONSULTAS_DE_PACIENTE = 2;
    public static final String MENSAJE_ERROR_CONFLICTO_HORARIOS = "Ya existe una cita para ese doctor o consultorio en ese horario.";
    public static final String MENSAJE_ERROR_PACIENTE_CON_CITAS_CERCANAS = "El paciente ya tiene una cita que se traslapa o está demasiado cercana en el mismo día.";
    public static final String MENSAJE_ERROR_DOCTOR_CON_MAXIMO_DE_CITAS_PERMITIDAS = "El doctor ya tiene el máximo de 8 citas asignadas para ese día.";

    private Constants() {}

}
