package recensement.entities;

/**
 * Represents a single geographical territory
 * (city, region...) of France.
 * 
 * @author DorianBoel
 */
public abstract class GeographicEntity {
	
	/**
	 * A code representing the geographic
	 * entity's unique standardized alphanumeric designation.
	 */
	protected String code;
	
	/**
	 * Constructor for {@link #GeographicEntity}.
	 * Constructs a new geographic entity with the given
	 * code.
	 * 
	 * @param code The unique alphanumeric code used to
	 * identify the geographic entity.
	 */
	public GeographicEntity(String code) {
		this.code = code;
	}
	
	/**
	 * Getter for {@link #code}.
	 * 
	 * @return This geographic entity's official code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Setter for {@link #code}
	 * 
	 * @param code The new code value to replace
	 * the current one
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets this geographical unit's total 
	 * number of inhabitants.
	 * 
	 * @return The total population in number 
	 * of inhabitants
	 */
	protected abstract int getPopulation();
	
	@Override
	public abstract String toString();
	
}
