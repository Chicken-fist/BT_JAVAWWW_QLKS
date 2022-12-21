package com.se.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.entity.LoaiPhong;
import com.se.service.LoaiPhongService;
@Service
public class LoaiPhongServiceClientImpl implements LoaiPhongService{
	private RestTemplate restTemplate;
	private String crmRestUrl;
	@Autowired
	public LoaiPhongServiceClientImpl(RestTemplate restTemplate,@Value("${crm.rest.url}/categories") String crmRestUrl) {
		super();
		this.restTemplate = restTemplate;
		this.crmRestUrl = crmRestUrl;
	}

	@Override
	public List<LoaiPhong> getLoaiPhongs() {
		// TODO Auto-generated method stub
		ResponseEntity<List<LoaiPhong>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, 
				null, new ParameterizedTypeReference<List<LoaiPhong>>() {
				}) ;
		List<LoaiPhong> list = responseEntity.getBody();
		return list;
	}

	@Override
	public LoaiPhong getLoaiPhong(String loaiPhongId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(crmRestUrl + "/" + loaiPhongId, LoaiPhong.class);
	}

	@Override
	public void saveLoaiPhong(LoaiPhong loaiPhong) {
		// TODO Auto-generated method stub
		String loaiPhongId = loaiPhong.getMaLoai();
		
		if(loaiPhongId.equals(""))
			restTemplate.postForEntity(crmRestUrl, loaiPhong, String.class);
		else 
			restTemplate.put(crmRestUrl, loaiPhong);
	}

	@Override
	public void updateLoaiPhong(LoaiPhong loaiPhong) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLoaiPhong(String loaiPhongId) {
		// TODO Auto-generated method stub
		restTemplate.delete(crmRestUrl +"/" + loaiPhongId);
	}

}
