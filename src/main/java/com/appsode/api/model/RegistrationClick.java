package com.appsode.api.model;

import com.google.gson.annotations.SerializedName;

public class RegistrationClick {

	@SerializedName("pipeline")
	private Integer pipeline;

	@SerializedName("country")
	private String country;

	@SerializedName("ref")
	private String ref;

	@SerializedName("city")
	private String city;

	@SerializedName("ip")
	private String ip;

	@SerializedName("pid")
	private String pid;

	public RegistrationClick setPipeline(Integer pipeline){
		this.pipeline = pipeline;
		return this;
	}

	public Integer getPipeline(){
		return pipeline;
	}

	public RegistrationClick setCountry(String country){
		this.country = country;
		return this;
	}

	public String getCountry(){
		return country;
	}

	public RegistrationClick setRef(String ref){
		this.ref = ref;
		return this;
	}

	public String getRef(){
		return ref;
	}

	public RegistrationClick setCity(String city){
		this.city = city;
		return this;
	}

	public String getCity(){
		return city;
	}

	public RegistrationClick setIp(String ip){
		this.ip = ip;
		return this;
	}

	public String getIp(){
		return ip;
	}

	public RegistrationClick setPid(String pid){
		this.pid = pid;
		return this;
	}

	public String getPid(){
		return pid;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"pipeline = '" + pipeline + '\'' + 
			",country = '" + country + '\'' + 
			",ref = '" + ref + '\'' + 
			",city = '" + city + '\'' + 
			",ip = '" + ip + '\'' + 
			",pid = '" + pid + '\'' + 
			"}";
		}
}
