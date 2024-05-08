package  ma.zs.zyn.ws.converter.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.zyn.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.zyn.ws.converter.template.CategoryProjectTemplateConverter;
import ma.zs.zyn.ws.converter.template.DomainTemplateConverter;
import ma.zs.zyn.ws.converter.collaborator.MemberConverter;



import ma.zs.zyn.zynerator.util.StringUtil;
import ma.zs.zyn.zynerator.converter.AbstractConverter;
import ma.zs.zyn.zynerator.util.DateUtil;
import ma.zs.zyn.bean.core.template.ProjectTemplate;
import ma.zs.zyn.ws.dto.template.ProjectTemplateDto;

@Component
public class ProjectTemplateConverter {

    @Autowired
    private CategoryProjectTemplateConverter categoryProjectTemplateConverter ;
    @Autowired
    private DomainTemplateConverter domainTemplateConverter ;
    @Autowired
    private MemberConverter memberConverter ;
    private boolean categoryProjectTemplate;
    private boolean domainTemplate;
    private boolean member;

    public  ProjectTemplateConverter() {
        initObject(true);
    }


    public ProjectTemplate toItem(ProjectTemplateDto dto) {
        if (dto == null) {
            return null;
        } else {
        ProjectTemplate item = new ProjectTemplate();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());
            if(StringUtil.isNotEmpty(dto.getYaml()))
                item.setYaml(dto.getYaml());
            if(StringUtil.isNotEmpty(dto.getAddingDate()))
                item.setAddingDate(DateUtil.stringEnToDate(dto.getAddingDate()));
            if(StringUtil.isNotEmpty(dto.getLastUpdateDate()))
                item.setLastUpdateDate(DateUtil.stringEnToDate(dto.getLastUpdateDate()));
            if(StringUtil.isNotEmpty(dto.getProjectTemplateTags()))
                item.setProjectTemplateTags(dto.getProjectTemplateTags());
            if(StringUtil.isNotEmpty(dto.getPrice()))
                item.setPrice(dto.getPrice());
            if(this.categoryProjectTemplate && dto.getCategoryProjectTemplate()!=null)
                item.setCategoryProjectTemplate(categoryProjectTemplateConverter.toItem(dto.getCategoryProjectTemplate())) ;

            if(this.domainTemplate && dto.getDomainTemplate()!=null)
                item.setDomainTemplate(domainTemplateConverter.toItem(dto.getDomainTemplate())) ;

            if(this.member && dto.getMember()!=null)
                item.setMember(memberConverter.toItem(dto.getMember())) ;




        return item;
        }
    }


    public ProjectTemplateDto toDto(ProjectTemplate item) {
        if (item == null) {
            return null;
        } else {
            ProjectTemplateDto dto = new ProjectTemplateDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());
            if(StringUtil.isNotEmpty(item.getYaml()))
                dto.setYaml(item.getYaml());
            if(item.getAddingDate()!=null)
                dto.setAddingDate(DateUtil.dateTimeToString(item.getAddingDate()));
            if(item.getLastUpdateDate()!=null)
                dto.setLastUpdateDate(DateUtil.dateTimeToString(item.getLastUpdateDate()));
            if(StringUtil.isNotEmpty(item.getProjectTemplateTags()))
                dto.setProjectTemplateTags(item.getProjectTemplateTags());
            if(StringUtil.isNotEmpty(item.getPrice()))
                dto.setPrice(item.getPrice());
            if(this.categoryProjectTemplate && item.getCategoryProjectTemplate()!=null) {
                dto.setCategoryProjectTemplate(categoryProjectTemplateConverter.toDto(item.getCategoryProjectTemplate())) ;

            }
            if(this.domainTemplate && item.getDomainTemplate()!=null) {
                dto.setDomainTemplate(domainTemplateConverter.toDto(item.getDomainTemplate())) ;

            }
            if(this.member && item.getMember()!=null) {
                dto.setMember(memberConverter.toDto(item.getMember())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.categoryProjectTemplate = value;
        this.domainTemplate = value;
        this.member = value;
    }
	
    public List<ProjectTemplate> toItem(List<ProjectTemplateDto> dtos) {
        List<ProjectTemplate> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (ProjectTemplateDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<ProjectTemplateDto> toDto(List<ProjectTemplate> items) {
        List<ProjectTemplateDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (ProjectTemplate item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(ProjectTemplateDto dto, ProjectTemplate t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getCategoryProjectTemplate() != null)
        categoryProjectTemplateConverter.copy(dto.getCategoryProjectTemplate(), t.getCategoryProjectTemplate());
        if (dto.getDomainTemplate() != null)
        domainTemplateConverter.copy(dto.getDomainTemplate(), t.getDomainTemplate());
        if (dto.getMember() != null)
        memberConverter.copy(dto.getMember(), t.getMember());
    }

    public List<ProjectTemplate> copy(List<ProjectTemplateDto> dtos) {
        List<ProjectTemplate> result = new ArrayList<>();
        if (dtos != null) {
            for (ProjectTemplateDto dto : dtos) {
                ProjectTemplate instance = new ProjectTemplate();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


    public CategoryProjectTemplateConverter getCategoryProjectTemplateConverter(){
        return this.categoryProjectTemplateConverter;
    }
    public void setCategoryProjectTemplateConverter(CategoryProjectTemplateConverter categoryProjectTemplateConverter ){
        this.categoryProjectTemplateConverter = categoryProjectTemplateConverter;
    }
    public DomainTemplateConverter getDomainTemplateConverter(){
        return this.domainTemplateConverter;
    }
    public void setDomainTemplateConverter(DomainTemplateConverter domainTemplateConverter ){
        this.domainTemplateConverter = domainTemplateConverter;
    }
    public MemberConverter getMemberConverter(){
        return this.memberConverter;
    }
    public void setMemberConverter(MemberConverter memberConverter ){
        this.memberConverter = memberConverter;
    }
    public boolean  isCategoryProjectTemplate(){
        return this.categoryProjectTemplate;
    }
    public void  setCategoryProjectTemplate(boolean categoryProjectTemplate){
        this.categoryProjectTemplate = categoryProjectTemplate;
    }
    public boolean  isDomainTemplate(){
        return this.domainTemplate;
    }
    public void  setDomainTemplate(boolean domainTemplate){
        this.domainTemplate = domainTemplate;
    }
    public boolean  isMember(){
        return this.member;
    }
    public void  setMember(boolean member){
        this.member = member;
    }
}
