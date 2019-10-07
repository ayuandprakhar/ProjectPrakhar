package wp.javaproject.service;

import java.util.List;

import wp.javaproject.entities.Query;

public interface QueryServiceInterface {

	public void addQuery(Query query);
	public List<Query> getQueryFromUser(String email);
	public void updateQuery(Query query);
	public List<Query> getQueryResponseFromTransporter(String email);
	public Query getQueryByNo(String query_id);
}
