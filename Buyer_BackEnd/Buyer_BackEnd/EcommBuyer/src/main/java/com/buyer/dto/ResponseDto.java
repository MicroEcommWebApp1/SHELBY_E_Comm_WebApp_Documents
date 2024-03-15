package com.buyer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ResponseDto {
private String statusCode;
private String statusMsg;
public ResponseDto() {
	super();
	// TODO Auto-generated constructor stub
}
public ResponseDto(String statusCode, String statusMsg) {
	super();
	this.statusCode = statusCode;
	this.statusMsg = statusMsg;
}
public String getStatusCode() {
	return statusCode;
}
public void setStatusCode(String statusCode) {
	this.statusCode = statusCode;
}
public String getStatusMsg() {
	return statusMsg;
}
public void setStatusMsg(String statusMsg) {
	this.statusMsg = statusMsg;
}


}