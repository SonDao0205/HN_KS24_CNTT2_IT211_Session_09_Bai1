# Phân tích việc sử dụng System.out.println() trên Production

Dưới đây là 3 lý do chính tại sao tuyệt đối không sử dụng `System.out.println()` và `e.printStackTrace()` trong môi trường thực tế:

1. **Mất dấu vết dữ liệu (Volatility):** `System.out` đẩy dữ liệu vào luồng console chuẩn. Khi server bị restart hoặc container bị xóa, toàn bộ các dòng log này sẽ biến mất vĩnh viễn, khiến việc điều tra nguyên nhân lỗi (root cause analysis) trở nên bất khả thi.
2. **Ảnh hưởng hiệu năng (Performance Block):** `System.out.println()` là một phương thức đồng bộ (synchronized). Khi hệ thống có hàng ngàn request Flash Sale cùng lúc, các luồng (threads) sẽ phải đứng đợi nhau để ghi log, gây ra hiện tượng thắt nút cổ chai và làm chậm toàn bộ hệ thống.
3. **Thiếu khả năng quản lý và phân loại:** Log từ `System.out` không có timestamp, không có level (INFO, ERROR, DEBUG), và không thể cấu hình để đẩy về các hệ thống quản lý tập trung (như ELK Stack, Graylog). Điều này biến hệ thống thành một "hộp đen" đúng nghĩa.