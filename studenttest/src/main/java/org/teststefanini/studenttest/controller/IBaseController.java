package org.teststefanini.studenttest.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.teststefanini.studenttest.utils.Constants.ID_VALUE_MINIMUM;
import static org.teststefanini.studenttest.utils.SystemConstants.CREATE_PATH;
import static org.teststefanini.studenttest.utils.SystemConstants.DELETE_PATH;
import static org.teststefanini.studenttest.utils.SystemConstants.EID;
import static org.teststefanini.studenttest.utils.SystemConstants.GET_ALL_PATH;
import static org.teststefanini.studenttest.utils.SystemConstants.GET_ID_PATH;
import static org.teststefanini.studenttest.utils.SystemConstants.UPDATE_PATH;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.teststefanini.studenttest.model.dto.PruebaEstudianteDTO;
import org.teststefanini.studenttest.utils.response.ReplyMessageList;
import org.teststefanini.studenttest.utils.response.ReplyMessageSimple;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

public interface IBaseController {
    @PostMapping(value = CREATE_PATH, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ReplyMessageSimple> create(@Valid @RequestBody PruebaEstudianteDTO entityDto);

    @GetMapping(GET_ALL_PATH)
    ResponseEntity<ReplyMessageList> getAll();

    @GetMapping(value = GET_ID_PATH + "{" + EID + "}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ReplyMessageSimple> getById(@PathVariable(EID) @Min(value = 1, message = ID_VALUE_MINIMUM) Integer id);

    @PutMapping(value = UPDATE_PATH, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ReplyMessageSimple> update(@Valid @RequestBody PruebaEstudianteDTO entityDto);

    @DeleteMapping(value = DELETE_PATH + "{" + EID + "}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<ReplyMessageSimple> delete(@PathVariable(EID) @Min(value = 1, message = ID_VALUE_MINIMUM) Integer id);
}