package sunwou.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserInfo {
	@Id
	private String us_id;
//	private String us_phone;
	private String nickname;
//	private Integer points;
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
		return "UserInfo [us_id=" + us_id + ", nickname=" + nickname + ", city=" + city + ", icon=" + icon
				+ ", countGroup=" + countGroup + ", countGroupLastWeek=" + countGroupLastWeek + ", countGroupThisWeek="
				+ countGroupThisWeek + ", opendid=" + opendid + ", fk_userid=" + fk_userid + ", appid=" + appid + "]";
	}
	public void setUs_id(String us_id) {
		this.us_id = us_id;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
