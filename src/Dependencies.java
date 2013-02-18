import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Dependencies {

	private Map<Dependency, List<Dependency>> dependencies = new HashMap<Dependency, List<Dependency>>();

	public void addDirect(Dependency item, Dependency dependency) {
		List<Dependency> directDependencies = lazyInitialiseFor(item);
		directDependencies.add(dependency);
	}

	private List<Dependency> lazyInitialiseFor(Dependency item) {
		List<Dependency> directDependencies = dependencies.get(item);
		if (directDependencies == null) {
			directDependencies = new LinkedList<Dependency>();
			dependencies.put(item, directDependencies);
		}
		return directDependencies;
	}

	public List<Dependency> getDependencyFor(Dependency item) {
		List<Dependency> deps = dependencies.get(item);
		return deps == null ? Collections.<Dependency>emptyList() : deps;
	}

}
