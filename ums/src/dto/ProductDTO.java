package dto;

public class ProductDTO {
	private int prodnum;
	private String prodname;
	private int prodprice;
	private int prodamount;
	private String prodinfo;
	private int likecnt;
	
	private String userid;

	public ProductDTO(int prodnum, String prodname, int prodprice, int prodamount, String prodinfo, String userid) {
		this.prodnum = prodnum;
		this.prodname = prodname;
		this.prodprice = prodprice;
		this.prodamount = prodamount;
		this.prodinfo = prodinfo;
		this.likecnt = 0;
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return prodnum + "\t" + prodname + "\t" + prodprice + "\t" + prodamount + "\t" + prodinfo + "\t" + likecnt + "\t" + userid;
	}

	public int getProdnum() {
		return prodnum;
	}

	public void setProdnum(int prodnum) {
		this.prodnum = prodnum;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public int getProdprice() {
		return prodprice;
	}

	public void setProdprice(int prodprice) {
		this.prodprice = prodprice;
	}

	public int getProdamount() {
		return prodamount;
	}

	public void setProdamount(int prodamount) {
		this.prodamount = prodamount;
	}

	public String getProdinfo() {
		return prodinfo;
	}

	public void setProdinfo(String prodinfo) {
		this.prodinfo = prodinfo;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
