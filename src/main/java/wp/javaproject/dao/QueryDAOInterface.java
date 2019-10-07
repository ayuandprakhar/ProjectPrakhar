package wp.javaproject.dao;

import java.util.List;

import wp.javaproject.entities.Query;

public interface QueryDAOInterface {

	public void addQuery(Query query);
	public List<Query> getQueryFromUser(String email);
	public List<Query> getQueryResponseFromTransporter(String email);
	public void updateQuery(Query query);
	public Query getQueryByNo(String query_id);
}
