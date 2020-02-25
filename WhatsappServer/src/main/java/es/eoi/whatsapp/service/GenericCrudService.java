package es.eoi.whatsapp.service;

import java.util.List;

public interface GenericCrudService<T> {
	
	public void create(T entity);
	public T read(int id);
	public void update(T entity);
	public void delete(int id);
	public List<T> readAll();
	
}
