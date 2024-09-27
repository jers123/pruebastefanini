package org.teststefanini.studenttest.utils.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

@Getter
@Setter
public abstract class ReplyMessage {
	private String uri;
	private HttpStatus httpStatus;
	private Boolean error;
	private List<String> message;
	private LocalDateTime date;
}