package codenest.hibernatets4.model;
// Generated 2019-1-28 10:59:08 by Hibernate Tools 5.3.0.Beta2

/**
 * BoUniconfigKeywordEnum generated by hbm2java
 */
public class BoUniconfigKeywordEnum implements java.io.Serializable {

	private BoUniconfigKeywordEnumId id;
	private BoUniconfigKeywordInfo boUniconfigKeywordInfo;

	public BoUniconfigKeywordEnum() {
	}

	public BoUniconfigKeywordEnum(BoUniconfigKeywordEnumId id, BoUniconfigKeywordInfo boUniconfigKeywordInfo) {
		this.id = id;
		this.boUniconfigKeywordInfo = boUniconfigKeywordInfo;
	}

	public BoUniconfigKeywordEnumId getId() {
		return this.id;
	}

	public void setId(BoUniconfigKeywordEnumId id) {
		this.id = id;
	}

	public BoUniconfigKeywordInfo getBoUniconfigKeywordInfo() {
		return this.boUniconfigKeywordInfo;
	}

	public void setBoUniconfigKeywordInfo(BoUniconfigKeywordInfo boUniconfigKeywordInfo) {
		this.boUniconfigKeywordInfo = boUniconfigKeywordInfo;
	}

}
