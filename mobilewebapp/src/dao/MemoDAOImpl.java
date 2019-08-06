package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Memo;

public class MemoDAOImpl extends BaseDAO implements MemoDAO {
	
	private static final String MEMO_INSERT_SQL 
		= "INSERT INTO memo VALUES (seq_memo.nextval, ?, ?)";
	private static final String MEMO_SELECT_ALL_SQL = 
			" SELECT * " + 
			" FROM memo " + 
			" ORDER BY memoid desc ";
	
	private static final String MEMO_SELECT_BY_MEMOID_SQL
			="SELECT * FROM memo WHERE memoid = ?";
	
	private static final String MEMO_UPDATE_SQL 
	 = "UPDATE memo SET name=?, age=? WHERE memoid =?";
	
	private static final String MEMO_DELETE_SQL 
	 = "DELETE FROM memo WHERE memoid = ?";
	private static final String MEMO_SELECT_BY_NAME_SQL 
		= "SELECT * FROM memo WHERE name LIKE ? ORDER BY memoid desc";
	private static final String MEMO_SELECT_ALL_FOR_PAGE_SQL
		="SELECT * " + 
			" FROM (SELECT rownum rn, memos.*" + 
			"		FROM (SELECT * FROM MEMO ORDER BY memoid DESC) memos)" + 
			" WHERE rn BETWEEN ? AND ?";
	@Override
	public boolean insert(Memo memo) {
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_INSERT_SQL);

			preparedStatement.setString(1, memo.getName());
			preparedStatement.setInt(2, memo.getAge());
			
			int rowCount = preparedStatement.executeUpdate();
			
			if(rowCount>0) {				
				result = true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		
		return result;
	}

	@Override
	public List<Memo> selectAll() {
		List<Memo> memos = new ArrayList<Memo>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_SELECT_ALL_SQL);
			
			
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Memo memo = new Memo();

				memo.setMemoid(resultSet.getInt("memoid"));
				memo.setName(resultSet.getString("name"));
				memo.setAge(resultSet.getInt("age"));
	
				memos.add(memo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memos;
	}

	@Override
	public Memo selectByMemoId(int memoid) {
		Memo memo = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_SELECT_BY_MEMOID_SQL);
			preparedStatement.setInt(1, memoid);
			
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				memo = new Memo();

				memo.setMemoid(resultSet.getInt("memoid"));
				memo.setName(resultSet.getString("name"));
				memo.setAge(resultSet.getInt("age"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memo;
	}

	@Override
	public boolean update(Memo memo) {
		
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_UPDATE_SQL);

			preparedStatement.setString(1, memo.getName());
			preparedStatement.setInt(2, memo.getAge());
			preparedStatement.setInt(3, memo.getMemoid());
			
			int rowCount = preparedStatement.executeUpdate();
			
			if(rowCount>0) {
				
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		
		return result;
	}

	@Override
	public boolean deleteByMemoId(int memoid) {
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_DELETE_SQL);

			preparedStatement.setInt(1, memoid);

			int rowCount = preparedStatement.executeUpdate();
			
			if(rowCount>0) {
				
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		
		return result;
	}

	@Override
	public List<Memo> selectByName(String name) {
		List<Memo> memos = new ArrayList<Memo>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_SELECT_BY_NAME_SQL);
			preparedStatement.setString(1, "%"+name+"%");
			
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Memo memo = new Memo();

				memo.setMemoid(resultSet.getInt("memoid"));
				memo.setName(resultSet.getString("name"));
				memo.setAge(resultSet.getInt("age"));
	
				memos.add(memo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memos;
	}

	@Override
	public List<Memo> selectAll(int rowStartNumber, int rowEndNumber) {
		List<Memo> memos = new ArrayList<Memo>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMO_SELECT_ALL_FOR_PAGE_SQL);
			
			preparedStatement.setInt(1, rowStartNumber);
			preparedStatement.setInt(2, rowEndNumber);
			
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Memo memo = new Memo();

				memo.setMemoid(resultSet.getInt("memoid"));
				memo.setName(resultSet.getString("name"));
				memo.setAge(resultSet.getInt("age"));
	
				memos.add(memo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memos;
	}

}
