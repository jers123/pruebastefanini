package org.teststefanini.studenttest.service;

import org.springframework.transaction.annotation.Transactional;
import org.teststefanini.studenttest.model.dto.PruebaEstudianteDTO;
import org.teststefanini.studenttest.utils.response.ReplyMessageList;
import org.teststefanini.studenttest.utils.response.ReplyMessageSimple;

public interface IBaseService {
	@Transactional()
	ReplyMessageSimple getCreate(PruebaEstudianteDTO entityDto);

	@Transactional(readOnly = true)
	ReplyMessageList getFindAll();

	@Transactional(readOnly = true)
	ReplyMessageSimple getFindById(Integer id);

	@Transactional()
	ReplyMessageSimple getUpdate(PruebaEstudianteDTO entityDto);

	@Transactional()
	ReplyMessageSimple getDelete(Integer id);

	String getUri(String method);

	String getUri(String method, Integer id);
}