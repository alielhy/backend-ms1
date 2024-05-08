package ma.zs.zyn.service.impl.admin.template;


import ma.zs.zyn.zynerator.exception.EntityNotFoundException;
import ma.zs.zyn.bean.core.template.ProjectTemplate;
import ma.zs.zyn.dao.criteria.core.template.ProjectTemplateCriteria;
import ma.zs.zyn.dao.facade.core.template.ProjectTemplateDao;
import ma.zs.zyn.dao.specification.core.template.ProjectTemplateSpecification;
import ma.zs.zyn.service.facade.admin.template.ProjectTemplateAdminService;
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

import ma.zs.zyn.service.facade.admin.template.CategoryProjectTemplateAdminService ;
import ma.zs.zyn.bean.core.template.CategoryProjectTemplate ;
import ma.zs.zyn.service.facade.admin.template.DomainTemplateAdminService ;
import ma.zs.zyn.bean.core.template.DomainTemplate ;
import ma.zs.zyn.service.facade.admin.collaborator.MemberAdminService ;
import ma.zs.zyn.bean.core.collaborator.Member ;

import java.util.List;
@Service
public class ProjectTemplateAdminServiceImpl implements ProjectTemplateAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public ProjectTemplate update(ProjectTemplate t) {
        ProjectTemplate loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{ProjectTemplate.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public ProjectTemplate findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public ProjectTemplate findOrSave(ProjectTemplate t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            ProjectTemplate result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<ProjectTemplate> importData(List<ProjectTemplate> items) {
        List<ProjectTemplate> list = new ArrayList<>();
        for (ProjectTemplate t : items) {
            ProjectTemplate founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<ProjectTemplate> findAll() {
        return dao.findAll();
    }

    public List<ProjectTemplate> findByCriteria(ProjectTemplateCriteria criteria) {
        List<ProjectTemplate> content = null;
        if (criteria != null) {
            ProjectTemplateSpecification mySpecification = constructSpecification(criteria);
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


    private ProjectTemplateSpecification constructSpecification(ProjectTemplateCriteria criteria) {
        ProjectTemplateSpecification mySpecification =  (ProjectTemplateSpecification) RefelexivityUtil.constructObjectUsingOneParam(ProjectTemplateSpecification.class, criteria);
        return mySpecification;
    }

    public List<ProjectTemplate> findPaginatedByCriteria(ProjectTemplateCriteria criteria, int page, int pageSize, String order, String sortField) {
        ProjectTemplateSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(ProjectTemplateCriteria criteria) {
        ProjectTemplateSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<ProjectTemplate> findByCategoryProjectTemplateId(Long id){
        return dao.findByCategoryProjectTemplateId(id);
    }
    public int deleteByCategoryProjectTemplateId(Long id){
        return dao.deleteByCategoryProjectTemplateId(id);
    }
    public long countByCategoryProjectTemplateId(Long id){
        return dao.countByCategoryProjectTemplateId(id);
    }
    public List<ProjectTemplate> findByDomainTemplateId(Long id){
        return dao.findByDomainTemplateId(id);
    }
    public int deleteByDomainTemplateId(Long id){
        return dao.deleteByDomainTemplateId(id);
    }
    public long countByDomainTemplateId(Long id){
        return dao.countByDomainTemplateId(id);
    }
    public List<ProjectTemplate> findByMemberId(Long id){
        return dao.findByMemberId(id);
    }
    public int deleteByMemberId(Long id){
        return dao.deleteByMemberId(id);
    }
    public long countByMemberId(Long id){
        return dao.countByMemberId(id);
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
    public int delete(ProjectTemplate t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<ProjectTemplate> delete(List<ProjectTemplate> list) {
		List<ProjectTemplate> result = new ArrayList();
        if (list != null) {
            for (ProjectTemplate t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public ProjectTemplate create(ProjectTemplate t) {
        ProjectTemplate loaded = findByReferenceEntity(t);
        ProjectTemplate saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<ProjectTemplate> create(List<ProjectTemplate> ts) {
        List<ProjectTemplate> result = new ArrayList<>();
        if (ts != null) {
            for (ProjectTemplate t : ts) {
				ProjectTemplate created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public ProjectTemplate findWithAssociatedLists(Long id){
        ProjectTemplate result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<ProjectTemplate> update(List<ProjectTemplate> ts, boolean createIfNotExist) {
        List<ProjectTemplate> result = new ArrayList<>();
        if (ts != null) {
            for (ProjectTemplate t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    ProjectTemplate loadedItem = dao.findById(t.getId()).orElse(null);
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





    public ProjectTemplate findByReferenceEntity(ProjectTemplate t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(ProjectTemplate t){
        if( t != null) {
            t.setCategoryProjectTemplate(categoryProjectTemplateService.findOrSave(t.getCategoryProjectTemplate()));
            t.setDomainTemplate(domainTemplateService.findOrSave(t.getDomainTemplate()));
            t.setMember(memberService.findOrSave(t.getMember()));
        }
    }



    public List<ProjectTemplate> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<ProjectTemplate>> getToBeSavedAndToBeDeleted(List<ProjectTemplate> oldList, List<ProjectTemplate> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<ProjectTemplate> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private CategoryProjectTemplateAdminService categoryProjectTemplateService ;
    @Autowired
    private DomainTemplateAdminService domainTemplateService ;
    @Autowired
    private MemberAdminService memberService ;

    private @Autowired ProjectTemplateDao dao;


}
