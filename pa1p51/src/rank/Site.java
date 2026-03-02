package rank;

import java.util.Objects;

public class Site {
	private String name;
	private double rank;
	
	public Site(String name) {
		super();
		this.name = name;
		rank = 0;
	}

	public String getName() {
		return name;
	}

	public double getRank() {
		return rank;
	}

	public void addRank(double r) {
		rank += r;
	}
	
	public int compareTo (Site o) {
		return name.compareToIgnoreCase(o.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Site s)
				&& s.name.equalsIgnoreCase(name);
	}
	
	@Override
	public String toString() {
		return  name + "(" + rank + ")";
	}
	
	
	

	
	
	
	
	

}
