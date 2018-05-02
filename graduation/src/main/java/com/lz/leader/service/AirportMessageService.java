package com.lz.leader.service;
/**
 * 机场信息的处理
 * @author ASUS
 *
 */

import java.util.List;

import com.lz.common.entity.Airport;
import com.lz.leader.dao.AirportMessageDao;

public class AirportMessageService {

	private AirportMessageDao airportMessageDao= new AirportMessageDao();
	public List<Airport> loadAirport() {
		return airportMessageDao.loadAirport();
	}
}
