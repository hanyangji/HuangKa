package sunwou.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GroupUser {
	@Id
	private String gu_id;
	private String fk_cg_id;
	private String fk_gr_id;
	private String fk_us_id;//用户信息表id 
	
	private String groupName;
	private String successNum;
	private String groupimg;
	private String groupdeadline;
	private String couponinfo;
	private String usericon;
	private String usernickname;
	
	private String tuanzhuang_propertyid;
	private String enjoy_from_id;
	
	public String getTuanzhuang_propertyid() {
		return tuanzhuang_propertyid;
	}
	public void setTuanzhuang_propertyid(String tuanzhuang_propertyid) {
		this.tuanzhuang_propertyid = tuanzhuang_propertyid;
	}
	public String getEnjoy_from_id() {
		return enjoy_from_id;
	}
	public void setEnjoy_from_id(String enjoy_from_id) {
		this.enjoy_from_id = enjoy_from_id;
	}
	public String getGroupimg() {
		return groupimg;
	}
	public void setGroupimg(String groupimg) {
		this.groupimg = groupimg;
	}
	public String getGroupdeadline() {
		return groupdeadline;
	}
	public void setGroupdeadline(String groupdeadline) {
		this.groupdeadline = groupdeadline;
	}
	public String getCouponinfo() {
		return couponinfo;
	}
	public void setCouponinfo(String couponinfo) {
		this.couponinfo = couponinfo;
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
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getSuccessNum() {
		return successNum;
	}
	public void setSuccessNum(String successNum) {
		this.successNum = successNum;
	}
	private String appid;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getGu_id() {
		return gu_id;
	}
	public void setGu_id(String gu_id) {
		this.gu_id = gu_id;
	}
	public String getFk_cg_id() {
		return fk_cg_id;
	}
	public void setFk_cg_id(String fk_cg_id) {
		this.fk_cg_id = fk_cg_id;
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
	@Override
	public String toString() {
		return "GroupUser [gu_id=" + gu_id + ", fk_cg_id=" + fk_cg_id + ", fk_gr_id=" + fk_gr_id + ", fk_us_id="
				+ fk_us_id + "]";
	}
	
}
