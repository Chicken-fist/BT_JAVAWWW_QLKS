package com.se.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.entity.Phong;
import com.se.service.PhongSerivce;

@Service
public class PhongServiceClientImpl implements PhongSerivce {

	private RestTemplate restTemplate;
	private String crmRestUrl;

	@Autowired
	public PhongServiceClientImpl(RestTemplate restTemplate, @Value("${crm.rest.url}/rooms") String crmRestUrl) {
		super();
		this.restTemplate = restTemplate;
		this.crmRestUrl = crmRestUrl;
	}

	@Override
	public List<Phong> getPhongs() {
		// TODO Auto-generated method stub
		ResponseEntity<List<Phong>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Phong>>() {
				});
		List<Phong> list = responseEntity.getBody();
		return list;
	}

	@Override
	public Phong getPhong(String phongId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(crmRestUrl + "/" + phongId, Phong.class);
	}

	@Override
	public void savePhong(Phong phong) {
		// TODO Auto-generated method stub
//		String phongId = phong.getMaPhong();
		if (phong.getMaPhong().equals(""))
			restTemplate.postForEntity(crmRestUrl, phong, Phong.class);
		else
			restTemplate.put(crmRestUrl, phong);
	}

	@Override
	public void updatePhong(Phong phong) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePhong(String phongId) {
		// TODO Auto-generated method stub
		restTemplate.delete(crmRestUrl + "/" + phongId);
	}

	@Override
	public List<Phong> getPhongByMaLoaiPhong(String maLoai) {
		ResponseEntity<List<Phong>> responseEntity = restTemplate.exchange(crmRestUrl + "/getPhongByMaLoai/" + maLoai,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Phong>>() {
				});
		List<Phong> list = responseEntity.getBody();
		return list;
	}

	@Override
	public List<Phong> getPhongByTinhTrang(int tinhTrang) {
		ResponseEntity<List<Phong>> responseEntity = restTemplate.exchange(
				crmRestUrl + "/getPhongByTinhTrang/" + String.valueOf(tinhTrang), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Phong>>() {
				});
		List<Phong> list = responseEntity.getBody();
		return list;
	}

	@Override
	public List<Phong> getPhongsKhongQuanTamTinhTrang(String maLoai) {
		ResponseEntity<List<Phong>> responseEntity = restTemplate.exchange(
				crmRestUrl + "/getPhongByMaLoaiKhongQuanTamTT/" + maLoai, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Phong>>() {
				});
		List<Phong> list = responseEntity.getBody();
		return list;
	}

	@Override
	public void setPhuongThucPhongMoiNgay() {
		ResponseEntity<List<Phong>> responseEntity = restTemplate.exchange(crmRestUrl + "/getPhongTheoNgayNhanNgayTra/",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Phong>>() {
				});
		List<Phong> list = responseEntity.getBody();
		if (list.size() > 0) {
			for (Phong phong2 : list) {
				Phong p = getPhong(phong2.getMaPhong());
				p.setTinhTrang(2);
				restTemplate.put(crmRestUrl, p);
//				System.out.println("đã cập nhật lại ngày hum nay bạn nhé");
			}
		}
	}

	@Override
	public List<Phong> getPhongByMaPhong(String maPhong) {
		ResponseEntity<List<Phong>> responseEntity = restTemplate.exchange(crmRestUrl + "/getPhongByMaPhong/" + maPhong,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Phong>>() {
				});
		List<Phong> list = responseEntity.getBody();
		return list;
	}
}
