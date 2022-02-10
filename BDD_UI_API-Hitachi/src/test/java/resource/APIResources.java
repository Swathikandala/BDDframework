package resource;

public enum APIResources {
	
	CreateAPI("/api/v2/tag/"),
	getAPI("/api/v2/tag/byname?tagname=\"\"");
	
	
	private String resource;

	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
