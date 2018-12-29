
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Tác giả: Huỳnh Minh Phúc
 * Desrciption.
 * Class MyBigNumber là lớp để tính tổng của 2 số s1 và s2.
 * Hàm sum trong Class MyBigNumber là hàm để thực hiện phép cộng 2 chuỗi số.
 */
 
public class MyBigNumber {
    
    /**
     * Khi thực hiện cộng 2 số, ta cần 2 chuỗi làm tham số cho hàm sum khi đó:
     * 2 chuỗi này chứa các kí số từ '0' đến '9'.
     * @param s1 chuỗi số thứ nhất.
     * @param s2 chuỗi số thứ hai.
     * @return chuỗi có giá trị là tổng của hai số s1 và s2 được truyền vào.
     */

    public String sum(final String s1,final String s2) {
        // Khai báo biến
        String str1 = s1; //temp variable of string s1
        String str2 = s2; //temp variable of string s1 
        final Pattern pattern = Pattern.compile("\\D"); //Numerical sequences represent numeric characters [0-9]
        final Matcher flag1 = pattern.matcher(str1); 
        final Matcher flag2 = pattern.matcher(str2); 

        
        //check two number sequences is empty or not
        // if it is null make it = '0'
        if ((str1 == null) || (str1.trim().isEmpty()) && (str2 == null) || (str2.trim().isEmpty())) {
        	return "0";//
        }
        else if ((str1 == null) || (str1.trim().isEmpty())) {
        	return s2;//
        }
        
        else if ((str2 == null) || (str2.trim().isEmpty())) {
        	return s1;//
        }
        
        //Check whether the number is negative
        if (str2.charAt(0) == '-' && str1.charAt(0) == '-') {
            
        	throw new NumberFormatException( "Cả hai số đều âm, vui lòng nhập lại cả hai số");//
        }
        
        if (str1.charAt(0) == '-' && str2.charAt(0) != '-') {
            
        	throw new NumberFormatException( "Số thứ nhất âm, vui lòng nhập lại số thứ nhất");//
        }
        
        if (str2.charAt(0) == '-' && str1.charAt(0) != '-') {
            
        	throw new NumberFormatException( "Số thứ hai âm, vui lòng nhập lại số thứ hai");//
        }
        

        //Check whether characters are special characters or characters
        if (flag1.find() && flag2.find()) {
            
        	throw new NumberFormatException( "Cả hai chuỗi không phải là số");
        }
        
        if (flag1.find()) {
            
        	throw new NumberFormatException( "Chuỗi một không phải là số");
        }
        if (flag2.find()) {
            
        	throw new NumberFormatException( "Chuỗi hai không phải là số");
        }
        String finalResult = "";// biến nhận kết quả trả về                    
        int len1 = s1.length();// độ dài chuỗi thứ nhất                     
        int len2 = s2.length();// độ dài chuỗi thứ hai                      
        int maxlen = (len1 > len2) ? len1 : len2;// so sánh độ dài chuỗi
        int index1;// Vị trí chuỗi 1                                   
        int index2;// Vị trí chuỗi 2
        char c1;// Lấy kí tự ở vị trí cuối cùng của chuỗi s1
        char c2;// Lấy kí tự ở ví trí cuối cùng của chuỗi s2
        int memory = 0;// biến ghi lại số nhớ khi cộng 2 số lớn hơn 9                                   
        int s = 0;// Khởi tạo biến tổng bằng 0 
        int step;// hiển thị đang ở bước nào
        String stringmemorynumber;//Chuỗi trả về xem có còn nợ hay không
        String stepresult = "";//chuỗi các bước
        int memorybefore;//giá trị cũ của số nhớ
        // Vòng lặp từ 0 đến chuỗi có độ dài lớn nhất
        for (int i = 0; i < maxlen; i++)
        {
            index1 = len1 - i - 1;// Lấy vị trí của chuỗi s1
            index2 = len2 - i - 1;// Lấy vị trí của chuỗi s2 
            c1 = (index1 >= 0) ? s1.charAt(index1) : '0';// Lấy kí tự từ phải sang trái của chuỗi s1
            c2 = (index2 >= 0) ? s2.charAt(index2) : '0';// Lấy kí tự từ phải sang trái của chuỗi s2
            s = (c1 - '0') + (c2 - '0') + memory;// Biến đổi kí tự thành số rồi cộng 
            memorybefore = memory;//lưu dữ lại giá trị cũ của số nhớ
            if (memorybefore == 1) {
                stringmemorynumber = " Trả nợ 1"; 
            } //Có nhớ trả về chuỗi 
            else { stringmemorynumber = ""; } //Không nhớ trả về null
            finalResult = (s % 10) + finalResult;// Lấy s chia dư rồi cộng vào kết quả                               
            memory = s / 10;// Cập nhật lại số nhớ
            step = i + 1;//Tính bước bắt đầu từ 1
            stepresult = stepresult + "bước " + step + ": Lấy " + c1 + " cộng " + c2 + stringmemorynumber 
                + " được " + s + " ghi " + s % 10 + " nhớ " + memory + "    ;    ";//chuỗi in ra từng bước
            memorybefore = s / 10;//cập nhật số nớ mới
            
        }
        if (memory >= 1) 
        {
            finalResult = 1 + finalResult;// Nếu cuối cùng còn số nhớ thì ghép vào trước kết quả 
            stepresult = stepresult + "cuối cùng nhớ một ghi 1 ;";
                 
        }
     
        return finalResult;// Trả ve kết quả cuối cùng
    }
}