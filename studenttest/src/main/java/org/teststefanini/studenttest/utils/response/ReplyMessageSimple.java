package org.teststefanini.studenttest.utils.response;

import org.springframework.stereotype.Component;
import org.teststefanini.studenttest.model.dto.PruebaEstudianteDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ReplyMessageSimple extends ReplyMessage {
	private PruebaEstudianteDTO response;
}