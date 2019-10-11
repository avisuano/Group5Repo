package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="FORUM")
public class Forum {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="forum_id")
	private int forum_id;
	@Column(name="title")
	private String title;
	@Column(name="body")
	private String body;
	@Column(name="isOffensive")
	private boolean isOffensive;
	@Column(name="replies")
	private int replies;
	@Column(name="user_id")
	private int user_id;
	
	public Forum() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Forum(int forum_id, String title, String body, boolean isOffensive, int replies, int user_id) {
		super();
		this.forum_id = forum_id;
		this.title = title;
		this.body = body;
		this.isOffensive = isOffensive;
		this.replies = replies;
		this.user_id = user_id;
	}

	public int getForum_id() {
		return forum_id;
	}

	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public boolean isOffensive() {
		return isOffensive;
	}

	public void setOffensive(boolean isOffensive) {
		this.isOffensive = isOffensive;
	}

	public int getReplies() {
		return replies;
	}

	public void setReplies(int replies) {
		this.replies = replies;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Forum [forum_id=" + forum_id + ", title=" + title + ", body=" + body + ", isOffensive=" + isOffensive
				+ ", replies=" + replies + ", user_id=" + user_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + forum_id;
		result = prime * result + (isOffensive ? 1231 : 1237);
		result = prime * result + replies;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + user_id;
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
		Forum other = (Forum) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (forum_id != other.forum_id)
			return false;
		if (isOffensive != other.isOffensive)
			return false;
		if (replies != other.replies)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	
}
