package wp.javaproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wp.javaproject.dao.QueryDAOInterface;
import wp.javaproject.entities.Query;

@Service
public class QueryService implements QueryServiceInterface {
	
	@Autowired
	QueryDAOInterface queryDAO;
	
	public void addQuery(Query query) {
		queryDAO.addQuery(query);
	}

	public List<Query> getQueryFromUser(String email) {
		
		return queryDAO.getQueryFromUser(email);
	}

	public void updateQuery(Query query) {
		queryDAO.updateQuery(query);
		
	}

	public List<Query> getQueryResponseFromTransporter(String email) {
		return queryDAO.getQueryResponseFromTransporter(email);
	}

	public Query getQueryByNo(String query_id) {
		
		return queryDAO.getQueryByNo(query_id);
	}

}
