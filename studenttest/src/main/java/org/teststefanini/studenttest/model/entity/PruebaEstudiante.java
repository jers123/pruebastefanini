package org.teststefanini.studenttest.model.entity;

import static org.teststefanini.studenttest.utils.SystemConstants.EID;
import static org.teststefanini.studenttest.utils.SystemConstants.ESPECIALIDAD;
import static org.teststefanini.studenttest.utils.SystemConstants.ESPECIALIDAD_LENGTH;
import static org.teststefanini.studenttest.utils.SystemConstants.GRADO;
import static org.teststefanini.studenttest.utils.SystemConstants.GRADO_LENGTH;
import static org.teststefanini.studenttest.utils.SystemConstants.NOMBRE;
import static org.teststefanini.studenttest.utils.SystemConstants.NOMBRE_LENGTH;
import static org.teststefanini.studenttest.utils.SystemConstants.PRUEBA_ESTUDIANTE_TABLE;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = PRUEBA_ESTUDIANTE_TABLE)
@Getter
@Setter
public class PruebaEstudiante {
	@Id
	@Column(name = EID, nullable = false, updatable = false)
	private Integer eid;

	@Column(name=NOMBRE, nullable=false, length=NOMBRE_LENGTH)
	private String nombre;
	
	@Column(name=ESPECIALIDAD, nullable=false, length=ESPECIALIDAD_LENGTH)
	private String especialidad;

	@Column(name=GRADO, nullable=false, length=GRADO_LENGTH)
	private String grado;
}