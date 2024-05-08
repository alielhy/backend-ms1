package  ma.zs.zyn.dao.criteria.core.template;


import ma.zs.zyn.dao.criteria.core.collaborator.MemberCriteria;

import ma.zs.zyn.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ProjectTemplateCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String name;
    private String nameLike;
    private String yaml;
    private String yamlLike;
    private LocalDateTime addingDate;
    private LocalDateTime addingDateFrom;
    private LocalDateTime addingDateTo;
    private LocalDateTime lastUpdateDate;
    private LocalDateTime lastUpdateDateFrom;
    private LocalDateTime lastUpdateDateTo;
    private String projectTemplateTags;
    private String projectTemplateTagsLike;
    private String price;
    private String priceMin;
    private String priceMax;

    private CategoryProjectTemplateCriteria categoryProjectTemplate ;
    private List<CategoryProjectTemplateCriteria> categoryProjectTemplates ;
    private DomainTemplateCriteria domainTemplate ;
    private List<DomainTemplateCriteria> domainTemplates ;
    private MemberCriteria member ;
    private List<MemberCriteria> members ;


    public ProjectTemplateCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getNameLike(){
        return this.nameLike;
    }
    public void setNameLike(String nameLike){
        this.nameLike = nameLike;
    }

    public String getYaml(){
        return this.yaml;
    }
    public void setYaml(String yaml){
        this.yaml = yaml;
    }
    public String getYamlLike(){
        return this.yamlLike;
    }
    public void setYamlLike(String yamlLike){
        this.yamlLike = yamlLike;
    }

    public LocalDateTime getAddingDate(){
        return this.addingDate;
    }
    public void setAddingDate(LocalDateTime addingDate){
        this.addingDate = addingDate;
    }
    public LocalDateTime getAddingDateFrom(){
        return this.addingDateFrom;
    }
    public void setAddingDateFrom(LocalDateTime addingDateFrom){
        this.addingDateFrom = addingDateFrom;
    }
    public LocalDateTime getAddingDateTo(){
        return this.addingDateTo;
    }
    public void setAddingDateTo(LocalDateTime addingDateTo){
        this.addingDateTo = addingDateTo;
    }
    public LocalDateTime getLastUpdateDate(){
        return this.lastUpdateDate;
    }
    public void setLastUpdateDate(LocalDateTime lastUpdateDate){
        this.lastUpdateDate = lastUpdateDate;
    }
    public LocalDateTime getLastUpdateDateFrom(){
        return this.lastUpdateDateFrom;
    }
    public void setLastUpdateDateFrom(LocalDateTime lastUpdateDateFrom){
        this.lastUpdateDateFrom = lastUpdateDateFrom;
    }
    public LocalDateTime getLastUpdateDateTo(){
        return this.lastUpdateDateTo;
    }
    public void setLastUpdateDateTo(LocalDateTime lastUpdateDateTo){
        this.lastUpdateDateTo = lastUpdateDateTo;
    }
    public String getProjectTemplateTags(){
        return this.projectTemplateTags;
    }
    public void setProjectTemplateTags(String projectTemplateTags){
        this.projectTemplateTags = projectTemplateTags;
    }
    public String getProjectTemplateTagsLike(){
        return this.projectTemplateTagsLike;
    }
    public void setProjectTemplateTagsLike(String projectTemplateTagsLike){
        this.projectTemplateTagsLike = projectTemplateTagsLike;
    }

    public String getPrice(){
        return this.price;
    }
    public void setPrice(String price){
        this.price = price;
    }   
    public String getPriceMin(){
        return this.priceMin;
    }
    public void setPriceMin(String priceMin){
        this.priceMin = priceMin;
    }
    public String getPriceMax(){
        return this.priceMax;
    }
    public void setPriceMax(String priceMax){
        this.priceMax = priceMax;
    }
      

    public CategoryProjectTemplateCriteria getCategoryProjectTemplate(){
        return this.categoryProjectTemplate;
    }

    public void setCategoryProjectTemplate(CategoryProjectTemplateCriteria categoryProjectTemplate){
        this.categoryProjectTemplate = categoryProjectTemplate;
    }
    public List<CategoryProjectTemplateCriteria> getCategoryProjectTemplates(){
        return this.categoryProjectTemplates;
    }

    public void setCategoryProjectTemplates(List<CategoryProjectTemplateCriteria> categoryProjectTemplates){
        this.categoryProjectTemplates = categoryProjectTemplates;
    }
    public DomainTemplateCriteria getDomainTemplate(){
        return this.domainTemplate;
    }

    public void setDomainTemplate(DomainTemplateCriteria domainTemplate){
        this.domainTemplate = domainTemplate;
    }
    public List<DomainTemplateCriteria> getDomainTemplates(){
        return this.domainTemplates;
    }

    public void setDomainTemplates(List<DomainTemplateCriteria> domainTemplates){
        this.domainTemplates = domainTemplates;
    }
    public MemberCriteria getMember(){
        return this.member;
    }

    public void setMember(MemberCriteria member){
        this.member = member;
    }
    public List<MemberCriteria> getMembers(){
        return this.members;
    }

    public void setMembers(List<MemberCriteria> members){
        this.members = members;
    }
}
