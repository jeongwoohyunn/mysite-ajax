package com.douzone.mysite.vo;

public class BoardVo {
	private Long no;
	private String name;
	private String title;
	private String contents;
	private String write_date;
	private Long hit;
	private Long group_no;
	private Long order_no;
	private Long depth;
	private Long user_no;
	private Long uno;
	public Long getUno() {
		return uno;
	}
	public void setUno(Long uno) {
		this.uno = uno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	public Long getGroup_no() {
		return group_no;
	}
	public void setGroup_no(Long group_no) {
		this.group_no = group_no;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
	public Long getUser_no() {
		return user_no;
	}
	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", name=" + name + ", title=" + title + ", contents=" + contents + ", write_date="
				+ write_date + ", hit=" + hit + ", group_no=" + group_no + ", order_no=" + order_no + ", depth=" + depth
				+ ", user_no=" + user_no + ", uno=" + uno + "]";
	}
	
	
}