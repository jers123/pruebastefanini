package org.teststefanini.studenttest.controller;

import static org.teststefanini.studenttest.utils.SystemConstants.PRUEBA_ESTUDIANTE_PATH;
import static org.teststefanini.studenttest.utils.SystemConstants.STUDENTTEST_PATH;
import static org.teststefanini.studenttest.utils.SystemConstants.answerList;
import static org.teststefanini.studenttest.utils.SystemConstants.answerSimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.teststefanini.studenttest.annotation.RestApi;
import org.teststefanini.studenttest.model.dto.PruebaEstudianteDTO;
import org.teststefanini.studenttest.service.IBaseService;
import org.teststefanini.studenttest.utils.response.ReplyMessageList;
import org.teststefanini.studenttest.utils.response.ReplyMessageSimple;

@RestApi
@RequestMapping(path = STUDENTTEST_PATH + PRUEBA_ESTUDIANTE_PATH)
public class PruebaEstudianteController implements IBaseController {

	@Autowired
	private IBaseService service;

	@Override
	public ResponseEntity<ReplyMessageSimple> create(PruebaEstudianteDTO entityDto) {
		try {
			return answerSimple(service.getCreate(entityDto));
		} catch (DataAccessException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<ReplyMessageList> getAll() {
		try {
			return answerList(service.getFindAll());
		} catch (DataAccessException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<ReplyMessageSimple> getById(Integer id) {
		try {
			return answerSimple(service.getFindById(id));
		} catch (DataAccessException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<ReplyMessageSimple> update(PruebaEstudianteDTO entityDto) {
		try {
			return answerSimple(service.getUpdate(entityDto));
		} catch (DataAccessException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<ReplyMessageSimple> delete(Integer id) {
		try {
			return answerSimple(service.getDelete(id));
		} catch (DataAccessException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}