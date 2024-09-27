package org.teststefanini.studenttest.utils.response;

import java.util.List;

import org.springframework.stereotype.Component;
import org.teststefanini.studenttest.model.dto.PruebaEstudianteDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ReplyMessageList extends ReplyMessage {
	private List<PruebaEstudianteDTO> response;
}