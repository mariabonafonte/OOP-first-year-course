package rank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

public class Web {
	private Set<Link> links;
	protected Set<Site> sites;
	private static final double THRESHOLD = 1E-5;
	private static Random alea = new Random(1);
	
	public Web() {
		super();
		links = new HashSet<>();
		sites = new HashSet<>();
	}
	
	protected void addSite(Site site) {
		sites.add(site);
	}
	
	protected void addSiteWithName (String name) {
		sites.add(new Site(name));
	}
	
	public void addLink (String dataLink) {
		try {
			String[] data = dataLink.split("->");
			addSiteWithName(data[1]);
			addSiteWithName(data[2]);
			Link l = new Link(data[1], data[2]);
			links.add(l);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.println("Problema en el dataLink");
		}
		
	}
	
	public Site getSite (String name) {
		/*Site sName = null;
		for(Site s: sites) {
			if(s.getName().equals(name)) {
				sName = s;
			} else throw new NoSuchElementException("Nombre no encontrado");
		}
		return sName;*/
		Site res = null;
		boolean encontrado = false;
		Iterator<Site> it = sites.iterator();
		while(!encontrado && it.hasNext()) {
			Site s = it.next();
			if(s.getName().equalsIgnoreCase(name)){
				encontrado = true;
				res = s;
			}
		}
		if(res == null) {
			throw new NoSuchElementException("Nombre no encontrado");
		}
		
		return res;
	}
	
	
	public Set<String> getNames(){
		Set<String> Listado = new HashSet<>();
		for(Site s: sites) {
			Listado.add(s.getName());
		}
		return Listado;
	}
	
	 private Set<Site> getSitesLinkedFrom(Site pagina){
		 Set<Site> Listado = new HashSet<>();
		 for(Link l: links) {
			 if(l.getOrigin().equalsIgnoreCase(pagina.getName())) {
				 Listado.add(getSite(l.getLinked()));
				 
			 }
		 }
		return Listado;
	 }
	 
	 protected void distribute(Site site, double prize) {
		 if(prize>THRESHOLD) {
			 site.addRank(prize/2);
			 Set<Site> Listado = getSitesLinkedFrom(site);
			 if(Listado.size()>0) {
				 int n = Listado.size();
				 for(Site s: Listado) {
					 s.addRank(prize/n);
				 }
			 }
		 }
	 }
	 
	 public void click(String name) {
		 Site s = getSite(name);
		 if(s!=null) {
			 distribute(s, 1);
		 }
	 }
	 
	public void simulateClick(int numClick) {
		List<String> names = new ArrayList<>(this.getNames());
		int size = names.size();
		if(size >0) {
			for(int i=0; i < numClick; ++i) {
				int pos = alea.nextInt(size);
				this.click(names.get(pos));
			}
		}		
	} 
}
