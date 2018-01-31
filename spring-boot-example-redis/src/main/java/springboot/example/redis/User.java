package springboot.example.redis;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 此处必须要加，否则在反序列化时会出错。
	 * 因为序列号和反序列化时的serialVersionUID都是系统自动生成的，可能不一致
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private Integer age;
	
	public User(Long id, String username, Integer age) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", age=" + age + "]";
	}
}
