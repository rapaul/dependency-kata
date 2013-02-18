import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Dependencies {

	private Map<Dependency, Set<Dependency>> allDependencies = new HashMap<Dependency, Set<Dependency>>();

	public void addDirect(Dependency item, Dependency dependency) {
		Set<Dependency> directDependencies = lazyInitialiseFor(item);
		directDependencies.add(dependency);
	}

	private Set<Dependency> lazyInitialiseFor(Dependency item) {
		Set<Dependency> directDependencies = allDependencies.get(item);
		if (directDependencies == null) {
			directDependencies = new HashSet<Dependency>();
			allDependencies.put(item, directDependencies);
		}
		return directDependencies;
	}

	public Set<Dependency> getDependencyFor(Dependency item) {
		Set<Dependency> directDependencies = allDependencies.get(item);
		if (directDependencies == null) { return Collections.<Dependency>emptySet(); }
		Set<Dependency> transitiveDependencies = new HashSet<Dependency>(directDependencies);
		for (Dependency directDependency : directDependencies) {
			transitiveDependencies.addAll(getDependencyFor(directDependency));
		}
		return transitiveDependencies;
	}

}
