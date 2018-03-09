package sunwou.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserInfo {
	@Id
	private String us_id;
	private String us_phone;
	private String nickname;
	private Integer points;
	private String city;
	private String icon;
	private String countGroup;
	private String countGroupLastWeek;
	private String countGroupThisWeek;
	private String opendid;
	
	public String getOpendid() {
		return opendid;
	}
	public void setOpendid(String opendid) {
		this.opendid = opendid;
	}
	public String getCountGroup() {
		return countGroup;
	}
	public void setCountGroup(String countGroup) {
		this.countGroup = countGroup;
	}
	public String getCountGroupLastWeek() {
		return countGroupLastWeek;
	}
	public void setCountGroupLastWeek(String countGroupLastWeek) {
		this.countGroupLastWeek = countGroupLastWeek;
	}
	public String getCountGroupThisWeek() {
		return countGroupThisWeek;
	}
	public void setCountGroupThisWeek(String countGroupThisWeek) {
		this.countGroupThisWeek = countGroupThisWeek;
	}
	private String fk_userid;
	
	public String getFk_userid() {
		return fk_userid;
	}
	public void setFk_userid(String fk_userid) {
		this.fk_userid = fk_userid;
	}
	private String appid;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getUs_id() {
		return us_id;
	}
	@Override
	public String toString() {
		return "UserInfo [us_id=" + us_id + ", us_phone=" + us_phone + ", nickname=" + nickname + ", points=" + points
				+ ", city=" + city + ", icon=" + icon + "]";
	}
	public void setUs_id(String us_id) {
		this.us_id = us_id;
	}
	public String getUs_phone() {
		return us_phone;
	}
	public void setUs_phone(String us_phone) {
		this.us_phone = us_phone;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
