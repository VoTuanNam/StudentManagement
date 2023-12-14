﻿# StudentManagement
Cơ sở dữ liệu quản lý sinh viên gồm 7 bảng:
TT	Mô tả	Chức năng
1	Bảng user	Thông tin người dùng
2	Bảng role	Thông tin phân quyền
3	Bảng user_role	Thông tin phân quyền người dùng quản lý
4	Bảng student	Thông tin sinh viên
5	Bảng teacher	Thông tin giáo viên
6	Bảng classuit	Thông tin lớp
7	Bảng faculty	Thông tin khoa
 
Hình 1 Cơ sở dữ liệu


•	Giải thích chi tiết:
Quan hệ	Thuộc tính	Kiểu dữ liệu	Diễn giải
user	id	bigint(20)	Khoá chính
	fullname	varchar(255)	Thông tin tên đăng nhập
	password	varchar(255)	Thông tin mật khẩu
	status	int(111)	Trạng thái hoạt động
	username	varchar(255)	Thông tin họ tên người dùng
role	id	bigint(20)	Khoá chính
	code	varchar(255)	Thông tin phân quyền(ADMIN, USER)
	name	varchar(255)	Thông tin tên phân quyền(Quản trị, Người dùng)
user_role	id	bigint(20)	Khoá chính
	userid	bigint(20)	Thông tin id người dùng
	roleid	bigint(20)	Thông tin phân quyền (1-ADMIN, 2-USER)
student	id	bigint(20)	Khoá chính
	code	varchar(255)	Thông tin mã sinh viên
	dateofbirth	varchar(255)	Thông tin ngày sinh
	gender	varchar(255)	Thông tin giới tính
	name	varchar(255)	Thông tin họ và tên
	classUIT_id	bigint(20)	Thông tin mã lớp
	faculty_id	bigint(20)	Thông tin mã khoa
teacher	id	bigint(20)	Khoá chính
	code	varchar(255)	Thông tin mã giáo viên
	dateofbirth	varchar(255)	Thông tin ngày sinh
	gender	varchar(255)	Thông tin giới tính
	name	varchar(255)	Thông tin họ và tên
	faculty_id	bigint(20)	Thông tin mã khoa
classuit	id	bigint(20)	Khoá chính
	classname	varchar(255)	Thông tin tên lớp
	code	varchar(255)	Thông tin mã lớp
	total	varchar(255)	Thông tin tổng số lượng
	teacher_code	bigint(20)	Thông tin mã giáo viên
faculty	id	bigint(20)	Khoá chính
	code	varchar(255)	Thông tin mã khoa
	facultyName	varchar(255)	Thông tin tên khoa

