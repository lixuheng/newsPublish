package online.wozn.domain;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	private String serial_id;//编号
	@Column(name = "uname", nullable = false, unique = true, length = 40)
	private String uname;
	@Column(length = 32)
	private String pwd;
	@Column(length = 40)
	private String rname;
	@Column(length = 13, unique = true)
	private String phone;
	@Temporal(value = TemporalType.DATE)
	private Date birth;
	private String email;
	private String hometown;
	private Integer salary;
	private Integer bonus;
	private String department;
	@Temporal(value = TemporalType.DATE)
	private Date join_date;
	@Column(length=1)
	private Integer level;//1-5级表示普通用户 （6-9级表示小编）
	@Lob @Basic(fetch=FetchType.LAZY)
	private Byte[]  headImage;

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean b = false;
		if (obj == null)
			return b;
		if (obj instanceof User == false)
			return b;
		if (((User) obj).toString().equals(this.toString())) {
			b = true;
		}
		return b;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return user_id + super.hashCode();
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", serial_id=" + serial_id + ", uname=" + uname + ", pwd=" + pwd
				+ ", rname=" + rname + ", phone=" + phone + ", birth=" + birth + ", email=" + email + ", hometown="
				+ hometown + ", salary=" + salary + ", bonus=" + bonus + ", department=" + department + ", join_date="
				+ join_date + ", level=" + level + ", headImage=" + Arrays.toString(headImage) + "]";
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getSerial_id() {
		return serial_id;
	}

	public void setSerial_id(String serial_id) {
		this.serial_id = serial_id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Byte[] getHeadImage() {
		return headImage;
	}

	public void setHeadImage(Byte[] headImage) {
		this.headImage = headImage;
	}

	
	
	

}
