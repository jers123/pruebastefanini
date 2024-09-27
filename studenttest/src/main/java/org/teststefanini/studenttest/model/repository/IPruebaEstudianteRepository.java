package org.teststefanini.studenttest.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.teststefanini.studenttest.model.entity.PruebaEstudiante;

import static org.teststefanini.studenttest.utils.SystemConstants.PRUEBA_ESTUDIANTE_ALL_QUERY;

@Repository
public interface IPruebaEstudianteRepository extends JpaRepository<PruebaEstudiante, Integer> {
	@Query(value = PRUEBA_ESTUDIANTE_ALL_QUERY)
	List<PruebaEstudiante> searchAll();
}