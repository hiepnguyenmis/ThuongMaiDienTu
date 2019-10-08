# Hướng dẫn cài đặt chương trình

----
## Cài đặt Database

> Chạy file **eCommerce.sql** với MySQL.

----
## Khởi động server
1. Mở thư mục **ecommerce** với **Eclipse** đã tích hợp **Spring tool suite**. 
2. Tìm đến thự mục **src/main/resources** -> **application.properties** và chỉnh sửa các dòng lệnh sau phù hợp với cấu hình trên máy bạn.

```
  	spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db?createDatabaseIfNotExist=true
	spring.datasource.username=root
	spring.datasource.password=******
});
```
3. Quay lại thư mục **src/main/java** -> **com.shopping4th.ecommerce**. *Right click* vào **EcommerceApplication.java** chọn *Run as* -> *Java Application*.

----
## Chạy client
Chạy thư mục **admin** với localhost (có thể sử dụng tính năng  [Live Server](https://marketplace.visualstudio.com/items?itemName=ritwickdey.LiveServer) trong [VS Code](https://code.visualstudio.com/).



>Lưu ý: Đảm bảo server đã chạy xong trước khi khởi động client.

----
## Môi trường phát triển
* AngularJS
* Java SpringBoot
* MySQL 8

----

## Danh sách API (update liên tục)
* [Xem tại đây](https://documenter.getpostman.com/view/8563174/SVtSW9tH)

