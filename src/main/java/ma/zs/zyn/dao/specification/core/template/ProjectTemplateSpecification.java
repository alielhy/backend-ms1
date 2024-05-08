package  ma.zs.zyn.dao.specification.core.template;

import ma.zs.zyn.dao.criteria.core.template.ProjectTemplateCriteria;
import ma.zs.zyn.bean.core.template.ProjectTemplate;
import ma.zs.zyn.zynerator.specification.AbstractSpecification;


public class ProjectTemplateSpecification extends  AbstractSpecification<ProjectTemplateCriteria, ProjectTemplate>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("name", criteria.getName(),criteria.getNameLike());
        addPredicate("addingDate", criteria.getAddingDate(), criteria.getAddingDateFrom(), criteria.getAddingDateTo());
        addPredicate("lastUpdateDate", criteria.getLastUpdateDate(), criteria.getLastUpdateDateFrom(), criteria.getLastUpdateDateTo());
        addPredicate("projectTemplateTags", criteria.getProjectTemplateTags(),criteria.getProjectTemplateTagsLike());
        addPredicateBigDecimal("price", criteria.getPrice(), criteria.getPriceMin(), criteria.getPriceMax());
        addPredicateFk("categoryProjectTemplate","id", criteria.getCategoryProjectTemplate()==null?null:criteria.getCategoryProjectTemplate().getId());
        addPredicateFk("categoryProjectTemplate","id", criteria.getCategoryProjectTemplates());
        addPredicateFk("domainTemplate","id", criteria.getDomainTemplate()==null?null:criteria.getDomainTemplate().getId());
        addPredicateFk("domainTemplate","id", criteria.getDomainTemplates());
        addPredicateFk("member","id", criteria.getMember()==null?null:criteria.getMember().getId());
        addPredicateFk("member","id", criteria.getMembers());
    }

    public ProjectTemplateSpecification(ProjectTemplateCriteria criteria) {
        super(criteria);
    }

    public ProjectTemplateSpecification(ProjectTemplateCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
