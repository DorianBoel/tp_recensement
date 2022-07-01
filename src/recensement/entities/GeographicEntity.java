package recensement.entities;

public abstract class GeographicEntity {
	
	protected String code;
	
	public GeographicEntity(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	protected abstract int getPopulation();
	
	@Override
	public abstract String toString();
	
}
