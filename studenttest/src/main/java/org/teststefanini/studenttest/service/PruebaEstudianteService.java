package org.teststefanini.studenttest.service;

import static org.teststefanini.studenttest.utils.Constants.EID_EXISTS;
import static org.teststefanini.studenttest.utils.Constants.NO_CONTENT;
import static org.teststefanini.studenttest.utils.Constants.NO_CONTENT_ID;
import static org.teststefanini.studenttest.utils.Constants.SUCCESSFULLY_CREATED_PRUEBA_ESTUDIANTE;
import static org.teststefanini.studenttest.utils.Constants.SUCCESSFULLY_DELETED_PRUEBA_ESTUDIANTE;
import static org.teststefanini.studenttest.utils.Constants.SUCCESSFULLY_UPDATED_PRUEBA_ESTUDIANTE;
import static org.teststefanini.studenttest.utils.Constants.YES_CONTENT;
import static org.teststefanini.studenttest.utils.SystemConstants.CREATE_PATH;
import static org.teststefanini.studenttest.utils.SystemConstants.DELETE_PATH;
import static org.teststefanini.studenttest.utils.SystemConstants.GET_ALL_PATH;
import static org.teststefanini.studenttest.utils.SystemConstants.GET_ID_PATH;
import static org.teststefanini.studenttest.utils.SystemConstants.PRUEBA_ESTUDIANTE_PATH;
import static org.teststefanini.studenttest.utils.SystemConstants.STUDENTTEST_PATH;
import static org.teststefanini.studenttest.utils.SystemConstants.UPDATE_PATH;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.teststefanini.studenttest.model.dto.PruebaEstudianteDTO;
import org.teststefanini.studenttest.model.entity.PruebaEstudiante;
import org.teststefanini.studenttest.model.repository.IPruebaEstudianteRepository;
import org.teststefanini.studenttest.utils.mappers.IMapper;
import org.teststefanini.studenttest.utils.response.ReplyMessageList;
import org.teststefanini.studenttest.utils.response.ReplyMessageSimple;

@Service
@Validated
public class PruebaEstudianteService implements IBaseService {

	@Autowired
	private IPruebaEstudianteRepository repository;

	@Autowired
	private ReplyMessageSimple replyMessageSimple;

	@Autowired
	private ReplyMessageList replyMessageList;

	@Autowired
	private IMapper mapper;

