package com.appsode.api.model;

import com.google.gson.annotations.SerializedName;

public class RegistrationLid {

	@SerializedName("country")
	private String country;

	@SerializedName("firstname")
	private String firstname;

	@SerializedName("sub2")
	private String sub2;

	@SerializedName("city")
	private String city;

	@SerializedName("ip")
	private String ip;

	@SerializedName("sub1")
	private String sub1;

	@SerializedName("pid")
	private String pid;

	@SerializedName("click")
	private String click;

	@SerializedName("lastname")
	private String lastname;

	@SerializedName("pipeline")
	private Integer pipeline;

	@SerializedName("ref")
	private String ref;

	@SerializedName("phone")
	private String phone;

	@SerializedName("email")
	private String email;

	public RegistrationLid setCountry(String country){
		this.country = country;
		return this;
	}

	public String getCountry(){
		return country;
	}

	public RegistrationLid setFirstname(String firstname){
		this.firstname = firstname;
		return this;
	}

	public String getFirstname(){
		return firstname;
	}

	public RegistrationLid setSub2(String sub2){
		this.sub2 = sub2;
		return this;
	}

	public String getSub2(){
		return sub2;
	}

	public RegistrationLid setCity(String city){
		this.city = city;
		return this;
	}

	public String getCity(){
		return city;
	}

	public RegistrationLid setIp(String ip){
		this.ip = ip;
		return this;
	}

	public String getIp(){
		return ip;
	}

	public RegistrationLid setSub1(String sub1){
		this.sub1 = sub1;
		return this;
	}

	public String getSub1(){
		return sub1;
	}

	public RegistrationLid setPid(String pid){
		this.pid = pid;
		return this;
	}

	public String getPid(){
		return pid;
	}

	public RegistrationLid setClick(String click){
		this.click = click;
		return this;
	}

	public String getClick(){
		return click;
	}

	public RegistrationLid setLastname(String lastname){
		this.lastname = lastname;
		return this;
	}

	public String getLastname(){
		return lastname;
	}

	public RegistrationLid setPipeline(Integer pipeline){
		this.pipeline = pipeline;
		return this;
	}

	public Integer getPipeline(){
		return pipeline;
	}

	public RegistrationLid setRef(String ref){
		this.ref = ref;
		return this;
	}

	public String getRef(){
		return ref;
	}

	public RegistrationLid setPhone(String phone){
		this.phone = phone;
		return this;
	}

	public String getPhone(){
		return phone;
	}

	public RegistrationLid setEmail(String email){
		this.email = email;
		return this;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"RegistrationLead{" + 
			"country = '" + country + '\'' + 
			",firstname = '" + firstname + '\'' + 
			",sub2 = '" + sub2 + '\'' + 
			",city = '" + city + '\'' + 
			",ip = '" + ip + '\'' + 
			",sub1 = '" + sub1 + '\'' + 
			",pid = '" + pid + '\'' + 
			",click = '" + click + '\'' + 
			",lastname = '" + lastname + '\'' + 
			",pipeline = '" + pipeline + '\'' + 
			",ref = '" + ref + '\'' + 
			",phone = '" + phone + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}
