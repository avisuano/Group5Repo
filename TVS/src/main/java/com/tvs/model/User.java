package com.tvs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="TVS_USER")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	public int user_id;
	@Column(name="username")
	public String username;
	@Column(name="email")
	public String email;
	@Column(name="firstname")
	public String firstname;
	@Column(name="lastname")
	public String lastname;
	@Column(name="isAdmin")
	public boolean isAdmin;
	@Column(name="isOffensive")
	public int isOffensive;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int user_id, String username, String email, String firstname, String lastname, boolean isAdmin,
			int isOffensive) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.isAdmin = isAdmin;
		this.isOffensive = isOffensive;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getIsOffensive() {
		return isOffensive;
	}

	public void setIsOffensive(int isOffensive) {
		this.isOffensive = isOffensive;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", email=" + email + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", isAdmin=" + isAdmin + ", isOffensive=" + isOffensive + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + isOffensive;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + user_id;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (isAdmin != other.isAdmin)
			return false;
		if (isOffensive != other.isOffensive)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (user_id != other.user_id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
