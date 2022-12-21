package com.se.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.entity.ChiTietDV;
import com.se.service.ChiTietDichVuService;
@Service
public class ChiTietDichVuServiceClientImpl implements ChiTietDichVuService{

	private RestTemplate restTemplate;
	private String crmRestUrl;
	@Autowired
	public ChiTietDichVuServiceClientImpl(RestTemplate restTemplate,@Value("${crm.rest.url}/servicedetails/") String crmRestUrl) {
		super();
		this.restTemplate = restTemplate;
		this.crmRestUrl = crmRestUrl;
	}
	@Override
	public ChiTietDV getChiTietDV(String maPhieuDatPhong, String MaDV) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(crmRestUrl +  maPhieuDatPhong + "/" + MaDV, ChiTietDV.class);
	}

	@Override
	public void saveCTDV(ChiTietDV ctp) {
		// TODO Auto-generated method stub
		
		String maDV = ctp.getDichVu().getMaDV();
		if(getChiTietDV(maDV, maDV) == null)
			restTemplate.postForEntity(crmRestUrl, ctp, String.class);
		else
			restTemplate.put(crmRestUrl, ctp);
	}

	@Override
	public void updateCTDV(Integer soLanSuDung, String maPhieuDatPhong, String MaDV) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCTDV(String maPhieuDatPhong, String MaDV) {
		// TODO Auto-generated method stub
		restTemplate.delete(crmRestUrl +  maPhieuDatPhong + "/" + MaDV);
	}

}
