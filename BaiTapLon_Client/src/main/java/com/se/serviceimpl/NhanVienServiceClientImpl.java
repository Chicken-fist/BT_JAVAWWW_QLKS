package com.se.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.entity.NhanVien;
import com.se.service.NhanVienService;

@Service
public class NhanVienServiceClientImpl implements NhanVienService{
	private RestTemplate restTemplate;
	private String crmRestUrl;
	
	@Autowired
	public NhanVienServiceClientImpl(RestTemplate restTemplate,@Value("${crm.rest.url}/employees/") String crmRestUrl) {
		super();
		this.restTemplate = restTemplate;
		this.crmRestUrl = crmRestUrl;
	}

	@Override
	public List<NhanVien> getNhanViens() {
		ResponseEntity<List<NhanVien>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<NhanVien>>() {
				});
		List<NhanVien> list = responseEntity.getBody();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public NhanVien getNhanVien(String nhanVienId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(crmRestUrl + "/" + nhanVienId, null);
	}

	@Override
	public void saveNhanVien(NhanVien nhanVien) {
		// TODO Auto-generated method stub
		String nhanvienId = nhanVien.getMaNV();
		if(nhanvienId.equals("0"))
			restTemplate.postForObject(crmRestUrl,nhanVien, String.class);
		else
			restTemplate.put(crmRestUrl, nhanVien);
	}

	@Override
	public void updateNhanVien(NhanVien nhanVien) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNhanVien(String nhanVienId) {
		// TODO Auto-generated method stub
		restTemplate.delete(crmRestUrl + "/" + nhanVienId);
	}

}
