package sunwou.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserCoupon {
	@Id
	private String ucpon_id;
	private String shopid;
	private String ucpon_info;
	private String ucpon_starttime;
	private String ucpon_deadline;
	private String fk_us_id;
	private String appid;
	private String isavailable;
	private Date ucpondeadline;
	public Date getUcpondeadline() {
		return ucpondeadline;
	}
	public void setUcpondeadline(Date ucpondeadline) {
		this.ucpondeadline = ucpondeadline;
	}
	public String getIsavailable() {
		return isavailable;
	}
	public void setIsavailable(String isavailable) {
		this.isavailable = isavailable;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getFk_us_id() {
		return fk_us_id;
	}
	public void setFk_us_id(String fk_us_id) {
		this.fk_us_id = fk_us_id;
	}
	public String getUcpon_id() {
		return ucpon_id;
	}
	public void setUcpon_id(String ucpon_id) {
		this.ucpon_id = ucpon_id;
	}
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public String getUcpon_info() {
		return ucpon_info;
	}
	public void setUcpon_info(String ucpon_info) {
		this.ucpon_info = ucpon_info;
	}
	public String getUcpon_starttime() {
		return ucpon_starttime;
	}
	public void setUcpon_starttime(String ucpon_starttime) {
		this.ucpon_starttime = ucpon_starttime;
	}
	public String getUcpon_deadline() {
		return ucpon_deadline;
	}
	public void setUcpon_deadline(String ucpon_deadline) {
		this.ucpon_deadline = ucpon_deadline;
	}
	@Override
	public String toString() {
		return "UserCoupon [ucpon_id=" + ucpon_id + ", shopid=" + shopid + ", ucpon_info="
				+ ucpon_info + ", ucpon_starttime=" + ucpon_starttime + ", ucpon_deadline=" + ucpon_deadline
				+ ", fk_us_id=" + fk_us_id + "]";
	}
	
}
