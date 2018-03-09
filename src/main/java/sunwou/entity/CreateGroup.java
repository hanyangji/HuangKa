package sunwou.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CreateGroup {

	@Id
	private String cg_id;
	private String fk_gr_id;
	private String fk_us_id;
	private Integer enjoy_num;
	private GroupInfo groupInfo;
	private String usericon;//团长头像
	private String usernickname;//团长昵称
	private String preptyid;
	
	
	public String getPreptyid() {
		return preptyid;
	}
	public void setPreptyid(String preptyid) {
		this.preptyid = preptyid;
	}
	public String getUsericon() {
		return usericon;
	}
	public void setUsericon(String usericon) {
		this.usericon = usericon;
	}
	public String getUsernickname() {
		return usernickname;
	}
	public void setUsernickname(String usernickname) {
		this.usernickname = usernickname;
	}
	private String appid;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public GroupInfo getGroupInfo() {
		return groupInfo;
	}
	public void setGroupInfo(GroupInfo groupInfo) {
		this.groupInfo = groupInfo;
	}
	public String getCg_id() {
		return cg_id;
	}
	public void setCg_id(String cg_id) {
		this.cg_id = cg_id;
	}
	@Override
	public String toString() {
		return "CreateGroup [cg_id=" + cg_id + ", fk_gr_id=" + fk_gr_id + ", fk_us_id=" + fk_us_id + ", enjoy_num="
				+ enjoy_num + ", groupInfo=" + groupInfo + "]";
	}
	public String getFk_gr_id() {
		return fk_gr_id;
	}
	public void setFk_gr_id(String fk_gr_id) {
		this.fk_gr_id = fk_gr_id;
	}
	public String getFk_us_id() {
		return fk_us_id;
	}
	public void setFk_us_id(String fk_us_id) {
		this.fk_us_id = fk_us_id;
	}
	public Integer getEnjoy_num() {
		return enjoy_num;
	}
	public void setEnjoy_num(Integer enjoy_num) {
		this.enjoy_num = enjoy_num;
	}

}
