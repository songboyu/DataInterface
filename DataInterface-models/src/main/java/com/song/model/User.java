package com.song.model;

import javax.persistence.*;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
@Table(name="Users")
public class User implements Serializable {
	

	private static final long serialVersionUID = -1407080488704232549L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false,unique=true)
	private String email;
	@Column(nullable=false)
	private String password;

	public User() {
		
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = encrypt(password);

	}

	private String encrypt(String passwordToEncrypt) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(passwordToEncrypt.getBytes());
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			return "";
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = encrypt(password);
	}

	public String getPassword() {
		return password;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
