Phần 1 – Phân tích lỗi
Code Junior dev
@PostMapping("/products/{productId}")
public Product updateProduct(@PathVariable String productId,
@RequestBody Product p) {
...
}
Lỗi 1: Dùng sai HTTP Method

    Sai:
    @PostMapping
    Đúng:
    @PutMapping
    Giải thích:
    POST dùng để tạo mới tài nguyên
    PUT dùng để cập nhật tài nguyên đã tồn tại
    
    API đang làm chức năng update nên phải dùng PUT.

Lỗi 2: Không xử lý trường hợp ID không tồn tại

    Code chỉ nhận dữ liệu rồi update mà không kiểm tra:
    
    productId có tồn tại hay không
    nếu không tồn tại phải trả lỗi phù hợp
    Đúng nghiệp vụ:
    Nếu không tìm thấy ID:
    return "Product not found";
    
    hoặc trả HTTP 404.