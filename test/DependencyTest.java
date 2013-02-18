import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class DependencyTest {

	private Dependency a = new Dependency("A");
	private Dependency b = new Dependency("B");
	private Dependency c = new Dependency("C");

	@Test
	public void noDependencies() {
		Dependencies dependencies = new Dependencies();
		assertThat(dependencies.getDependencyFor(a), is(empty()));
	}

	@Test
	public void singleDirectDependency() throws Exception {
		Dependencies dependencies = new Dependencies();
		dependencies.addDirect(a, b);
		assertThat(dependencies.getDependencyFor(a), contains(b));
	}

	@Test
	public void multipleDirectDependencies() throws Exception {
		Dependencies dependencies = new Dependencies();
		dependencies.addDirect(a, b);
		dependencies.addDirect(a, c);
		assertThat(dependencies.getDependencyFor(a), containsInAnyOrder(b, c));
	}

}
