package Test7;

public class Member {
	private String name;
	private String id;
	private String hobby;
	private int age;

	@Override
	public String toString() {
		return "Member [ID:" + id + ", Name:" + name + ", Hobby:" + hobby + ", Age:" + age + "]";
	}

	public Member() {
		super();
	}

	public Member(String name, String id, String hobby, int age) {
		super();
		this.name = name;
		this.id = id;
		this.hobby = hobby;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
