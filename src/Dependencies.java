import java.util.LinkedList;
import java.util.List;


public class Dependencies {

	private List<Dependency> dependencies = new LinkedList<Dependency>();

	public void addDirect(Dependency item, Dependency dependency) {
		this.dependencies.add(dependency);
	}

	public List<Dependency> getDependencyFor(Dependency item) {
		return dependencies;
	}

}
