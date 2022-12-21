package com.se.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.entity.ChiTietPhong;
import com.se.entity.PhieuDatPhong;
import com.se.service.ChiTietPhongService;
@Service
public class ChiTietPhongServiceClientImpl implements ChiTietPhongService{
	private RestTemplate restTemplate;
	private String crmRestUrl;
	@Autowired
	public ChiTietPhongServiceClientImpl(RestTemplate restTemplate,@Value("${crm.rest.url}/roomdetails/") String crmRestUrl) {
		super();
		this.restTemplate = restTemplate;
		this.crmRestUrl = crmRestUrl;
	}
	
	@Override
	public ChiTietPhong getChiTietPhong(String maPhieuDatPhong, String maPhong) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(crmRestUrl + "/" + maPhieuDatPhong + "/" + maPhong, ChiTietPhong.class);
	}

	@Override
	public void saveCTP(ChiTietPhong ctdv) {
		// TODO Auto-generated method stub
		String maCTP = ctdv.getPhong().getMaPhong();
//		if(maCTP.equals("") && maPhieuDatPhong.equals("0"))
			restTemplate.postForEntity(crmRestUrl, ctdv, String.class);
//		else
//			restTemplate.put(crmRestUrl, ctdv);
			
	}

	@Override
	public void updateCTP(ChiTietPhong ctdv, String maPhieuDatPhong, String maPhong) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCTP(String maPhieuDatPhong, String maPhong) {
		// TODO Auto-generated method stub
		restTemplate.delete(crmRestUrl + "/" + maPhieuDatPhong + "/" + maPhong);
	}

	@Override
	public PhieuDatPhong getPhieuDatPhongTheoMaPhong(String maPhong) {
		return restTemplate.getForObject(crmRestUrl + "/getPhieuDatTheMaPhong/" + maPhong, PhieuDatPhong.class);
	}

}
