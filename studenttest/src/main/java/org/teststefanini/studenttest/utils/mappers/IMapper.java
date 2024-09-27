package org.teststefanini.studenttest.utils.mappers;

import java.util.ArrayList;
import java.util.List;

import org.teststefanini.studenttest.model.dto.PruebaEstudianteDTO;
import org.teststefanini.studenttest.model.entity.PruebaEstudiante;

public interface IMapper {
	PruebaEstudiante create(PruebaEstudianteDTO entityDto);
	PruebaEstudianteDTO read(PruebaEstudiante entity);
	default List<PruebaEstudianteDTO> readList(List<PruebaEstudiante> entities) {
		List<PruebaEstudianteDTO> entitiesDto = new ArrayList<>();
		for (PruebaEstudiante entity : entities) {
			entitiesDto.add(read(entity));
		}
		return entitiesDto;
	}
	PruebaEstudiante update(PruebaEstudianteDTO entityDto, PruebaEstudiante entity);
}