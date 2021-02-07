package com.appsode.api.resopnses;

import java.util.List;
import java.util.stream.Stream;

import com.google.gson.annotations.SerializedName;

public class RegistrationResponse {

	@SerializedName("id")
	private String id;

	@SerializedName("result")
	private String result;

	@SerializedName("lidId")
	private Integer lidId;

	@SerializedName("message")
	private List<String> message;

	@SerializedName("error")
	private String error;

	@SerializedName("statusCode")
	private Integer statusCode;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setMessage(List<String> message){
		this.message = message;
	}

	public List<String> getMessage(){
		return message;
	}

	public void setError(String error){
		this.error = error;
	}

	public String getError(){
		return error;
	}

	public void setStatusCode(Integer statusCode){
		this.statusCode = statusCode;
	}

	public Integer getStatusCode(){
		return statusCode;
	}


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getLidId() {
		return lidId;
	}

	public void setLidId(Integer lidId) {
		this.lidId = lidId;
	}

	@Override
	public String toString() {
		return "RegistrationResponse{" +
				"id='" + id + '\'' +
				", result='" + result + '\'' +
				", lidId=" + lidId +
				", message=" + message +
				", error='" + error + '\'' +
				", statusCode=" + statusCode +
				'}';
	}
}
