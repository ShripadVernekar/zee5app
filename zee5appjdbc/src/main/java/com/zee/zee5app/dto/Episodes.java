package com.zee.zee5app.dto;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor

public class Episodes {

	@Setter(value = AccessLevel.NONE)
	private String epiId;
	@Setter(value = AccessLevel.NONE)
	private String seriesId;
	private String episodeName;
	private int epiLength;
	private String location;
	private String trailer;

	public void setEpiId(String id) throws InvalidIdLengthException {
		if (id.length() < 6) {
			throw new InvalidIdLengthException("id length is less than or equal to 6");
		}
		this.epiId = id;
	}

	public void setSeriesId(String id) throws InvalidIdLengthException {
		if (id.length() < 6) {
			throw new InvalidIdLengthException("id length is less than or equal to 6");
		}
		this.seriesId = id;
	}
}
