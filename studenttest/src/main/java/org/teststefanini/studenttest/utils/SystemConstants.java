package org.teststefanini.studenttest.utils;

import org.teststefanini.studenttest.utils.response.ReplyMessageList;
import org.teststefanini.studenttest.utils.response.ReplyMessageSimple;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class SystemConstants {

	// PATHS
	public static final String LOCAL_ORIGIN_PATH = "http://localhost:8080";
	public static final String PUBLIC_ORIGIN_PATH = "http://192.168.1.9:8080";
	public static final String STUDENTTEST_PATH = "/studenttest";
	public static final String CREATE_PATH = "/create";
	public static final String DELETE_PATH = "/delete/";
	public static final String GET_ALL_PATH = "/get-all";
	public static final String GET_ID_PATH = "/get-id/";
	public static final String UPDATE_PATH = "/update";

	// HEADERS
	public static final String ACCEPT = "Accept";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String LOCATION = "Location";

	// SUBPATHS
	public static final String PRUEBA_ESTUDIANTE_PATH = "/prueba-estudiante";

	// PRUEBA_ESTUDIANTE
	public static final String EID = "eid";
	public static final String NOMBRE = "nombre";
	public static final int NOMBRE_LENGTH = 20;
	public static final String ESPECIALIDAD = "especialidad";
	public static final int ESPECIALIDAD_LENGTH = 20;
	public static final String GRADO = "grado";
	public static final int GRADO_LENGTH = 2;
	public static final String PRUEBA_ESTUDIANTE_ALL_QUERY = "SELECT pe FROM PruebaEstudiante pe ORDER BY pe." + EID + " ASC";
	public static final String PRUEBA_ESTUDIANTE_TABLE = "prueba_estudiante";

	public static ResponseEntity<ReplyMessageSimple> answerSimple(ReplyMessageSimple replyMessage) {
		return ResponseEntity
				.status(replyMessage.getHttpStatus())
				.header(LOCATION, replyMessage.getUri())
				.header(ACCEPT, APPLICATION_JSON_VALUE)
				.body(replyMessage);
	}

	public static ResponseEntity<ReplyMessageList> answerList(ReplyMessageList replyMessage) {
		return ResponseEntity
				.status(replyMessage.getHttpStatus())
				.header(LOCATION, replyMessage.getUri())
				.header(ACCEPT, APPLICATION_JSON_VALUE)
				.body(replyMessage);
	}
}