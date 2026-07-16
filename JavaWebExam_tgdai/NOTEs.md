# NOTES — JavaWebExam_tgdai 

Học viên: Trần Gia Đại
Ngày bắt đầu: 13/07/2026
Branch: `java-web/exam`

---

## 1. Nhật ký hàng ngày
               
### Day 1 — 13/07/2026
- **Đã làm:**
  - Khởi tạo project
  - Thêm api dùng để lấy thông tin của tất cả owners
  - Thêm file NOTEs.md
  - Thêm GlobalExceptionHandler cho project
  - Formatting code 
- **Khó khăn:** Không có.
- **Cách giải quyết:**: Không gặp khó khăn.
- **Commit:**
  - c8dd09415d
- **Ref mục Quyết định thiết kế (nếu có):** Không có.

### Day 2 — 14/07/2026
- **Đã làm:**
	- Thêm vào chức năng tạo owner
	- Thêm regex để kiểm tra cấu trúc email được input
	- Thay đổi OwnerResponse, Owner entity, OwnerRequest (thêm field "pets")
	- Thêm Pet entity, PetResponseDTO, PetRequestDTO, PetMapperDTO
	- Thêm enum PetType
	- Thay đổi giá trị mẩu của ErrorDetail
	- Cập nhật NOTEs.md
- **Khó khăn:** Không có.
- **Cách giải quyết:**: Không gặp khó khăn.
- **Commit:**
  - a8b08f04cd
- **Ref mục Quyết định thiết kế (nếu có):** Không có.

### Day 3 — 15/07/2026
- **Đã làm:**
	- Adding feature 
	- Thêm tính năng update owner information, searching owners bởi name hoặc phone number, deleting owner
	- Fix bug trong PetMapperDTO
	- Thêm field "id" vào OwnerResponseDTO
	- Thay đổi OwnerMapperDTO để mapping field pets
	- Fix bug trong PetMapperDTO
	- Fix bug về validation của field createdAt trong OwnerRequestDTO(thay đổi từ @NotBlank sang @NotNull)
	- Thêm regex pattern để validate field "phone" trong OwnerRequestDTO 
	- Xóa field pets trong OwnerRequestDTO
	- Đổi tên database (requirement F-2)
	- Loại bỏ code dư thừa
	- Formatting code
	- Cập nhật NOTEs.md
- **Khó khăn:** Không có.
- **Cách giải quyết:**: Không gặp khó khăn.
- **Commit:**
  - 3e3c441607
- **Ref mục Quyết định thiết kế (nếu có):** Không có.

### Day 4 — 16/07/2026
- **Đã làm:**
	- Thêm chức năng thêm thú cưng, hiển thị danh sách thú cưng, xem chi tiết thông tin thú cưng, cập nhật thông tin thú cưng, xóa thú cưng, hiển thị danh sách thú cưng đã 	được lọc theo loại
	- Thay đổi vài kiểu validation trong PetRequestDTO
	- Thay đổi field của entity Pet (thêm field "owner" để lấy ra chi tiết thông tin của owner của pet)
	- Thay đổi PetMapDTO cho phù hợp với entity Pet
	- Thêm enum PetStatus
	- Thêm chức năng lấy thông tin chi tiết của 1 owner
	- Loại bỏ code dư thừa
	- Formating code
	- Cập nhật NOTEs.md
- **Khó khăn:** Không có.
- **Cách giải quyết:**: Không gặp khó khăn.
- **Commit:**
  - ...
- **Ref mục Quyết định thiết kế (nếu có):** Không có.


---

## 2. Quyết định thiết kế (các phần đề không đặc tả đầy đủ)
Không có

---

## 3. Ghi chú kỹ thuật khác
Không có