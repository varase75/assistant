package es.gosssan.assistant.service;

import java.util.List;

import es.gosssan.assistant.domain.Service;

public interface HiringAssistant {
	List<String> searchMinimalAmount();
	void add(Service service);
}