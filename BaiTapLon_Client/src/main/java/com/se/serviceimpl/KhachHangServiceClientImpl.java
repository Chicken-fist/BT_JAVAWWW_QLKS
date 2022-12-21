package com.se.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.entity.KhachHang;
import com.se.service.KhachHangService;

@Service
public class KhachHangServiceClientImpl implements KhachHangService{
	
	private RestTemplate restTemplate;
	private String crmRestUrl;
	
	@Autowired
	public KhachHangServiceClientImpl(RestTemplate restTemplate,@Value("${crm.rest.url}/customers/")  String crmRestUrl) {
		this.restTemplate = restTemplate;
		this.crmRestUrl = crmRestUrl;
	}

	@Override
	public List<KhachHang> getKhachHangs() {
		// TODO Auto-generated method stub
		ResponseEntity<List<KhachHang>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null
				, new ParameterizedTypeReference<List<KhachHang>>() {});
		List<KhachHang> list = responseEntity.getBody();
		return list;
	}

	@Override
	public KhachHang getKhachHang(String khachHangId) {
		// TODO Auto-generated method stub
		KhachHang khachHang = restTemplate.getForObject(crmRestUrl + "/" + khachHangId, KhachHang.class);
		return khachHang;
	}

	@Override
	public void saveKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		String khachHangId = khachHang.getMaKH();
		if(khachHangId.equals(""))
			restTemplate.postForEntity(crmRestUrl, khachHang, String.class);
		else
			restTemplate.put(crmRestUrl, khachHang);
	}

	@Override
	public void updateKhachHang(KhachHang khachHang) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteKhachHang(String khachHangId) {
		// TODO Auto-generated method stub
		restTemplate.delete(crmRestUrl + "/" + khachHangId);
	}

}
