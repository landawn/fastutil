package it.unimi.dsi.fastutil.ints;

import it.unimi.dsi.fastutil.ints.IntArraySet;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.io.BinIO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import junit.framework.TestCase;

public class IntArraySetTest extends TestCase {
	
	public void testSet() {
		for( int i = 1; i <= 1; i++ ) {
			final IntArraySet s = i == 0 ? new IntArraySet() : new IntArraySet( new int[ i ] );
			assertTrue( s.add( 1 ) );
			assertEquals( 1, s.size() );
			assertTrue( s.contains( 1 ) );
			assertTrue( s.add(  2  ) );
			assertTrue( s.contains( 2 ) );
			assertEquals( 2, s.size() );
			assertFalse( s.add( 1 ) );
			assertFalse( s.remove( 3 ) );
			assertTrue( s.add( 3 ) );
			assertEquals( 3, s.size() );
			assertTrue( s.contains( 1 ) );
			assertTrue( s.contains( 2 ) );
			assertTrue( s.contains( 2 ) );
			assertEquals( new IntOpenHashSet( new int[] { 1, 2, 3 } ), new IntOpenHashSet( s.iterator() ) );
			assertTrue( s.remove( 3 ) );
			assertEquals( 2, s.size() );
			assertTrue( s.remove( 1 ) );
			assertEquals( 1, s.size() );
			assertFalse( s.contains( 1 ) );
			assertTrue( s.remove( 2 ) );
			assertEquals( 0, s.size() );
			assertFalse( s.contains( 1 ) );
		}
	}
	
	public void testClone() {
		IntArraySet s = new IntArraySet();
		assertEquals( s, s.clone() );
		s.add( 0 );
		assertEquals( s, s.clone() );
		s.add( 0 );
		assertEquals( s, s.clone() );
		s.add( 1 );
		assertEquals( s, s.clone() );
		s.add( 2 );
		assertEquals( s, s.clone() );
		s.remove( 0 );
		assertEquals( s, s.clone() );
	}

	public void testSerialisation() throws IOException, ClassNotFoundException {
		IntArraySet s = new IntArraySet();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream( baos );
		oos.writeObject( s );
		oos.close();
		assertEquals( s, BinIO.loadObject( new ByteArrayInputStream( baos.toByteArray() ) ) );
		
		s.add( 0 );
		s.add( 1 );

		baos.reset();
		oos = new ObjectOutputStream( baos );
		oos.writeObject( s );
		oos.close();
		assertEquals( s, BinIO.loadObject( new ByteArrayInputStream( baos.toByteArray() ) ) );
	}
}
