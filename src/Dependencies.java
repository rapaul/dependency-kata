import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Dependencies {

	private Dependency dependency;

	public List<Dependency> getDependencyFor(String string) {
		return new LinkedList<Dependency>();
	}

	public void addDirect(Dependency item, Dependency dependency) {
		this.dependency = dependency;
		
	}

	public List<Dependency> getDependencyFor(Dependency item) {
		return Arrays.asList(dependency);
	}

}
