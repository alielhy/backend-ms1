package  ma.zs.zyn.dao.specification.core.template;

import ma.zs.zyn.dao.criteria.core.template.CategoryProjectTemplateCriteria;
import ma.zs.zyn.bean.core.template.CategoryProjectTemplate;
import ma.zs.zyn.zynerator.specification.AbstractSpecification;


public class CategoryProjectTemplateSpecification extends  AbstractSpecification<CategoryProjectTemplateCriteria, CategoryProjectTemplate>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("name", criteria.getName(),criteria.getNameLike());
    }

    public CategoryProjectTemplateSpecification(CategoryProjectTemplateCriteria criteria) {
        super(criteria);
    }

    public CategoryProjectTemplateSpecification(CategoryProjectTemplateCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
