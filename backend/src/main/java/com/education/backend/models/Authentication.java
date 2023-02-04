package com.education.backend.models;

public class Authentication {

	private String userid;
	private String username;
	private String sessionid;
	private String accessLevel;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public Authentication() {
		
	}

	public Authentication(String username, String sessionid, String accessLevel, String userid) {
		super();
		this.username = username;
		this.sessionid = sessionid;
		this.accessLevel = accessLevel;
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Authentication [username=" + username + ", sessionid=" + sessionid + ", accessLevel=" + accessLevel
				+ ", userid=" + userid + "]";
	}

}
