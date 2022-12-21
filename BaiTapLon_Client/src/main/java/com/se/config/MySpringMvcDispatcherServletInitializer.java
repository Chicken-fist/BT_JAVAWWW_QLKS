package com.se.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends 
	AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {DemoAppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
//create trigger tigger2 
//on HoaDonBanHang
//after insert, update, delete
//as
//declare @maKH varchar(255), @subTotal float
//if not exists (select * from deleted)
//	select @maKH= MaKhachHang from inserted where TinhTrang = 1
//else if not exists (select * from inserted)
//	select @maKH= MaKhachHang from deleted where TinhTrang = 1
//else if UPDATE(TongTien)
//	select @maKH= MaKhachHang from inserted
//select @subTotal = sum(TongTien) from HoaDonBanHang where MaKhachHang=@maKH and TinhTrang = 1
//update KhachHang
//set LoaiKhachHang = case
//when @subTotal > 10000000 then 1
//when @subTotal between 5000000 and 10000000 then 2
//else 3
//end
//where @maKH = maKhachHang
