# StudentManagement
Chạy sản phẩm các bước sau
Bước 1: Truy cập và update project.
-	Khởi động spring tool suite 4 và truy cập đến file chứa ứng dụng.
-	Click chuột phải vào project và chọn Maven install.
-	Click chuột phải vào file pom.xml và chọn update project.
  
Bước 2: Cấu hình sever deploy.
-	Chuột phải vào project và chọn run as > run on sever.
-	Chọn Apache và chọn Tomcat 8.5 để deploy.

Bước 3: Khởi chạy ứng dụng.
-	Sau khi truy khởi chạy xong, từ trang trình duyệt web truy cập đến địa chỉ:
http://localhost:8080/spring-mvc/dang-nhap
-	Tiếp tục đăng nhập và thực hiện các chức năng của ứng dụng.
 

Cơ sở dữ liệu quản lý sinh viên gồm 7 bảng:
TT	Mô tả	Chức năng
1	Bảng user	Thông tin người dùng
2	Bảng role	Thông tin phân quyền
3	Bảng user_role	Thông tin phân quyền người dùng quản lý
4	Bảng student	Thông tin sinh viên
5	Bảng teacher	Thông tin giáo viên
6	Bảng classuit	Thông tin lớp
7	Bảng faculty	Thông tin khoa
 

![image](https://github.com/VoTuanNam/StudentManagement/assets/142739440/3b754f76-fe71-4c03-a336-577255a456cc)
a. Kiến trúc MVC
 ![image](https://github.com/VoTuanNam/StudentManagement/assets/142739440/3c2f0351-92d9-494c-9cf3-bd84b2ba74f2)

Hình 2 Mô hình MVC [6]
Mô hình MVC (Model-View-Controller) là một mô hình kiến trúc phần mềm được sử dụng để phát triển các ứng dụng web. Mô hình này chia ứng dụng thành ba thành phần chính:
−	Model: Mô hình đại diện cho dữ liệu và logic bussiness của ứng dụng.
−	View: View là giao diện người dùng của ứng dụng.
−	Controller: Controller là thành phần trung gian giữa model và view. Nó nhận yêu cầu từ người dùng và chuyển yêu cầu đến model để xử lý. Sau đó, controller nhận kết quả từ model và gửi kết quả đến view để hiển thị cho người dùng



b. Logic Dispatcher Servlet
 ![image](https://github.com/VoTuanNam/StudentManagement/assets/142739440/79ea9b64-0b52-4342-82a2-ed50c6584f48)

Hình 3 Logic Dispatcher Servlet
Dispatcher servlet là một servlet được sử dụng để điều phối các yêu cầu HTTP đến các controller trong Spring MVC. Nó là một thành phần quan trọng của kiến trúc MVC của Spring và chịu trách nhiệm xử lý các yêu cầu HTTP, chuyển chúng đến các controller thích hợp và trả về phản hồi cho người dùng. [7]
Dispatcher servlet hoạt động như sau:
1.	Khi một yêu cầu HTTP được gửi đến ứng dụng, Dispatcher servlet sẽ nhận yêu cầu đó.
2.	Dispatcher servlet sẽ sử dụng một servlet mapping để xác định controller nào sẽ xử lý yêu cầu.
3.	Dispatcher servlet sẽ chuyển yêu cầu đến controller thích hợp.
4.	Controller sẽ xử lý yêu cầu và trả về một đối tượng ModelAndView.
5.	Dispatcher servlet sẽ sử dụng một view resolver để tìm view phù hợp với ModelAndView.
6.	Dispatcher servlet sẽ trả về phản hồi cho người dùng.
![image](https://github.com/VoTuanNam/StudentManagement/assets/142739440/38437f72-9af7-47fa-ae9b-440056d4d291)
![image](https://github.com/VoTuanNam/StudentManagement/assets/142739440/7da9be44-6f91-4a7a-a420-7775a917e9c3)
![image](https://github.com/VoTuanNam/StudentManagement/assets/142739440/21bfdefc-25f1-4127-929d-f1f49befb2d9)
