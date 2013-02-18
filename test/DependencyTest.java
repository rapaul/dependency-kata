import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;


public class DependencyTest {

	@Test
	public void noDependencies() {
		Dependencies dependencies = new Dependencies();
		assertThat(dependencies.getDependencyFor("A"), is(empty()));
	}

}
