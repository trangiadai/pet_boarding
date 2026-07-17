package training.javaweb.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import training.javaweb.exam.dto.ValidationErrorDetail;
import training.javaweb.exam.dto.request.PetRequestDTO;
import training.javaweb.exam.dto.response.PetResponseDTO;
import training.javaweb.exam.service.PetService;

@RestController
@RequestMapping("/pets")
public class PetController {
	private final PetService petService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "B1. Thêm thú cưng mới (gắn với chủ nuôi)")
    @ApiResponse(responseCode = "201", description = "Successfully add new pet.")
	@ApiResponse(responseCode = "400", description = "Payload schema field rule constraint violation caught.", content = @Content(schema = @Schema(implementation = ValidationErrorDetail.class)))
    public PetResponseDTO createPet(@Valid @RequestBody PetRequestDTO petRequest){
        return petService.createPet(petRequest);
    }

    @GetMapping
    @Operation(summary = "B2. Hiển thị danh sách thú cưng")
    @ApiResponse(responseCode = "200", description = "Successfully get all information of pets")
    public List<PetResponseDTO> getAllPets(){
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    @Operation(summary = "B3. Xem chi tiết (kèm thông tin chủ nuôi)")
    @ApiResponse(responseCode = "200", description = "Get pet's detail completed.")
    public PetResponseDTO getPetById(@PathVariable Long id){
        return petService.getPetById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "B4. Cập nhật thông tin (bao gồm ảnh)")
    @ApiResponse(responseCode = "200", description = "Pet information updated successfully.")
    public PetResponseDTO updatePetById(@PathVariable Long id, @Valid @RequestBody PetRequestDTO petRequest){
        return petService.updatePetById(id, petRequest);
    }
   

    @DeleteMapping("/{id}")
    @Operation(summary = "B5. Xóa thú cưng")
    @ApiResponse(responseCode = "204", description = "Pets details and their boearding-record purged successfully.")
    public int deletePetById(@PathVariable Long id){
        return petService.deletePetById(id);
    }
    

    @GetMapping("/filter")
    @Operation(summary = "B6. Lọc theo loại (DOG/CAT/...)")
    @ApiResponse(responseCode = "200", description = "Successfully get all information of filtered pets")
    public List<PetResponseDTO> filterPets(@RequestParam(required = false) List<String> rawTypes){
        return petService.findPetsFiltered(rawTypes);
    }
    
    @GetMapping("/search")
    @Operation(summary = "B7. Tìm thú cưng theo chủ nuôi")
    @ApiResponse(responseCode = "200", description = "Successfully search all information of pets by owner name")
    public List<PetResponseDTO> searchPetByOwnerName(@RequestParam(required = false) String name){
        return petService.searchPetByOwnerName(name);
    }
    
    
    public PetController(PetService petService){
        this.petService = petService;
    }
	
}
