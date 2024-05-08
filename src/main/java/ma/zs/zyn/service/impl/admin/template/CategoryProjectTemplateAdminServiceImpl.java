package ma.zs.zyn.service.impl.admin.template;


import ma.zs.zyn.zynerator.exception.EntityNotFoundException;
import ma.zs.zyn.bean.core.template.CategoryProjectTemplate;
import ma.zs.zyn.dao.criteria.core.template.CategoryProjectTemplateCriteria;
import ma.zs.zyn.dao.facade.core.template.CategoryProjectTemplateDao;
import ma.zs.zyn.dao.specification.core.template.CategoryProjectTemplateSpecification;
import ma.zs.zyn.service.facade.admin.template.CategoryProjectTemplateAdminService;
import ma.zs.zyn.zynerator.service.AbstractServiceImpl;
import ma.zs.zyn.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import ma.zs.zyn.zynerator.util.RefelexivityUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class CategoryProjectTemplateAdminServiceImpl implements CategoryProjectTemplateAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public CategoryProjectTemplate update(CategoryProjectTemplate t) {
        CategoryProjectTemplate loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{CategoryProjectTemplate.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public CategoryProjectTemplate findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public CategoryProjectTemplate findOrSave(CategoryProjectTemplate t) {
        if (t != null) {
            CategoryProjectTemplate result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<CategoryProjectTemplate> importData(List<CategoryProjectTemplate> items) {
        List<CategoryProjectTemplate> list = new ArrayList<>();
        for (CategoryProjectTemplate t : items) {
            CategoryProjectTemplate founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<CategoryProjectTemplate> findAll() {
        return dao.findAll();
    }

    public List<CategoryProjectTemplate> findByCriteria(CategoryProjectTemplateCriteria criteria) {
        List<CategoryProjectTemplate> content = null;
        if (criteria != null) {
            CategoryProjectTemplateSpecification mySpecification = constructSpecification(criteria);
            if (criteria.isPeagable()) {
                Pageable pageable = PageRequest.of(0, criteria.getMaxResults());
                content = dao.findAll(mySpecification, pageable).getContent();
            } else {
                content = dao.findAll(mySpecification);
            }
        } else {
            content = dao.findAll();
        }
        return content;

    }


    private CategoryProjectTemplateSpecification constructSpecification(CategoryProjectTemplateCriteria criteria) {
        CategoryProjectTemplateSpecification mySpecification =  (CategoryProjectTemplateSpecification) RefelexivityUtil.constructObjectUsingOneParam(CategoryProjectTemplateSpecification.class, criteria);
        return mySpecification;
    }

    public List<CategoryProjectTemplate> findPaginatedByCriteria(CategoryProjectTemplateCriteria criteria, int page, int pageSize, String order, String sortField) {
        CategoryProjectTemplateSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(CategoryProjectTemplateCriteria criteria) {
        CategoryProjectTemplateSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }


	public boolean deleteById(Long id) {
        boolean condition = deleteByIdCheckCondition(id);
        if (condition) {
            dao.deleteById(id);
        }
        return condition;
    }

    public boolean deleteByIdCheckCondition(Long id) {
        return true;
    }

    public void deleteByIdIn(List<Long> ids) {
        //dao.deleteByIdIn(ids);
    }
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int delete(CategoryProjectTemplate t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<CategoryProjectTemplate> delete(List<CategoryProjectTemplate> list) {
		List<CategoryProjectTemplate> result = new ArrayList();
        if (list != null) {
            for (CategoryProjectTemplate t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public CategoryProjectTemplate create(CategoryProjectTemplate t) {
        CategoryProjectTemplate loaded = findByReferenceEntity(t);
        CategoryProjectTemplate saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<CategoryProjectTemplate> create(List<CategoryProjectTemplate> ts) {
        List<CategoryProjectTemplate> result = new ArrayList<>();
        if (ts != null) {
            for (CategoryProjectTemplate t : ts) {
				CategoryProjectTemplate created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public CategoryProjectTemplate findWithAssociatedLists(Long id){
        CategoryProjectTemplate result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<CategoryProjectTemplate> update(List<CategoryProjectTemplate> ts, boolean createIfNotExist) {
        List<CategoryProjectTemplate> result = new ArrayList<>();
        if (ts != null) {
            for (CategoryProjectTemplate t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    CategoryProjectTemplate loadedItem = dao.findById(t.getId()).orElse(null);
                    if (createIfNotExist && (t.getId() == null || loadedItem == null)) {
                        dao.save(t);
                    } else if (t.getId() != null && loadedItem != null) {
                        dao.save(t);
                    } else {
                        result.add(t);
                    }
                }
            }
        }
        return result;
    }





    public CategoryProjectTemplate findByReferenceEntity(CategoryProjectTemplate t) {
        return t == null || t.getId() == null ? null : findById(t.getId());
    }



    public List<CategoryProjectTemplate> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<CategoryProjectTemplate>> getToBeSavedAndToBeDeleted(List<CategoryProjectTemplate> oldList, List<CategoryProjectTemplate> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<CategoryProjectTemplate> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired CategoryProjectTemplateDao dao;


}
