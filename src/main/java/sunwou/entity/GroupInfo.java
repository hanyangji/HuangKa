package sunwou.entity;


import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GroupInfo {
	@Id
	private String gr_id;
	private String shopId;
	private String gr_name;
	private List<String> gr_imglist;
	private String gr_rule;
	private String gr_cost;
	private String gr_deadline;
	private Boolean gr_online;
	private String cpon_info;
	private String cpon_head_info;
	public String getCpon_head_info() {
		return cpon_head_info;
	}
	public void setCpon_head_info(String cpon_head_info) {
		this.cpon_head_info = cpon_head_info;
	}
	private String cpon_start_time;
	private String cpon_deadline;
	private Integer gr_limitnum;
	private Integer gr_exits;
	private Integer gr_success;
	private Integer gr_num;
	private Integer gr_point;
	
	public Integer getGr_point() {
		return gr_point;
	}
	public void setGr_point(Integer gr_point) {
		this.gr_point = gr_point;
	}
	private Date grdeadline;
	
	public String getGr_deadline() {
		return gr_deadline;
	}
	public void setGr_deadline(String gr_deadline) {
		this.gr_deadline = gr_deadline;
	}
	public Date getGrdeadline() {
		return grdeadline;
	}
	public void setGrdeadline(Date grdeadline) {
		this.grdeadline = grdeadline;
	}
	private String appid;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getGr_id() {
		return gr_id;
	}
	@Override
	public String toString() {
		return "GroupInfo [gr_id=" + gr_id + ", shopId=" + shopId + ", gr_name=" + gr_name
				+ ", gr_imglist=" + gr_imglist + ", gr_rule=" + gr_rule + ", gr_cost=" + gr_cost + ", gr_deadline="
				+ gr_deadline + ", gr_online=" + gr_online + ", cpon_info=" + cpon_info + ", cpon_start_time="
				+ cpon_start_time + ", cpon_deadline=" + cpon_deadline + ", gr_limitnum=" + gr_limitnum + ", gr_exits="
				+ gr_exits + ", gr_success=" + gr_success + ", gr_num=" + gr_num + "]";
	}
	public void setGr_id(String gr_id) {
		this.gr_id = gr_id;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	
	public String getGr_name() {
		return gr_name;
	}
	public void setGr_name(String gr_name) {
		this.gr_name = gr_name;
	}
	
	public List<String> getGr_imglist() {
		return gr_imglist;
	}
	public void setGr_imglist(List<String> gr_imglist) {
		this.gr_imglist = gr_imglist;
	}
	public String getGr_rule() {
		return gr_rule;
	}
	public void setGr_rule(String gr_rule) {
		this.gr_rule = gr_rule;
	}
	public String getGr_cost() {
		return gr_cost;
	}
	public void setGr_cost(String gr_cost) {
		this.gr_cost = gr_cost;
	}

	

	public Boolean getGr_online() {
		return gr_online;
	}
	public void setGr_online(Boolean gr_online) {
		this.gr_online = gr_online;
	}
	public String getCpon_info() {
		return cpon_info;
	}
	public void setCpon_info(String cpon_info) {
		this.cpon_info = cpon_info;
	}
	public String getCpon_start_time() {
		return cpon_start_time;
	}
	public void setCpon_start_time(String cpon_start_time) {
		this.cpon_start_time = cpon_start_time;
	}
	public String getCpon_deadline() {
		return cpon_deadline;
	}
	public void setCpon_deadline(String cpon_deadline) {
		this.cpon_deadline = cpon_deadline;
	}
	public Integer getGr_limitnum() {
		return gr_limitnum;
	}
	public void setGr_limitnum(Integer gr_limitnum) {
		this.gr_limitnum = gr_limitnum;
	}
	public Integer getGr_exits() {
		return gr_exits;
	}
	public void setGr_exits(Integer gr_exits) {
		this.gr_exits = gr_exits;
	}
	public Integer getGr_success() {
		return gr_success;
	}
	public void setGr_success(Integer gr_success) {
		this.gr_success = gr_success;
	}
	public Integer getGr_num() {
		return gr_num;
	}
	public void setGr_num(Integer gr_num) {
		this.gr_num = gr_num;
	}
}

