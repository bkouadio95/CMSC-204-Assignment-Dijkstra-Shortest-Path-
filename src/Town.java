import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @author Betty Kouadio
 *
 */

public class Town implements Comparable<Town> {
	private String Name;
	private Set<Town> AdjTowns;
	private int Weight;
	private Town Backpath;
	/**
	 * Town constructor
	 * @param name
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Town(String name) {
		this.Name = name;
		AdjTowns = new HashSet();
		Weight = Integer.MAX_VALUE;
		Backpath = null;
	}
/**
 * Getter and setter for name
 * @return Name
 */
	public String getName() {
		return Name;
	}
/**
 * Getter and setter for weight
 * @return Weight
 */
	public int getWeight() {
		return Weight;
	}
/**
 * Getter and setter for weight 
 * @param weight
 */
	public void setWeight(int weight) {
		this.Weight = weight;
	}
/**
 * Getter and setter for backpath
 * @return Backpath
 */
	public Town getBackpath() {
		return Backpath;
	}
/**
 * Getter and setter for bathpath
 * @param backpath
 */
	public void setBackpath(Town backpath) {
		this.Backpath = backpath;
	}
/**
 * addTown method
 * @param T
 */
	public void addTowns(Town T) {
		AdjTowns.add(T);
	}
	/**
	 * removeTown method
	 * @param T
	 */
	public void removeTowns(Town T) {
		AdjTowns.remove(T);
	}
	/**
	 * getAdjacentTowns method
	 * @return AdjTowns
	 */
	public Set<Town> getAdjacentTowns() {
		return AdjTowns;
	}
/**
 * setAdjacentTowns method
 * @param adjacentTowns
 */
	public void setAdjacentTowns(Set<Town> adjacentTowns) {
		this.AdjTowns = adjacentTowns;
	}
	/**
	 * resetLocation method
	 */
	public void resetLocation() {
		Weight = Integer.MAX_VALUE;
		Backpath = null;
	}
	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return Name;
	}
/**
 * hashCode method
 */
	@Override
	public int hashCode() {
		final int p = 31;
		int result = 1;
		result = p * result + ((Name == null) ? 0 : Name.hashCode());
		return result;
	}
/**
 * equals method
 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Town o = (Town) obj;
		if (Name == null) {
			if (o.Name != null)
				return false;
		} else if (!Name.equals(o.Name))
			return false;
		return compareTo((Town) obj) == 0;
	}
/**
 * compareTo method
 */
	@Override
	public int compareTo(Town o) {
		return this.Name.compareTo(o.getName()); 
	}


}
