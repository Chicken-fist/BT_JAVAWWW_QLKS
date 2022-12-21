package com.se.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.entity.ChiTietPhong;
import com.se.entity.PhieuDatPhong;
import com.se.service.PhieuDatPhongSerivce;

@Service
public class PhieuDatPhongServiceClientImpl implements PhieuDatPhongSerivce{
	private RestTemplate restTemplate;
	private String crmRestUrl;
	
	@Autowired
	public PhieuDatPhongServiceClientImpl(RestTemplate restTemplate,@Value("${crm.rest.url}/reservations/") String crmRestUrl) {
		super();
		this.restTemplate = restTemplate;
		this.crmRestUrl = crmRestUrl;
	}

	@Override
	public List<PhieuDatPhong> getPhieuDatPhongs() {
		// TODO Auto-generated method stub
		ResponseEntity<List<PhieuDatPhong>> responseEntity = restTemplate.exchange(crmRestUrl,HttpMethod.GET ,null,
				new ParameterizedTypeReference<List<PhieuDatPhong>>() {});
		List<PhieuDatPhong> list = responseEntity.getBody();
		return list;
	}

	@Override
	public PhieuDatPhong getPhieuDatPhong(String phieuDatPhongId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(crmRestUrl + "/" + phieuDatPhongId, PhieuDatPhong.class);
	}

	@Override
	public PhieuDatPhong savePhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		// TODO Auto-generated method stub
		String id = phieuDatPhong.getMaPhieuDatPhong();
		if(id.equals("")) {
			restTemplate.postForObject(crmRestUrl, phieuDatPhong, PhieuDatPhong.class);
			
		}
		else {
			restTemplate.put(crmRestUrl, phieuDatPhong);
			System.out.println("Da Cap Nhat:" );
		}
			
			return getPhieuDatPhongs().get(0);
	}
	
	@Override
	public void updatePhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePhieuDatPhong(String phieuDatPhongId) {
		// TODO Auto-generated method stub
		restTemplate.delete(crmRestUrl + "/" + phieuDatPhongId);
	}

	@Override
	public List<PhieuDatPhong> getPhieuDatPhongByMaPhong(String maPhongId) {
		ResponseEntity<List<PhieuDatPhong>> responseEntity = restTemplate.exchange(crmRestUrl + 
				"/getPhieuDatByMaPhong/" + maPhongId,HttpMethod.GET ,null,
				new ParameterizedTypeReference<List<PhieuDatPhong>>() {});
		List<PhieuDatPhong> list = responseEntity.getBody();
		return list;
	}

}
