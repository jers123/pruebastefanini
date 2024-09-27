package org.teststefanini.studenttest.utils;

import static org.teststefanini.studenttest.utils.SystemConstants.ESPECIALIDAD_LENGTH;
import static org.teststefanini.studenttest.utils.SystemConstants.GRADO_LENGTH;
import static org.teststefanini.studenttest.utils.SystemConstants.NOMBRE_LENGTH;

public class Constants {

	// ERRORS
	public static final String HTTP_MESSAGE1 = "Problema de método HTTP, se esperaba la petición por medio del método ";
	public static final String HTTP_MESSAGE2 = " pero se solicitó por medio del metodo ";

	public static final String ID_VALUE_MINIMUM = "El ID ingresado debe ser mayor o igual a 1";
	public static final String NO_CONTENT = "No hay registros";
	public static final String NO_CONTENT_ID = "No hay registros con el id = ";
	public static final String YES_CONTENT = "Si hay registros";

	// PRUEBA_ESTUDIANTE
	public static final String EID_EXISTS = "El Eid del estudiante ya existe en otro registro.";
	public static final String EID_NOT_NULL = "El Eid del estudiante no puede ser nulo.";
	public static final String ESPECIALIDAD_NOT_BLANK = "La especialidad del estudiante no puede ser vacío.";
	public static final String ESPECIALIDAD_NOT_NULL = "La especialidad del estudiante no puede ser nulo.";
	public static final String ESPECIALIDAD_SIZE = "El tamaño de la especialidad del estudiante es mínimo de 1 y máximo de " + ESPECIALIDAD_LENGTH + ".";
	public static final String GRADO_NOT_BLANK = "El grado del estudiante no puede ser vacío.";
	public static final String GRADO_NOT_NULL = "El grado del estudiante no puede ser nulo.";
	public static final String GRADO_SIZE = "El tamaño del grado del estudiante es mínimo de 1 y máximo de " + GRADO_LENGTH + ".";
	public static final String NOMBRE_NOT_BLANK = "El nombre del estudiante no puede ser vacío.";
	public static final String NOMBRE_NOT_NULL = "El nombre del estudiante no puede ser nulo.";
	public static final String NOMBRE_SIZE = "El tamaño del nombre del estudiante es mínimo de 1 y máximo de " + NOMBRE_LENGTH + ".";
	public static final String SUCCESSFULLY_CREATED_PRUEBA_ESTUDIANTE = "Estudiante creado exitosamente.";
	public static final String SUCCESSFULLY_DELETED_PRUEBA_ESTUDIANTE = "Estudiante eliminado exitosamente.";
	public static final String SUCCESSFULLY_UPDATED_PRUEBA_ESTUDIANTE = "Estudiante actualizado exitosamente.";
}