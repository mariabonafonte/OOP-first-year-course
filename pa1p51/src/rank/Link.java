package rank;

import java.util.Objects;

public class Link {
	private String origin;
	private String linked;

	public Link(String origin, String linked) {
		super();
		this.origin = origin;
		this.linked = linked;
	}

	public String getOrigin() {
		return origin;
	}

	public String getLinked() {
		return linked;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(origin.toLowerCase(), linked.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		if(obj instanceof Link) {
			Link other = (Link) obj;
			ok = this.origin.equalsIgnoreCase(other.origin)
					&&this.linked.equalsIgnoreCase(other.linked);
			
		}
		return ok;
	}

	@Override
	public String toString() {
		return origin + "->" + linked;
	}
	
	
	
	
	

}
