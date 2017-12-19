package com.ss.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String roleName;

	//bi-directional many-to-many association to User
	/*@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="user_role_mapping", joinColumns={@JoinColumn(name="role_id")}, inverseJoinColumns={@JoinColumn(name="user_id")})
	private List<User> users;*/

	@ManyToMany(mappedBy="roles", fetch=FetchType.LAZY)
	private List<User> users;
	
	public Role() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}