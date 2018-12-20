/**
     * Hàm để sử lý xuất nhập dữ liệu kế thừa class MyBigNumber
     * Kiểm tra xem có phải là chuỗi số
     * Kiểm tra và trả về kết quả cho mỗi trường hợp
     * Lấy ra từng bước cộng hai số
     */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ScanAndPrint {
	String NumberA;// Biến lưu số thứ nhất
    String NumberB;// Biến lưu số thứ hai
    String Result;// Biến lưu giá trị trả về
    MyBigNumber mybignumber = new MyBigNumber();
    
    
//Hàm kiểm tra xem chuỗi có phải là số trả về true or false  
public Boolean TextEro( String Number) 
	
{
	
	Pattern pattern = Pattern.compile("\\d*");
	Matcher matcher = pattern.matcher(Number);
	
	if (matcher.matches()) return true;
    else return false;
  
}

//Hàm in ra kết quả cho mỗi trường hợp
public String Print(String NumberA,String NumberB)
{
	
     Boolean ero1=TextEro(NumberA);// Kiểm tra số A
     Boolean ero2=TextEro(NumberB);// Kiểm tra số B
     // Xuất thông báo khi nhập sai 
    if (ero1 == false && ero2 == false) 
    {
    	 Result ="Cả hai đều không phải là số, vui lòng nhâp lại";
    }
    
    
    if(ero1 == false && ero2 == true)
    {
    	Result ="Nhập sai số thứ nhất,vui lòng nhâp lại";
    }
    
    
    if(ero1 == true && ero2 == false)
    {
    	Result ="Nhập sai số thứ hai,vui lòng nhập lại";
    }
    
    
    if(ero1 == true && ero2 == true) // Xuất kết quả cộng hai số
    {
    	Result=mybignumber.sum(NumberA, NumberB);
    }
    
    return Result;
    
    
}
public String StepResult(final String s1,final String s2) {
	
	
    // Khai báo biến
	String stepResult="";
    String finalResult = "";// biến nhận kết quả trả ve                    
    int len1 = s1.length();// độ dài chuỗi thứ nhất                     
    int len2 = s2.length();// độ dài chuỗi thứ hai                      
    int maxlen = (len1 > len2) ? len1 : len2;// so sánh độ dài chuỗi
    int index1;// Vị trí chuỗi 1                                   
    int index2;// Vị trí chuỗi 2
    char c1;// Lấy kí tự ở vị trí cuối cùng của chuỗi s1
    char c2;// Lấy kí tự ở ví trí cuối cùng của chuỗi s2
    int sonho = 0;// biến ghi lại số nhớ khi cộng 2 số lớn hơn 9                                   
    int s = 0;// Khởi tạo biến tổng bằng 0  
    String Soconnho;//Chuỗi trả về xem có còn nợ hay không
    int soconnho;//giá trị cũ của số nhớ
    
    // Vòng lặp từ 0 đến chuỗi có độ dài lớn nhất
    for (int i = 0; i < maxlen; i++)
    {
    	
        index1 = len1 - i - 1;// Lấy vị trí của chuỗi s1                       
        index2 = len2 - i - 1;// Lấy vị trí của chuỗi s2 
        c1 = (index1 >= 0) ? s1.charAt(index1) : '0';// Lấy kí tự từ phải sang trái của chuỗi s1
        c2 = (index2 >= 0) ? s2.charAt(index2) : '0';// Lấy kí tự từ phải sang trái của chuỗi s2
        s = (c1 - '0') + (c2 - '0') + sonho;// Biến đổi kí tự thành số rồi cộng 
        soconnho=sonho;//lưu dữ lại giá trị cũ của số nhớ
        if(soconnho==1) {Soconnho=" Trả nợ 1";}//Có nhớ trả về chuỗi
        else {Soconnho="";}//Không nhớ trả về null
        finalResult = (s % 10) + finalResult;// Lấy s chia dư rồi cộng vào kết quả                               
        sonho = s / 10;// Cập nhật lại số nhớ
        int buoc=i+1;//Tính bước bắt đầu từ 1
        stepResult=stepResult+"bước "+buoc+": Lấy "+c1+" cộng "+c2+Soconnho+" được "+s+" ghi "+s%10+" nhớ "+sonho+"    ;    ";//chuỗi in ra từng bước
        soconnho = s / 10;//cập nhật số nớ mới
        
    }
    if (sonho >= 1) 
    {     
    	
        finalResult = 1 + finalResult;// Nếu cuối cùng còn số nhớ thì ghép vào trước kết quả 
        stepResult=stepResult+"cuối cùng nhớ một ghi 1 ;";//thêm chuỗi nếu cuối cùng còn số nhớ thì ghép vào trước kết quả
        
    }
 
    return stepResult;// Trả ve kết quả cuối cùng
}
}
