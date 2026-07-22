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
	- Thêm chức năng cập nhật thông tin của owner, tìm kiếm owners bởi tên hoặc số điện thoại, xóa owner
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
  - ac0da7aae1
- **Ref mục Quyết định thiết kế (nếu có):** Không có.

### Day 5 — 17/07/2026
- **Đã làm:**
	- Thêm chức năng thêm thú cưng, hiển thị danh sách thú cưng, xem chi tiết thông tin thú cưng, cập nhật thông tin thú cưng, xóa thú cưng, hiển thị danh sách thú cưng đã 	được lọc theo loại
	- Cài đặt cấu hình cho Open API (OpenApiConfig) và SecurityConfig để có thể truy cập vào các api endpoint của dự án thông qua SwaggerAPI
	- Thêm method deletePetsByOwnerId trong PetMapper inteface để triển khai tính năng nhất quán dữ liệu (khi xóa owner sẽ xóa luôn những pet của owner đó)
	- Thêm api tạo tài khoản cho owner
	- Thêm api tìm kiếm pet bằng tên owner
	- Thêm thêm spring security vào pom.xml
	- Loại bỏ code dư thừa
	- Formating code
	- Cập nhật NOTEs.md
- **Khó khăn:** Không có.
- **Cách giải quyết:**: Không gặp khó khăn.
- **Commit:**
  - 524772c974
- **Ref mục Quyết định thiết kế (nếu có):** Không có.

### Day 6 — 21/07/2026
- **Đã làm:**
	- Thêm method getPetByNameAndOwnerId để đám bảo 1 owner không thể gửi 2 pet có cùng tên (dùng trong PetService)
	- Thêm method deleteUserByOwnerId để xóa user account khi xóa owner
	- Thêm validation kiểm tra null trước khi dùng Stream API trong OwnerMapperDTO
	- Thêm field userResponse để trả về thông tin user account trong OwnerResponseDTO
	- Thêm tính năng tạo tài khoản user khi tạo owner
	- Thêm BoardingRecord,  BoardingRecordRequestDTO, BoardingRecordResponseDTO, BoardingRecordMapperDTO
	- Thêm CareNote, CareNoteRequestDTO, CareNoteResponseDTO, CareNoteMapperDTO
	- Thêm enum BoardingFee
	- Thêm BoardingRecordRepository
	- Đổi tên enum PetStatus thành BoardingStatus
	- Thay đổi database schema (thêm cột expected_check_out trong table boarding_records)
	- Formating code
	- Cập nhật NOTEs.md
- **Khó khăn:** Không có.
- **Cách giải quyết:**: Không gặp khó khăn.
- **Commit:**
  - a33fe7b543
- **Ref mục Quyết định thiết kế (nếu có):** 2.1

### Day 7 — 22/07/2026
- **Đã làm:**
	- Thêm API tạo boarding record, hiển thị tất cả boarding record, lấy thông tin của boarding record qua id của boarding record, hiển thị thông tin của tất cả 	boarding record đang được gửi, lấy thông tin boarding record thông qua id của pet, lấy thông tin của boarding record thông qua id của owner, tìm kiếm và lấy 	những boarding record thuộc khoảng thời gian (ngày), lọc và lấy nhưng boarding record thông qua trạng thái của record, type của pet, khoảng thời gina (ngày), 	id của owner
	- Thêm validation cho BoardingRecordRequestDTO và CareNoteRequestDTO
	- Thêm @Schema cho BoardingRecordReponseDTO và CareNoteResponseDTO
	- Fix: lỗi chính tả English (sửa "can't not" -> "can not")
	- Loại bỏ code dư thừa
	- Formating code
	- Cập nhật NOTEs.md
- **Khó khăn:** Không có.
- **Cách giải quyết:**: Không gặp khó khăn.
- **Commit:**
  - ...
- **Ref mục Quyết định thiết kế (nếu có):** Không có

---

## 2. Quyết định thiết kế (các phần đề không đặc tả đầy đủ)
### 2.1 Không có column nào trong database để biết ngày dự kiến check out là ngày nào
- **Vấn đề:** Không có column nào trong database để biết ngày dự kiến check out là ngày nào => Không có số liệu căn cứ để tính phí thêm do trể là bao nhiêu vì không biết đã trể bao nhiều ngày so với dự tín.
- **Quyết định của tôi:** thêm column expected_check_out kiểu DATE với constrant NOT NULL trong database để giải quyết vấn đề này
- **Lý do chọn:** dữ liệu được lưu bền vững trong database và cách thực hiện đơn giãn, tăng khả năng mở rộng cho hệ thống nếu trong tương lai muốn thêm tính năng chỉnh sửa ngày dự kiến check out
- **Thay đổi schema (nếu có):** expected_check_out

---

## 3. Ghi chú kỹ thuật khác
Không có