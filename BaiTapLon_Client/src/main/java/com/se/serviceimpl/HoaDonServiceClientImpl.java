package com.se.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.entity.HoaDon;
import com.se.service.HoaDonService;
@Service
public class HoaDonServiceClientImpl implements HoaDonService{

	private RestTemplate restTemplate;
	private String crmRestUrl;
	@Autowired
	public HoaDonServiceClientImpl(RestTemplate restTemplate,@Value("${crm.rest.url}/bills/") String crmRestUrl) {
		this.restTemplate = restTemplate;
		this.crmRestUrl = crmRestUrl;
	}

	@Override
	public List<HoaDon> getHoaDons() {
		// TODO Auto-generated method stub
		ResponseEntity<List<HoaDon>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<HoaDon>>() {
				});
		List<HoaDon> list = responseEntity.getBody();
		return list;
	}

	@Override
	public HoaDon getHoaDon(String hoaDonId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(crmRestUrl + "/" + hoaDonId, HoaDon.class);
	}

	@Override
	public void saveHoaDon(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		if(hoaDon.getMaHD().equals("0"))
			restTemplate.postForObject(crmRestUrl, hoaDon, String.class);
		else
			restTemplate.put(crmRestUrl, hoaDon);
	}

	@Override
	public void updateHoaDon(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHoaDon(String hoaDonId) {
		// TODO Auto-generated method stub
		restTemplate.delete(crmRestUrl + "/" + hoaDonId);
	}

}