	@Override
	public ReplyMessageSimple getCreate(PruebaEstudianteDTO entityDto) {
		replyMessageSimple.setUri(getUri(CREATE_PATH));
		replyMessageSimple.setError(true);
		replyMessageSimple.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			PruebaEstudiante entity = repository.findById(entityDto.getEid()).orElse(null);
			if (entity == null) {
				entity = mapper.create(entityDto);
				PruebaEstudianteDTO entityOutput = mapper.read(repository.save(entity));
				replyMessageSimple.setHttpStatus(HttpStatus.CREATED);
				replyMessageSimple.setError(false);
				messages.add(SUCCESSFULLY_CREATED_PRUEBA_ESTUDIANTE);
				replyMessageSimple.setResponse(entityOutput);
			} else {
				replyMessageSimple.setHttpStatus(HttpStatus.CONFLICT);
				messages.add(EID_EXISTS);
			}
		} catch (Exception e) {
			replyMessageSimple.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			messages.add(e.getMessage());
		}
		replyMessageSimple.setMessage(messages);
		replyMessageSimple.setDate(LocalDateTime.now());
		return replyMessageSimple;
	}

	@Override
	public ReplyMessageList getFindAll() {
		replyMessageList.setUri(getUri(GET_ALL_PATH));
		replyMessageList.setError(true);
		replyMessageList.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			List<PruebaEstudiante> entities = repository.searchAll();
			if (!entities.isEmpty()) {
				List<PruebaEstudianteDTO> entitiesDto = mapper.readList(entities);
				messages.add(YES_CONTENT);
				replyMessageList.setResponse(entitiesDto);
			} else {
				messages.add(NO_CONTENT);
			}
			replyMessageList.setHttpStatus(HttpStatus.OK);
			replyMessageList.setError(false);
		} catch (Exception e) {
			replyMessageList.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			messages.add(e.getMessage());
		}
		replyMessageList.setMessage(messages);
		replyMessageList.setDate(LocalDateTime.now());
		return replyMessageList;
	}

	@Override
	public ReplyMessageSimple getFindById(Integer id) {
		replyMessageSimple.setUri(getUri(GET_ID_PATH, id));
		replyMessageSimple.setError(true);
		replyMessageSimple.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			PruebaEstudiante entity = repository.findById(id).orElse(null);
			if (entity != null) {
				PruebaEstudianteDTO entityDto = mapper.read(entity);
				replyMessageSimple.setHttpStatus(HttpStatus.OK);
				replyMessageSimple.setError(false);
				messages.add(YES_CONTENT);
				replyMessageSimple.setResponse(entityDto);
			} else {
				replyMessageSimple.setHttpStatus(HttpStatus.NOT_FOUND);
				messages.add(NO_CONTENT_ID + id);
			}
		} catch (Exception e) {
			replyMessageSimple.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			messages.add(e.getMessage());
		}
		replyMessageSimple.setMessage(messages);
		replyMessageSimple.setDate(LocalDateTime.now());
		return replyMessageSimple;
	}

	@Override
	public ReplyMessageSimple getUpdate(PruebaEstudianteDTO entityDto) {
		replyMessageSimple.setUri(getUri(UPDATE_PATH));
		replyMessageSimple.setError(true);
		replyMessageSimple.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			PruebaEstudiante entity = repository.findById(entityDto.getEid()).orElse(null);
			if (entity != null) {
				entity = mapper.update(entityDto, entity);
				PruebaEstudianteDTO entityOutput = mapper.read(repository.save(entity));
				replyMessageSimple.setHttpStatus(HttpStatus.OK);
				replyMessageSimple.setError(false);
				messages.add(SUCCESSFULLY_UPDATED_PRUEBA_ESTUDIANTE);
				replyMessageSimple.setResponse(entityOutput);
			} else {
				replyMessageSimple.setHttpStatus(HttpStatus.NOT_FOUND);
				messages.add(NO_CONTENT_ID + entityDto.getEid());
			}
		} catch (Exception e) {
			replyMessageSimple.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			messages.add(e.getMessage());
		}
		replyMessageSimple.setMessage(messages);
		replyMessageSimple.setDate(LocalDateTime.now());
		return replyMessageSimple;
	}

	@Override
	public ReplyMessageSimple getDelete(Integer id) {
		replyMessageSimple.setUri(getUri(DELETE_PATH, id));
		replyMessageSimple.setError(true);
		replyMessageSimple.setResponse(null);
		List<String> messages = new ArrayList<>();
		try {
			PruebaEstudiante entity = repository.findById(id).orElse(null);
			if (entity != null) {
				repository.delete(entity);
				replyMessageSimple.setHttpStatus(HttpStatus.OK);
				replyMessageSimple.setError(false);
				messages.add(SUCCESSFULLY_DELETED_PRUEBA_ESTUDIANTE);
			} else {
				replyMessageSimple.setHttpStatus(HttpStatus.NOT_FOUND);
				messages.add(NO_CONTENT_ID + id);
			}
		} catch (Exception e) {
			replyMessageSimple.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			messages.add(e.getMessage());
		}
		replyMessageSimple.setMessage(messages);
		replyMessageSimple.setDate(LocalDateTime.now());
		return replyMessageSimple;
	}

	@Override
	public String getUri(String method) {
		return STUDENTTEST_PATH + PRUEBA_ESTUDIANTE_PATH + method;
	}

	@Override
	public String getUri(String method, Integer id) {
		return STUDENTTEST_PATH + PRUEBA_ESTUDIANTE_PATH + method + id;
	}
}