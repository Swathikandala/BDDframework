package resource;

import payloads.Payload;

public class ConstructPayload {
	
	public static Payload addPayLoad(String name, String description, String domainKey)
	{
		Payload p =new Payload();
		p.setName(name);
		p.setDescription(description);
		p.setDomainKey(domainKey);
		return p;
				
	}

}
