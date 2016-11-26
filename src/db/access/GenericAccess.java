package db.access;

import java.util.List;

public interface GenericAccess <T>{
	public void adiciona(T t);
	public void atualiza(T t);
	public void remove(T t);
	public List<T> procuraTodos();
	public T procuraPorID(int id);
}
