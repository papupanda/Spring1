package com.nt.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.PassegenerBO;

@Repository("reservationDAO")
public class ReservationDAOImpl implements ReservationDAO {
	private  static final String  RESERVE_TICKET="INSERT INTO TSRTC_RESERVATION VALUES(PSGNR_SEQ.NEXTVAL,?,?,?,?,?)";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int[] insertGroup(List<PassegenerBO> listBO) {
		int result[]=null;
		result=jt.batchUpdate(RESERVE_TICKET,
				                                new BatchPreparedStatementSetter() {
													
													@Override
													public void setValues(PreparedStatement ps, int i) throws SQLException {
														//set each BO obj data of listBO to  query param values
														ps.setString(1,listBO.get(i).getPsngrName());
														ps.setInt(2,listBO.get(i).getAge());
														ps.setString(3,listBO.get(i).getSource());
														ps.setString(4,listBO.get(i).getDestination());
														ps.setInt(5,listBO.get(i).getFare());
														
													}
													
													@Override
													public int getBatchSize() {
													
														return listBO.size();
													}
												});
		
		return result;
	}

}
