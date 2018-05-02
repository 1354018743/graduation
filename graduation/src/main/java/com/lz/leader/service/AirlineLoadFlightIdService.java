package com.lz.leader.service;

import java.util.List;

import com.lz.common.entity.FlightId;
import com.lz.leader.dao.AirlineLoadFlightIdDao;

/**
 * 航班编号
 * @author ASUS
 *
 */
public class AirlineLoadFlightIdService {

	private AirlineLoadFlightIdDao airlineLoadFlightIdDao= new AirlineLoadFlightIdDao();
	public List<FlightId> loadFlightId(int cid) {
		return airlineLoadFlightIdDao.loadFlightId(cid);
	}
}
