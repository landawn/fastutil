package it.unimi.dsi.fastutil.ints;

import java.util.Collections;
import java.util.EnumSet;
import java.util.function.Supplier;
import org.junit.runners.Parameterized.Parameters;

public class Int2IntMapGenericArrayTest extends Int2IntMapGenericTest<Int2IntArrayMap> {
	@Parameters
	public static Iterable<Object[]> data() {
		final EnumSet<Capability> capabilities = EnumSet.allOf(Capability.class);
		capabilities.remove(Capability.ITERATOR_MODIFY);
		return Collections.singletonList(new Object[] { (Supplier<Int2IntMap>) Int2IntArrayMap::new, capabilities });
	}
}