package es.gosssan.assistant.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import es.gosssan.assistant.domain.Service;
import es.gosssan.assistant.service.HiringAssistant;

public class HiringAssistantImpl implements HiringAssistant {
	private List<Service> services;

	public List<String> searchMinimalAmount() {
		Map<Double, List<String>> combinations = getCombinations();
		double minimalAmount = combinations.keySet().parallelStream()
			.mapToDouble(v -> v)
			.min().orElse(Double.NaN);

		return combinations.get(minimalAmount);
	}

	public void add(Service service) {
		services = Optional.ofNullable(services).orElseGet(() -> new ArrayList<Service>());
		if (!services.contains(service)) {
			services.add(service);
		}
	}

	private Map<Double, List<String>> getCombinations() {
		Map<Double, List<String>> combinations = new HashMap<>();

		List<Service> combination;
		Double average;

		for (int i = 0; i < services.size(); i++) {
			for (int j = i; services.size() > j + 1; j++) {
				combination = services.subList(i, j + 2);

				average = getAverage(combination);
				if (!combinations.containsKey(average)) {
					combinations.put(average, getNames(combination));
				}
			}
		}

		return combinations;
	}

	private double getAverage(List<Service> combination) {
		return combination.stream()
			.mapToDouble(Service::getAmount)
			.average().orElse(Double.NaN);
	}

	private List<String> getNames(List<Service> combination) {
		return combination.stream()
			.map(Service::getName)
			.collect(Collectors.toList());
	}
}