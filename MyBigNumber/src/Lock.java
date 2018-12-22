

/**
     *Hàm khóa chứa chức năng 
     *Đếm số lần nhập sai liên tiếp
     *Thực hiện khóa chương trình
     *In ra để kiểm tra những dữ liệu đã bị nhập sai
     */
public class Lock {
	int NumberEro=0;//đếm số lần sai liên tiếp
	String StringEro;//Lưu lại chuỗi sai liên tiếp
	public boolean lockin(String s1, String s2)
	{
		
		NumberEro++;//cộng thêm 1 lần sai vào biến đếm
		StringEro=StringEro+"  "+s1+","+ s2;//lấy chuỗi sai vừa nhập
		if (NumberEro==5) //Xem xem đã sai quá 5 lần hay chưa
		{
			return true;
		}
		else
		{	
			return false;
		}
	}
	public void lockup()//reset lại biến đém số sai khi nhập đúng
	{
		NumberEro=0;
		StringEro="";
	}
	  
	
	
	public void TestSleep() //Khóa chương trình trong 10s xuất ra chuỗi gồm các sổ đã nhập sai trong 5 lần nhập
	{
		try {
			
				//sleep 10 seconds
				Thread.sleep(10000);
				StringEro=StringEro+"  ,  ";
				System.out.println(StringEro);//print ra chuỗi số nhập sai
				NumberEro=0;//rest lại biến đém
				
			} 
		catch (InterruptedException e)
		{
		 
			
		}
			
			
		

	}

}
