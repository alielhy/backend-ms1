package  ma.zs.zyn.ws.facade.admin.template;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.ArrayList;

import ma.zs.zyn.bean.core.template.CategoryProjectTemplate;
import ma.zs.zyn.dao.criteria.core.template.CategoryProjectTemplateCriteria;
import ma.zs.zyn.service.facade.admin.template.CategoryProjectTemplateAdminService;
import ma.zs.zyn.ws.converter.template.CategoryProjectTemplateConverter;
import ma.zs.zyn.ws.dto.template.CategoryProjectTemplateDto;
import ma.zs.zyn.zynerator.controller.AbstractController;
import ma.zs.zyn.zynerator.dto.AuditEntityDto;
import ma.zs.zyn.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.zyn.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.zyn.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/categoryProjectTemplate/")
public class CategoryProjectTemplateRestAdmin {




    @Operation(summary = "Finds a list of all categoryProjectTemplates")
    @GetMapping("")
    public ResponseEntity<List<CategoryProjectTemplateDto>> findAll() throws Exception {
        ResponseEntity<List<CategoryProjectTemplateDto>> res = null;
        List<CategoryProjectTemplate> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<CategoryProjectTemplateDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all categoryProjectTemplates")
    @GetMapping("optimized")
    public ResponseEntity<List<CategoryProjectTemplateDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<CategoryProjectTemplateDto>> res = null;
        List<CategoryProjectTemplate> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<CategoryProjectTemplateDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a categoryProjectTemplate by id")
    @GetMapping("id/{id}")
    public ResponseEntity<CategoryProjectTemplateDto> findById(@PathVariable Long id) {
        CategoryProjectTemplate t = service.findById(id);
        if (t != null) {
            CategoryProjectTemplateDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a categoryProjectTemplate by name")
    @GetMapping("name/{name}")
    public ResponseEntity<CategoryProjectTemplateDto> findByName(@PathVariable String name) {
	    CategoryProjectTemplate t = service.findByReferenceEntity(new CategoryProjectTemplate(name));
        if (t != null) {
            CategoryProjectTemplateDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  categoryProjectTemplate")
    @PostMapping("")
    public ResponseEntity<CategoryProjectTemplateDto> save(@RequestBody CategoryProjectTemplateDto dto) throws Exception {
        if(dto!=null){
            CategoryProjectTemplate myT = converter.toItem(dto);
            CategoryProjectTemplate t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                CategoryProjectTemplateDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  categoryProjectTemplate")
    @PutMapping("")
    public ResponseEntity<CategoryProjectTemplateDto> update(@RequestBody CategoryProjectTemplateDto dto) throws Exception {
        ResponseEntity<CategoryProjectTemplateDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            CategoryProjectTemplate t = service.findById(dto.getId());
            converter.copy(dto,t);
            CategoryProjectTemplate updated = service.update(t);
            CategoryProjectTemplateDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of categoryProjectTemplate")
    @PostMapping("multiple")
    public ResponseEntity<List<CategoryProjectTemplateDto>> delete(@RequestBody List<CategoryProjectTemplateDto> dtos) throws Exception {
        ResponseEntity<List<CategoryProjectTemplateDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<CategoryProjectTemplate> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified categoryProjectTemplate")
    @DeleteMapping("")
    public ResponseEntity<CategoryProjectTemplateDto> delete(@RequestBody CategoryProjectTemplateDto dto) throws Exception {
		ResponseEntity<CategoryProjectTemplateDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            CategoryProjectTemplate t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified categoryProjectTemplate")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        ResponseEntity<Long> res;
        HttpStatus status = HttpStatus.PRECONDITION_FAILED;
        if (id != null) {
            boolean resultDelete = service.deleteById(id);
            if (resultDelete) {
                status = HttpStatus.OK;
            }
        }
        res = new ResponseEntity<>(id, status);
        return res;
    }
    @Operation(summary = "Delete multiple categoryProjectTemplates by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
        ResponseEntity<List<Long>> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (ids != null) {
            service.deleteByIdIn(ids);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(ids, status);
        return res;
     }



    @Operation(summary = "Finds a categoryProjectTemplate and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<CategoryProjectTemplateDto> findWithAssociatedLists(@PathVariable Long id) {
        CategoryProjectTemplate loaded =  service.findWithAssociatedLists(id);
        CategoryProjectTemplateDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds categoryProjectTemplates by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<CategoryProjectTemplateDto>> findByCriteria(@RequestBody CategoryProjectTemplateCriteria criteria) throws Exception {
        ResponseEntity<List<CategoryProjectTemplateDto>> res = null;
        List<CategoryProjectTemplate> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<CategoryProjectTemplateDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated categoryProjectTemplates by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody CategoryProjectTemplateCriteria criteria) throws Exception {
        List<CategoryProjectTemplate> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<CategoryProjectTemplateDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets categoryProjectTemplate data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody CategoryProjectTemplateCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<CategoryProjectTemplateDto> findDtos(List<CategoryProjectTemplate> list){
        List<CategoryProjectTemplateDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<CategoryProjectTemplateDto> getDtoResponseEntity(CategoryProjectTemplateDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private CategoryProjectTemplateAdminService service;
    @Autowired private CategoryProjectTemplateConverter converter;





}
