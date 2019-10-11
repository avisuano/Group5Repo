package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="FORUMPOST")
public class ForumPost {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="forumPost_id")
	private int forumPost_id;
	@Column(name="forum_id")
	private int forum_id;
	@Column(name="msg")
	private String msg;
	@Column(name="user_id")
	private int user_id;
	@Column(name="isOffensive")
	private boolean isOffensive;
	
	public ForumPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ForumPost(int forumPost_id, int forum_id, String msg, int user_id, boolean isOffensive) {
		super();
		this.forumPost_id = forumPost_id;
		this.forum_id = forum_id;
		this.msg = msg;
		this.user_id = user_id;
		this.isOffensive = isOffensive;
	}

	public int getForumPost_id() {
		return forumPost_id;
	}

	public void setForumPost_id(int forumPost_id) {
		this.forumPost_id = forumPost_id;
	}

	public int getForum_id() {
		return forum_id;
	}

	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public boolean isOffensive() {
		return isOffensive;
	}

	public void setOffensive(boolean isOffensive) {
		this.isOffensive = isOffensive;
	}

	@Override
	public String toString() {
		return "ForumPost [forumPost_id=" + forumPost_id + ", forum_id=" + forum_id + ", msg=" + msg + ", user_id="
				+ user_id + ", isOffensive=" + isOffensive + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + forumPost_id;
		result = prime * result + forum_id;
		result = prime * result + (isOffensive ? 1231 : 1237);
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
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
		ForumPost other = (ForumPost) obj;
		if (forumPost_id != other.forumPost_id)
			return false;
		if (forum_id != other.forum_id)
			return false;
		if (isOffensive != other.isOffensive)
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	
}
