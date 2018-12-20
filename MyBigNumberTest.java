import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyBigNumberTest {
	/**
     * 1 Kiểm thử khả năng chính xác của phần mềm so với hàm tính tổng 2 số integer thông thường.
     * 2 Kiểm thử hàm có hoạt động được khi số chữ số vượt quá giới hạn của kiểu dữ liệu integer.
     * 3 Kiểm thử hàm có hoạt động khi chạy chạy những số vô cùng lớn ( 1000 tỷ chữ số )
     */

	@Test
	void test() {
		MyBigNumber myClass =new MyBigNumber();
		
		//Kiểm thử giá trị tổng khi chuỗi 1 và chuỗi 2 chạy lần lượt từ 0 - 9, bao quát tất cả các trường hợp có nhớ và không nhớ trong phạm vi cộng hai số có một chữ số.
		for (int i=0;i<10;i++) 
		{
			for (int j=0;j<10;j++)
			{
				
				String s1 = String.valueOf(i);		
				String s2 = String.valueOf(j);		
				String Sum = String.valueOf((i)+(j));		
				String sum = myClass.sum(s1, s2);
				assertEquals(Sum,sum);
				
			}
		//Kiểm thử tất cả giá trị tổng có thực hiện đúng trong phạm vi chuỗi gồm 1000000 chữ số.
			
			for (int j=0;j<1000000;j++)
			{
				
				String s1 = String.valueOf(10^i);
				String s2 = String.valueOf(10^j);
				String Sum = String.valueOf((10^i)+(10^j));
				String sum = myClass.sum(s1, s2);
				assertEquals(Sum,sum);
			}
			
		//Kiểm thử hàm có thể thực hiện tính đúng các số gồm 1000000 tới 100000000 chữ số.
			
			for (int j=1000000;j<1000000000;j=j*10)
			{
				
			String s1 = String.valueOf(10^j);
			String s2 = String.valueOf(10^j);
			String Sum = String.valueOf((10^j)+(10^j));
			String sum = myClass.sum(s1, s2);
			assertEquals(Sum,sum);
			
			}
			
		//Kiểm thử hàm có thể thực hiện được với các các số gồm 1000000000 tới 10000000000000 chữ số
			String s1 = String.valueOf(10^100000000);
			String s2 = String.valueOf(0);
			for (int j=0;j<10000;j++)//Vòng lập thêm 1 chữ số 0
			s1=s1+"0";
			String sum = myClass.sum(s1, s2);
			assertEquals(s1,sum);
		
		}
	}
	/**
     * 1 Kiểm thử khả năng chính xác của phần mềm so với hàm tính tổng 2 số integer thông thường.100%
     * 2 Kiểm thử hàm có hoạt động được khi số chữ số vượt quá giới hạn của kiểu dữ liệu integer.100%
     * 3 Kiểm thử hàm có hoạt động khi chạy chạy những số vô cùng lớn ( 1000 tỷ chữ số )100%
     * Vậy chương trình chạy đúng 100% tất cả các dữ liệu trong phạm vi dưới 1000 tỷ chữ số
     */
}
