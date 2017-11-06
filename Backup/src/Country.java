
public class Country 
{
	private String countryCode;
	private String countryName;
	private String continent;
	private String region;
	private Double surfaceArea;
	private Integer population;
	private String localName;
	private String governmentForm;
	
	public Country() 
	{
		this.countryCode="";
		this.countryName="";
		this.continent="";
		this.surfaceArea=new Double(0.0);
		this.population=new Integer(0);
		this.localName="";
		this.governmentForm="";
	}

	public Country(String countryCode, String countryName, String continent, String region, Double surfaceArea, Integer population,
			String localName, String governmentForm) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.continent = continent;
		this.region = region;
		this.surfaceArea = surfaceArea;
		this.population = population;
		this.localName = localName;
		this.governmentForm = governmentForm;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	@Override
	public String toString() {
		return "Country Code\t=" + countryCode + "\n Country Name\t=" + countryName + "\nCountry Continent\t=" + continent + "\nCountry Region\t="+region
				+ "\n Surface Area\t=" + surfaceArea + "\nCountry Population\t=" + population + "\n Local Name\t=" + localName
				+ "\n Government Form\t=" + governmentForm + "\n";
	}
	
	
	
	
}
