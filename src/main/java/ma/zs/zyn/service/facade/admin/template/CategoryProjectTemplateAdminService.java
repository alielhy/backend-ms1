package ma.zs.zyn.service.facade.admin.template;

import java.util.List;
import ma.zs.zyn.bean.core.template.CategoryProjectTemplate;
import ma.zs.zyn.dao.criteria.core.template.CategoryProjectTemplateCriteria;
import ma.zs.zyn.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface CategoryProjectTemplateAdminService {







	CategoryProjectTemplate create(CategoryProjectTemplate t);

    CategoryProjectTemplate update(CategoryProjectTemplate t);

    List<CategoryProjectTemplate> update(List<CategoryProjectTemplate> ts,boolean createIfNotExist);

    CategoryProjectTemplate findById(Long id);

    CategoryProjectTemplate findOrSave(CategoryProjectTemplate t);

    CategoryProjectTemplate findByReferenceEntity(CategoryProjectTemplate t);

    CategoryProjectTemplate findWithAssociatedLists(Long id);

    List<CategoryProjectTemplate> findAllOptimized();

    List<CategoryProjectTemplate> findAll();

    List<CategoryProjectTemplate> findByCriteria(CategoryProjectTemplateCriteria criteria);

    List<CategoryProjectTemplate> findPaginatedByCriteria(CategoryProjectTemplateCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(CategoryProjectTemplateCriteria criteria);

    List<CategoryProjectTemplate> delete(List<CategoryProjectTemplate> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<CategoryProjectTemplate>> getToBeSavedAndToBeDeleted(List<CategoryProjectTemplate> oldList, List<CategoryProjectTemplate> newList);

    List<CategoryProjectTemplate> importData(List<CategoryProjectTemplate> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<CategoryProjectTemplate> importExcel(MultipartFile file);

}
