import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Dependencies {

	private Map<Dependency, List<Dependency>> allDependencies = new HashMap<Dependency, List<Dependency>>();

	public void addDirect(Dependency item, Dependency dependency) {
		List<Dependency> directDependencies = lazyInitialiseFor(item);
		directDependencies.add(dependency);
	}

	private List<Dependency> lazyInitialiseFor(Dependency item) {
		List<Dependency> directDependencies = allDependencies.get(item);
		if (directDependencies == null) {
			directDependencies = new LinkedList<Dependency>();
			allDependencies.put(item, directDependencies);
		}
		return directDependencies;
	}

	public List<Dependency> getDependencyFor(Dependency item) {
		List<Dependency> directDependencies = allDependencies.get(item);
		if (directDependencies == null) { return Collections.<Dependency>emptyList(); }
		List<Dependency> transitiveDependencies = new LinkedList<Dependency>(directDependencies);
		for (Dependency directDependency : directDependencies) {
			transitiveDependencies.addAll(getDependencyFor(directDependency));
		}
		return transitiveDependencies;
	}

}
