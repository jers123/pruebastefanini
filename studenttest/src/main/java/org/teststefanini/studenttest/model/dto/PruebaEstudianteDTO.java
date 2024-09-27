package org.teststefanini.studenttest.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import static org.teststefanini.studenttest.utils.Constants.EID_NOT_NULL;
import static org.teststefanini.studenttest.utils.Constants.ESPECIALIDAD_NOT_BLANK;
import static org.teststefanini.studenttest.utils.Constants.ESPECIALIDAD_NOT_NULL;
import static org.teststefanini.studenttest.utils.Constants.ESPECIALIDAD_SIZE;
import static org.teststefanini.studenttest.utils.Constants.GRADO_NOT_BLANK;
import static org.teststefanini.studenttest.utils.Constants.GRADO_NOT_NULL;
import static org.teststefanini.studenttest.utils.Constants.GRADO_SIZE;
import static org.teststefanini.studenttest.utils.Constants.ID_VALUE_MINIMUM;
import static org.teststefanini.studenttest.utils.Constants.NOMBRE_NOT_BLANK;
import static org.teststefanini.studenttest.utils.Constants.NOMBRE_NOT_NULL;
import static org.teststefanini.studenttest.utils.Constants.NOMBRE_SIZE;
import static org.teststefanini.studenttest.utils.SystemConstants.ESPECIALIDAD_LENGTH;
import static org.teststefanini.studenttest.utils.SystemConstants.GRADO_LENGTH;
import static org.teststefanini.studenttest.utils.SystemConstants.NOMBRE_LENGTH;

@Getter
@Setter
public class PruebaEstudianteDTO {
	@NotNull(message=EID_NOT_NULL)
	@Min(value=1, message=ID_VALUE_MINIMUM)
	private Integer eid;

	@NotNull(message=NOMBRE_NOT_NULL)
	@NotBlank(message=NOMBRE_NOT_BLANK)
	@Size(min=1, max=NOMBRE_LENGTH, message=NOMBRE_SIZE)
	private String nombre;
	
	@NotNull(message=ESPECIALIDAD_NOT_NULL)
	@NotBlank(message=ESPECIALIDAD_NOT_BLANK)
	@Size(min=1, max=ESPECIALIDAD_LENGTH, message=ESPECIALIDAD_SIZE)
	private String especialidad;

	@NotNull(message=GRADO_NOT_NULL)
	@NotBlank(message=GRADO_NOT_BLANK)
	@Size(min=1, max=GRADO_LENGTH, message=GRADO_SIZE)
	private String grado;
}