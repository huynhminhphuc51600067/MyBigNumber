import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class Interface {

	public JFrame frmCngHaiS;
	public JTextField numberA;
	public JTextField numberB;
   
	/**
	 * Tính tổng hai số lớn
	 * Hàm main chạy giao diện GUI của Eclipse
	 * Kế thừa 2 class ScanAndPrint và lock
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmCngHaiS.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	Lock lock = new Lock();//Tạo lớp khóa
	public void initialize() {
		frmCngHaiS = new JFrame();
		frmCngHaiS.setTitle("Cộng hai số");
		frmCngHaiS.setBounds(100, 100, 1445, 394);
		frmCngHaiS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCngHaiS.getContentPane().setLayout(null);
		
		JLabel result = new JLabel("");
		result.setBounds(88, 171, 852, 23);
		frmCngHaiS.getContentPane().add(result);
		
		numberA = new JTextField(); // chỗ nhâp số thứ nhất
		numberA.setBounds(90, 71, 1329, 28);
		frmCngHaiS.getContentPane().add(numberA);
		numberA.setColumns(10);
		
		JLabel number1 = new JLabel("S\u1ED1 th\u1EE9 1");
		number1.setBounds(17, 74, 63, 14);
		frmCngHaiS.getContentPane().add(numberA);
		
		numberB = new JTextField();// chỗ nhập số thức hai
		numberB.setBounds(90, 119, 1329, 28);
		frmCngHaiS.getContentPane().add(numberB);
		numberB.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("+");
		lblNewLabel_2.setBounds(239, 102, 13, 20);
		frmCngHaiS.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("=");
		lblNewLabel_3.setBounds(239, 150, 13, 14);
		frmCngHaiS.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Kết quả");
		lblNewLabel_4.setBounds(14, 171, 46, 14);
		frmCngHaiS.getContentPane().add(lblNewLabel_4);
		
		
		JLabel lblNewLabel = new JLabel("S\u1ED1 th\u1EE9 nh\u1EA5t");
		lblNewLabel.setBounds(14, 78, 66, 14);
		frmCngHaiS.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("S\u1ED1 th\u1EE9 hai");
		lblNewLabel_1.setBounds(14, 126, 72, 14);
		frmCngHaiS.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(27, 32, 477, 14);
		frmCngHaiS.getContentPane().add(lblNewLabel_5);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();//Field in ra các bước làm
		formattedTextField.setBounds(29, 279, 1390, 20);
		frmCngHaiS.getContentPane().add(formattedTextField);
		
		JLabel lblNewLabel_6 = new JLabel("Từng bước cộng");
		lblNewLabel_6.setBounds(35, 254, 118, 14);
		frmCngHaiS.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cộng hai số");
		lblNewLabel_7.setBounds(507, 11, 101, 14);
		frmCngHaiS.getContentPane().add(lblNewLabel_7);
		
		//Hàm thực hiện xóa dữ liệu
		JButton clear = new JButton("Nh\u1EADp l\u1EA1i");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Clear="";//chuỗi trắng
				result.setText(String.valueOf(Clear));//xóa result
		        numberA.setText(String.valueOf(Clear));//xóa numberA
		        numberB.setText(String.valueOf(Clear));//xóa numberB
		        lblNewLabel_5.setText(String.valueOf(Clear));//xóa thông báo
		        formattedTextField.setText(String.valueOf(Clear));//xóa các bước làm
			}
		});
		clear.setBounds(312, 210, 101, 23);
		frmCngHaiS.getContentPane().add(clear);
	
		JButton btnNewButton = new JButton("Thực hiện");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String NumberA = numberA.getText();//lấy giá trị A
			String NumberB = numberB.getText();//lấy giá trị B
			String Result;//biến lưu kết quả
					
			formattedTextField.setText("");//xóa các bước            
	        int len1 = NumberA.length();// độ dài chuỗi thứ nhất                     
	        int len2 = NumberB.length();// độ dài chuỗi thứ hai                      
	        int maxlen = (len1 > len2) ? len1 : len2;// so sánh độ dài chuỗi
	        int index1;// Vị trí chuỗi 1                                   
	        int index2;// Vị trí chuỗi 2
	        char c1;// Lấy kí tự ở vị trí cuối cùng của chuỗi s1
	        char c2;// Lấy kí tự ở ví trí cuối cùng của chuỗi s2
	        int memory = 0;// biến ghi lại số nhớ khi cộng 2 số lớn hơn 9                                   
	        int s = 0;// Khởi tạo biến tổng bằng 0 
	        int step;// hiển thị đang ở bước nào
	        String StringMemoryNumber;//Chuỗi trả về xem có còn nợ hay không
	        String StepResult="";//chuỗi các bước
	        int memorybefore;//giá trị cũ của số nhớ
	        // Vòng lặp từ 0 đến chuỗi có độ dài lớn nhất
	        for (int i = 0; i < maxlen; i++)
	        {
	        	
	            index1 = len1 - i - 1;// Lấy vị trí của chuỗi s1                       
	            index2 = len2 - i - 1;// Lấy vị trí của chuỗi s2 
	            c1 = (index1 >= 0) ? NumberA.charAt(index1) : '0';// Lấy kí tự từ phải sang trái của chuỗi s1
	            c2 = (index2 >= 0) ? NumberB.charAt(index2) : '0';// Lấy kí tự từ phải sang trái của chuỗi s2
	            s = (c1 - '0') + (c2 - '0') + memory;// Biến đổi kí tự thành số rồi cộng 
	            memorybefore=memory;//lưu dữ lại giá trị cũ của số nhớ
	            if(memorybefore==1) {StringMemoryNumber=" Trả nợ 1";}//Có nhớ trả về chuỗi
	            else {StringMemoryNumber="";}//Không nhớ trả về null                              
	            memory = s / 10;// Cập nhật lại số nhớ
	            step=i+1;//Tính bước bắt đầu từ 1
	            StepResult=StepResult+"bước "+step+": Lấy "+c1+" cộng "+c2+StringMemoryNumber+" được "+s+" ghi "+s%10+" nhớ "+memory+"    ;    ";//chuỗi in ra từng bước
	            memorybefore = s / 10;//cập nhật số nớ mới
	            
	        }
	        if (memory >= 1) 
	        {    
	            StepResult=StepResult+"cuối cùng nhớ một ghi 1 ;";//thêm chuỗi nếu cuối cùng còn số nhớ thì ghép vào trước kết quả
	            
	        }
	        MyBigNumber mybignumber = new MyBigNumber();	
			Result=mybignumber.sum(NumberA, NumberB);//lấy kết quả từ chức năng print của class MyBigNumber			
			System.out.println(Result);
			final Pattern pattern = Pattern.compile("\\D"); //Numerical sequences represent numeric characters [0-9]
	        final Matcher isnumber = pattern.matcher(Result);
	        
			if ((isnumber.find()  && !NumberB.matches ("null")  &&  !NumberA.matches ("null"))||Result=="Cả hai số đều âm, vui lòng nhập lại cả hai số" ||Result=="Số thứ nhất âm, vui lòng nhập lại số thứ nhất"||Result=="Số thứ nhất hai, vui lòng nhập lại số thứ hai") 
			{
				result.setText("");
				lblNewLabel_5.setText(String.valueOf(Result));//in ra thông báo nếu nhập sai
				if(lock.lockin(NumberA,NumberB)==true)//khóa chương trình 10s,vì nhập sai qua 5 lần
				{
					
					JOptionPane.showMessageDialog(frmCngHaiS,"Bạn đã nhập sai 5 lần liên tiếp, hãy chờ 10s để tiếp tục ");//xuất ra thông báo
					lock.TestSleep();//gọi chức năng khóa của lớp lock
					
				}
			}
			else 
			{
				if (((NumberA.matches ("null")) || (NumberA.trim().isEmpty())) && ((!NumberB.matches ("null")) && (!NumberB.trim().isEmpty())))  {
					formattedTextField.setText("");
		        }
		        if (((NumberB.matches ("null"))|| (NumberB.trim().isEmpty())) && ((!NumberA.matches ("null")) && (!NumberA.trim().isEmpty()))) {
		        	formattedTextField.setText("");
		        }
		        if (((NumberA.matches("null") || (NumberA.trim().isEmpty()))) && (((NumberB.matches("null")) || (NumberB.trim().isEmpty())))) {
		        	formattedTextField.setText("");
		        }
		        if (((!NumberA.matches("null") || (!NumberA.trim().isEmpty()))) && (((!NumberB.matches("null")) || (!NumberB.trim().isEmpty()))))
		        {
				result.setText(String.valueOf(Result));// xuất giá trị ra
				lblNewLabel_5.setText("Đã thực hiện");// xuất thông báo hoàn thành
				formattedTextField.setText(String.valueOf(StepResult));//xuất các bước làm ra
				lock.lockup();
		        }
			}
			}
		});
		btnNewButton.setBounds(152, 210, 100, 23);
		frmCngHaiS.getContentPane().add(btnNewButton);
		
		JLabel lblnhpHaiS = new JLabel("- Nhập hai số tự nhiên bất kỳ cho  \"Số thứ nhất\" và \"Số thứ hai\" để  tính  tổng (Số âm và ký tự khác là không hợp lệ).");
		lblnhpHaiS.setBounds(487, 205, 771, 28);
		frmCngHaiS.getContentPane().add(lblnhpHaiS);
		
		JLabel lblNewLabel_8 = new JLabel("- Không được nhập sai liên tiếp quá 5 lần.");
		lblNewLabel_8.setBounds(487, 241, 739, 14);
		frmCngHaiS.getContentPane().add(lblNewLabel_8);
		
	}
}
