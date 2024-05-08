package  ma.zs.zyn.ws.dto.template;

import ma.zs.zyn.zynerator.audit.Log;
import ma.zs.zyn.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


import ma.zs.zyn.ws.dto.collaborator.MemberDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectTemplateDto  extends AuditBaseDto {

    private String code  ;
    private String name  ;
    private String yaml  ;
    private String addingDate ;
    private String lastUpdateDate ;
    private String projectTemplateTags  ;
    private BigDecimal price  ;

    private CategoryProjectTemplateDto categoryProjectTemplate ;
    private DomainTemplateDto domainTemplate ;
    private MemberDto member ;



    public ProjectTemplateDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Log
    public String getYaml(){
        return this.yaml;
    }
    public void setYaml(String yaml){
        this.yaml = yaml;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getAddingDate(){
        return this.addingDate;
    }
    public void setAddingDate(String addingDate){
        this.addingDate = addingDate;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getLastUpdateDate(){
        return this.lastUpdateDate;
    }
    public void setLastUpdateDate(String lastUpdateDate){
        this.lastUpdateDate = lastUpdateDate;
    }

    @Log
    public String getProjectTemplateTags(){
        return this.projectTemplateTags;
    }
    public void setProjectTemplateTags(String projectTemplateTags){
        this.projectTemplateTags = projectTemplateTags;
    }

    @Log
    public BigDecimal getPrice(){
        return this.price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }


    public CategoryProjectTemplateDto getCategoryProjectTemplate(){
        return this.categoryProjectTemplate;
    }

    public void setCategoryProjectTemplate(CategoryProjectTemplateDto categoryProjectTemplate){
        this.categoryProjectTemplate = categoryProjectTemplate;
    }
    public DomainTemplateDto getDomainTemplate(){
        return this.domainTemplate;
    }

    public void setDomainTemplate(DomainTemplateDto domainTemplate){
        this.domainTemplate = domainTemplate;
    }
    public MemberDto getMember(){
        return this.member;
    }

    public void setMember(MemberDto member){
        this.member = member;
    }






}
