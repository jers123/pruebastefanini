package org.teststefanini.studenttest.utils.mappers;

import org.springframework.stereotype.Component;
import org.teststefanini.studenttest.model.dto.PruebaEstudianteDTO;
import org.teststefanini.studenttest.model.entity.PruebaEstudiante;

@Component
public class PruebaEstudianteMapper implements IMapper {

	@Override
	public PruebaEstudiante create(PruebaEstudianteDTO entityDto) {
		PruebaEstudiante entity = new PruebaEstudiante();
		entity.setEid(entityDto.getEid());
		entity.setNombre(entityDto.getNombre().toUpperCase());
		entity.setEspecialidad(entityDto.getEspecialidad().toUpperCase());
		entity.setGrado(entityDto.getGrado().toUpperCase());
		return entity;
	}

	@Override
	public PruebaEstudianteDTO read(PruebaEstudiante entity) {
		PruebaEstudianteDTO entityDto = new PruebaEstudianteDTO();
		entityDto.setEid(entity.getEid());
		entityDto.setNombre(entity.getNombre());
		entityDto.setEspecialidad(entity.getEspecialidad());
		entityDto.setGrado(entity.getGrado());
		return entityDto;
	}

	@Override
	public PruebaEstudiante update(PruebaEstudianteDTO entityDto, PruebaEstudiante entity) {
		entity.setNombre(entityDto.getNombre().toUpperCase());
		entity.setEspecialidad(entityDto.getEspecialidad().toUpperCase());
		entity.setGrado(entityDto.getGrado().toUpperCase());
		return entity;
	}

}