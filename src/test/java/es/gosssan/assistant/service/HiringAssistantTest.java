package es.gosssan.assistant.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.gosssan.assistant.domain.Service;
import es.gosssan.assistant.service.HiringAssistant;
import es.gosssan.assistant.service.impl.HiringAssistantImpl;

import static org.junit.Assert.assertEquals;

public class HiringAssistantTest {
	private HiringAssistant assistant;

	private final static List<String> RESULT_CASO_1 = Arrays.asList("S2", "S3");
	private final static List<String> RESULT_CASO_2 = Arrays.asList("S3", "S4");
	private final static List<String> RESULT_CASO_3 = Arrays.asList("S3", "S4", "S5");

	@Before
	public void setUp() {
		assistant = new HiringAssistantImpl();
	}

	@Test
	public void testCaso1() {
		assistant.add(new Service(0, "S1", 4.0));
		assistant.add(new Service(1, "S2", 2.0));
		assistant.add(new Service(2, "S3", 2.0));
		assistant.add(new Service(3, "S4", 5.0));
		assistant.add(new Service(4, "S5", 1.0));
		assistant.add(new Service(5, "S6", 5.0));
		assistant.add(new Service(6, "S7", 8.0));

		List<String> combination = assistant.searchMinimalAmount();
		assertEquals(RESULT_CASO_1, combination);
	}

	@Test
	public void testCaso2() {
		assistant.add(new Service(0, "S1", 5.0));
		assistant.add(new Service(1, "S2", 6.0));
		assistant.add(new Service(2, "S3", 3.0));
		assistant.add(new Service(3, "S4", 4.0));
		assistant.add(new Service(4, "S5", 9.0));

		List<String> combination = assistant.searchMinimalAmount();
		assertEquals(RESULT_CASO_2, combination);
	}

	
	@Test
	public void testCaso3() {
		assistant.add(new Service(0, "S1", 5.0));
		assistant.add(new Service(1, "S2", 6.0));
		assistant.add(new Service(2, "S3", 2.0));
		assistant.add(new Service(3, "S4", 3.0));
		assistant.add(new Service(4, "S5", 2.0));

		List<String> combination = assistant.searchMinimalAmount();
		assertEquals(RESULT_CASO_3, combination);
	}

}