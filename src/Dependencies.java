import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Dependencies {

	private Dependency dependency;

	public void addDirect(Dependency item, Dependency dependency) {
		this.dependency = dependency;
	}

	public List<Dependency> getDependencyFor(Dependency item) {
		if (dependency == null) return Collections.emptyList();
		return Arrays.asList(dependency);
	}

}
