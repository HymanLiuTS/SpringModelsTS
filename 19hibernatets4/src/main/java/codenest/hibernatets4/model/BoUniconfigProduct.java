package codenest.hibernatets4.model;
// Generated 2019-1-28 10:59:08 by Hibernate Tools 5.3.0.Beta2

/**
 * BoUniconfigProduct generated by hbm2java
 */
public class BoUniconfigProduct implements java.io.Serializable {

	private int productid;
	private String productname;

	public BoUniconfigProduct() {
	}

	public BoUniconfigProduct(int productid) {
		this.productid = productid;
	}

	public BoUniconfigProduct(int productid, String productname) {
		this.productid = productid;
		this.productname = productname;
	}

	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

}
