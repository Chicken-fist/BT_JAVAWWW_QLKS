package com.se.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.entity.DichVu;
import com.se.service.DichVuService;

@Service
public class DichVuServiceClientImpl implements DichVuService {

	private RestTemplate restTemplate;
	private String crmRestUrl;
	@Autowired
	public DichVuServiceClientImpl(RestTemplate restTemplate,@Value("${crm.rest.url}/services/") String crmRestUrl) {
		this.restTemplate = restTemplate;
		this.crmRestUrl = crmRestUrl;
	}
	
	@Override
	public List<DichVu> getDichVus() {
		ResponseEntity<List<DichVu>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<DichVu>>() {});
		List<DichVu> list = responseEntity.getBody();
		return list;
	}

	@Override
	public DichVu getDichVu(String dichVuId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(crmRestUrl + "/" + dichVuId, DichVu.class);
	}

	@Override
	public void saveDichVu(DichVu dichVu) {
		// TODO Auto-generated method stub
		String id = dichVu.getMaDV();
		if(id.equals(""))
			restTemplate.postForObject(crmRestUrl, dichVu, String.class);
		else
			restTemplate.put(crmRestUrl, dichVu);
	}

	@Override
	public void updateDichVu(DichVu dichVu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDichVu(String dichVuId) {
		// TODO Auto-generated method stub
		restTemplate.delete(crmRestUrl + "/" + dichVuId);
	}

}
